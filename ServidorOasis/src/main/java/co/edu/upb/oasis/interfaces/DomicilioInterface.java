package co.edu.upb.oasis.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * @author Juliana Chavez King
 * @author Juan David Patiño Parra
 */
public interface DomicilioInterface extends Remote {
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

}
