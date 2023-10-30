package co.edu.upb.oasis.clases;

import java.io.Serializable;

import co.edu.upb.oasis.estructuras.lists.LinkedList1;

public class Peddisos implements Serializable{
    public LinkedList1<Producto> listaProductos = new LinkedList1<>();
    public String id;
    public String nombres;
    public String apellidos;
    public int claseDelCliente; //para premium es 1 para regular es 0
    public String direccion;
    public String barrio;
    public double valorTotal;
    public int cantidadProductos;
    public String numeroTelefono;

    public Peddisos(){
        valorTotal = 0;
    }
    public Peddisos(String nombres, String apellidos, int claseDelCliente, String direccion, int valorTotal) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.claseDelCliente = claseDelCliente;
        this.direccion = direccion;
        this.valorTotal = valorTotal;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getClaseDelCliente() {
        return claseDelCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void addProducto(Producto newProduct){
        listaProductos.add(newProduct);
        valorTotal += newProduct.precio;
    }

    public void removeProduct(Producto producto){
        if (listaProductos.remove(producto)){
            valorTotal -= producto.precio;
        }
    }

    public void imprimir(){
        listaProductos.imprimir();
    }

    @Override
    public String toString(){
        return "-" + nombres + ",  $" + valorTotal;
    }

}

