package co.edu.upb.oasis.clases;

import java.io.Serializable;

import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;

public class Pedido implements Serializable {
    int id;
    public static DoubleLinkedList<Producto> productos;
    Cliente cliente;

    public Pedido() {
    }

    public int getId() {
        return id;
    }

    public static DoubleLinkedList getProductos() {
        return productos;
    }

    public void setProductos(DoubleLinkedList productos) {
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
