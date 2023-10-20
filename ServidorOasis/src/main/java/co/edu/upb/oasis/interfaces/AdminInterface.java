package co.edu.upb.oasis.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import co.edu.upb.oasis.clases.Usuario;
import co.edu.upb.oasis.estructuras.lists.LinkedList;

public interface AdminInterface extends Remote {
    public boolean login(String user, String password) throws RemoteException;
    public boolean addUsuario(String usuario, String contraseña, int id) throws RemoteException;
    public LinkedList<Usuario> buscarOperadorPorUsuario(String usuario) throws RemoteException;
    public boolean addProducto(String nombre, String descripcion, int precio, int tiempoDePreparacion, int id) throws RemoteException;

}
