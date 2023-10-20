package co.edu.upb.oasis.clases;

import java.io.Serializable;

import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;

public class Cliente implements Serializable {

    String nombre;
    String direccion;
    String ciudad;
    int telefono;
    //Tipo de cliente (ENUM )
    DoubleLinkedList<Pedido> pedidos;   //Tipo pedido

    public Cliente(String nombre, String direccion , String ciudad , int telefono){
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        pedidos = new DoubleLinkedList<>();
    }


    public String getNombre() {
        return nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getCiudad() {
        return ciudad;
    }
    public int getTelefono() {
        return telefono;
    }
    public DoubleLinkedList<Pedido> getPedidos() {
        return pedidos;
    }
    
    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", direccion=" + direccion + ", ciudad=" + ciudad + ", telefono="
                + telefono + ", pedidos=" + pedidos + "]";
    }
}
