package co.edu.upb.oasis.interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

import co.edu.upb.oasis.clases.Usuario;
public interface AdminInterface extends Remote{
    public boolean login(String user, String password) throws RemoteException;
    public boolean addUsuario(String user , String password , int id) throws RemoteException;
    public boolean addCliente(String nombreCliente, String direccion, String ciudad, int telefono)throws RemoteException;
    public LinkedList<Usuario> buscarOperadorPorUsuario(String usuario) throws RemoteException;
    public boolean addProducto(String nombre, String descripcion, int precio, int tiempoDePreparacion, int id)throws RemoteException;

}
