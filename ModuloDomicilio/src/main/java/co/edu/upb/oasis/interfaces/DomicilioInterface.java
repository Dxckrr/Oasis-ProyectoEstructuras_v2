package co.edu.upb.oasis.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import co.edu.upb.oasis.clases.Cliente;
import co.edu.upb.oasis.clases.Pedido;
import co.edu.upb.oasis.clases.Producto;
import co.edu.upb.oasis.estructuras.lists.LinkedList1;

public interface DomicilioInterface extends Remote { 
    public boolean login(String user, String password) throws RemoteException;
    //public LinkedList1<Peddisos> getPedidos() throws RemoteException;
    public Pedido getPedido() throws RemoteException;
}
