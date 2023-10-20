package co.edu.upb.oasis.server;

import co.edu.upb.oasis.interfaces.AdminInterface;
import co.edu.upb.oasis.interfaces.CocinaInterface;
import co.edu.upb.oasis.interfaces.DomicilioInterface;
import co.edu.upb.oasis.services.ServicioAdministrador;
import co.edu.upb.oasis.services.ServicioCocina;
import co.edu.upb.oasis.services.ServicioDomicilio;
import co.edu.upb.oasis.services.ServicioOperador;
import co.edu.upb.oasis.interfaces.OperadorInterface;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    public String ip;
    public String port;
    public String serviceName;
    public String url;

    public Server(String ip, String port, String serviceName) {
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.url = "//" + ip + ":" + port + "/" + serviceName;
    }

    public Server(String ip) {
        this.ip = ip;

    }

    public boolean deployServices() {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(new File("config.properties")));
            deployServiceOperador(
                    "Operador",
                    (String) properties.get("PORT"),
                    (String) properties.get("SERVICENAME"));

            deployServiceAdministrador(
                    "Admin",
                    (String) properties.get("PORT1"),
                    (String) properties.get("SERVICENAME1"));

            deployServiceCocina(
                    "Cocina",
                    (String) properties.get("PORT2"),
                    (String) properties.get("SERVICENAME2"));

            deployServiceDomicilio(
                    "Domicilio",
                    (String) properties.get("PORT3"),
                    (String) properties.get("SERVICENAME3"));

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deployServiceOperador(String serviceType, String port, String serviceName) {
        boolean ack = false;
        if (ip == null | port == null | serviceName == null)
            return ack;
        try {
            System.setProperty("java.rmi.server.hostname", ip);
            String url = "//" + ip + ":" + port + "/" + serviceName;
            LocateRegistry.createRegistry(Integer.parseInt(port)); // port
            OperadorInterface service = new ServicioOperador();
            Naming.rebind(url, service);
            System.out.println("Service:" + serviceType + ": on");
            ack = true;
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        } finally {
            return ack;
        }
    }

    public boolean deployServiceAdministrador(String serviceType, String port, String serviceName) {
        boolean ack = false;
        if (ip == null | port == null | serviceName == null)
            return ack;
        try {
            System.setProperty("java.rmi.server.hostname", ip);
            String url = "//" + ip + ":" + port + "/" + serviceName;
            LocateRegistry.createRegistry(Integer.parseInt(port)); // port
            AdminInterface service = new ServicioAdministrador();
            Naming.rebind(url, service);
            System.out.println("Service:" + serviceType + ": on");
            ack = true;
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        } finally {
            return ack;
        }
    }

    public boolean deployServiceCocina(String serviceType, String port, String serviceName) {
        boolean ack = false;
        if (ip == null | port == null | serviceName == null)
            return ack;
        try {
            System.setProperty("java.rmi.server.hostname", ip);
            String url = "//" + ip + ":" + port + "/" + serviceName;
            LocateRegistry.createRegistry(Integer.parseInt(port)); // port
            CocinaInterface service = new ServicioCocina();
            Naming.rebind(url, service);
            System.out.println("Service:" + serviceType + ": on");
            ack = true;
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        } finally {
            return ack;
        }
    }

    public boolean deployServiceDomicilio(String serviceType, String port, String serviceName) {
        boolean ack = false;
        if (ip == null | port == null | serviceName == null)
            return ack;
        try {
            System.setProperty("java.rmi.server.hostname", ip);
            String url = "//" + ip + ":" + port + "/" + serviceName;
            LocateRegistry.createRegistry(Integer.parseInt(port)); // port
            DomicilioInterface service = new ServicioDomicilio();
            Naming.rebind(url, service);
            System.out.println("Service:" + serviceType + ": on");
            ack = true;
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        } finally {
            return ack;
        }
    }

}
