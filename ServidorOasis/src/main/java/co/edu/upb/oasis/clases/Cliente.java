package co.edu.upb.oasis.clases;

import java.io.Serializable;

public class Cliente implements Serializable {

    String nombre;
    String direccion;
    String barrio;
    int telefono;
    int numeroDePedidos;

    // Tipo de cliente (ENUM )
    public Cliente(String nombre, String direccion, String barrio, int telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.barrio = barrio;
        this.telefono = telefono;
        this.numeroDePedidos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public int getTelefono() {
        return telefono;
    }

    public int addPedido() {
        return numeroDePedidos++;
    }

    public int getNumeroDePedidos() {
        return numeroDePedidos;
    }
    public boolean isVip(){
        return numeroDePedidos>=10;
    }

    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", direccion=" + direccion + ", barrio=" + barrio + ", telefono="
                + telefono + "]";
    }

}
