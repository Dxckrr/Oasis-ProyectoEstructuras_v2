package co.edu.upb.oasis.services;

import co.edu.upb.oasis.clases.Cliente;
import co.edu.upb.oasis.clases.Cocina;
import co.edu.upb.oasis.clases.JSONClass;
import co.edu.upb.oasis.clases.Pedido;
import co.edu.upb.oasis.clases.Producto;
import co.edu.upb.oasis.clases.Usuario;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;
import co.edu.upb.oasis.estructuras.node.DoubleListNode;
import co.edu.upb.oasis.interfaces.OperadorInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;

public class ServicioOperador extends UnicastRemoteObject implements OperadorInterface {
    JSONClass<Usuario> jsonClassUser = new JSONClass("usuarios.json", Usuario.class);
    JSONClass<Cliente> jsonClassClientes = new JSONClass("clientes.json", Cliente.class);
    JSONClass<Producto> jsonClassMenu = new JSONClass("menu.json", Producto.class);
    // JSONClass jsonClassPedidos = new JSONClass("pedidos.json", Pedido.class);

    public ServicioOperador() throws RemoteException {
        jsonClassUser.cargarJson();
        jsonClassMenu.cargarJson();
        jsonClassClientes.cargarJson();
        // jsonClassPedidos.cargarJson();

    }

    @Override
    public boolean login(String user, String password) throws RemoteException {
        DoubleLinkedList lista = jsonClassUser.obtenerLista();
        Iterator iterator = lista.iterator();
        DoubleListNode temporal;
        Usuario tempUser;
        Usuario inUser = new Usuario(user, password);
        while (iterator.hasNext()) {
            temporal = (DoubleListNode) iterator.next();
            tempUser = (Usuario) temporal.getObject();
            /*
             * System.out.println(user);
             * System.out.println(password);
             * System.out.println("---------------");
             * System.out.println(inUser.getUsuario());
             * System.out.println(inUser.getPassword());
             * System.out.println("---------------");
             */
            if (tempUser.getUsuario().equals(inUser.getUsuario()) && tempUser.getPassword().equals(inUser.getPassword())
                    && (tempUser.getId() > 100 && tempUser.getId() < 200)) {
                System.out.println("1");
                return true;
            }
        }
        System.out.println("2");
        return false;
    }

    public boolean addClienteConfirmation(String nombreCliente, String direccion, String ciudad, int telefono)
            throws RemoteException {

        Cliente clienteToAdd = new Cliente(nombreCliente, direccion, ciudad, telefono);

        DoubleLinkedList lista = jsonClassClientes.obtenerLista();
        System.out.println("------------------");
        lista.imprimir();
        System.out.println("------------------");
        Iterator iterator = lista.iterator();
        DoubleListNode temporal;
        Cliente tempCliente;
        while (iterator.hasNext()) {

            temporal = (DoubleListNode) iterator.next();
            tempCliente = (Cliente) temporal.getObject();
            System.out.println("ClienteTemp telefono: " + tempCliente.getTelefono());
            System.out.println("Cliente to add telefono:  " + clienteToAdd.getTelefono());
            System.out.println("iUGLAS?");
            System.out.println(clienteToAdd.getTelefono() == tempCliente.getTelefono());
            if (clienteToAdd.getTelefono() == tempCliente.getTelefono()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addCliente(String nombreCliente, String direccion, String ciudad, int telefono) {
        try {
            // System.out.println(" ----" + addClienteConfirmation(nombreCliente, direccion,
            // ciudad, telefono));
            if (addClienteConfirmation(nombreCliente, direccion, ciudad, telefono)) {
                Cliente clienteToAdd = new Cliente(nombreCliente, direccion, ciudad, telefono);
                System.out.println("Entra");
                jsonClassClientes.agregarObjetico(clienteToAdd);
                return true;
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override

    public DoubleLinkedList<Producto> getMenu() {
        return jsonClassMenu.obtenerLista();
    }

    @Override

    public DoubleLinkedList<Cliente> getClientes() {
        return jsonClassClientes.obtenerLista();
    }

    @Override
    public boolean sendPedido(Cliente clienteToLink, DoubleLinkedList<Producto> pedidoList) throws RemoteException {
        try {
            Pedido pedidoToAdd = new Pedido(clienteToLink, pedidoList);
            clienteToLink.addPedido();

            DoubleLinkedList lista = jsonClassClientes.obtenerLista();
            Iterator iterator = lista.iterator();
            DoubleListNode temporal;
            Cliente tempCliente;
            while (iterator.hasNext()) {
                temporal = (DoubleListNode) iterator.next();
                tempCliente = (Cliente) temporal.getObject();
                if (clienteToLink.getTelefono() == tempCliente.getTelefono()) {
                    jsonClassClientes.actualizarObjetico(clienteToLink, tempCliente);
                    break;
                }
            }
            System.out.println(clienteToLink.getNombre());
            System.out.println(pedidoList);
            // DoubleLinkedList<Pedido> pedido = new DoubleLinkedList<>();

            // pedido.add(pedidoToAdd);
            // pedido.imprimir();

            System.out.println("aofsdfsfgsfs");
            return Cocina.add(pedidoToAdd);
        } catch (Exception e) {
            return false;
        }

    }

    /*
     * public boolean sendPedido(Cliente clienteToLink, DoubleLinkedList<Producto>
     * pedidoList) {
     * try {
     * System.out.println(clienteToLink);
     * pedidoList.imprimir();
     * Cliente tempCliente = new Cliente(clienteToLink.getNombre(),
     * clienteToLink.getDireccion(),
     * clienteToLink.getCiudad(), clienteToLink.getTelefono());
     * DoubleLinkedList<Producto> tempList = new DoubleLinkedList<>();
     * for (int i = 0; i < pedidoList.size(); i++) {
     * tempList.add(pedidoList.pop());
     * }
     * 
     * Pedido pedido = new Pedido(tempCliente, tempList);
     * jsonClassPedidos.agregarObjetico(pedido);
     * System.out.println(clienteToLink);
     * System.out.println(pedidoList.size());
     * return true;
     * }catch(Exception e){
     * return false;
     * }
     * 
     * }
     */

}
