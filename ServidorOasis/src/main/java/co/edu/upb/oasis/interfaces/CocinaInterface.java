package co.edu.upb.oasis.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import co.edu.upb.oasis.clases.Pedido;

/**
 * Interface for ServicioCocina
 * 
 * @author Juan David Patiño Parra
 */
public interface CocinaInterface extends Remote {
    /**
     * Checks if the user and password belong to an existing user
     * 
     * @param user
     * @param password
     * @return 'true' if the login was succesful (the data did match with the
     *         database), otherwise 'false'
     * @throws RemoteException
     */
    public boolean login(String user, String password) throws RemoteException;

    /**
     *  Gets a 'Pedido' from  a PriorityQueue of the server
     * 
     * @return 'Pedido' on the 'PriorityQueue' , if 'PriorityQueue' is empty return
     *         'null'
     * @throws RemoteException
     */
    public Pedido getPedido() throws RemoteException;

}
