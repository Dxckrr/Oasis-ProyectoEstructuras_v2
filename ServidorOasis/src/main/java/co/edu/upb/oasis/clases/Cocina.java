package co.edu.upb.oasis.clases;

import co.edu.upb.oasis.estructuras.queue.PriorityQueue;

public class Cocina {
    public static PriorityQueue<Pedido> priorityQueueToCooK = new PriorityQueue<>(4);   //por definir VIP / NO , COCCION 

    public Cocina() {

    }

    public static boolean add(Pedido pedido) {
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
