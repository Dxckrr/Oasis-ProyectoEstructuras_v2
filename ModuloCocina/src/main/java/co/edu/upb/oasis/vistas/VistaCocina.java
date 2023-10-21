package co.edu.upb.oasis.vistas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import co.edu.upb.oasis.clases.Horno;
import javafx.scene.control.ListView;

public class VistaCocina {
    Stage window;
    // Escenas
    Scene principal, confirmarPedidos;
    // Paneles
    StackPane panelPrincipal;
    public VBox panelListaPedidos;
    GridPane contenedorHornos;

    // Botones
    Button clientes;
    Button menu;
    Button pedido;
    Button domicilio;
    // LABELS
    public Label textListaPedidos;

    // Arrays Horno
    Horno[] hornos = new Horno[4];
    // Figuras
    Rectangle rectangleToDecorate;
    Rectangle rectangleLogo;

    // Colores
    String beige = "#FFECBB";
    Color colorBeige = Color.web(beige);
    //
    String sand = "#FFC93E";
    Color colorSand = Color.web(sand);
    //
    String orange = "#FF9900";
    Color colorOrange = Color.web(orange);
    //

    public Button getPedidos;

    //
    public ListView<String> listView;
    //ESTO DEBE SER UN ARRAY DE BOTONES PARA DESPACHAR
    public Button deleteProducto;
    public ObservableList<String> items;

    // Background
    BackgroundFill colorFondo = new BackgroundFill(colorSand, null, null);
    Background fondo = new Background(colorFondo);

    BackgroundFill colorFondoCocina = new BackgroundFill(colorBeige, null, null);
    Background fondoCocina = new Background(colorFondoCocina);

    public VistaCocina() {
        window = new Stage();
        initCocina();
    }

    private void initCocina() {

        // PANELES--------------------

        panelPrincipal = new StackPane();
        panelListaPedidos = new VBox();
        contenedorHornos = new GridPane();
        // ELEMENTOS----------------------
        textListaPedidos = new Label("Pedidos en cola: ");
        textListaPedidos.setFont(new Font(20));
        // Hornos-------------------------
        int ancho = 0;
        int largo = 0;
        for (int i = 0; i < hornos.length; i++) {
            hornos[i] = new Horno(40);
            if (i % 2 == 0) {
                ancho = 0;
                largo++;
                contenedorHornos.add(hornos[i].getHorno(), ancho, largo); // Añadir elementos al layout
                continue; // Funcion continue para skipear el codigo y volver al for
            }
            ancho++;
            contenedorHornos.add(hornos[i].getHorno(), ancho, largo);
        }
        // Propiedades de los paneles
        // Vbox
        panelListaPedidos.setSpacing(5);
        panelListaPedidos.setPrefWidth(100);

        // GridPane Propiedades
        contenedorHornos.setHgap(200);
        contenedorHornos.setVgap(200);

        // Rectangle para decorar

        rectangleToDecorate = new Rectangle(300, 720);
        rectangleToDecorate.setFill(colorOrange);

        // Añadiendo elementos a los paneles
        panelListaPedidos.getChildren().add(textListaPedidos);
        // --------------
        contenedorHornos.getChildren().addAll();
        // Propiedades elemtnos
        textListaPedidos.setFont(new Font(20));
        getPedidos = new Button("Click");

        panelPrincipal.getChildren().addAll(panelListaPedidos, contenedorHornos, rectangleToDecorate, getPedidos);
        //
        panelPrincipal.setBackground(fondoCocina);

        // LISTA PARA VER LAS COSAS QUE SE AGREGAN

        // Crear una lista observable para almacenar elementos
        items = FXCollections.observableArrayList();

        // Crear un ListView y configurarlo con la lista observable
        listView = new ListView<>(items);
        //KASKDFKASD
        deleteProducto = new Button("Eliminar");
       // deleteProducto.setId("deleteButton");
        // Crear un diseño de caja vertical para organizar los elementos
        VBox contenedorDeProductosToAdd = new VBox(listView, deleteProducto);
        panelPrincipal.getChildren().add(contenedorDeProductosToAdd);
        // Panel Principal distribucion
        panelPrincipal.setMargin(contenedorDeProductosToAdd, new Insets(0, 600, 300, 0));
        panelPrincipal.setAlignment(panelListaPedidos, Pos.CENTER_LEFT);
        panelPrincipal.setAlignment(rectangleToDecorate, Pos.CENTER_LEFT);
        panelPrincipal.setMargin(contenedorHornos, new Insets(0, 0, 0, 600)); // establecer un margen
                                                                              // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        rectangleToDecorate.toBack();
        getPedidos.toFront();
        // -------
        principal = new Scene(panelPrincipal, 1080, 720);

        window.setScene(principal);
        window.setTitle("Oasis"); // Estableciendo titulo
        window.show();
    }
}
