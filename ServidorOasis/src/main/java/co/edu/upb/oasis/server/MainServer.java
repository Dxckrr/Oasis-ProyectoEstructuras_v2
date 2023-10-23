package co.edu.upb.oasis.server;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Main Class
 * 
 *@author Juan David Patiño Parra
 */
public class MainServer {
    public static void main(String[] args) {
        try {
            /**
             * Intialize Server
             */
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File("config.properties")));
            Server serverOasis = new Server((String) properties.get("IP"));

            if (serverOasis.deployServices()) {
                System.out.println("All services On");
            } else {
                System.out.println("error");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
