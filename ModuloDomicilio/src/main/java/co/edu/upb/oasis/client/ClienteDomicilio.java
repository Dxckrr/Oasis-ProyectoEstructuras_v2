package co.edu.upb.oasis.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import co.edu.upb.oasis.clases.Peddisos;
import co.edu.upb.oasis.clases.Pedido;
import co.edu.upb.oasis.estructuras.lists.LinkedList1;
import co.edu.upb.oasis.interfaces.DomicilioInterface;

public class ClienteDomicilio implements DomicilioInterface{
    private DomicilioInterface serviceEntrega;
    private String ip;
    private String port;
    private String serviceName;
    private String url;

    public ClienteDomicilio(String ip, String port, String serviceName){
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.url = "rmi://" + ip + ":" + port + "/" + serviceName;
    }

    public ClienteDomicilio() {
    }

    /*@Override
    public LinkedList1<Peddisos> getPedidos() throws RemoteException {
        try {
            if (serviceEntrega == null){
                serviceEntrega = (DomicilioInterface) Naming.lookup(this.url);
            }
            return serviceEntrega.getPedidos();
        } catch (NotBoundException | MalformedURLException ex) {
            ex.printStackTrace(); // Imprimir la excepción en la consola
        }
        return null;
    }*/

    @Override
    public Pedido getPedido() throws RemoteException {
        try {
            serviceEntrega = (DomicilioInterface) Naming.lookup(url);
            return serviceEntrega.getPedido();
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean login(String user, String password) throws RemoteException {
        try {
            serviceEntrega = (DomicilioInterface) Naming.lookup(this.url);
            return serviceEntrega.login(user, password);
        } catch (NotBoundException | MalformedURLException ex) {
            ex.printStackTrace(); // Imprimir la excepción en la consola
        }
        return false;
    }
}