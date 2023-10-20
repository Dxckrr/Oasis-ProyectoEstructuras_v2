package co.edu.upb.oasis.vistas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VistaOperador {
    public Stage window;
    // Escenas
    public Scene optionPanel;
    //
    public Scene clientesView;
    public Scene agregarClienteView;
    //
    public Scene menuView;
    public Scene confirmarPedidoView;
    // Scene RutasView;

    // Paneles
    StackPane panelPrincipal;

    //
    StackPane panelPrincipalClientes;
    StackPane panelAgregarClientes;

    // Menu
    StackPane panelPrincipalMenu;
    ScrollPane scrollerDeMenu;
    public Button goBackToOptions;
    public Button confirmarPedido;

    // --
    public Label pedidoText = new Label();
    public Label domicilioText = new Label();
    public Label precioText = new Label();
    public Label impuestoText = new Label();
    public Label precioTotalText = new Label();
    // --
    public Button sendPedidoToCocinaButton;
    public Button backToMenu;
    // ----
    public Button[] comidas;
    public Button[] bebidas;
    public Button[] postres;

    // ---
    public ListView<String> listView;
    public Button deleteProducto;
    public ObservableList<String> items;
    // ---

    // StackPane panelPrincipalRutas;
    HBox selector;

    // Botones
    public Button clientesButton;
    public Button menuButton;
    public Button pedidoButton;

    // Botones clientes
    public Button buscarClienteButton, agregarClienteButton;
    public Button goBack;

    // -----

    public Button goBackToClientes;
    public Button confirmAddButton;

    // -----
    public TextField cliente;
    public TextField direccion;
    public TextField ciudad;
    public TextField telefono;

    // TextField

    // Imagenes
    ImageView logo;
    ImageView logoClientes;
    Image picture = new Image("file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\logo\\OasisFondo.png");

    // Figuras
    Rectangle rectangleToDecorate;
    Rectangle rectangleToDecorateClientes;
    Rectangle rectangleToDecorateAddClientes;

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

    public VistaOperador() {
        // -----------------------
        // -----------------------
        window = new Stage();
        goBack = new Button("Atras");
        goBack.setId("buttonBack");
        logo = new ImageView(picture);
        logoClientes = new ImageView(picture);
        initOperador();
        initShowClientes();
        initAgregarCliente();
        initShowMenu();
        initShowConfirmarPedido();
    }

    public void initOperador() {
        // Crear Panel
        panelPrincipal = new StackPane();
        selector = new HBox();

        selector.setSpacing(150); // Ajusta la separación horizontal
        // Crear los objetos
        clientesButton = new Button("Clientes");
        menuButton = new Button("Menu");
        pedidoButton = new Button("Pedidos");
        // -----------
        rectangleToDecorate = new Rectangle(700, 400);
        // Agregando elementos
        selector.getChildren().addAll(clientesButton, menuButton, pedidoButton);
        selector.setAlignment(Pos.CENTER);
        panelPrincipal.getChildren().addAll(logo, rectangleToDecorate, selector);

        // Propiedades
        clientesButton.setScaleY(2);
        clientesButton.setScaleX(2);
        menuButton.setScaleY(2);
        menuButton.setScaleX(2);
        pedidoButton.setScaleY(2);
        pedidoButton.setScaleX(2);
        // -----------
        logo.setFitHeight(80); // Alto
        logo.setFitWidth(80); // Ancho
        // -----------
        panelPrincipal.setBackground(fondo);
        // -------------------------
        rectangleToDecorate.setFill(colorBeige);
        rectangleToDecorate.setStroke(Color.BLACK); // Color del borde
        rectangleToDecorate.setStrokeWidth(1); // Grosor del borde
        rectangleToDecorate.toBack();
        //

        // Organizando items
        panelPrincipal.setMargin(logo, new Insets(0, 0, 125, 0)); // establecer un margen
                                                                  // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        panelPrincipal.setAlignment(selector, Pos.CENTER); // establecer un margen (ABAJO,IZQUIERDA,ARRIBA,DERECHA)

        optionPanel = new Scene(panelPrincipal, 1080, 720);
        window.setScene(optionPanel);
        window.setTitle("Oasis"); // Estableciendo titulo
        window.show();

    }

    public void initShowClientes() {
        panelPrincipalClientes = new StackPane();
        panelPrincipalClientes.setBackground(fondo);
        // -------------------------
        buscarClienteButton = new Button("Buscar Cliente");
        agregarClienteButton = new Button("Agregar Cliente");
        agregarClienteButton.setId("add");
        rectangleToDecorateClientes = new Rectangle(700, 400);

        // Propiedades
        goBack.setScaleX(2.5);
        goBack.setScaleY(2.5);
        buscarClienteButton.setScaleX(2);
        buscarClienteButton.setScaleY(2);

        agregarClienteButton.setScaleX(2);
        agregarClienteButton.setScaleY(2);

        // -------------------------
        rectangleToDecorateClientes.setFill(colorBeige);
        rectangleToDecorateClientes.setStroke(Color.BLACK); // Color del borde
        rectangleToDecorateClientes.setStrokeWidth(1); // Grosor del borde
        rectangleToDecorateClientes.toBack();

        panelPrincipalClientes.getChildren().addAll(logo, rectangleToDecorateClientes, buscarClienteButton,
                agregarClienteButton, goBack);
        //
        panelPrincipalClientes.setMargin(buscarClienteButton, new Insets(0, 0, 0, 250)); // establecer un margen
                                                                                         // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        panelPrincipalClientes.setMargin(agregarClienteButton, new Insets(0, 250, 0, 0)); // establecer un margen
                                                                                          // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        panelPrincipalClientes.setMargin(goBack, new Insets(500, 550, 0, 0)); // establecer un margen
                                                                              // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)

        clientesView = new Scene(panelPrincipalClientes, 1080, 720);
        clientesView.getStylesheets().add("style.css");

        /*
         * window.setScene(clientesView);
         * window.setTitle("Oasis"); //Estableciendo titulo
         * window.show();
         */
    }

    public void initAgregarCliente() {

        panelAgregarClientes = new StackPane();
        panelAgregarClientes.setBackground(fondo);

        rectangleToDecorateAddClientes = new Rectangle(700, 400);
        rectangleToDecorateAddClientes.setFill(colorBeige);
        rectangleToDecorateAddClientes.setStroke(Color.BLACK); // Color del borde
        rectangleToDecorateAddClientes.setStrokeWidth(1); // Grosor del borde
        rectangleToDecorateAddClientes.toBack();

        Label clienteLabel = new Label("Cliente: ");
        Label direccionLabel = new Label("Direccion: ");
        Label ciudadLabel = new Label("Barrio: ");
        Label telefonoLabel = new Label("Telefono: ");
        ciudadLabel.setFont(new Font(20));
        clienteLabel.setFont(new Font(20));
        direccionLabel.setFont(new Font(20));
        telefonoLabel.setFont(new Font(20));

        // ----------------------------------
        cliente = new TextField();
        direccion = new TextField();
        ciudad = new TextField();
        telefono = new TextField();

        // ----------------------------------

        goBackToClientes = new Button("Atras");
        confirmAddButton = new Button("Guardar Informacion");
        // ----------------------------------

        goBackToClientes.setScaleY(2);
        goBackToClientes.setScaleX(2);

        confirmAddButton.setScaleY(2);
        confirmAddButton.setScaleX(2);

        cliente.setPrefWidth(10);
        cliente.setPrefHeight(5);

        direccion.setPrefWidth(10);
        direccion.setPrefHeight(5);

        ciudad.setPrefWidth(10);
        ciudad.setPrefHeight(5);

        telefono.setPrefWidth(10);
        telefono.setPrefHeight(5);

        panelAgregarClientes.getChildren().addAll(rectangleToDecorateAddClientes, goBackToClientes, confirmAddButton);

        VBox contenedorLabelsAddCliente = new VBox();
        contenedorLabelsAddCliente.setSpacing(15);
        contenedorLabelsAddCliente.getChildren().addAll(clienteLabel, direccionLabel, ciudadLabel, telefonoLabel);

        VBox contenedorTextAddCliente = new VBox();
        contenedorTextAddCliente.setSpacing(20);
        contenedorTextAddCliente.getChildren().addAll(cliente, direccion, ciudad, telefono);

        // ----------------------------------------------------------------------

        panelAgregarClientes.getChildren().addAll(contenedorLabelsAddCliente, contenedorTextAddCliente);

        panelAgregarClientes.setMargin(contenedorLabelsAddCliente, new Insets(280, 0, 0, 300));
        panelAgregarClientes.setMargin(contenedorTextAddCliente, new Insets(280, 300, 0, 400));
        panelAgregarClientes.setMargin(goBackToClientes, new Insets(600, 600, 0, 0));
        panelAgregarClientes.setMargin(confirmAddButton, new Insets(600, 0, 0, 500));

        confirmAddButton.toFront();
        agregarClienteView = new Scene(panelAgregarClientes, 1080, 720);
        agregarClienteView.getStylesheets().add("style.css");
    }

    public void initShowMenu() {

        panelPrincipalMenu = new StackPane();
        GridPane contenedorComidas = new GridPane();
        GridPane contenedorBebidas = new GridPane();
        GridPane contenedorPostres = new GridPane();

        contenedorComidas.setHgap(35); // Espacio horizontal entre las celdas
        contenedorComidas.setVgap(25); // Espacio vertical entre las celdas

        contenedorBebidas.setHgap(35); // Espacio horizontal entre las celdas
        contenedorBebidas.setVgap(25); // Espacio vertical entre las celdas

        contenedorPostres.setHgap(35); // Espacio horizontal entre las celdas
        contenedorPostres.setVgap(25); // Espacio vertical entre las celdas

        // Buttons
        comidas = new Button[6];
        bebidas = new Button[6];
        postres = new Button[6];

        for (int i = 0; i < comidas.length; i++) {
            // ----
            comidas[i] = new Button();

            // comidas[i].setScaleY(1.5);
            // comidas[i].setScaleX(1.5);
            comidas[i].setPrefSize(120, 50);
            // ---
            bebidas[i] = new Button();

            // bebidas[i].setScaleY(1.5);
            // bebidas[i].setScaleX(1.5);
            bebidas[i].setPrefSize(120, 50);
            // ---
            postres[i] = new Button();

            // postres[i].setScaleY(1.5);
            // postres[i].setScaleX(1.5);
            postres[i].setPrefSize(120, 50);
            // ---
        }

        // -----------------------
        comidas[0].setText("Pescado a la Sal");
        comidas[1].setText("Paella");
        comidas[2].setText("Kebabs");
        comidas[3].setText("Ratatouille");
        comidas[4].setText("Couscous");
        comidas[5].setText("Moussaka");
        // ------------------------
        bebidas[0].setText("Sangría");
        bebidas[1].setText("Café Griego");
        bebidas[2].setText("Ayran");
        bebidas[3].setText("Agua de Valencia");
        bebidas[4].setText("Café Espresso");
        bebidas[5].setText("Limoncello");
        // -------------------------

        postres[0].setText("Baklava");
        postres[1].setText("Tiramisú");
        postres[2].setText("Cannoli");
        postres[3].setText("Pastel De Santiago");
        postres[4].setText("Budin de Pan");
        postres[5].setText("Loukoumades");
        // Comidas-------------------------
        int ancho = 0;
        int largo = 0;
        for (int i = 0; i < comidas.length; i++) {
            if (i % 2 == 0) {
                ancho = 0;
                largo++;
                contenedorComidas.add(comidas[i], ancho, largo); // Añadir elementos al layout
                continue; // Funcion continue para skipear el codigo y volver al for
            }
            ancho++;
            contenedorComidas.add(comidas[i], ancho, largo);
        }
        // Bebidas-------------------------
        ancho = 0;
        largo = 0;
        for (int i = 0; i < bebidas.length; i++) {
            if (i % 2 == 0) {
                ancho = 0;
                largo++;
                contenedorBebidas.add(bebidas[i], ancho, largo); // Añadir elementos al layout
                continue; // Funcion continue para skipear el codigo y volver al for
            }
            ancho++;
            contenedorBebidas.add(bebidas[i], ancho, largo);
        }
        // Postres-------------------------
        ancho = 0;
        largo = 0;
        for (int i = 0; i < postres.length; i++) {
            if (i % 2 == 0) {
                ancho = 0;
                largo++;
                contenedorPostres.add(postres[i], ancho, largo); // Añadir elementos al layout
                continue; // Funcion continue para skipear el codigo y volver al for
            }
            ancho++;
            contenedorPostres.add(postres[i], ancho, largo);
        }

        panelPrincipalMenu.setBackground(fondo);
        // ----------------------
        panelPrincipalMenu.getChildren().addAll(contenedorComidas, contenedorBebidas, contenedorPostres);
        // ----------------------
        goBackToOptions = new Button("Atras");
        goBackToOptions.setScaleX(1.7);
        goBackToOptions.setScaleY(1.7);
        panelPrincipalMenu.getChildren().addAll(goBackToOptions);
        panelPrincipalMenu.setMargin(goBackToOptions, new Insets(850, 850, 0, 0));

        // ----------------------
        panelPrincipalMenu.setMargin(contenedorComidas, new Insets(100, 0, 0, 400));
        panelPrincipalMenu.setMargin(contenedorBebidas, new Insets(400, 0, 0, 400));
        panelPrincipalMenu.setMargin(contenedorPostres, new Insets(700, 0, 0, 400));
        // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)

        // -------
        TextField barraDeBusqueda = new TextField();
        barraDeBusqueda.setText("Buscar...");
        barraDeBusqueda.setScaleX(1.5);
        barraDeBusqueda.setScaleY(1.5);
        panelPrincipalMenu.getChildren().add(barraDeBusqueda);

        panelPrincipalMenu.setMargin(barraDeBusqueda, new Insets(0, 750, 400, 110));
        // ------------------------------------------------------------

        // --------------------
        confirmarPedido = new Button("ConfirmarPedido");
        confirmarPedido.setId("add");
        confirmarPedido.setScaleX(2);
        confirmarPedido.setScaleY(2);

        panelPrincipalMenu.getChildren().add(confirmarPedido);

        panelPrincipalMenu.setMargin(confirmarPedido, new Insets(850, 0, 0, 850));
        // -------------------
        Label footer = new Label("Oasis");

        footer.setScaleX(1.5);
        footer.setScaleY(1.5);
        panelPrincipalMenu.getChildren().add(footer);
        panelPrincipalMenu.setMargin(footer, new Insets(950, 0, 0, 0));
        // ----------
        // LISTA PARA VER LAS COSAS QUE SE AGREGAN

        // Crear una lista observable para almacenar elementos
        items = FXCollections.observableArrayList();

        // Crear un ListView y configurarlo con la lista observable
        listView = new ListView<>(items);
        deleteProducto = new Button("Eliminar");

        // Crear un diseño de caja vertical para organizar los elementos
        VBox contenedorDeProductosToAdd = new VBox(listView, deleteProducto);
        panelPrincipalMenu.getChildren().add(contenedorDeProductosToAdd);

        panelPrincipalMenu.setMargin(contenedorDeProductosToAdd, new Insets(600, 0, 150, 850));
        // ------
        scrollerDeMenu = new ScrollPane(panelPrincipalMenu);
        scrollerDeMenu.setFitToWidth(true); // Hacer que el ScrollPane se ajuste al ancho de la ventana
        scrollerDeMenu.setFitToHeight(true); // Hacer que el ScrollPane se ajuste al alto de la ventana

        menuView = new Scene(scrollerDeMenu, 1080, 720);
        menuView.getStylesheets().add("style.css");
    }

    public void initShowConfirmarPedido() {
        // Crear Panel
        StackPane contenedorELementosConfirmView = new StackPane();
        // Crear los objetos
        sendPedidoToCocinaButton = new Button("Confirmar!");
        // ---------------------
        backToMenu = new Button("Anterior");
        // -----------
        logo = new ImageView(picture);
        // -----------
        Rectangle rectangleToDecorateConfirm = new Rectangle(600, 700);
        // LABELS
        Label informacionDelPedidoLabel = new Label("Informacion del Pedido: ");
        informacionDelPedidoLabel.setFont(new Font(40));

        Label peidoLabel = new Label("Pedido: ");
        peidoLabel.setFont(new Font(20));

        Label domicilioLabel = new Label("Domicilio: ");
        domicilioLabel.setFont(new Font(20));

        Label precioLabel = new Label("Precio: ");
        precioLabel.setFont(new Font(20));

        Label impuestosLabel = new Label("Impuestos: ");
        impuestosLabel.setFont(new Font(20));

        Label precioTotalLabel = new Label("Precio Total");
        precioTotalLabel.setFont(new Font(20));

        VBox vboxParaLabels = new VBox();
        vboxParaLabels.setSpacing(45);
        vboxParaLabels.getChildren().addAll(informacionDelPedidoLabel, peidoLabel, domicilioLabel, precioLabel,
                impuestosLabel, precioTotalLabel);
        // -
        VBox vBoxParaText = new VBox();
        vBoxParaText.setSpacing(55);

        vBoxParaText.getChildren().addAll(pedidoText, domicilioText, precioText, impuestoText,
                precioTotalText);

        // Agregando elementos
        contenedorELementosConfirmView.getChildren().addAll(sendPedidoToCocinaButton, backToMenu, logo,
                rectangleToDecorateConfirm, vboxParaLabels, vBoxParaText);

        // Propiedades
        sendPedidoToCocinaButton.setScaleY(2);
        sendPedidoToCocinaButton.setScaleX(2);
        sendPedidoToCocinaButton.setId("add");
        // ----------------------------------
        backToMenu.setScaleY(2);
        backToMenu.setScaleX(2);
        // -----------
        logo.setFitHeight(120); // Alto
        logo.setFitWidth(100); // Ancho
        // -----------
        contenedorELementosConfirmView.setBackground(fondo);
        // -------------------------

        rectangleToDecorateConfirm.toBack();
        rectangleToDecorateConfirm.setFill(colorBeige);
        rectangleToDecorateConfirm.setStroke(Color.BLACK); // Color del borde
        rectangleToDecorateConfirm.setStrokeWidth(1); // Grosor del borde

        //
        pedidoText.setFont(new Font(12));
        domicilioText.setFont(new Font(12));
        precioText.setFont(new Font(12));
        impuestoText.setFont(new Font(12));
        precioTotalText.setFont(new Font(12));
        // Organizando items
        contenedorELementosConfirmView.setMargin(sendPedidoToCocinaButton, new Insets(600, 0, 0, 350)); // establecer un
                                                                                                        // margen
                                                                                                        // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        contenedorELementosConfirmView.setMargin(backToMenu, new Insets(650, 800, 0, 0)); // establecer un

        contenedorELementosConfirmView.setMargin(logo, new Insets(0, 900, 620, 0)); // establecer un margen
        // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        contenedorELementosConfirmView.setMargin(vboxParaLabels, new Insets(50, 0, 0, 350)); // establecer un

        contenedorELementosConfirmView.setMargin(vBoxParaText, new Insets(200, 0, 0, 550)); // establecer un
        sendPedidoToCocinaButton.toFront();
        confirmarPedidoView = new Scene(contenedorELementosConfirmView, 1080, 720);
        confirmarPedidoView.getStylesheets().add("style.css");
    }

    public void switchScene(Scene scene) {
        window.setScene(scene);
    }
}