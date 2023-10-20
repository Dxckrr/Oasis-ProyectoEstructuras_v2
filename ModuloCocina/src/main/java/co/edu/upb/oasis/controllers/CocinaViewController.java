package co.edu.upb.oasis.controllers;

import co.edu.upb.oasis.models.ModelCocina;
import co.edu.upb.oasis.vistas.VistaCocina;

public class CocinaViewController {

    public CocinaViewController() {
        ModelCocina modelCocina = new ModelCocina();
        VistaCocina vistaCocina = new VistaCocina();

        vistaCocina.buttonTEST.setOnAction(actionEvent -> {
            System.out.println(modelCocina.getPedido());
            // modelCocina.getPedido();
        });

    }

}
