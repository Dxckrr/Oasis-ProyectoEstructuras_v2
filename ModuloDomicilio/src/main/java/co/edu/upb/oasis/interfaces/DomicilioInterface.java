package co.edu.upb.oasis.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import co.edu.upb.oasis.clases.Cliente;
import co.edu.upb.oasis.clases.Pedido;
import co.edu.upb.oasis.clases.Producto;

public interface DomicilioInterface extends Remote { 
    public boolean login(String user, String password) throws RemoteException;
    public void addPedido(Cliente cliente) throws RemoteException;
    void addProductoToPedido(Producto producto, Pedido pedido) throws RemoteException;
    double calcularTotalPorPedido(Pedido pedido) throws RemoteException;
    void generarFactura(Pedido pedido) throws RemoteException;
    double getMontoTotal() throws RemoteException;
    public int getCostosssDomicilio(Cliente cliente) throws RemoteException;
    public Cliente getCurrentUser() throws RemoteException;
    void agregarPedido(Pedido pedido) throws RemoteException;
    void entregarPedidos() throws RemoteException;
    void entregarPedido(Pedido pedido);
    
}
