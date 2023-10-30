package co.edu.upb.oasis.vistas;

import java.rmi.RemoteException;
import java.util.Arrays;

import co.edu.upb.oasis.clases.Peddisos;
import co.edu.upb.oasis.clases.Usuario;
import co.edu.upb.oasis.clases1.DatosGraficos;
import co.edu.upb.oasis.client.ClienteDomicilio;
import co.edu.upb.oasis.estructuras.lists.LinkedList1;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 *  @author Juliana Chavez King
 */
public class VistaDomicilio {
    Stage window;
    // Escenas
    Scene optionPanel, login, selector;
    // Paneles
    StackPane panelPrincipal;
    GridPane opcionesPanel;
    StackPane panelLogin;
    VBox contenedorLoginPassWord;
    ClienteDomicilio service;
    Peddisos[] domicilioActual;

    public int Numerotope = 0;
    DatosGraficos arboles = new DatosGraficos();

    // Botones
    public Button clientes;
    public Button anteriorButton = new Button();
    /*
     * Button menu;
     * Button pedido;
     * Button domicilio;
     */
    public Button confirmAddButton;
    public Button mondaButton;
    public Button Prod22Button;
    public Button mojarraButton;
    public Button productt3Button;
    public Button anotherButton;
    public Button clientButton;
    public Button searchOperadorButton;
    public Button tomarPedidosButton;
    public VBox vbox;
    public Button tenerLosPedidosBotoon;
    // TextField
    public TextField usuarioField;
    public TextField contraseñaField;
    public TextField idField;
    public TextField search24Field;
    public TextField usuario1Field;
    public TextField contraseña1Field;
    public TextField id1Field;
    public TextField nombreField;
    public TextField direccionField;
    public TextField ciudadField;
    public TextField telefonoField;
    public TextField productoField;
    public TextField descripcionField;
    public TextField precioField;
    public TextField tiempdePreparacion;
    public TextField idField2;
    public TextField producto11Field;
    public TextField precio11Field;
    public TextField id11Field2;
    public TextField descripcion11Field;
    public TextField tiempo11dePreparacion;
    public TextField producto22Field;
    public TextField precio22Field;
    public TextField id22Field2;
    public TextField descripcion22Field;
    public TextField tiempo22dePreparacion;
    public HBox header;
    public HBox hbox;
    public BorderPane root;
    public Button configButton;
    // Imagenes
    ImageView logo;
    Image picture = new Image("file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\OasisFondo.png");

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

    // Background
    BackgroundFill colorFondo = new BackgroundFill(colorSand, null, null);
    Background fondo = new Background(colorFondo);

    Pane pane = new Pane();

    public VistaDomicilio() {
        window = new Stage();
        initDomicilio();

        clientes.setOnAction(event -> {
            Scene firstScreen = createFirstScreen();
            window.setScene(firstScreen);
        });
    }

    public void initDomicilio() {
        // Crear Panel
        panelPrincipal = new StackPane();
        opcionesPanel = new GridPane();
        opcionesPanel.setHgap(100); // Ajusta la separación horizontal a 20 píxeles
        opcionesPanel.setVgap(100); // Ajusta la separación vertical a 20 píxeles
        // Crear los objetos
        clientes = new Button("HELLO DOMI");
        confirmAddButton = new Button("Guardar Operador");
        mojarraButton = new Button("Guardar Domiciliario");
        clientButton = new Button("Guardar cliente");
        searchOperadorButton = new Button("Operador Buscado");
        mondaButton = new Button("Guardar Producto");
        Prod22Button = new Button("Guardar Producto");
        productt3Button = new Button("Guardar producto");
        tomarPedidosButton = new Button("Tomar pedidos");
        header = new HBox();
        hbox = new HBox();
        vbox = new VBox();
        root = new BorderPane();
        configButton = new Button("RUTAS");
        tenerLosPedidosBotoon = new Button("Mirar Pedidos");
        /*
         * menu = new Button("Menu");
         * pedido = new Button("Pedidos");
         * domicilio = new Button("Rutas");
         */
        // -----------
        logo = new ImageView(picture);
        // -----------
        rectangleToDecorate = new Rectangle(700, 400);

        // Agregando elementos

        opcionesPanel.add(clientes, 0, 0);
        /*
         * opcionesPanel.add(menu, 1, 0);
         * opcionesPanel.add(pedido, 0, 1);
         * opcionesPanel.add(domicilio, 1, 1);
         */
        opcionesPanel.setAlignment(Pos.CENTER);
        panelPrincipal.getChildren().addAll(logo, rectangleToDecorate, opcionesPanel);

        // Propiedades
        clientes.setScaleY(2.5);
        clientes.setScaleX(2.5);
        /*
         * menu.setScaleY(2);
         * menu.setScaleX(2);
         * pedido.setScaleY(2);
         * pedido.setScaleX(2);
         * domicilio.setScaleY(2);
         * domicilio.setScaleX(2);
         */
        // -----------
        logo.setFitHeight(80); // Alto
        logo.setFitWidth(80); // Ancho
        // -----------
        panelPrincipal.setBackground(fondo);
        // -------------------------

        rectangleToDecorate.toBack();
        rectangleToDecorate.setFill(colorBeige);
        rectangleToDecorate.setStroke(Color.BLACK); // Color del borde
        rectangleToDecorate.setStrokeWidth(1); // Grosor del borde

        //
        clientes.setOnAction(event -> {

        });

        // Organizando items
        panelPrincipal.setMargin(logo, new Insets(0, 0, 125, 0)); // establecer un margen
                                                                  // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        panelPrincipal.setAlignment(opcionesPanel, Pos.CENTER); // establecer un margen (ABAJO,IZQUIERDA,ARRIBA,DERECHA)

        optionPanel = new Scene(panelPrincipal, 1080, 720);

        window.setScene(optionPanel);
        window.setTitle("Oasis"); // Estableciendo titulo
        window.show();
    }

