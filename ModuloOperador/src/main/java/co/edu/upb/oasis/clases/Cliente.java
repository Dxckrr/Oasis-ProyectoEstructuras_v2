package co.edu.upb.oasis.clases;

import java.io.Serializable;

/**
 * Class that represents a client.
 * 
 * Clase que representa a un cliente.
 * 
 * 
 * @author Juan David Patiño Parra
 */
public class Cliente implements Serializable {

    String nombre;
    String direccion;
    String barrio;
    long telefono;
    int numeroDePedidos;

    public Cliente(String nombre, String direccion, String barrio, long telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.barrio = barrio;
        this.telefono = telefono;
        this.numeroDePedidos = 0;
    }

    /**
     * 
     * 
     * @return The name of the client.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @return The address of the client.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * 
     * @return The neighborhood of the client.
     */
    public String getBarrio() {
        return barrio;
    }

    /**
     * 
     * @return The phone number of the client.
     */
    public long getTelefono() {
        return telefono;
    }

    /**
     * Updates the numbers of orders 
     * 
     * @return The updated number of orders.
     */
    public int addPedido() {
        return numeroDePedidos++;
    }

    /**
     * 
     * @return The number of orders done by the client.
     */
    public int getNumeroDePedidos() {
        return numeroDePedidos;
    }

    /**
     * Check if the client is a VIP customer (has placed 10 or more orders).
     * 
     * 
     * @return 'true' if the client is a VIP otherwise 'false'.
     */
    public boolean isVip() {
        return numeroDePedidos >= 10;
    }

    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", direccion=" + direccion + ", barrio=" + barrio + ", telefono="
                + telefono + "]";
    }
}
