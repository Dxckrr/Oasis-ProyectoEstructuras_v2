package co.edu.upb.oasis.client;

import co.edu.upb.oasis.clases.Pedido;
import co.edu.upb.oasis.interfaces.CocinaInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClienteCocina implements CocinaInterface {
    private CocinaInterface service;
    private String ip;
    private String port;
    private String serviceName;
    private String url;

    public ClienteCocina(String ip, String port, String serviceName) {
        this.service = null;
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.url = "rmi://" + ip + ":" + port + "/" + serviceName;
    }

    @Override
    public boolean login(String user, String password) throws RemoteException {
        try {
            service = (CocinaInterface) Naming.lookup(url);
            return service.login(user, password);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Pedido getPedido() throws RemoteException {
        try {
            service = (CocinaInterface) Naming.lookup(url);
            return service.getPedido();
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
