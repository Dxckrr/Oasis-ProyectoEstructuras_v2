package co.edu.upb.oasis.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import co.edu.upb.oasis.client.ClienteDomicilio;

public class ModelVistaDomiciliario {
    ClienteDomicilio domicilio;

    public ModelVistaDomiciliario(){
        Properties properties = new Properties();

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

}
