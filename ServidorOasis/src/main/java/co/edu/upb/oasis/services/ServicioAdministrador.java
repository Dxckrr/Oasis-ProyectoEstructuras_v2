package co.edu.upb.oasis.services;

import co.edu.upb.oasis.clases.JSONClass;
import co.edu.upb.oasis.clases.Producto;
import co.edu.upb.oasis.clases.Usuario;
import co.edu.upb.oasis.estructuras.interfaces.NodeInterface;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;
import co.edu.upb.oasis.estructuras.node.DoubleListNode;
import co.edu.upb.oasis.interfaces.AdminInterface;
import co.edu.upb.oasis.estructuras.lists.LinkedList;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.Iterator;
/**
 * Class that implements the AdminInterface
 * 
 * @author Juan David Patiño Parra
 * @author Juliana Chavez King
 */
public class ServicioAdministrador extends UnicastRemoteObject implements AdminInterface {
    JSONClass jsonClassUser = new JSONClass("usuarios.json", Usuario.class);
    public ServicioAdministrador() throws RemoteException {
    }

    @Override
    public boolean login(String user, String password) throws RemoteException {
        jsonClassUser.cargarJson();
        DoubleLinkedList lista = jsonClassUser.obtenerLista();
        Iterator iterator = lista.iterator();
        DoubleListNode temporal;
        Usuario tempUser;
        Usuario inUser = new Usuario (user,password);
        while(iterator.hasNext()){
            temporal = (DoubleListNode) iterator.next();
            tempUser = (Usuario) temporal.getObject();
            System.out.println(user);
            System.out.println(password);
            System.out.println("---------------");
            System.out.println(inUser.getUsuario());
            System.out.println(inUser.getPassword());
            System.out.println("---------------");
            if(tempUser.getUsuario().equals(inUser.getUsuario()) && tempUser.getPassword().equals(inUser.getPassword()) && (tempUser.getId()>200 && tempUser.getId()<300)){
                System.out.println("1");
                return true;
            }
        }
        System.out.println("2");
        return false;
    }

    public boolean addUsuarioConfirmation(String usuario, String contraseña, int id) throws RemoteException {
        Usuario usuarioToAdd = new Usuario(usuario, contraseña, id);

        jsonClassUser.cargarJson();
        DoubleLinkedList<Usuario> lista = jsonClassUser.obtenerLista();
        System.out.println("------------------");
        lista.imprimir();
        System.out.println("------------------");
        Iterator<NodeInterface<Usuario>> iterator = lista.iterator();
        NodeInterface<Usuario> temporal;
        Usuario tempCliente;
        while (iterator.hasNext()) {
            temporal = iterator.next();
            tempCliente = temporal.getObject();
            System.out.println("UsuarioTemp usuario: " + tempCliente.getUsuario());
            System.out.println("Usuario to add usuario:  " + usuarioToAdd.getUsuario());
            System.out.println("iUGLAS?");
            System.out.println(usuarioToAdd.getUsuario().equals(tempCliente.getUsuario()));
            if (usuarioToAdd.getUsuario().equals(tempCliente.getUsuario())) {
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean addUsuario(String usuario, String contraseña, int id) throws RemoteException {
        try {
            //System.out.println(" ----" + addClienteConfirmation(nombreCliente, direccion, ciudad, telefono));
            if (addUsuarioConfirmation(usuario, contraseña, id)) {
                Usuario usuarioToAdd = new Usuario(usuario, contraseña, id);
                System.out.println("Entra");
                jsonClassUser.agregarObjetico(usuarioToAdd);
                return true;
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean addProductoConfirmation(String nombre, String descripcion, int precio, int tiempoDePreparacion, int id) throws RemoteException {
        Producto productoToAdd = new Producto(nombre, descripcion, precio, tiempoDePreparacion, id);

        jsonClassUser.cargarJson();
        DoubleLinkedList<Producto> lista = jsonClassUser.obtenerLista();
        System.out.println("------------------");
        lista.imprimir();
        System.out.println("------------------");
        Iterator<NodeInterface<Producto>> iterator = lista.iterator();
        NodeInterface<Producto> temporal;
        Producto tempProducto;
        while (iterator.hasNext()) {
            temporal = iterator.next();
            tempProducto = temporal.getObject();
            System.out.println("ProductoTemp producto: " + tempProducto.getNombre());
            System.out.println("Producto to add producto:  " + productoToAdd.getNombre());
            System.out.println("iUGLAS?");
            System.out.println(productoToAdd.getNombre().equals(tempProducto.getNombre()));
            if (productoToAdd.getNombre().equals(tempProducto.getNombre())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addProducto(String nombre, String descripcion, int precio, int tiempoDePreparacion, int id) throws RemoteException {
        try {
            //System.out.println(" ----" + addClienteConfirmation(nombreCliente, direccion, ciudad, telefono));
            if (addProductoConfirmation(nombre, descripcion, precio, tiempoDePreparacion, id)){
                Producto productoTAdd = new Producto(nombre, descripcion, precio, tiempoDePreparacion, id);
                System.out.println("Entra");
                jsonClassUser.agregarObjetico(productoTAdd);
                return true;
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public LinkedList<Usuario> buscarOperadorPorUsuario(String usuario) throws RemoteException {
        LinkedList<Usuario> resultados = new LinkedList<>();
        try {
            jsonClassUser.cargarJson();
            DoubleLinkedList<Usuario> lista = jsonClassUser.obtenerLista();
            Iterator<NodeInterface<Usuario>> iterator = lista.iterator();
            while (iterator.hasNext()) {
                NodeInterface<Usuario> node = iterator.next();
                Usuario tempUser = node.getObject();
                String[] palabras = tempUser.getUsuario().split(" ");
                String[] stringUsuarioActual = palabras.length > 1 ? Arrays.copyOf(palabras, palabras.length + 1) : palabras;

                String usuarioToCompare = usuario.toLowerCase().replace(" ", "");
                for (String palabra : stringUsuarioActual) {
                    int igualdades = 0;
                    int pos1 = 0;
                    int pos2 = 0;
                    palabra = palabra.toLowerCase();
                    int limite = Math.min(usuarioToCompare.length(), palabra.length());
                    int iterador = 0;
                    while (iterador < limite) {
                        if (usuarioToCompare.charAt(pos1) == palabra.charAt(pos2)) {
                            igualdades++;
                            pos1++;
                            pos2++;
                        } else {
                            if ((pos2 + 1) < palabra.length() && usuarioToCompare.charAt(pos1) == palabra.charAt(pos2 + 1)) {
                                igualdades++;
                                pos1++;
                                pos2 += 2;
                                if (usuarioToCompare.length() >= palabra.length()) {
                                    iterador++;
                                }
                            } else {
                                pos1++;
                                pos2++;
                            }
                        }
                        iterador++;
                    }
                    if (igualdades > 0 && (double) usuarioToCompare.length() / igualdades <= 1.5) {
                        resultados.add(tempUser);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultados;
    }



    /*public static Producto fromJSON(String filePath) {
        try {
            Gson gson = new Gson();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("file:src\\main\\java\\co\\edu\\upb\\oasis\\services\\ServicioAdministrador.java"));
            //Convertir el JSON a objeto
            Producto product = gson.fromJson(bufferedReader, Producto.class);
            bufferedReader.close();
            return product;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/

}

