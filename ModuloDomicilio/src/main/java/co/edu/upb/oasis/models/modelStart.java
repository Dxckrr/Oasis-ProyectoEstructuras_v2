package co.edu.upb.oasis.models;

import co.edu.upb.oasis.client.ClienteDomicilio;
import co.edu.upb.oasis.vistas.Start;
import co.edu.upb.oasis.vistas.VistaDomicilio;
import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

public class modelStart {

    ClienteDomicilio cliente;

    public modelStart(){
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(new File("config.properties")));
            cliente = new ClienteDomicilio((String) properties.get("IP"), (String) properties.get("PORT3"),
                    (String) properties.get("SERVICENAME3"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public boolean buttonSubmit(String usuario , String password){
        //Usuario operadorIn = new Usuario(start.usuario.getText(),start.password.getText());

        try{
            if(cliente.login(usuario, password)){
                VistaDomicilio domicilio = new VistaDomicilio();
                System.out.println("it works");
                return true;
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("NOT FOUND");
                alert.setHeaderText("ERROR 404.");
                alert.setContentText("Operador no encontrado!"+"\n"+"Intentelo de nuevo");

                alert.showAndWait();
                return false;
            }
        }catch (RemoteException e){
            throw new RuntimeException(e);
        }
    }
}
