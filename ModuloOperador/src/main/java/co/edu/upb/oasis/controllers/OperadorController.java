package co.edu.upb.oasis.controllers;

import java.util.Iterator;

import co.edu.upb.oasis.clases.Cliente;
import co.edu.upb.oasis.clases.Pedido;
import co.edu.upb.oasis.clases.Producto;
import co.edu.upb.oasis.estructuras.interfaces.NodeInterface;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;
import co.edu.upb.oasis.estructuras.node.DoubleListNode;
import co.edu.upb.oasis.models.ModelVistaOperador;
import co.edu.upb.oasis.vistas.VistaOperador;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * 
 * Class that represents the controller of the operador view
 * 
 * Clase que representa el controlador para la vista de operador
 * 
 * This class links buttons and images as well as proccess information from
 * database
 * 
 * 
 * @author Juan David Patiño Parra
 */
public class OperadorController {

    Cliente clienteToLinkPedido;
    Iterator<NodeInterface<Producto>> iterator2;
    DoubleLinkedList<Cliente> clientes;

    /**
     * Once initialized, the constructor sets all the actions that must be done once
     * the user interacts with the elements
     * (Buttons , ImageView , TextLabels , ComboBox, etc...)
     */
    public OperadorController() {
        // CREAR VISTA Y MODELO
        VistaOperador vistaOperador = new VistaOperador();

        ModelVistaOperador modelVistaOperador = new ModelVistaOperador();

        // ------------
        // ------------- Consiguiendo MEnu
        DoubleLinkedList<Producto> menu = modelVistaOperador.getMenu();
        Producto[] productos = new Producto[menu.size()];
        Iterator<NodeInterface<Producto>> iterador = menu.iterator();
        DoubleListNode<Producto> temp;
        int i = 0;
        while (iterador.hasNext()) {
            temp = (DoubleListNode<Producto>) iterador.next();
            productos[i] = temp.getObject();
            i++;
        }
        // ------------

        // -------------
        // LISTA PEDIDOS TO ADD
        DoubleLinkedList<Producto> pedido = new DoubleLinkedList<Producto>();

        // SELECTOR ------------------------------------------------------------
        vistaOperador.clientesButton.setOnAction(actionEvent -> {
            vistaOperador.switchScene(vistaOperador.clientesView);
        });
        vistaOperador.menuButton.setOnAction(actionEvent -> {

            // ---------------Consiguiendo los clientes del json y colocandolos en COMBOBOX
            clientes = modelVistaOperador.getClientes();
            // clientes.imprimir();
            Iterator<NodeInterface<Cliente>> iteratorDeClientes = clientes.iterator();
            DoubleListNode<Cliente> temporalCliente;

            ComboBox<String> comboBox = new ComboBox<>();
            while (iteratorDeClientes.hasNext()) {
                temporalCliente = (DoubleListNode<Cliente>) iteratorDeClientes.next();
                comboBox.getItems().addAll(temporalCliente.getObject().getNombre());
            }

            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.initOwner(vistaOperador.window);
            popupStage.setTitle("Seleccionar Cliente");

            // Crear ComboBox y botón de confirmación.
            // comboBox.getItems().addAll("Dato 1", "Dato 2", "Dato 3");
            Button confirmButton = new Button("Confirmar");

            confirmButton.setOnAction(e -> {
                String selectedData = comboBox.getValue();
                if (selectedData == null) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("ERRORRR");
                    alert.setHeaderText("CLIENTE NO SELECCIONADO");
                    alert.setContentText(
                            "Tienes que seleccionar uno!" + "\n"
                                    + "Porfavor selecciona uno...");
                    alert.showAndWait();
                    vistaOperador.switchScene(vistaOperador.optionPanel);
                } else {
                    System.out.println("Cliente seleccionado: " + selectedData);
                    // Falta iterar
                    Iterator<NodeInterface<Cliente>> iteratorDeClientes1 = clientes.iterator();
                    DoubleListNode<Cliente> temporalClienteSelect;
                    while (iteratorDeClientes1.hasNext()) {
                        temporalClienteSelect = (DoubleListNode<Cliente>) iteratorDeClientes1.next();
                        if (temporalClienteSelect.getObject().getNombre().equals(selectedData)) {
                            Cliente clienteToLinkPedido = temporalClienteSelect.getObject();
                            System.out.println(clienteToLinkPedido.getNombre());
                            setClienteToLinkPedido(clienteToLinkPedido);
                        }
                    }
                    // Cliente clienteSelected = selectedData.

                    popupStage.close();
                    vistaOperador.switchScene(vistaOperador.menuView);
                }

            });
            // Crear el diseño de la ventana emergente y agregar elementos.
            VBox popupLayout = new VBox(10);
            popupLayout.setAlignment(Pos.CENTER);
            popupLayout.getChildren().addAll(comboBox, confirmButton);

            // Crear una escena para la ventana emergente.
            Scene popupScene = new Scene(popupLayout, 300, 200);
            popupStage.setScene(popupScene);

            // Mostrar la ventana emergente.
            popupStage.showAndWait();
        });