    private Scene createFirstScreen() {

        GridPane mainPane = new GridPane();
        mainPane.setPrefSize(960, 603);
        mainPane.setBackground(new Background(new BackgroundFill(Color.web("#FFECBB"), null, null)));

        GridPane smallerScreen = createSmallerScreen();
        mainPane.add(smallerScreen, 0, 0);

        Scene scene = new Scene(mainPane, 960, 603);

        Button databaseButton = (Button) smallerScreen.lookup("#databaseButton");
        databaseButton.setOnAction(event -> {
            Scene pedidoScrennn = createSecondScreen();
            window.setScene(pedidoScrennn);
        });
        return scene;
    }

    private GridPane createSmallerScreen() {
        GridPane smallerScreen = otrofuncio("DOMICILIARIO");
        smallerScreen.add(anteriorButton, 0, 3);

        Button databaseButton = new Button("PEDIDOS");
        databaseButton.setPrefSize(277, 209);
        databaseButton.setId("databaseButton");

        Button configButton = new Button("RUTAS");
        configButton.setPrefSize(277, 209);
        configButton.setOnAction(event -> {
            window.setScene(createDijkstraScreen());
        });

        GridPane buttonsGrid = new GridPane();
        buttonsGrid.setHgap(10);

        buttonsGrid.add(databaseButton, 0, 0);
        buttonsGrid.add(configButton, 1, 0);

        GridPane.setColumnSpan(buttonsGrid, 3);
        smallerScreen.add(buttonsGrid, 0, 1);

        anteriorButton.setOnAction(event -> {
            window.setScene(createFirstScreen());
        });
        return smallerScreen;
    }

    private GridPane otrofuncio(String title) {
        GridPane otrofunsionscreen = new GridPane();
        otrofunsionscreen.setBackground(new Background(new BackgroundFill(Color.web("#FFECBB"), null, null)));
        otrofunsionscreen.setPrefSize(893, 545);
        otrofunsionscreen.setVgap(10);
        otrofunsionscreen.setHgap(20);
        otrofunsionscreen.setPadding(new Insets(20));

        anteriorButton.setPrefSize(100, 40);
        anteriorButton = new Button("ANTERIOR");

        Rectangle adminLabel = new Rectangle(318, 31);
        adminLabel.setFill(Color.web("#FFC93E"));
        adminLabel.setStroke(Color.BLACK);
        adminLabel.setStrokeWidth(1);
        otrofunsionscreen.add(adminLabel, 1, 0, 1, 1);

        Button adminText = new Button(title);
        adminText.setStyle("-fx-background-color: transparent;");
        adminText.setFont(new Font(14));
        otrofunsionscreen.add(adminText, 1, 0, 1, 1);

        ImageView image = new ImageView(new Image("file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\OasisFondo.png"));
        image.setFitWidth(165);
        image.setFitHeight(119);
        otrofunsionscreen.add(image, 0, 0, 1, 1);

        ImageView adminImage = new ImageView(
                new Image("file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\adminUser.png"));
        adminImage.setFitWidth(148);
        adminImage.setFitHeight(121);
        otrofunsionscreen.add(adminImage, 2, 0, 1, 1);

        return otrofunsionscreen;
    }

