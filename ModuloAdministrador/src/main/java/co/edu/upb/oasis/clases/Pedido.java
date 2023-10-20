package co.edu.upb.oasis.clases;

import java.io.Serializable;

import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;

public class Pedido implements Serializable {
    
    int id;
    DoubleLinkedList<Pedido> productos;
    public Pedido(int id, DoubleLinkedList<Pedido> productos) {
        this.id = id;
        this.productos = productos;
    }
    public int getId() {
        return id;
    }
    public DoubleLinkedList<Pedido> getProductos() {
        return productos;
    }
    
}
