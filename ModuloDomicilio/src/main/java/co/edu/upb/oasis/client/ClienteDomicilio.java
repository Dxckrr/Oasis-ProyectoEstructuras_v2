package co.edu.upb.oasis.client;

import co.edu.upb.oasis.clases.Cliente;
import co.edu.upb.oasis.clases.Pedido;
import co.edu.upb.oasis.clases.Producto;
import co.edu.upb.oasis.interfaces.DomicilioInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClienteDomicilio implements DomicilioInterface {
    private DomicilioInterface service;
    private String ip;
    private String port;
    private String serviceName;
    private String url;

    public ClienteDomicilio(String ip, String port, String serviceName){
        this.service = null;
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.url = "rmi://" + ip + ":" + port + "/" + serviceName;
    }


    @Override
    public boolean login(String user, String password) throws RemoteException {
        try{
            service = (DomicilioInterface) Naming.lookup(url);
            return service.login(user,password);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public void addPedido(Cliente cliente) throws RemoteException {
        try {
            service = (DomicilioInterface) Naming.lookup(url);
            service.addPedido(cliente);
        } catch (Exception e) {
            System.err.println("Error en enviar el pedido");
            e.printStackTrace();
        }
    }

    @Override

    public void addProductoToPedido(Producto producto, Pedido pedido) throws RemoteException {
        try {
            service = (DomicilioInterface) Naming.lookup(url);
            service.addProductoToPedido(producto, pedido);
        } catch (Exception e) {
            System.err.println("Error en enviar el pedido");
            e.printStackTrace();
        }
    }

    @Override
    public double calcularTotalPorPedido(Pedido pedido) throws RemoteException {

        try {
            service = (DomicilioInterface) Naming.lookup(url);
            service.calcularTotalPorPedido(pedido);
        } catch (Exception e) {
            System.err.println("Error en enviar el pedido");
            e.printStackTrace();
        }
        return 0;
    }

    @Override

    public void generarFactura(Pedido pedido) throws RemoteException {

        try {
            service = (DomicilioInterface) Naming.lookup(url);
            service.generarFactura(pedido);
        } catch (Exception e) {
            System.err.println("Error en enviar el pedido");
            e.printStackTrace();
        }
    }

    @Override
    public double getMontoTotal() throws RemoteException {
        try {
            service = (DomicilioInterface) Naming.lookup(url);
            service.getMontoTotal();
        } catch (Exception e) {
            System.err.println("Error en enviar el pedido");
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Cliente getCurrentUser() throws RemoteException {
        try {
            service = (DomicilioInterface) Naming.lookup(url);
            service.getCurrentUser();
        } catch (Exception e) {
            System.err.println("Error en enviar el pedido");
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentUser'");
    }

    @Override
    public void agregarPedido(Pedido pedido) throws RemoteException {
        try {
            service = (DomicilioInterface) Naming.lookup(url);
            service.agregarPedido(pedido);
        } catch (Exception e) {
            System.err.println("Error en enviar el pedido");
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'agregarPedido'");
    }

    @Override
    public void entregarPedidos() throws RemoteException {
       try {
            service = (DomicilioInterface) Naming.lookup(url);
            service.entregarPedidos();
        } catch (Exception e) {
            System.err.println("Error en enviar el pedido");
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'entregarPedidos'");
    }

    @Override
    public void entregarPedido(Pedido pedido) {
       try {
            service = (DomicilioInterface) Naming.lookup(url);
            service.entregarPedido(pedido);
        } catch (Exception e) {
            System.err.println("Error en enviar el pedido");
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'entregarPedido'");
    }

    public boolean isConnected() throws RemoteException{
        try{
            System.out.println(url);
            service = (DomicilioInterface) Naming.lookup(url);
            return true;
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public int getCostosssDomicilio(Cliente cliente) throws RemoteException {
        try {
            service = (DomicilioInterface) Naming.lookup(url);
            service.getCostosssDomicilio(cliente);
        } catch (Exception e) {
            System.err.println("Error en enviar el pedido");
            e.printStackTrace();
        }
        return 0;
    }

}
