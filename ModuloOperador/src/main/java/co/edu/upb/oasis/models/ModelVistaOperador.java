package co.edu.upb.oasis.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

import co.edu.upb.oasis.clases.Cliente;
import co.edu.upb.oasis.clases.Producto;
import co.edu.upb.oasis.client.ClienteOperador;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;
import javafx.scene.control.Alert;

/**
 * 
 * Class that represents the operations for the 'VistaOperador'
 * 
 * 
 * @author Juan David Patiño Parra
 * 
 */
public class ModelVistaOperador {
    ClienteOperador cliente;

    public ModelVistaOperador() {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(new File("config.properties")));

            cliente = new ClienteOperador((String) properties.get("IP"), (String) properties.get("PORT"),
                    (String) properties.get("SERVICENAME"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Asks the server if a 'Cliente' can be added to the database
     * 
     * @param nombreCliente
     * @param direccion
     * @param ciudad
     * @param telefono
     * @return 'true' if it can, otherwise no
     */
    public boolean addCliente(String nombreCliente, String direccion, String ciudad, long telefono) {
        // Cliente clienteToAdd = new Cliente(nombreCliente, direccion, ciudad,
        // telefono);
        try {
            if (cliente.addCliente(nombreCliente, direccion, ciudad, telefono)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("SUCCESS");
                alert.setHeaderText("CLIENTE AGREGADO CON EXITO");
                alert.setContentText("El cliente ha sido agregado con exito!" + "\n" + "Ahora sigue con el pedido...");
                alert.showAndWait();
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERROR");
                alert.setHeaderText("CLIENTE NO AGREGADO");
                alert.setContentText("El cliente ya existe !" + "\n" + "Ahora intenta de nuevo...");
                alert.showAndWait();
                return false;
            }

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Creates an 'Alert' to inform that there was a mistake on addingClient
     */
    public void checkTelefono() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("TELEFONO ERROR");
        alert.setHeaderText("PORFAVOR INGRESE SOLO NUMEROS");
        alert.setContentText("Ejemplo !" + "\n" + "12948773");
        alert.showAndWait();
    }

    /**
     * Asks the server for a List of products
     * 
     * @return 'DoubleLinkedList' of products
     */
    public DoubleLinkedList<Producto> getMenu() {
        try {
            return cliente.getMenu();

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Asks the server for a List of products
     * 
     * @return 'DoubleLinkedList' of products
     */
    public DoubleLinkedList<Cliente> getClientes() {
        try {
            return cliente.getClientes();

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Asks the server for request to 'sendPedido'
     * @param clienteToLink
     * @param pedidoList
     * @return 'true' if it was successful , otherwise 'false'
     */
    public boolean sendPedido(Cliente clienteToLink, DoubleLinkedList<Producto> pedidoList) {
        try {
            return cliente.sendPedido(clienteToLink, pedidoList);

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

}
