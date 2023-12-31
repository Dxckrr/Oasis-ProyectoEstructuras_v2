package co.edu.upb.oasis.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.Properties;

import co.edu.upb.oasis.clases.Cliente;
import co.edu.upb.oasis.clases.Producto;
import co.edu.upb.oasis.clases.Usuario;
import co.edu.upb.oasis.client.ClienteAdmin;
import javafx.scene.control.Alert;

public class ModelVistaAdministrador {
    ClienteAdmin adminn;
    LinkedList<Usuario> operadores = new LinkedList<>(); // Debes definir la lista de operadores
    // LinkedList<Producto> producto = new LinkedList<>();

    public ModelVistaAdministrador() {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(new File("config.properties")));
            adminn = new ClienteAdmin((String) properties.get("IP"), (String) properties.get("PORT1"),
                    (String) properties.get("SERVICENAME1"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean addUsuario(String usuario, String contraseña, int id) {
        // Cliente clienteToAdd = new Cliente(nombreCliente, direccion, ciudad,
        // telefono);
        try {
            if (adminn.addUsuario(usuario, contraseña, id)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("SUCCESS");
                alert.setHeaderText("USUARIO AGREGADO CON EXITO");
                alert.setContentText("El usuario ha sido agregado con exito!" + "\n" + "Ahora sigue con el pedido...");
                alert.showAndWait();
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERROR");
                alert.setHeaderText("USUARIO NO AGREGADO");
                alert.setContentText("El cliente ya existe !" + "\n" + "Ahora intenta de nuevo...");
                alert.showAndWait();
                return false;
            }

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addCliente(String nombreCliente, String direccion, String ciudad, int telefono) {
        // Cliente clienteToAdd = new Cliente(nombreCliente, direccion, ciudad,
        // telefono);
        try {
            if (adminn.addCliente(nombreCliente, direccion, ciudad, telefono)) {
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

    public void checkUser() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("USUARIO ERROR");
        alert.setHeaderText("PORFAVOR INGRESE SOLO EL USUARIO");
        alert.setContentText("VUELVA A INTENTARLO");
        alert.showAndWait();
    }

    public Cliente buscarCliente(int telefono) {
        try {
            return adminn.buscarCliente(telefono);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean addProducto(String nombre, String descripcion, int precio, int tiempoDePreparacion, int id) {
        // Cliente clienteToAdd = new Cliente(nombreCliente, direccion, ciudad,
        // telefono);
        try {
            if (adminn.addProducto(nombre, descripcion, precio, tiempoDePreparacion, id)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("SUCCESS");
                alert.setHeaderText("PRODUCTO AGREGADO CON EXITO");
                alert.setContentText("El producto ha sido agregado con exito!" + "\n" + "Ahora sigue con el pedido...");
                alert.showAndWait();
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERROR");
                alert.setHeaderText("PRODUCTO NO AGREGADO");
                alert.setContentText("El PRODUCTO ya existe !" + "\n" + "Ahora intenta de nuevo...");
                alert.showAndWait();
                return false;
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}