package co.edu.upb.oasis.controllers;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Iterator;

import co.edu.upb.oasis.clases.Pedido;
import co.edu.upb.oasis.clases.Producto;
import co.edu.upb.oasis.estructuras.interfaces.NodeInterface;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;
import co.edu.upb.oasis.estructuras.node.DoubleListNode;
import co.edu.upb.oasis.estructuras.queue.PriorityQueue;
import co.edu.upb.oasis.models.ModelVistaDomiciliario;
import co.edu.upb.oasis.vistas.VistaDomicilio;
import javafx.scene.control.Alert;

public class DomiController {
    public DomiController()throws RemoteException{
        VistaDomicilio vistaDomicilio = new VistaDomicilio();
        ModelVistaDomiciliario modelVistaDomiciliario = new ModelVistaDomiciliario();

        PriorityQueue<Producto> laColaDElDomosilio = new PriorityQueue<>(8);
        PriorityQueue<Producto> laColaTemporalDelDomicilio = new PriorityQueue<>(8);
        PriorityQueue<Pedido> pedidosENlAMotoO = new PriorityQueue<>(8);
        DoubleLinkedList<Pedido> pedidos = new DoubleLinkedList<>();
        DoubleLinkedList<Pedido> productosPedidosPorellos = new DoubleLinkedList<>();

        vistaDomicilio.tenerLosPedidosBotoon.setOnAction(actionEvent -> {
            try {
                Pedido inPedido = modelVistaDomiciliario.getPedido();
                pedidos.add(inPedido);
                DoubleLinkedList<Producto> productosEnPedido = inPedido.getProductos();
                System.out.println(productosEnPedido);
                if (!productosEnPedido.isEmpty()) {
                    Iterator<NodeInterface<Producto>> iterator = productosEnPedido.iterator();
                    DoubleListNode<Producto> temp;
                    while (iterator.hasNext()) {
                        /*
                         * hacer la logica de los pedidos que lleguen ede cocina, que al dar click en el 
                         * botton se vean todos los pedidos de la cola que mando la cocina
                         */
                    }

                    /*System.out.println(laColaDElDomosilio.size());
                    while (!laColaDElDomosilio.isEmpty()) {
                        vistaDomicilio.items.add(laColaDElDomosilio.extract().getNombre());
                        System.out.println("------------");
                    }*/
                }

            } catch (Exception e) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("VACIO");
                alert.setHeaderText("NO HAY MAS PEDIDOS");
                alert.setContentText("La cola de pedidos a entragar esta vacia....");
                alert.showAndWait();
            }
        });

        vistaDomicilio.mostrarPedidosButton.setOnAction(actionEvent -> {
            try {
                Pedido inPedido = modelVistaDomiciliario.getPedido();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información del Pedido");
                alert.setHeaderText("Detalles del Pedido:");
                alert.setContentText("Cliente: " + inPedido.getCliente().getNombre() + "\n" +
                                    "Productos:");

                DoubleLinkedList<Producto> productosEnPedido = inPedido.getProductos();
                Iterator<NodeInterface<Producto>> iterator = productosEnPedido.iterator();
                while (iterator.hasNext()) {
                    Producto producto = iterator.next().getObject();
                    alert.setContentText(alert.getContentText() + "\n- " + producto.getNombre());
                }
            }catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("0 PEDIDOS");
                alert.setHeaderText("NO HAY MAS PEDIDOS");
                alert.setContentText("La cola de pedidos a entragar esta vacia....");
                alert.showAndWait();
            }
        });
    }
}
