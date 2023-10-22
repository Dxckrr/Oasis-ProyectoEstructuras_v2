package co.edu.upb.oasis.clases;

import java.util.Iterator;

import co.edu.upb.oasis.estructuras.interfaces.NodeInterface;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;
import co.edu.upb.oasis.estructuras.node.DoubleListNode;
import co.edu.upb.oasis.estructuras.queue.PriorityQueue;

/**
 * 
 * Class that manage "orders" with the Kitchen by using an static PriorityQueue
 * 
 * Clase que permite el manejo de los pedidos con la cocina haciendo uso de una
 * cola estatica de tipo pedido
 * 
 * @author Juan David Patiño Parra
 */

public class Cocina {

    public static PriorityQueue<Pedido> priorityQueueToCooK = new PriorityQueue<>(4); // por definir VIP / NO , COCCION

    public Cocina() {

    }

    /**
     * Recibes an 'Pedido' and adds it to a PriorityQueue
     * 
     * @param pedido
     * 
     * @return true when the procces was succesful otherwise false
     */
    public static boolean add(Pedido pedido) {

        try {
            if (pedido.getCliente().isVip()) {

                if (pedido.getProductos().size() >= 5) {
                    priorityQueueToCooK.add(pedido, 0);

                    return true;

                } else {

                    priorityQueueToCooK.add(pedido, 2);

                    return true;
                }
            } else {

                if (pedido.getProductos().size() >= 5) {
                    priorityQueueToCooK.add(pedido, 1);

                    return true;
                } else {
                    priorityQueueToCooK.add(pedido, 3);

                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 
     * @return the 'Pedido' which was previously added, if it doesnt exist so it
     *         will return null
     */
    public static Pedido pop() {
        return priorityQueueToCooK.extract();
    }

    /**
     * 
     * @return 'true' is the queue is empty otherwise 'false'
     */
    public static boolean isEmpty() {
        return priorityQueueToCooK.isEmpty();
    }
}
