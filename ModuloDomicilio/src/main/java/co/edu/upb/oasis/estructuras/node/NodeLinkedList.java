package co.edu.upb.oasis.estructuras.node;

public class NodeLinkedList<T> extends Nodo<T> {
    NodeLinkedList<T> siguiente;

    public NodeLinkedList() {
        super();
        siguiente = null;
    }

    public NodeLinkedList(T objeto) {
        super(objeto);
        siguiente = null;
    }

    public NodeLinkedList(T objeto, NodeLinkedList<T> siguiente) {
        super(objeto);
        this.siguiente = siguiente;
    }

    public NodeLinkedList<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodeLinkedList<T> siguiente) {
        this.siguiente = siguiente;
    }

    public boolean hasSiguiente() {
        if (this.siguiente != null) {
            return true;
        }
        return false;
    }
}

