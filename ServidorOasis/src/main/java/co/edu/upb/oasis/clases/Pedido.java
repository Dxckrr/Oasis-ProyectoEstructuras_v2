package co.edu.upb.oasis.clases;

import java.io.Serializable;

import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;
/**
 * 
 * Class that represents an order
 * 
 * Clase que representa un pedido
 * 
 * 
 * @author Juan David Patiño Parra
 */
public class Pedido implements Serializable {
    
    Cliente cliente;
    DoubleLinkedList<Producto> productos;

    public Pedido(Cliente cliente, DoubleLinkedList<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
    }
    /**
     * 
     * @return the 'Cliente' linked to the class
     */
    public Cliente getCliente() {
        return cliente;
    }
    /**
     * 
     * @return a 'DoubleLinkedList' with elements of 'Producto' type
     */
    public DoubleLinkedList<Producto> getProductos() {
        return productos;
    }
    @Override
    public String toString() {
        return "Pedido [cliente=" + cliente + ", productos=" + productos + "]";
    }
    
}
