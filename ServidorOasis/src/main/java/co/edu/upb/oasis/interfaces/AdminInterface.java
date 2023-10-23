package co.edu.upb.oasis.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import co.edu.upb.oasis.clases.Cliente;
import co.edu.upb.oasis.clases.Usuario;
import co.edu.upb.oasis.estructuras.lists.LinkedList;

/**
 * 
 * Interface for ServicioAdministrador
 * 
 * 
 * @author Juan David Patiño Parra
 * @author Juliana Chavez King
 */
public interface AdminInterface extends Remote {
    /**
     * 
     * @param user
     * @param password
     * @return 'true' if the login was succesful (the data did match with the
     *         database) , otherwise 'false'
     * @throws RemoteException
     */
    public boolean login(String user, String password) throws RemoteException;

    /**
     * 
     * @param usuario
     * @param contraseña
     * @param id
     * @return 'true' if an 'Usuario' was added correctly to the database ,
     *         otherwise 'false'
     * @throws RemoteException
     */
    public boolean addUsuario(String usuario, String contraseña, int id) throws RemoteException;

    /**
     * 
     * @param usuario
     * @return 'LinkedList' of the
     * @throws RemoteException
     */
    public LinkedList<Usuario> buscarOperadorPorUsuario(String usuario) throws RemoteException;

    /**
     * 
     * @param nombre
     * @param descripcion
     * @param precio
     * @param tiempoDePreparacion
     * @param id
     * @param isLento
     * @return 'true' if a 'Producto' was added correctly, if not 'false'
     * @throws RemoteException
     */
    public boolean addProducto(String nombre, String descripcion, int precio, int tiempoDePreparacion, int id,
            boolean isLento) throws RemoteException;
    /**
     * Search a client by its phone number
     * @param number
     * @return a 'Client' if exists, otherwise 'false'
     * @throws RemoteException
     */
    public Cliente buscarCliente(int number) throws RemoteException;
    /**
     * Delete a client by its phone number
     * @param number
     * @return 'true' if it worked, otherwise 'false'
     * @throws RemoteException
     */
    public boolean borrarrCliente(int number) throws RemoteException;

}
