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

public class ModelVistaDomiciliario  implements DomicilioInterface{
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


    @Override
    public void addPedido(Cliente cliente) throws RemoteException {
        Pedido nuevoPedido = new Pedido();
        productos.add(nuevoPedido);
    }

    @Override
    public void addProductoToPedido(Producto producto, Pedido pedido) throws RemoteException {
        ClienteDomicilio clienteCocina= new ClienteDomicilio("localhost", "5000", "ServiceDomicilio");
        clienteCocina.addProductoToPedido(producto,pedido);

        for (DoubleLinkedList<Pedido> current = (DoubleLinkedList<Pedido>) productos.getHead(); current != null; current = current.getNext()) {
            if (current.get() == pedido) {
                Pedido pedidoEncontrado = current.get();
                DoubleLinkedList<Producto> productosPedido = pedidoEncontrado.getProductos();
                productosPedido.add(producto);

                return;
            }
        }

        throw new RemoteException("Pedido no encontrado: " + pedido);
    }

    @Override
    public double calcularTotalPorPedido(Pedido pedido) throws RemoteException {
         ClienteDomicilio clienteCocina= new ClienteDomicilio("localhost", "5000", "ServiceDomicilio");
        clienteCocina.calcularTotalPorPedido(pedido);

        DoubleLinkedList<Producto> productosPedido = pedido.getProductos();

        double total = 0.0;

        // Recorre la lista de productos del pedido y suma los precios
        for (DoubleLinkedList<Pedido> current = productosPedido.getHead(); current != null; current = current.getNext()) {
            Producto producto = current.getObject();
            total += producto.getPrecio() * impuestoFijo;
        }

        return total;
    }

    @Override
    public void generarFactura(Pedido pedido) throws RemoteException {
         ClienteDomicilio clienteCocina= new ClienteDomicilio("localhost", "5000", "ServiceDomicilio");
        clienteCocina.generarFactura(pedido);

        DoubleLinkedList<Producto> productosPedido = pedido.getProductos();

        StringBuilder factura = new StringBuilder();

        factura.append("Factura de Compra\n\n");
        factura.append("Cliente: ").append(pedido.getCliente().getNombre()).append("\n");
        factura.append("Dirección: ").append(pedido.getCliente().getCiudad()).append("\n");
        factura.append("Número de Factura: ").append(pedido.getCliente()).append("\n\n");

        factura.append("Productos Comprados:\n");

        for (DoubleLinkedList<Pedido> current = (DoubleLinkedList<Pedido>) productosPedido.getHead(); current != null; current = current.getNext()) {
            Producto producto = current.getObject();
            factura.append(producto.getNombre()).append(" - $").append(producto.getPrecio())
                    .append(" x ");
        }

        double subtotal = calcularTotalPorPedido(pedido);
        double impuesto = subtotal * impuestoFijo;
        double total = subtotal + impuesto;

        factura.append("\nSubtotal: $").append(String.format("%.2f", subtotal)).append("\n");
        factura.append("Impuesto (8%): $").append(String.format("%.2f", impuesto)).append("\n");
        factura.append("Total: $").append(String.format("%.2f", total)).append("\n");

        // Puedes imprimir la factura en la consola o guardarla en un archivo
        System.out.println(factura.toString());
    }

    @Override
    public double getMontoTotal() throws RemoteException {
        ClienteDomicilio clienteCocina= new ClienteDomicilio("localhost", "5000", "ServiceDomicilio");
        clienteCocina.getMontoTotal();
        double montoTotal = 0.0;
        for (DoubleLinkedList<Pedido> current = productos.getHead(); current != null; current = current.getNext()) {
            Pedido pedido = current.get();
            double totalPedido = calcularTotalPorPedido(pedido);
            montoTotal += totalPedido;
        }

        return montoTotal;
    }

    @Override
    public int getCostosssDomicilio(Cliente cliente) throws RemoteException {
        int costoDomicilio = 0;
        boolean siesPremium = cliente.getPremium();
        String barrio = cliente.getDireccion();
        String ciudad = cliente.getCiudad();
        if (siesPremium) {
            costoDomicilio = 0;
        } else {
            if (ciudad.equalsIgnoreCase("Piedecuesta")) {
                costoDomicilio = 9000;
            } else if (ciudad.equalsIgnoreCase("Bucaramanga")) {
                costoDomicilio = 25000;
            } else if (ciudad.equalsIgnoreCase("Florida")) {
                costoDomicilio = 13000;
            }
        }
        return costoDomicilio;
    }

    @Override
    public Cliente getCurrentUser() throws RemoteException {
        ClienteDomicilio cliente = new ClienteDomicilio("localhost", "5000", "ServiceDomicilio");
        cliente.getCurrentUser();
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentUser'");
    }

    @Override
    public void agregarPedido(Pedido pedido) throws RemoteException {
        pedidosParaLlevar.insert(pedido);
    }

    @Override
    public void entregarPedidos() throws RemoteException {
        pedidosParaLlevar.clear();
    }

    @Override
    public void entregarPedido(Pedido pedido) {
        if (pedido != null) {
            try {

                System.out.println("Pedido entregado: " + pedido);
                
                currentPedido = null;
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        throw new UnsupportedOperationException("Unimplemented method 'entregarPedido'");
    }


    @Override
    public boolean login(String user, String password) throws RemoteException {
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

}
