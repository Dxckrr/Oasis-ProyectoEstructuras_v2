package co.edu.upb.oasis.server;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class MainServer {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
                properties.load(new FileInputStream(new File("config.properties")));
            Server serverOasis = new Server((String) properties.get("IP"));
            if (serverOasis.deployServices()) {
                System.out.println("All services On");
            } else {
                System.out.println("error");
            }
            
            // --
            // Server serverOasis = new Server("localhost");
            // ---

            /*
             * Server serverOperador = new Server("localhost","5000","serviceOperador");
             * if(serverOperador.deployServiceOperador()){
             * System.out.println("Service Operador on");
             * }
             * Server serverAdmin = new Server("localhost","5001","serviceAdmin");
             * if(serverAdmin.deployServiceAdministrador()){
             * System.out.println("Service Admin on");
             * }
             * Server serverCocina = new Server("localhost","5002","serviceCocina");
             * if(serverCocina.deployServiceCocina()){
             * System.out.println("Service Cocina on");
             * }
             * Server serverDomicilio = new Server("localhost","5003","serviceDomicilio");
             * if(serverDomicilio.deployServiceDomicilio()){
             * System.out.println("Service Domicilio on");
             * }
             */

            /*
             * Server serverAdmin = new Server("localhost","5000","serviceOperador");
             * server.deployService();
             * System.out.println("Service Operador on");
             * Server serverCocina = new Server("localhost","5000","serviceOperador");
             * server.deployService();
             * System.out.println("Service Operador on");
             * Server serverDomicilio = new Server("localhost","5000","serviceOperador");
             * server.deployService();
             * System.out.println("Service Operador on");
             */
        } catch (Exception e) {
            e.printStackTrace();
        } /*
           * catch (FileNotFoundException e) {
           * throw new RuntimeException(e);
           * } catch (IOException e) {
           * throw new RuntimeException(e);
           * }
           */
    }
}
