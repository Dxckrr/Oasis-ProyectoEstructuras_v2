package co.edu.upb.oasis.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import co.edu.upb.oasis.clases.Cliente;
import co.edu.upb.oasis.clases.Pedido;
import co.edu.upb.oasis.clases.Producto;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;

/**
 * Interface for ServicioOperador
 * 
 * @author Juan David Patiño Parra
 */
public interface OperadorInterface extends Remote {
    /**
     * 
     * @param user
     * @param password
     * @return 'true' if the login was succesful (the data did match with the database) , otherwise 'false'
     * @throws RemoteException
     */
    public boolean login(String user, String password) throws RemoteException;

    /**
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
     * 
     * @return the 'DoubleLinkedList' of the products on the database
     * @throws RemoteException
     */
    public DoubleLinkedList<Producto> getMenu() throws RemoteException;
    /**
     * 
     * @return the 'DoubleLinkedList' of the clients on the database
     * @throws RemoteException
     */

    public DoubleLinkedList<Cliente> getClientes() throws RemoteException;
    /**
     * 
     * @param clienteToLink
     * @param pedidoList
     * @return 'true' if the information was processed succesfully , otherwise 'false'
     * @throws RemoteException
     */

    public boolean sendPedido(Cliente clienteToLink, DoubleLinkedList<Producto> pedidoList) throws RemoteException;

}