    private Scene createSecondScreen() {
        GridPane secondScreen = otrofuncio("¿QUÉ DESEA GESTIONAR EN LA BASE DE DATOS?");
        secondScreen.add(anteriorButton, 0, 3);

        Button mostrarButton = new Button("MOSTRAR");
        mostrarButton.setPrefSize(277, 209);

        Button verFacturaButton = new Button("VER FACTURA");
        verFacturaButton.setPrefSize(277, 209);

        GridPane buttonsGrid = new GridPane();
        buttonsGrid.setHgap(10);

        buttonsGrid.add(mostrarButton, 0, 0);
        buttonsGrid.add(verFacturaButton, 1, 0);

        GridPane.setColumnSpan(buttonsGrid, 3);
        secondScreen.add(buttonsGrid, 0, 1);

        anteriorButton.setOnAction(event -> {
            window.setScene(createFirstScreen());
        });

        // Acción del botón Mostrar
        mostrarButton.setOnAction(event -> {
            Stage pedidoStage = new Stage();
            GridPane pedidoPane = new GridPane(); // Crea tu diseño de visualización de pedidos aquí

            // Simula la información del cliente y sus pedidos directamente en el código
            String nombreCliente = "Nombre del cliente: Juan Perez";
            String pedido1 = "Pedido 1: Producto A - Entregado";
            String pedido2 = "Pedido 2: Producto B - Pendiente de entrega";
            String pedido3 = "Pedido 3: Producto C - Entregado";

            // Agrega la información del cliente y sus pedidos al pedidoPane
            Text infoCliente = new Text(nombreCliente);
            Text infoPedido1 = new Text(pedido1);
            Text infoPedido2 = new Text(pedido2);
            Text infoPedido3 = new Text(pedido3);

            pedidoPane.add(infoCliente, 0, 0);
            pedidoPane.add(infoPedido1, 0, 1);
            pedidoPane.add(infoPedido2, 0, 2);
            pedidoPane.add(infoPedido3, 0, 3);

            Scene pedidoScene = new Scene(pedidoPane, 600, 400);
            pedidoStage.setScene(pedidoScene);
            pedidoStage.show();
        });

        verFacturaButton.setOnAction(event -> {
            Stage facturaStage = new Stage();

            // Crear rectángulos para mostrar las facturas
            Rectangle factura1 = new Rectangle(250, 150);
            factura1.setFill(Color.LIGHTBLUE);
            factura1.setStroke(Color.BLACK);
            Text infoFactura1 = new Text("Cliente: Juan Perez\nFecha de compra: 2023-10-24\nTotal: $200");
            infoFactura1.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            StackPane stackPane1 = new StackPane();
            stackPane1.getChildren().addAll(factura1, infoFactura1);

            Rectangle factura2 = new Rectangle(250, 150);
            factura2.setFill(Color.LIGHTYELLOW);
            factura2.setStroke(Color.BLACK);
            Text infoFactura2 = new Text("Cliente: Maria Lopez\nFecha de compra: 2023-10-23\nTotal: $150");
            infoFactura2.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            StackPane stackPane2 = new StackPane();
            stackPane2.getChildren().addAll(factura2, infoFactura2);

            Rectangle factura3 = new Rectangle(250, 150);
            factura3.setFill(Color.LIGHTGREEN);
            factura3.setStroke(Color.BLACK);
            Text infoFactura3 = new Text("Cliente: Pedro Ramirez\nFecha de compra: 2023-10-22\nTotal: $300");
            infoFactura3.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            StackPane stackPane3 = new StackPane();
            stackPane3.getChildren().addAll(factura3, infoFactura3);

            // Organizar las facturas en la pantalla
            HBox hbox = new HBox(20);
            hbox.getChildren().addAll(stackPane1, stackPane2, stackPane3);

            Scene facturaScene = new Scene(hbox, 800, 200);
            facturaStage.setScene(facturaScene);
            facturaStage.show();
        });

        return new Scene(secondScreen, 960, 603);
    }

    private Scene createDijkstraScreen() {
        GridPane dijkstraPane = otrofuncio("VISUALIZAR LAS RUTAS");
        dijkstraPane.add(anteriorButton, 0, 3);

        int graph[][] = {
                { 0, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 500, 0, 300, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 300, 0, 200, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 200, 0, 150, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 150, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 100, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 100, 0, 150, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 150, 0, 200, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 200, 0, 250, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 250, 0, 200, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 200, 0, 300, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 300, 0, 150, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 150, 0, 200, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 200, 0, 250, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 250, 0, 300, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 300, 0, 350, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 350, 0, 200 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 200, 0 }
        };

        int V = graph.length;
        String[] places = { "Cabecera del Llano", "San Alonso", "La Ciudadela", "Lagos del Cacique",
                "San Francisco", "La Joya", "Cañaveral", "Ciudad Valencia", "Restaurante OASIS UPB", "Girardot",
                "El Bosque",
                "Los Cambulos", "Junin", "Ciudadela Comfenalco", "La Salle", "Centro", "La Feria" };

        String ruta = "Restaurante OASIS UPB (origen) -> Cabecera del Llano -> San Alonso -> La Ciudadela -> Lagos del Cacique";

        int[] distancias = { 500, 300, 200 };

        // Calcula la distancia total sumando todas las distancias
        int distanciaTotal = 0;
        for (int distancia : distancias) {
            distanciaTotal += distancia;
        }
        Text rutaText = new Text("Ruta: " + ruta);
        Text distanciaTotalText = new Text("Distancia total: " + distanciaTotal + " metros");
        dijkstraPane.add(rutaText, 0, 1);
        dijkstraPane.add(distanciaTotalText, 0, 2);

        anteriorButton.setOnAction(event -> {
            window.setScene(createSecondScreen());
        });

        return new Scene(dijkstraPane, 960, 603);
    }

}