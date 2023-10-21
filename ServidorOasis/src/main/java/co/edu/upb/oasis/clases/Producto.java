package co.edu.upb.oasis.clases;

import java.io.Serializable;

public class Producto implements Serializable {
    String nombre;
    String descripcion;
    int precio;
    int tiempoDePreparacion;
    int id;

    public Producto(String nombre, String descripcion, int precio, int tiempoDePreparacion, int id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tiempoDePreparacion = tiempoDePreparacion;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public int getTiempoDePreparacion() {
        return tiempoDePreparacion;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", id=" + id
                + "]";
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return precio == producto.precio &&
                tiempoDePreparacion == producto.tiempoDePreparacion &&
                id == producto.id &&
                Objects.equals(nombre, producto.nombre) &&
                Objects.equals(descripcion, producto.descripcion);
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(nombre, descripcion, precio, tiempoDePreparacion, id);
    }*/

}