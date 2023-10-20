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

}
