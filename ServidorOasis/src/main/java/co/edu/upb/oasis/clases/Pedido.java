package co.edu.upb.oasis.clases;

import java.io.Serializable;

import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;

public class Pedido implements Serializable {
    
    Cliente cliente;
    DoubleLinkedList<Producto> productos;

    public Pedido(Cliente cliente, DoubleLinkedList<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public DoubleLinkedList<Producto> getProductos() {
        return productos;
    }
    @Override
    public String toString() {
        return "Pedido [cliente=" + cliente + ", productos=" + productos + "]";
    }
    
}
