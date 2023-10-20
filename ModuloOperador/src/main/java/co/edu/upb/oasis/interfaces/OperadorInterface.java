package co.edu.upb.oasis.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import co.edu.upb.oasis.clases.Cliente;
import co.edu.upb.oasis.clases.Pedido;
import co.edu.upb.oasis.clases.Producto;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;

public interface OperadorInterface extends Remote {

    public boolean login(String user, String password) throws RemoteException;

    public boolean addCliente(String nombreCliente, String direccion, String ciudad, int telefono)
            throws RemoteException;

    public DoubleLinkedList<Producto> getMenu() throws RemoteException;

    public DoubleLinkedList<Cliente> getClientes() throws RemoteException;

    public boolean sendPedido(Cliente clienteToLink, DoubleLinkedList<Producto> pedidoList) throws RemoteException;


}
