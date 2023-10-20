package co.edu.upb.oasis.controllers;

import java.util.LinkedList;

import co.edu.upb.oasis.models.ModelVistaAdministrador;
import co.edu.upb.oasis.vistas.VistaAdmin;
import javafx.scene.control.Alert;

public class AdminController {

    public AdminController(){
        VistaAdmin vistaAdmin = new VistaAdmin();
        ModelVistaAdministrador modelVistaAdministrador = new ModelVistaAdministrador();
        vistaAdmin.confirmAddButton.setOnAction(actionEvent -> {
            if (!isEmpty(vistaAdmin.usuarioField.getText())) {
                if (vistaAdmin.usuarioField == null || vistaAdmin.contraseñaField == null || vistaAdmin.idField == null) {
                } else {
                    if (modelVistaAdministrador.addUsuario(vistaAdmin.usuarioField.getText(),vistaAdmin.contraseñaField.getText(), Integer.parseInt(vistaAdmin.idField.getText()))) {
                        vistaAdmin.usuarioField.setText("");
                        vistaAdmin.contraseñaField.setText("");
                        vistaAdmin.idField.setText("");
                    }
                }
            } else {
                modelVistaAdministrador.checkUser();}
        });

        vistaAdmin.mojarraButton.setOnAction(actionEvent ->{
            if(!isEmpty(vistaAdmin.usuario1Field.getText())){
                if(vistaAdmin.usuario1Field == null || vistaAdmin.contraseña1Field == null || vistaAdmin.id1Field == null){
                }else if(modelVistaAdministrador.addUsuario(vistaAdmin.usuario1Field.getText(), vistaAdmin.contraseña1Field.getText(), Integer.parseInt(vistaAdmin.id1Field.getText()))){
                    vistaAdmin.usuario1Field.setText("");
                    vistaAdmin.contraseña1Field.setText("");
                    vistaAdmin.id1Field.setText("");
                }
            }else{ modelVistaAdministrador.checkUser();}
        });

        vistaAdmin.clientButton.setOnAction(actionEvent ->{
            if(!isEmpty(vistaAdmin.nombreField.getText())){
                if(vistaAdmin.nombreField == null || vistaAdmin.direccionField == null || vistaAdmin.ciudadField == null || vistaAdmin.telefonoField == null){
                }else if(modelVistaAdministrador.addCliente(vistaAdmin.nombreField.getText(), vistaAdmin.direccionField.getText(), vistaAdmin.ciudadField.getText() ,Integer.parseInt(vistaAdmin.telefonoField.getText()))){
                    vistaAdmin.nombreField.setText("");
                    vistaAdmin.direccionField.setText("");
                    vistaAdmin.ciudadField.setText("");
                    vistaAdmin.telefonoField.setText("");

                }
            }else{ modelVistaAdministrador.checkUser();}
        });

        vistaAdmin.searchOperadorButton.setOnAction(actionEvent -> {
            if (!isEmpty(vistaAdmin.search24Field.getText())) {
                LinkedList<String> resultados = modelVistaAdministrador.distanciaHammingMod(vistaAdmin.search24Field.getText());
                // Lógica adicional para manejar los resultados de la búsqueda
                if (resultados.isEmpty()) {
                    displayNoResultsAlert();
                } else {
                    displaySearchResults(resultados);
                }
            } else {
                modelVistaAdministrador.checkUser();
            }
        });

        vistaAdmin.mondaButton.setOnAction(actionEvent ->{
            if(!isEmpty(vistaAdmin.producto11Field.getText())){
                if(vistaAdmin.producto11Field == null || vistaAdmin.descripcion11Field == null || vistaAdmin.precio11Field == null || vistaAdmin.tiempo11dePreparacion == null || vistaAdmin.id11Field2 == null){
                }else if(modelVistaAdministrador.addProducto(vistaAdmin.producto11Field.getText(), vistaAdmin.descripcion11Field.getText(), Integer.parseInt(vistaAdmin.precio11Field.getText()), Integer.parseInt(vistaAdmin.tiempo11dePreparacion.getText()), Integer.parseInt(vistaAdmin.id11Field2.getText()))){
                    vistaAdmin.producto11Field.setText("");
                    vistaAdmin.descripcion11Field.setText("");
                    vistaAdmin.precio11Field.setText("");
                    vistaAdmin.tiempo11dePreparacion.setText("");
                    vistaAdmin.id11Field2.setText("");
                }
            }else{ modelVistaAdministrador.checkUser();}
        });
        vistaAdmin.Prod22Button.setOnAction(actionEvent ->{
            if(!isEmpty(vistaAdmin.producto11Field.getText())){
                if(vistaAdmin.producto11Field == null || vistaAdmin.descripcion11Field == null || vistaAdmin.precio11Field == null || vistaAdmin.tiempo11dePreparacion == null || vistaAdmin.id11Field2 == null){
                }else if(modelVistaAdministrador.addProducto(vistaAdmin.producto11Field.getText(), vistaAdmin.descripcion11Field.getText(), Integer.parseInt(vistaAdmin.precio11Field.getText()), Integer.parseInt(vistaAdmin.tiempo11dePreparacion.getText()), Integer.parseInt(vistaAdmin.id11Field2.getText()))){
                    vistaAdmin.producto11Field.setText("");
                    vistaAdmin.descripcion11Field.setText("");
                    vistaAdmin.precio11Field.setText("");
                    vistaAdmin.tiempo11dePreparacion.setText("");
                    vistaAdmin.id11Field2.setText("");
                }
            }else{ modelVistaAdministrador.checkUser();}
        });
        vistaAdmin.productt3Button.setOnAction(actionEvent ->{
            if(!isEmpty(vistaAdmin.producto11Field.getText())){
                if(vistaAdmin.producto11Field == null || vistaAdmin.descripcion11Field == null || vistaAdmin.precio11Field == null || vistaAdmin.tiempo11dePreparacion == null || vistaAdmin.id11Field2 == null){
                }else if(modelVistaAdministrador.addProducto(vistaAdmin.producto11Field.getText(), vistaAdmin.descripcion11Field.getText(), Integer.parseInt(vistaAdmin.precio11Field.getText()), Integer.parseInt(vistaAdmin.tiempo11dePreparacion.getText()), Integer.parseInt(vistaAdmin.id11Field2.getText()))){
                    vistaAdmin.producto11Field.setText("");
                    vistaAdmin.descripcion11Field.setText("");
                    vistaAdmin.precio11Field.setText("");
                    vistaAdmin.tiempo11dePreparacion.setText("");
                    vistaAdmin.id11Field2.setText("");
                }
            }else{ modelVistaAdministrador.checkUser();}
        });
    }
    
    public boolean isEmpty(String textToCheck) {
        return textToCheck.trim().isEmpty();
    }

    public void displaySearchResults(LinkedList<String> results) {
        StringBuilder resultText = new StringBuilder();
        resultText.append("Search results:\n");
        for (String result : results) {
            resultText.append(result).append("\n");
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Search Results");
        alert.setHeaderText("Results found for the search:");
        alert.setContentText(resultText.toString());
        alert.showAndWait();
    }

    public void displayNoResultsAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("No Results");
        alert.setHeaderText("No results found for the search.");
        alert.setContentText("Please try again with a different search term.");
        alert.showAndWait();
    }
}

