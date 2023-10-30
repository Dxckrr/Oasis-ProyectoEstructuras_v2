package co.edu.upb.oasis.clases;

import co.edu.upb.oasis.estructuras.queue.PriorityQueue;

/**
 * @author Juan David Patiño Parra
 */
public class Domicilio {

    public static PriorityQueue<Pedido> pedQueue = new PriorityQueue<>(2);

    public Domicilio() {

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
                pedQueue.add(pedido, 0);
            } else {
                pedQueue.add(pedido, 1);
            }
            return true;
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
        return pedQueue.extract();
    }

    /**
     * 
     * @return 'true' is the queue is empty otherwise 'false'
     */
    public static boolean isEmpty() {
        return pedQueue.isEmpty();
    }

}
