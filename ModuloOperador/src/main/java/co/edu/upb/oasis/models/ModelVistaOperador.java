package co.edu.upb.oasis.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

import co.edu.upb.oasis.clases.Cliente;
import co.edu.upb.oasis.clases.Pedido;
import co.edu.upb.oasis.clases.Producto;
import co.edu.upb.oasis.client.ClienteOperador;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;
import javafx.scene.control.Alert;

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

    public boolean addCliente(String nombreCliente, String direccion, String ciudad, int telefono) {
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

    public void checkTelefono() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("TELEFONO ERROR");
        alert.setHeaderText("PORFAVOR INGRESE SOLO NUMEROS");
        alert.setContentText("Ejemplo !" + "\n" + "12948773");
        alert.showAndWait();
    }

    public DoubleLinkedList<Producto> getMenu() {
        try {
            return cliente.getMenu();

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public DoubleLinkedList<Cliente> getClientes() {
        try {
            return cliente.getClientes();

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * public boolean sendPedido(String nombreCliente, Producto[] productos) {
     * try {
     * return cliente.sendPedido(nombreCliente, productos);
     * 
     * } catch (RemoteException e) {
     * throw new RuntimeException(e);
     * }
     * }
     */

    public boolean sendPedido(Cliente clienteToLink, DoubleLinkedList<Producto> pedidoList) {
        try {
            return cliente.sendPedido(clienteToLink, pedidoList);

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

}