        // -----------------------------------------------------------------------

        // vISTA CLIENTE-----------------------------------------------------------
        vistaOperador.goBack.setOnAction(actionEvent -> {
            // vistaOperador.window.setScene(VistaOperador.optionPanel);
            vistaOperador.switchScene(vistaOperador.optionPanel);

        });
        vistaOperador.goBackToClientesOption.setOnAction(actionEvent -> {
            vistaOperador.clientesFounded.clear();
            vistaOperador.switchScene(vistaOperador.clientesView);
        });
        vistaOperador.buscarClienteButton.setOnAction(actionEvent -> {
            vistaOperador.switchScene(vistaOperador.buscarClienteView);
        });

        vistaOperador.agregarClienteButton.setOnAction(actionEvent -> {
            // vistaOperador.window.setScene(VistaOperador.optionPanel);
            vistaOperador.switchScene(vistaOperador.agregarClienteView);

        });
        vistaOperador.goBackToClientes.setOnAction(actionEvent -> {
            // vistaOperador.window.setScene(VistaOperador.optionPanel);
            vistaOperador.switchScene(vistaOperador.clientesView);

        });
        // ---------------------------------------------------------------------------
        //---------------
        //Buscar cliente
        vistaOperador.busquedaDeClientes.setOnKeyPressed(event ->{
            if(event.getCode() == KeyCode.ENTER){
                clientes = modelVistaOperador.getClientes();
                Long numeroIngresado = Long.parseLong(vistaOperador.busquedaDeClientes.getText());
                Iterator<NodeInterface<Cliente>> iterator = clientes.iterator();
                DoubleListNode<Cliente> temporallll;
                while(iterator.hasNext()){
                    temporallll = (DoubleListNode<Cliente>)iterator.next();
                    if(temporallll.getObject().getTelefono() == (numeroIngresado)){
                        vistaOperador.clientesFounded.add(temporallll.getObject().getNombre());
                        break;
                    }
                }
            }
        });




        // aGREGAR CLIENTE

        vistaOperador.confirmAddButton.setOnAction(actionEvent -> {
            if (checkNumber(vistaOperador.telefono.getText())) {
                if (vistaOperador.cliente == null || vistaOperador.direccion == null || vistaOperador.barrio == null
                        || vistaOperador.telefono == null) {
                } else {
                    if (modelVistaOperador.addCliente(vistaOperador.cliente.getText(),
                            vistaOperador.direccion.getText(), vistaOperador.barrio.getValue(),
                            (Long.parseLong(vistaOperador.telefono.getText())))) {
                        vistaOperador.cliente.setText("");
                        vistaOperador.direccion.setText("");
                        vistaOperador.barrio.getSelectionModel().clearSelection();
                        vistaOperador.telefono.setText("");
                    }
                }
            } else {
                modelVistaOperador.checkTelefono();
            }

        });
        // --------------------------------------------------------------------------------------------
        // menu
        vistaOperador.goBackToOptions.setOnAction(actionEvent -> {
            vistaOperador.items.clear();
            pedido.clear();
            vistaOperador.switchScene(vistaOperador.optionPanel);
        });

        // BUSQUEDA ---------------------------
        vistaOperador.barraDeBusqueda.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String busqueda = vistaOperador.barraDeBusqueda.getText();

                for (int a = 0; a < vistaOperador.comidas.length; a++) {
                    if (vistaOperador.comidas[a].getText().toLowerCase().contains(busqueda)) {
                        vistaOperador.comidas[a].setVisible(true);
                    } else {
                        vistaOperador.comidas[a].setVisible(false);
                    }
                }

                for (int b = 0; b < vistaOperador.bebidas.length; b++) {

                    if (vistaOperador.bebidas[b].getText().toLowerCase().contains(busqueda)) {
                        vistaOperador.bebidas[b].setVisible(true);
                    } else {
                        vistaOperador.bebidas[b].setVisible(false);
                    }
                }

