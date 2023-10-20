package co.edu.upb.oasis.client;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.LinkedList;
//import com.google.gson.*;

import co.edu.upb.oasis.clases.Producto;
import co.edu.upb.oasis.clases.Usuario;
import co.edu.upb.oasis.interfaces.AdminInterface;

public class ClienteAdmin implements AdminInterface {
    private AdminInterface service;
    private String ip;
    private String port;
    private String serviceName;
    private String url;

    public ClienteAdmin(String ip, String port, String serviceName){
        this.service = null;
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.url = "rmi://" + ip + ":" + port + "/" + serviceName;
    }


    @Override
    public boolean login(String user, String password) throws RemoteException {
        try{
            service = (AdminInterface) Naming.lookup(url);
            return service.login(user,password);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addUsuario(String user , String password , int id) throws RemoteException {
        try {
            service = (AdminInterface) Naming.lookup(url);
            return service.addUsuario(user,password,id);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean addCliente(String nombreCliente, String direccion, String ciudad, int telefono)throws RemoteException {
        try {
            service = (AdminInterface) Naming.lookup(url);
            return service.addCliente(nombreCliente, direccion, ciudad, telefono);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public LinkedList<Usuario> buscarOperadorPorUsuario(String usuario) throws RemoteException {
        try {
            service = (AdminInterface) Naming.lookup(url);
            return service.buscarOperadorPorUsuario(usuario);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return new LinkedList<>();
        }
    }

    @Override
    public boolean addProducto(String nombre, String descripcion, int precio, int tiempoDePreparacion, int id)throws RemoteException {
        try {
            service = (AdminInterface) Naming.lookup(url);
            return service.addProducto(nombre, descripcion, precio, tiempoDePreparacion, id);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

     /*public static Producto fromJSON(String filePath) {
        try {
            Gson gson = new Gson();
            File file = new File(filePath);
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
                // Convertir el JSON a objeto
                Producto product = gson.fromJson(bufferedReader, Producto.class);
                bufferedReader.close();
                return product;
            } else {
                System.out.println("El archivo no existe en la ruta especificada.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/

}