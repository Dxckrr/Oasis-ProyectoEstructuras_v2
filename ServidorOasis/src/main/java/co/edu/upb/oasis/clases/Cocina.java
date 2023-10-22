package co.edu.upb.oasis.clases;

import java.util.Iterator;

import co.edu.upb.oasis.estructuras.interfaces.NodeInterface;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;
import co.edu.upb.oasis.estructuras.node.DoubleListNode;
import co.edu.upb.oasis.estructuras.queue.PriorityQueue;

public class Cocina {
    public static PriorityQueue<Pedido> priorityQueueToCooK = new PriorityQueue<>(4); // por definir VIP / NO , COCCION

    public Cocina() {

    }

    public static boolean add(Pedido pedido) {
        try {
            if (pedido.getCliente().isVip()) {

                if (pedido.getProductos().size() >= 5) {
                    priorityQueueToCooK.add(pedido, 0);
                    System.out.println(priorityQueueToCooK.size());

                    return true;

                } else {

                    priorityQueueToCooK.add(pedido, 2);
                    System.out.println(priorityQueueToCooK.size());

                    return true;
                }
            } else {

                if (pedido.getProductos().size() >= 5) {
                    priorityQueueToCooK.add(pedido, 1);
                    System.out.println(priorityQueueToCooK.size());

                    return true;
                } else {
                    priorityQueueToCooK.add(pedido, 3);
                    System.out.println(priorityQueueToCooK.);

                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        // organizar prioridades

        // VIP RAPIDO / VIP LENTO

        // NO " " RAPIDO / LENTO
    }

    public static Pedido pop() {
        return priorityQueueToCooK.extract();
    }

    public static boolean isEmpty() {
        return priorityQueueToCooK.isEmpty();
    }
}
