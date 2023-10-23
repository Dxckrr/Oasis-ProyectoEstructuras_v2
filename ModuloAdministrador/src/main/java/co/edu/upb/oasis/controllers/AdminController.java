package co.edu.upb.oasis.controllers;

import java.rmi.RemoteException;
import java.util.LinkedList;

import co.edu.upb.oasis.clases.Cliente;
import co.edu.upb.oasis.models.ModelVistaAdministrador;
import co.edu.upb.oasis.vistas.VistaAdmin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class AdminController {
    public AdminController() throws RemoteException{
        VistaAdmin vistaAdmin = new VistaAdmin();
        ModelVistaAdministrador modelVistaAdministrador = new ModelVistaAdministrador();
        //Event handler for the confirmAddButton on the UI
        vistaAdmin.confirmAddButton.setOnAction(actionEvent -> {
            //Checking if the usuarioField is not empty
            if (!isEmpty(vistaAdmin.usuarioField.getText())) {
                //Checking if the necessary fields are not null
                if (vistaAdmin.usuarioField == null || vistaAdmin.contraseñaField == null || vistaAdmin.idField == null) {
                    //Placeholder for further logic
                } else {
                    //Calling the addUsuario method and handling the result accordingly
                    if (modelVistaAdministrador.addUsuario(vistaAdmin.usuarioField.getText(), vistaAdmin.contraseñaField.getText(), Integer.parseInt(vistaAdmin.idField.getText()))) {
                        //Resetting the input fields if the operation is successful
                        vistaAdmin.usuarioField.setText("");
                        vistaAdmin.contraseñaField.setText("");
                        vistaAdmin.idField.setText("");
                    }
                }
            } else {
                //Calling the checkUser method if the usuarioField is empty
                modelVistaAdministrador.checkUser();
            }
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

        //Method to display client information on the UI
        vistaAdmin.searchClienteButton.setOnAction(actionEvent -> {
            if (!isEmpty(vistaAdmin.telefonoField.getText())) {
                try {
                    //Trying to find the Cliente using the provided telefonoField value
                    Cliente cliente = modelVistaAdministrador.buscarCliente(Integer.parseInt(vistaAdmin.telefonoField.getText()));
                    if (cliente != null) {
                        //Calling the displayClientInformation method if the Cliente is found
                        displayClientInformation(cliente, vistaAdmin);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });
        
    }

    private void displayClientInformation(Cliente cliente, VistaAdmin vistaAdmin) {
        // Lógica para mostrar la información del cliente en la interfaz de usuario
        String information = "Nombre: " + cliente.getNombre() + "\n" +
                "Dirección: " + cliente.getDireccion() + "\n" +
                "Ciudad: " + cliente.getCiudad() + "\n" +
                "Teléfono: " + cliente.getTelefono() + "\n";
        vistaAdmin.textAreaInfoCliente.setText(information); // Ajusta el nombre del campo de texto según tu implementación
        vistaAdmin.botonEliminarCliente.setVisible(true); // Ajusta la visibilidad del botón según tu implementación
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

    /*public void displaySearchResults(java.util.LinkedList<String> resultados) {
        StringBuilder resultText = new StringBuilder();
        resultText.append("Resultados de la búsqueda:\n");
        for (String result : resultados) {
            resultText.append(result).append("\n");
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Resultados de la búsqueda");
        alert.setHeaderText("Resultados encontrados para la búsqueda:");
        alert.setContentText(resultText.toString());
        alert.showAndWait();
    }*/

    /*public void displayNoResultsAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("No Results");
        alert.setHeaderText("No se encontraron resultados para la búsqueda.");
        alert.setContentText("Por favor, intente de nuevo con un término de búsqueda diferente.");
        alert.showAndWait();
    }*/

    public void displayNoInputAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("No Input");
        alert.setHeaderText("Ningún término de búsqueda ingresado.");
        alert.setContentText("Por favor, ingrese un término de búsqueda.");
        alert.showAndWait();
    }
}