                for (int c = 0; c < vistaOperador.postres.length; c++) {
                    if (vistaOperador.postres[c].getText().toLowerCase().contains(busqueda)) {
                        vistaOperador.postres[c].setVisible(true);
                    } else {
                        vistaOperador.postres[c].setVisible(false);
                    }
                }
            }

        });

        // CREAR PEDIDO
        vistaOperador.comidas[0].setOnAction(actionEvent -> {
            pedido.add(productos[0]);
            vistaOperador.items.add(vistaOperador.comidas[0].getText());
        });
        vistaOperador.comidas[1].setOnAction(actionEvent -> {
            pedido.add(productos[1]);
            vistaOperador.items.add(vistaOperador.comidas[1].getText());
        });
        vistaOperador.comidas[2].setOnAction(actionEvent -> {
            pedido.add(productos[2]);
            vistaOperador.items.add(vistaOperador.comidas[2].getText());
        });
        vistaOperador.comidas[3].setOnAction(actionEvent -> {
            pedido.add(productos[3]);
            vistaOperador.items.add(vistaOperador.comidas[3].getText());
        });
        vistaOperador.comidas[4].setOnAction(actionEvent -> {
            pedido.add(productos[4]);
            vistaOperador.items.add(vistaOperador.comidas[4].getText());
        });
        vistaOperador.comidas[5].setOnAction(actionEvent -> {
            pedido.add(productos[5]);
            vistaOperador.items.add(vistaOperador.comidas[5].getText());
        });
        // ----------------------------------------
        vistaOperador.bebidas[0].setOnAction(actionEvent -> {
            pedido.add(productos[6]);
            vistaOperador.items.add(vistaOperador.bebidas[0].getText());
        });
        vistaOperador.bebidas[1].setOnAction(actionEvent -> {
            pedido.add(productos[7]);
            vistaOperador.items.add(vistaOperador.bebidas[1].getText());
        });
        vistaOperador.bebidas[2].setOnAction(actionEvent -> {
            pedido.add(productos[8]);
            vistaOperador.items.add(vistaOperador.bebidas[2].getText());
        });
        vistaOperador.bebidas[3].setOnAction(actionEvent -> {
            pedido.add(productos[9]);
            vistaOperador.items.add(vistaOperador.bebidas[3].getText());
        });
        vistaOperador.bebidas[4].setOnAction(actionEvent -> {
            pedido.add(productos[10]);
            vistaOperador.items.add(vistaOperador.bebidas[4].getText());
        });
        vistaOperador.bebidas[5].setOnAction(actionEvent -> {
            pedido.add(productos[11]);
            vistaOperador.items.add(vistaOperador.bebidas[5].getText());
        });
        // ----------------------------------------
        vistaOperador.postres[0].setOnAction(actionEvent -> {
            pedido.add(productos[12]);
            vistaOperador.items.add(vistaOperador.postres[0].getText());
        });
        vistaOperador.postres[1].setOnAction(actionEvent -> {
            pedido.add(productos[13]);
            vistaOperador.items.add(vistaOperador.postres[1].getText());
        });
        vistaOperador.postres[2].setOnAction(actionEvent -> {
            pedido.add(productos[14]);
            vistaOperador.items.add(vistaOperador.postres[2].getText());
        });
        vistaOperador.postres[3].setOnAction(actionEvent -> {
            pedido.add(productos[15]);
            vistaOperador.items.add(vistaOperador.postres[3].getText());
        });
        vistaOperador.postres[4].setOnAction(actionEvent -> {
            pedido.add(productos[16]);
            vistaOperador.items.add(vistaOperador.postres[4].getText());
        });
        vistaOperador.postres[5].setOnAction(actionEvent -> {
            pedido.add(productos[17]);
            vistaOperador.items.add(vistaOperador.postres[5].getText());
        });

        // ----------------------------------------------------------------------------------------------

        // Delete producto
        vistaOperador.deleteProducto.setOnAction(event -> {
            Iterator<NodeInterface<Producto>> iteratorOtro = pedido.iterator();
            setIterator2(iteratorOtro);
            int selectedIndex = vistaOperador.listView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                String productoSeleccionado = vistaOperador.items.get(selectedIndex);
                Iterator<NodeInterface<Producto>> iterator = pedido.iterator();
                DoubleListNode<Producto> temporalNode;
                while (iterator.hasNext()) {

                    temporalNode = (DoubleListNode<Producto>) iterator.next();
                    if (temporalNode.getObject().getNombre().equals(productoSeleccionado)) {

                        pedido.remove(temporalNode);
                        break;
                    }
                }
                vistaOperador.items.remove(selectedIndex);
            }
        });

        // confirmar Pedido
        vistaOperador.confirmarPedido.setOnAction(actionEvent -> {
            Iterator<NodeInterface<Producto>> iteratorOtro = pedido.iterator();
            setIterator2(iteratorOtro);
            if (pedido.isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERRORRR");
                alert.setHeaderText("PEDIDO SIN PRODUCTOS");
                alert.setContentText(
                        "El pedido que se esta generando carece de productos!" + "\n" + "Porfavor añada productos...");
                alert.showAndWait();
            } else {
                // -----Metodo para SACAR PRECIO Y IMPUESTOS
                String result = "";
                int precioTemp = 0;
                int impuestos = 0;
                DoubleListNode<Producto> increibleNode;
                while (iterator2.hasNext()) {
                    increibleNode = (DoubleListNode<Producto>) iterator2.next();
                    result += increibleNode.getObject().getNombre() + "| ";
                    precioTemp += increibleNode.getObject().getPrecio();
                    impuestos += getImpuesto(precioTemp);
                }

                vistaOperador.pedidoText.setText(result);
                vistaOperador.domicilioText
                        .setText(String.valueOf(getPrecioDomicilio(clienteToLinkPedido.getDireccion())));
                vistaOperador.precioText.setText(String.valueOf(precioTemp));
                vistaOperador.impuestoText.setText(String.valueOf(impuestos));

                vistaOperador.precioTotalText.setText((String.valueOf(precioTemp + impuestos)));

                vistaOperador.switchScene(vistaOperador.confirmarPedidoView);

            }

            System.out.println("------------");
            pedido.imprimir();
            System.out.println("-----------");
        });

        // Enviar la linked list a la cola (CONFIRMAR CONFIRMAR)

        // -----------------------------------------------------------------------------------------------
        vistaOperador.backToMenu.setOnAction(addCliente -> {
            vistaOperador.items.clear();
            pedido.clear();
            vistaOperador.switchScene(vistaOperador.menuView);
        });

        vistaOperador.sendPedidoToCocinaButton.setOnAction(actionEvent -> {
            modelVistaOperador.sendPedido(clienteToLinkPedido, pedido);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("SUCCESSSS");
            alert.setHeaderText("PEDIDO ENVIADO A COCINA");
            alert.setContentText(
                    "El pedido fue enviado con exito!" + "\n" + "Porfavor agradezca a nuestros cocineros luego...");
            alert.showAndWait();
            vistaOperador.items.clear();
            pedido.clear();
            vistaOperador.switchScene(vistaOperador.optionPanel);
        });
        /*
         * / Producto[] pedidoArray = new Producto[pedido.size()];
         * Iterator<NodeInterface<Producto>> iteradorPedido = pedido.iterator();
         * DoubleListNode<Producto> tempPedido;
         * int p = 0;
         * while (iteradorPedido.hasNext()) {
         * tempPedido = (DoubleListNode<Producto>) iteradorPedido.next();
         * pedidoArray[p] = tempPedido.getObject();
         * p++;
         * }
         * // System.out.println(clienteToLinkPedido.getNombre());
         * modelVistaOperador.sendPedido(clienteToLinkPedido.getNombre(), pedidoArray);
         * });
         */
    }
    /**
     * Changes a String into a Long type
     * @param textToConfirm
     * @return 'true' if an 'String' was parsed to 'Long' , otherwise 'false'
     */
    public boolean checkNumber(String textToConfirm) {
        try {
            Long.parseLong(textToConfirm);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    /**
     * Setter for 'Cliente'
     * @param cliente
     * 
     */
    public void setClienteToLinkPedido(Cliente cliente) {
        clienteToLinkPedido = cliente;
    }
    /**
     * Setter for an iterator
     * @param iteraastor2
     */
    public void setIterator2(Iterator<NodeInterface<Producto>> iteraastor2) {
        this.iterator2 = iteraastor2;
    }
    /**
     * Gets the 'Cliente' from a ComboBox, this because the class atribute cant have a initialization on the constructor
     * @return 'Cliente' in order to have its reference
     */
    public Cliente getClienteToLinkPedido() {
        return clienteToLinkPedido;
    }
    /**
     * Gets the extra cost of a product
     * 
     * int this case is about 5%
     * @param producto
     * @return the price of the extra price of a product
     */
    public int getImpuesto(int producto) {
        return ((producto * 5) / 100);
    }
    /**
     * 
     * @param direccion
     * @return the price that cost the delivery
     */
    public int getPrecioDomicilio(String direccion) {
        return 0;
    }
}
