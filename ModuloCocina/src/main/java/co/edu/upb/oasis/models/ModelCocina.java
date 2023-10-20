package co.edu.upb.oasis.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

import co.edu.upb.oasis.clases.Pedido;
import co.edu.upb.oasis.client.ClienteCocina;

public class ModelCocina {

    ClienteCocina cliente;

    public ModelCocina() {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(new File("config.properties")));
            cliente = new ClienteCocina((String) properties.get("IP"), (String) properties.get("PORT2"),
                    (String) properties.get("SERVICENAME2"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Pedido getPedido() {
        // Usuario operadorIn = new
        // Usuario(start.usuario.getText(),start.password.getText());
        try {
            return cliente.getPedido();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
    // METODOS

}
