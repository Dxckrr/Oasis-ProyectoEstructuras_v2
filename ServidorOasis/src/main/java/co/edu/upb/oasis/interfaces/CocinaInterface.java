package co.edu.upb.oasis.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import co.edu.upb.oasis.clases.Pedido;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;

public interface CocinaInterface extends Remote {
    public boolean login(String user, String password) throws RemoteException; 
    public Pedido getPedido() throws RemoteException;

}
