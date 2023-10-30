package co.edu.upb.oasis.services;

import co.edu.upb.oasis.clases.Cocina;
import co.edu.upb.oasis.clases.Domicilio;
import co.edu.upb.oasis.clases.JSONClass;
import co.edu.upb.oasis.clases.Pedido;
import co.edu.upb.oasis.clases.Usuario;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;
import co.edu.upb.oasis.estructuras.node.DoubleListNode;
import co.edu.upb.oasis.interfaces.DomicilioInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * Class that implements the DomicilioInterface
 * 
 * @author Juan David Patiño Parra
 */
public class ServicioDomicilio extends UnicastRemoteObject implements DomicilioInterface {
    JSONClass jsonClassUser = new JSONClass("usuarios.json", Usuario.class);
    //DoubleLinkedList<Pedido> listaPedidos = new DoubleLinkedList<>();
    public ServicioDomicilio() throws RemoteException {
    }

    public boolean login(String user, String password) throws RemoteException {
        jsonClassUser.cargarJson();
        DoubleLinkedList lista = jsonClassUser.obtenerLista();
        Iterator iterator = lista.iterator();
        DoubleListNode temporal;
        Usuario tempUser;
        Usuario inUser = new Usuario(user, password);
        while (iterator.hasNext()) {
            temporal = (DoubleListNode) iterator.next();
            tempUser = (Usuario) temporal.getObject();
            System.out.println(user);
            System.out.println(password);
            System.out.println("---------------");
            System.out.println(inUser.getUsuario());
            System.out.println(inUser.getPassword());
            System.out.println("---------------");
            if (tempUser.getUsuario().equals(inUser.getUsuario()) && tempUser.getPassword().equals(inUser.getPassword())
                    && (tempUser.getId() > 400 && tempUser.getId() < 500)) {
                System.out.println("1");
                return true;
            }
        }
        System.out.println("2");
        return false;
    }

    @Override
    public Pedido getPedido()throws RemoteException {
        try {
            if (!Domicilio.isEmpty()) {
                return Domicilio.pop();
            }
            return null;
        } catch (Exception e) {
            return null;
        }

    }
    
}
