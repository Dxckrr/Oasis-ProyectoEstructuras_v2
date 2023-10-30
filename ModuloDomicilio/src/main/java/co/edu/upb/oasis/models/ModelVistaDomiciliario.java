package co.edu.upb.oasis.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

import co.edu.upb.oasis.clases.Cliente;
import co.edu.upb.oasis.clases.Pedido;
import co.edu.upb.oasis.clases.Producto;
import co.edu.upb.oasis.client.ClienteDomicilio;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;
import co.edu.upb.oasis.estructuras.queue.QueueList;
import co.edu.upb.oasis.interfaces.DomicilioInterface;

public class ModelVistaDomiciliario{
    private ClienteDomicilio domicilio;
    private Cliente cliente;
    private String numeroFactura;
    private DoubleLinkedList<Pedido> productos;
    private QueueList<Pedido> pedidosParaLlevar;
    private Pedido currentPedido;
    private double impuestoFijo = 0.08;

    public ModelVistaDomiciliario() {
        Properties properties = new Properties();
        productos = new DoubleLinkedList<>();
        pedidosParaLlevar = new QueueList<>();
        try {
            properties.load(new FileInputStream(new File("config.properties")));
            domicilio = new ClienteDomicilio((String) properties.get("IP"), (String) properties.get("PORT3"),
                    (String) properties.get("SERVICENAME3"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Pedido getPedido() {
        try {
            return domicilio.getPedido();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

}
