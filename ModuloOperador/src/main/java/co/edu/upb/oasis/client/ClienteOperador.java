package co.edu.upb.oasis.client;

import co.edu.upb.oasis.clases.Cliente;
import co.edu.upb.oasis.clases.Pedido;
import co.edu.upb.oasis.clases.Producto;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;
import co.edu.upb.oasis.interfaces.OperadorInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClienteOperador implements OperadorInterface {
    private OperadorInterface service;
    private String ip;
    private String port;
    private String serviceName;
    private String url;

    public ClienteOperador(String ip, String port, String serviceName) {
        this.service = null;
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.url = "rmi://" + ip + ":" + port + "/" + serviceName;
    }

    @Override
    public boolean login(String user, String password) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.login(user, password);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addCliente(String nombreCliente, String direccion, String ciudad, int telefono)
            throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.addCliente(nombreCliente, direccion, ciudad, telefono);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public DoubleLinkedList<Producto> getMenu() throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.getMenu();
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public DoubleLinkedList<Cliente> getClientes() throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.getClientes();
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean sendPedido(Cliente clienteToLink, DoubleLinkedList<Producto> pedidoList) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.sendPedido(clienteToLink, pedidoList);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

}
