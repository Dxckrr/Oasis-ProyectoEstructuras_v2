package co.edu.upb.oasis.controllers;

import java.util.Iterator;

import co.edu.upb.oasis.clases.Producto;
import co.edu.upb.oasis.estructuras.interfaces.NodeInterface;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;
import co.edu.upb.oasis.estructuras.node.DoubleListNode;
import co.edu.upb.oasis.estructuras.queue.PriorityQueue;
import co.edu.upb.oasis.models.ModelCocina;
import co.edu.upb.oasis.vistas.VistaCocina;

public class CocinaViewController {

    public CocinaViewController() {
        ModelCocina modelCocina = new ModelCocina();
        VistaCocina vistaCocina = new VistaCocina();
        // CREAR OTRA COLA PARA ASI ORGANIZAR LOS PEDIDOS
        PriorityQueue<Producto> mPriorityQueue = new PriorityQueue<>(2);
        PriorityQueue<Producto> mPriorityQueueCopia = new PriorityQueue<>(2);

        vistaCocina.getPedidos.setOnAction(actionEvent -> {
            // ---
            DoubleLinkedList<Producto> productosEnPedido = modelCocina.getPedido().getProductos();
            Iterator<NodeInterface<Producto>> iterator = productosEnPedido.iterator();
            DoubleListNode<Producto> temp;
            while (iterator.hasNext()) {
                temp = (DoubleListNode<Producto>) iterator.next();
                String productoTemp = temp.getObject().getNombre();
                // implementar una listview
                // ----CAMBIAR ESTO DE ADD AQUI
                if (temp.getObject().isLento()) {
                    mPriorityQueue.add(temp.getObject(), 0);
                    mPriorityQueueCopia.add(temp.getObject(), 0);
                } else {
                    mPriorityQueue.add(temp.getObject(), 1);
                    mPriorityQueueCopia.add(temp.getObject(), 1);
                }
            }

            for (int i = 0; i <= mPriorityQueue.size(); i++) {
                vistaCocina.items.add(mPriorityQueue.extract().getNombre());
            }

            // System.out.println(modelCocina.getPedido());
        });

    }

}
