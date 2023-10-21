package co.edu.upb.oasis.clases;

import java.util.Iterator;

import co.edu.upb.oasis.estructuras.interfaces.NodeInterface;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;
import co.edu.upb.oasis.estructuras.node.DoubleListNode;
import co.edu.upb.oasis.estructuras.queue.PriorityQueue;

public class Cocina {
    public static PriorityQueue<Pedido> priorityQueueToCooK = new PriorityQueue<>(4);   //por definir VIP / NO , COCCION 

    public Cocina() {

    }

    public static boolean add(Pedido pedido) {
        if(pedido.getCliente().isVip()){
            priorityQueueToCooK.add(pedido, 0);
        } else {
            priorityQueueToCooK.add(pedido, 4);
        }
        //organizar prioridades

        //VIP RAPIDO / VIP LENTO

        //NO " " RAPIDO / LENTO
        return priorityQueueToCooK.add(pedido, 0);
    }

    public static Pedido pop() {
        return priorityQueueToCooK.extract();
    }

    public static boolean isEmpty() {
        return priorityQueueToCooK.isEmpty();
    }
}
