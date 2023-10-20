package co.edu.upb.oasis.controllers;

import co.edu.upb.oasis.models.modelStart;
import co.edu.upb.oasis.vistas.Start;

public class startController {
    public startController(){
        Start start = new Start();  //VISTA
        //------------------------
        modelStart modelStart = new modelStart();   //MODELO
        start.submit.setOnAction(event -> {
            if(modelStart.buttonSubmit(start.usuario.getText() , start.password.getText())){
                start.window.close();
            }
        });
    }
}
