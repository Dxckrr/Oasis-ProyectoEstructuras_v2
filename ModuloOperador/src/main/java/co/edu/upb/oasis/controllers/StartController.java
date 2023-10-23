package co.edu.upb.oasis.controllers;

import co.edu.upb.oasis.models.ModelStart;
import co.edu.upb.oasis.vistas.Start;
/**
 * Controller Class for start window
 * 
 * this class is the neccesary for the login
 * 
 * @author Juan David Patiño Parra
 */
public class StartController {
    public StartController(){
        Start start = new Start();  //VISTA
        //------------------------
        ModelStart modelStart = new ModelStart();   //MODELO
        start.submit.setOnAction(event -> {
            if(modelStart.buttonSubmit(start.usuario.getText() , start.password.getText())){
                start.window.close();
            }
        });
    }

}
