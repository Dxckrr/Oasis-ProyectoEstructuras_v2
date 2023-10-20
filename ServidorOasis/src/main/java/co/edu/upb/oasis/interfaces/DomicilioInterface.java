package co.edu.upb.oasis.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DomicilioInterface extends Remote {
    public boolean login(String user, String password) throws RemoteException;

}
