package co.edu.upb.oasis.client;

import co.edu.upb.oasis.interfaces.DomicilioInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClienteDomicilio implements DomicilioInterface {
    private DomicilioInterface service;
    private String ip;
    private String port;
    private String serviceName;
    private String url;

    public ClienteDomicilio(String ip, String port, String serviceName){
        this.service = null;
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.url = "rmi://" + ip + ":" + port + "/" + serviceName;
    }


    @Override
    public boolean login(String user, String password) throws RemoteException {
        try{
            service = (DomicilioInterface) Naming.lookup(url);
            return service.login(user,password);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
