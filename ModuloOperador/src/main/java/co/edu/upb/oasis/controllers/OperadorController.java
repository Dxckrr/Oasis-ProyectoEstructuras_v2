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
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OperadorController {

    Cliente clienteToLinkPedido;
    Iterator<NodeInterface<Producto>> iterator2;

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
            DoubleLinkedList<Cliente> clientes = modelVistaOperador.getClientes();
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

        vistaOperador.agregarClienteButton.setOnAction(actionEvent -> {
            // vistaOperador.window.setScene(VistaOperador.optionPanel);
            vistaOperador.switchScene(vistaOperador.agregarClienteView);

        });
        vistaOperador.goBackToClientes.setOnAction(actionEvent -> {
            // vistaOperador.window.setScene(VistaOperador.optionPanel);
            vistaOperador.switchScene(vistaOperador.clientesView);

        });
        // ---------------------------------------------------------------------------
        // aGREGAR CLIENTE

        vistaOperador.confirmAddButton.setOnAction(actionEvent -> {
            if (checkInteger(vistaOperador.telefono.getText())) {
                if (vistaOperador.cliente == null || vistaOperador.direccion == null || vistaOperador.ciudad == null
                        || vistaOperador.telefono == null) {
                } else {
                    if (modelVistaOperador.addCliente(vistaOperador.cliente.getText(),
                            vistaOperador.direccion.getText(), vistaOperador.ciudad.getText(),
                            (Integer.parseInt(vistaOperador.telefono.getText())))) {
                        vistaOperador.cliente.setText("");
                        vistaOperador.direccion.setText("");
                        vistaOperador.ciudad.setText("");
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
                DoubleListNode<Producto> increibleNode;
                while (iterator2.hasNext()) {
                    increibleNode = (DoubleListNode<Producto>) iterator2.next();
                    result += increibleNode.getObject().getNombre() + "| ";
                    precioTemp += increibleNode.getObject().getPrecio();
                }

                vistaOperador.pedidoText.setText(result);
                vistaOperador.domicilioText.setText("Depende aun");
                vistaOperador.precioText.setText(String.valueOf(precioTemp));
                vistaOperador.impuestoText.setText("dcdd");

                vistaOperador.precioTotalText.setText((String.valueOf(precioTemp))+" "+ "impuestos" );

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
            System.out.println("HOLAA");
            modelVistaOperador.sendPedido(clienteToLinkPedido, pedido);
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

    public boolean checkInteger(String textToConfirm) {
        try {
            Integer.parseInt(textToConfirm);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public void setClienteToLinkPedido(Cliente cliente) {
        clienteToLinkPedido = cliente;
    }

    public void setIterator2(Iterator<NodeInterface<Producto>> iteraastor2) {
        this.iterator2 = iteraastor2;
    }

    public Cliente getClienteToLinkPedido() {
        return clienteToLinkPedido;
    }

}
