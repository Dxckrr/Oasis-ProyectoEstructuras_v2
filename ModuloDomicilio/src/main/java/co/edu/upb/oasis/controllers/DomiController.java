package co.edu.upb.oasis.controllers;

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
                         * Mirar que el pedidddos e reciba de la cocina
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
    }
}
