package co.edu.upb.oasis.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import co.edu.upb.oasis.clases.Cliente;
import co.edu.upb.oasis.clases.Producto;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;

/**
 * Interface for 'ClienteOperador'
 * 
 * @author Juan David Patiño Parra
 */
public interface OperadorInterface extends Remote {
    /**
     *  Checks if the user and password belong to an existing user
     * @param user
     * @param password
     * @return 'true' if the login was succesful (the data did match with the database) , otherwise 'false'
     * @throws RemoteException
     */
    public boolean login(String user, String password) throws RemoteException;

    /**
     * Add a 'Cliente' to the database (JSON file)
     * 
     * @param nombreCliente
     * @param direccion
     * @param ciudad
     * @param telefono
     * @return 'true' if an 'Cliente' was added correctly to the database , otherwise 'false'
     * @throws RemoteException
     */
    public boolean addCliente(String nombreCliente, String direccion, String ciudad, long telefono)
            throws RemoteException;

    /**
     * Gets a List of products
     * @return the 'DoubleLinkedList' of the products on the database
     * @throws RemoteException
     */
    public DoubleLinkedList<Producto> getMenu() throws RemoteException;
    /**
     * Gets a list of clients
     * @return the 'DoubleLinkedList' of the clients on the database
     * @throws RemoteException
     */

    public DoubleLinkedList<Cliente> getClientes() throws RemoteException;
    /**
     * Sends a 'Pedido' to the Server and adds it to a 'PriorityQueue'
     * @param clienteToLink
     * @param pedidoList
     * @return 'true' if the information was send succesfully , otherwise 'false'
     * @throws RemoteException
     */

    public boolean sendPedido(Cliente clienteToLink, DoubleLinkedList<Producto> pedidoList) throws RemoteException;

}
