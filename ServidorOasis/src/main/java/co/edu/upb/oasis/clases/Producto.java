package co.edu.upb.oasis.clases;

import java.io.Serializable;

/**
 * Class that represents a product.
 * 
 * Clase que representa un producto.
 * 
 * 
 * @author Juan David Patiño Parra
 */
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

    /**
     * Get the name of the product.
     * 
     * @return The name of the product.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Get the description of the product.
     * 
     * @return The description of the product.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Get the price of the product.
     *
     * @return The price of the product.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Get the preparation time of the product.
     * 
     * @return The preparation time of the product.
     */
    public int getTiempoDePreparacion() {
        return tiempoDePreparacion;
    }

    /**
     * Get the ID of the product.
     * 
     * @return The 'id' of the product.
     */
    public int getId() {
        return id;
    }

    /**
     * Check if the product is 'Lento'.
     * 
     * @return 'true' if the product is 'Lento', otherwise 'false'.
     */
    public boolean isLento() {
        return isLento;
    }


    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", id=" + id + "]";
    }

}
