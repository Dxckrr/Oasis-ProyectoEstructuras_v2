package co.edu.upb.oasis.vistas;

import co.edu.upb.oasis.clases.Usuario;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VistaAdmin {
    Stage window;
    //Escenas
    Scene optionPanel , login , selector;
    //Paneles
    StackPane panelPrincipal;
    GridPane opcionesPanel;
    StackPane panelLogin;
    VBox contenedorLoginPassWord;

    //Botones
    public Button clientes;
    public Button anteriorButton = new Button();
    /*Button menu;
    Button pedido;
    Button domicilio;*/
    public Button confirmAddButton;
    public Button mondaButton;
    public Button Prod22Button;
    public Button mojarraButton;
    public Button productt3Button;
    public Button anotherButton;
    public Button clientButton;
    public Button searchOperadorButton;

    //TextField
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

    //Imagenes
    ImageView logo;
    Image picture = new Image("file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\UX.png");

    //Figuras
    Rectangle rectangleToDecorate;
    Rectangle rectangleLogo;

    //Colores
    String beige = "#FFECBB";
    Color colorBeige = Color.web(beige);
    //
    String sand = "#FFC93E";
    Color colorSand = Color.web(sand);
    //
    String orange = "#FF9900";
    Color colorOrange = Color.web(orange);

    //Background
    BackgroundFill colorFondo = new BackgroundFill(colorSand,null,null);
    Background fondo = new Background(colorFondo);

    Pane pane = new Pane();

    public VistaAdmin() {
        window = new Stage();
        initAdmin();

        clientes.setOnAction(event -> {
            Scene firstScreen = createFirstScreen();
            window.setScene(firstScreen);
        });
    }

    private void initAdmin() {
        //Crear Panel
        panelPrincipal = new StackPane();
        opcionesPanel = new GridPane();
        opcionesPanel.setHgap(100); // Ajusta la separación horizontal a 20 píxeles
        opcionesPanel.setVgap(100); // Ajusta la separación vertical a 20 píxeles
        //Crear los objetos
        clientes = new Button("HELLO ADMIN");
        confirmAddButton = new Button("Guardar Operador");
        mojarraButton = new Button("Guardar Domiciliario");
        clientButton = new Button("Guardar cliente");
        searchOperadorButton = new Button("Operador Buscado");
        mondaButton = new Button("Guardar Producto");
        Prod22Button = new Button("Guardar Producto");
        productt3Button = new Button("Guardar producto");
        /*menu = new Button("Menu");
        pedido = new Button("Pedidos");
        domicilio = new Button("Rutas");*/
        //-----------
        logo = new ImageView(picture);
        //-----------
        rectangleToDecorate = new Rectangle(700,400);

        //Agregando elementos

        opcionesPanel.add(clientes, 0, 0);
       /*opcionesPanel.add(menu, 1, 0);
        opcionesPanel.add(pedido, 0, 1);
        opcionesPanel.add(domicilio, 1, 1);*/
        opcionesPanel.setAlignment(Pos.CENTER);
        panelPrincipal.getChildren().addAll(logo,rectangleToDecorate,opcionesPanel);

        //Propiedades
        clientes.setScaleY(2.5);
        clientes.setScaleX(2.5);
        /*menu.setScaleY(2);
        menu.setScaleX(2);
        pedido.setScaleY(2);
        pedido.setScaleX(2);
        domicilio.setScaleY(2);
        domicilio.setScaleX(2);*/
        //-----------
        logo.setFitHeight(80);	//Alto
        logo.setFitWidth(80);	//Ancho
        //-----------
        panelPrincipal.setBackground(fondo);
        //-------------------------

        rectangleToDecorate.toBack();
        rectangleToDecorate.setFill(colorBeige);
        rectangleToDecorate.setStroke(Color.BLACK); // Color del borde
        rectangleToDecorate.setStrokeWidth(1); // Grosor del borde

        //
        clientes.setOnAction(event -> {


        });

        //Organizando items
        panelPrincipal.setMargin(logo, new Insets(0,0,125,0)); // establecer un margen (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        panelPrincipal.setAlignment(opcionesPanel,Pos.CENTER); // establecer un margen (ABAJO,IZQUIERDA,ARRIBA,DERECHA)



        optionPanel = new Scene(panelPrincipal,1080,720);

        window.setScene(optionPanel);
        window.setTitle("Oasis"); 	//Estableciendo titulo
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
            Scene secondScreen = createSecondScreen();
            window.setScene(secondScreen);
        });
        return scene;
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

        ImageView adminImage = new ImageView(new Image("file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\adminUser.png"));
        adminImage.setFitWidth(148);
        adminImage.setFitHeight(121);
        otrofunsionscreen.add(adminImage, 2, 0, 1, 1);

        return otrofunsionscreen;
    }

    private GridPane createSmallerScreen() {
        GridPane smallerScreen =otrofuncio("ADMINISTRADOR");
        smallerScreen.add(anteriorButton, 0, 3);

        Button databaseButton = new Button("BASE DE DATOS");
        databaseButton.setPrefSize(277, 209);
        databaseButton.setId("databaseButton");

        Button configButton = new Button("CONFIGURACION DEL SISTEMA");
        configButton.setPrefSize(277, 209);

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

    private Scene anoTherProductsScreen(){
        GridPane productScreen = otrofuncio("¿QUÉ DESEA GESTIONAR DE LOS PRODUCTOS?");
        productScreen.add(anteriorButton, 0, 3);

        Button comidasRapidad = new Button("COMIDAS RÁPIDAS");
        comidasRapidad.setPrefSize(277, 209);
        comidasRapidad.setOnAction(event -> {
            Scene productComsRapidas = productComidasRapidas();
            window.setScene(productComsRapidas);
        });
        Button debidasButton = new Button("BEBIDAS");
        debidasButton.setPrefSize(277, 209);
        debidasButton.setPrefSize(277,209);
        debidasButton.setOnAction(event ->{
            Scene produccctBebidas = productBebidas();
            window.setScene(produccctBebidas);
        });

        Button postresButton = new Button("POSTRES");
        postresButton.setPrefSize(277, 209);
        postresButton.setOnAction(event ->{
            Scene producttPostress = productPostrews();
            window.setScene(producttPostress);
        });

        GridPane buttonsGrid = new GridPane();
        buttonsGrid.setHgap(10);

        buttonsGrid.add(comidasRapidad, 0, 0);
        buttonsGrid.add(debidasButton, 1, 0);
        buttonsGrid.add(postresButton, 2, 0);

        GridPane.setColumnSpan(buttonsGrid, 3);
        productScreen.add(buttonsGrid, 0, 1);

        anteriorButton.setOnAction(event -> {
            window.setScene(createSecondScreen());
        });
        return new Scene(productScreen, 960, 603);

    }

    private Scene productComidasRapidas() {
        GridPane comidasRapidasScreen = otrofuncio("COMIDAS MEDITERRANEAS");
    
        comidasRapidasScreen.add(anteriorButton, 0, 5);
    
        String[] productNames = {"Ratatouille", "Pescado", "Paella", "Moussaka", "Couscous", "Kebabs"};
    
        Button agregarProducto = new Button("Agregar Producto");
        agregarProducto.setOnAction(event -> {
            window.setScene(addProductScreen());
        });
        comidasRapidasScreen.add(agregarProducto, 5, 5);
    
        Button buscarProducto = new Button("Buscar Producto");
        buscarProducto.setOnAction(event -> {
            window.setScene(createSearchProductScene());
        });
        comidasRapidasScreen.add(buscarProducto, 5, 4);
    
        TextArea infoTextArea = new TextArea();
        infoTextArea.setPrefRowCount(5);
        infoTextArea.setPrefColumnCount(30);
        comidasRapidasScreen.add(infoTextArea, 0, 6, 3, 1);
    
        for (int i = 2; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                int index = 3 * (i - 2) + j;
                if (index < productNames.length) {
                    String productName = productNames[index];
                    Button button = new Button(productName);
                    button.setPrefSize(200, 150);
                    button.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-margin: 10px;");
                    comidasRapidasScreen.add(button, j, i);
    
                    button.setOnAction(event -> {
                        //displayProductInformation(productName);
                        infoTextArea.setText("Aquí va la información del producto " + productName);
                    });
                }
            }
        }
    
        anteriorButton.setOnAction(event -> {
            window.setScene(anoTherProductsScreen());
        });
    
        return new Scene(comidasRapidasScreen, 960, 603);
    }
    
    private Scene addProduct11Screen() {
        GridPane addProduct11Screen = otrofuncio("CREAR PRODUCTO");

        producto11Field = new TextField();
        producto11Field.setPromptText("Producto");
        addProduct11Screen.add(producto11Field, 0, 2);

        descripcion11Field = new TextField();
        descripcion11Field.setPromptText("Descripción");
        addProduct11Screen.add(descripcion11Field, 0, 2);

        precio11Field = new TextField();
        precio11Field.setPromptText("Precio");
        addProduct11Screen.add(precio11Field, 0, 4);

        tiempo11dePreparacion = new TextField();
        tiempo11dePreparacion.setPromptText("Tiempo de preparación");
        addProduct11Screen.add(tiempo11dePreparacion, 0, 5);

        id11Field2 = new TextField();
        id11Field2.setPromptText("Id");
        addProduct11Screen.add(id11Field2, 0, 6);

        addProduct11Screen.add(mondaButton, 0, 7);

        Button backButton = new Button("ANTERIOR");
        backButton.setOnAction(event -> window.setScene(productBebidas()));
        addProduct11Screen.add(backButton, 0, 8);

        return new Scene(addProduct11Screen, 960, 603);
    }

    private Scene createSearch11ProductScene() {
        GridPane searchProductt11Screen = otrofuncio("ENCONTRAR PRODUCTO");

        TextField searchField = new TextField();
        searchField.setPromptText("Buscar producto por nombre");
        searchProductt11Screen.add(searchField, 0, 1);

        Button searchButton = new Button("Buscar");
        searchProductt11Screen.add(searchButton, 1, 1);

        Button backButton = new Button("ANTERIOR");
        backButton.setOnAction(event -> window.setScene(productBebidas()));
        searchProductt11Screen.add(backButton, 0, 4);

        return new Scene(searchProductt11Screen, 960, 603);
    }

    private Scene addProduct22Screen() {
        GridPane addProduct22Screen = otrofuncio("CREAR PRODUCTO");

        producto22Field = new TextField();
        producto22Field.setPromptText("Producto");
        addProduct22Screen.add(producto22Field, 0, 2);

        descripcion22Field = new TextField();
        descripcion22Field.setPromptText("Descripción");
        addProduct22Screen.add(descripcion22Field, 0, 2);

        precio22Field = new TextField();
        precio22Field.setPromptText("Precio");
        addProduct22Screen.add(precio22Field, 0, 4);

        tiempo22dePreparacion = new TextField();
        tiempo22dePreparacion.setPromptText("Tiempo de preparación");
        addProduct22Screen.add(tiempo22dePreparacion, 0, 5);

        id22Field2 = new TextField();
        id22Field2.setPromptText("Id");
        addProduct22Screen.add(id22Field2, 0, 6);

        addProduct22Screen.add(Prod22Button, 0, 7);

        Button backButton = new Button("ANTERIOR");
        backButton.setOnAction(event -> window.setScene(productPostrews()));
        addProduct22Screen.add(backButton, 0, 8);

        return new Scene(addProduct22Screen, 960, 603);
    }

    private Scene createSearch122ProductScene() {
        GridPane searchProductt22Screen = otrofuncio("ENCONTRAR PRODUCTO");

        TextField searchField = new TextField();
        searchField.setPromptText("Buscar producto por nombre");
        searchProductt22Screen.add(searchField, 0, 1);

        Button searchButton = new Button("Buscar");
        searchProductt22Screen.add(searchButton, 1, 1);

        Button backButton = new Button("ANTERIOR");
        backButton.setOnAction(event -> window.setScene(productPostrews()));
        searchProductt22Screen.add(backButton, 0, 4);

        return new Scene(searchProductt22Screen, 960, 603);
    }


    private Scene addProductScreen() {
        GridPane addProductScreen = otrofuncio("CREAR PRODUCTO");

        productoField = new TextField();
        productoField.setPromptText("Producto");
        addProductScreen.add(productoField, 0, 2);

        descripcionField = new TextField();
        descripcionField.setPromptText("Descripción");
        addProductScreen.add(descripcionField, 0, 3);

        precioField = new TextField();
        precioField.setPromptText("Precio");
        addProductScreen.add(precioField, 0, 4);

        tiempdePreparacion = new TextField();
        tiempdePreparacion.setPromptText("Tiempo de preparación");
        addProductScreen.add(tiempdePreparacion, 0, 5);

        idField2 = new TextField();
        idField2.setPromptText("Id");
        addProductScreen.add(idField2, 0, 6);

        addProductScreen.add(productt3Button, 0, 7);

        Button backButton = new Button("ANTERIOR");
        backButton.setOnAction(event -> window.setScene(productComidasRapidas()));
        addProductScreen.add(backButton, 0, 8);

        return new Scene(addProductScreen, 960, 603);
    }

    private Scene createSearchProductScene() {
        GridPane searchOperatorScreen = otrofuncio("ENCONTRAR PRODUCTO");

        TextField searchField = new TextField();
        searchField.setPromptText("Buscar producto por nombre");
        searchOperatorScreen.add(searchField, 0, 1);

        Button searchButton = new Button("Buscar");
        searchOperatorScreen.add(searchButton, 1, 1);

        Button backButton = new Button("ANTERIOR");
        backButton.setOnAction(event -> window.setScene(productComidasRapidas()));
        searchOperatorScreen.add(backButton, 0, 4);

        return new Scene(searchOperatorScreen, 960, 603);
    }

    /*private void displayProductInformation(String productName) {
        Stage productInfoStage = new Stage();
        productInfoStage.initModality(Modality.APPLICATION_MODAL);

        VBox productInfoLayout = new VBox();
        productInfoLayout.setAlignment(Pos.CENTER);
        productInfoLayout.setSpacing(20);

        TextArea productInfoTextArea = new TextArea();
        productInfoTextArea.setPrefRowCount(5);
        productInfoTextArea.setPrefColumnCount(30);
        productInfoTextArea.setEditable(false); // Make it non-editable
        productInfoLayout.getChildren().add(productInfoTextArea);

        String filePath = "path_to_your_json_directory/" + productName + ".json"; // Reemplaza con la ruta real
        Producto product = ServicioAdministrador.fromJSON(filePath);
        if (product != null) {
            String productInfo = "Name: " + product.getName() + "\n"
                    + "Description: " + product.getDescription() + "\n"
                    + "Price: " + product.getPrice() + "\n"
                    + "Preparation Time: " + product.getPreparationTime() + "\n"
                    + "ID: " + product.getId();
            productInfoTextArea.setText(productInfo);
        }

        Scene productInfoScene = new Scene(productInfoLayout, 400, 400);
        productInfoStage.setScene(productInfoScene);
        productInfoStage.show();
    }*/

    private Scene productBebidas() {
        GridPane bebdiasScreen = otrofuncio("Menú de bebidas");

        bebdiasScreen.add(anteriorButton, 0, 5);

        String[] imagePaths = { "file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\Sangría.jpg", "file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\CaféEspresso.jpg", "file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\CafeGriego.jpg", 
        "file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\Ayran.jpg", "file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\AguadeValencia.jpg", "file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\Limoncello.jpg" };

        Button agregar1Producto = new Button("Agregar Producto");
        agregar1Producto.setOnAction(event -> {
            window.setScene(addProduct11Screen());
        });
        bebdiasScreen.add(agregar1Producto,5,5);

        Button buscar1Producto = new Button("Buscar Producto");
        buscar1Producto.setOnAction(event -> {
            window.setScene(createSearch11ProductScene());
        });
        bebdiasScreen.add(buscar1Producto, 5, 4);

        TextArea infoTextArea = new TextArea();
        infoTextArea.setPrefRowCount(5);
        infoTextArea.setPrefColumnCount(30);
        bebdiasScreen.add(infoTextArea, 0, 6, 3, 1);

        int index = 0;
        for (int i = 2; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (index < imagePaths.length) {
                    Button button = new Button();
                    button.setPrefSize(200, 150);

                    String imagePath = imagePaths[index];
                    BackgroundImage backgroundImage = new BackgroundImage(
                            new Image(imagePath, 200, 150, false, true),
                            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                            BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
                    button.setBackground(new Background(backgroundImage));

                    // Agregar estilo CSS a los botones de imagen
                    button.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-margin: 10px;");

                    bebdiasScreen.add(button, j, i);
                    index++;

                    button.setOnAction(event -> {
                        //displayProductInformation(imagePath);
                        infoTextArea.setText("Aquí va la información del producto " + imagePath);
                    });
                }
            }
        }
        anteriorButton.setOnAction(event -> {
            window.setScene(anoTherProductsScreen());
        });
        return new Scene(bebdiasScreen, 960, 603);
    }


    private Scene productPostrews(){
        GridPane postressScreen = otrofuncio("POSTRES");

        postressScreen.add(anteriorButton, 0, 5);

        String[] imagePaths = {"file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\Tiramisu.jpg", "file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\PasteldeSantiago.jpg","file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\Loukoumades.jpg",
        "file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\Cannoli.jpg", "file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\BudíndePan.jpg", "file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\Baklava.jpg"};

        Button agregar2Producto = new Button("Agregar Producto");
        agregar2Producto.setOnAction(event -> {
            window.setScene(addProduct22Screen());
        });
        postressScreen.add(agregar2Producto,5,5);

        Button buscar2Producto = new Button("Buscar Producto");
        buscar2Producto.setOnAction(event -> {
            window.setScene(createSearch122ProductScene());
        });
        postressScreen.add(buscar2Producto, 5, 4);

        TextArea infoTextArea = new TextArea();
        infoTextArea.setPrefRowCount(5);
        infoTextArea.setPrefColumnCount(30);
        postressScreen.add(infoTextArea, 0, 6, 3, 1);

        int index = 0;
        for (int i = 2; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (index < imagePaths.length) {
                    Button button = new Button();
                    button.setPrefSize(200, 150);

                    String imagePath = imagePaths[index];
                    BackgroundImage backgroundImage = new BackgroundImage(
                            new Image(imagePath, 200, 150, false, true),
                            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                            BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
                    button.setBackground(new Background(backgroundImage));
                    button.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-margin: 10px;");
                    postressScreen.add(button, j, i);
                    index++;

                    button.setOnAction(event -> {
                        //displayProductInformation(imagePath);
                        infoTextArea.setText("Aquí va la información del producto " + imagePath);
                    });
                }
            }
        }
        anteriorButton.setOnAction(event -> {
            window.setScene(anoTherProductsScreen());
        });
        return new Scene(postressScreen, 960, 603);
    }

    private Scene createSecondScreen() {
        GridPane secondScreen = otrofuncio("¿QUÉ DESEA GESTIONAR EN LA BASE DE DATOS?");
        secondScreen.add(anteriorButton, 0, 3);

        Button usersButton = new Button("USUARIOS");
        usersButton.setPrefSize(277, 209);
        usersButton.setOnAction(event -> {
            Scene thirdScreen = createThirdScreen();
            window.setScene(thirdScreen);
        });
        Button productsButton = new Button("PRODUCTOS");
        productsButton.setPrefSize(277, 209);
        productsButton.setPrefSize(277,209);
        productsButton.setOnAction(event ->{
            Scene productsScreen = anoTherProductsScreen();
            window.setScene(productsScreen);
        });

        Button registeredClientsButton = new Button("CLIENTES REGISTRADOS");
        registeredClientsButton.setPrefSize(277, 209);
        registeredClientsButton.setOnAction(event ->{
            Scene clientScreen = createManageClientScene();
            window.setScene(clientScreen);
        });

        GridPane buttonsGrid = new GridPane();
        buttonsGrid.setHgap(10);

        buttonsGrid.add(usersButton, 0, 0);
        buttonsGrid.add(productsButton, 1, 0);
        buttonsGrid.add(registeredClientsButton, 2, 0);

        GridPane.setColumnSpan(buttonsGrid, 3);
        secondScreen.add(buttonsGrid, 0, 1);

        anteriorButton.setOnAction(event -> {
            window.setScene(createFirstScreen());
        });
        return new Scene(secondScreen, 960, 603);
    }
    private Scene createThirdScreen() {
        GridPane thirdScreen = otrofuncio("SELECCIONE UN TIPO DE USUARIO");
        thirdScreen.add(anteriorButton, 0, 3);

        Button operatorButton = new Button("OPERADOR");
        operatorButton.setPrefSize(277, 209);

        Button deliveryButton = new Button("DOMICILIARIO");
        deliveryButton.setPrefSize(277, 209);

        GridPane buttonsGrid = new GridPane();
        buttonsGrid.setHgap(10);

        buttonsGrid.add(operatorButton, 0, 0);
        buttonsGrid.add(deliveryButton, 1, 0);

        GridPane.setColumnSpan(buttonsGrid, 3);
        thirdScreen.add(buttonsGrid, 0, 1);

        anteriorButton.setOnAction(event -> {
            window.setScene(createSecondScreen());
        });
        operatorButton.setOnAction(event -> {
            Scene manageOperatorsScene = createManageOperatorsScene();
            window.setScene(manageOperatorsScene);
        });
        deliveryButton.setOnAction(event ->{
            Scene manageDomiziliario = createManageDomiciliariozScene();
            window.setScene(manageDomiziliario);
        });

        return new Scene(thirdScreen, 960, 603);
    }

    private Scene createManageDomiciliariozScene() {
        GridPane manageDomiciliarioScreen = otrofuncio("GESTIONAR DOMICILIARIO");

        Button addDomicilairiosButton = new Button("Agregar Domiciliario");
        addDomicilairiosButton.setOnAction(event -> {
            window.setScene(createAdddDomiziliarioScene());
        });
        manageDomiciliarioScreen.add(addDomicilairiosButton, 0, 1);

        Button searchmanageDomiciliarioScreenzButton = new Button("Buscar Domiciliario");
        searchmanageDomiciliarioScreenzButton.setOnAction(event -> {
            window.setScene(createSearchDomiciliariioScene());
        });
        manageDomiciliarioScreen.add(searchmanageDomiciliarioScreenzButton, 1, 1);

        Button backButton = new Button("ANTERIOR");
        backButton.setOnAction(event -> window.setScene(createThirdScreen()));
        manageDomiciliarioScreen.add(backButton, 0, 4);

        return new Scene(manageDomiciliarioScreen, 960, 603);
    }

    private Scene createManageOperatorsScene() {
        GridPane manageOperatorsScreen = otrofuncio("GESTIONAR OPERADOR");

        Button addOperatorButton = new Button("Agregar Operador");
        addOperatorButton.setOnAction(event -> {
            window.setScene(createAddOperatorScene());
        });
        manageOperatorsScreen.add(addOperatorButton, 0, 1);

        Button searchOperatorButton = new Button("Buscar Operador");
        searchOperatorButton.setOnAction(event -> {
            window.setScene(createSearchOperatorScene());
        });
        manageOperatorsScreen.add(searchOperatorButton, 1, 1);

        Button backButton = new Button("ANTERIOR");
        backButton.setOnAction(event -> window.setScene(createThirdScreen()));
        manageOperatorsScreen.add(backButton, 0, 4);

        return new Scene(manageOperatorsScreen, 960, 603);
    }

    private Scene createSearchDomiciliariioScene(){
        GridPane searchDomixilairioScreen = otrofuncio("ENCONTRAR DOMICILIARIO");

        TextField searchField = new TextField();
        searchField.setPromptText("Buscar Domiciliario por Código");
        searchDomixilairioScreen.add(searchField, 0, 1);

        Button searchButton = new Button("Buscar");
        searchButton.setOnAction(event -> {
            /*String searchCode = searchField.getText();
            if (!searchCode.isEmpty()) {
                Usuario domiciliarioEncontrado = domiciliarioEncontrado.buscarDomiciliarioPorUsuario(searchCode);
                if (domiciliarioEncontrado != null) {
                    showDomiciliariosInfo(domiciliarioEncontrado);
                } else {
                    displayNotFoundAlert();
                }
            }*/
        });
        searchDomixilairioScreen.add(searchButton, 1, 1);

        Button backButton = new Button("ANTERIOR");
        backButton.setOnAction(event -> window.setScene(createManageDomiciliariozScene()));
        searchDomixilairioScreen.add(backButton, 0, 4);

        return new Scene(searchDomixilairioScreen, 960, 603);
    }

    private Scene createSearchOperatorScene() {
        GridPane searchOperatorScreen = otrofuncio("ENCONTRAR OPERADOR");

        search24Field = new TextField();
        search24Field.setPromptText("Buscar Operador por Código");
        searchOperatorScreen.add(search24Field, 0, 1);

        searchOperatorScreen.add(searchOperadorButton, 1, 1);

        Button backButton = new Button("ANTERIOR");
        backButton.setOnAction(event -> window.setScene(createManageOperatorsScene()));
        searchOperatorScreen.add(backButton, 0, 4);

        return new Scene(searchOperatorScreen, 960, 603);
    }

    private void showDomiciliariosInfo(Usuario domiciliario) {
        Stage infoStage = new Stage();
        GridPane infoPane = new GridPane();
        infoPane.setAlignment(Pos.CENTER);
        Scene infoScene = new Scene(infoPane, 400, 300);
        infoStage.setScene(infoScene);

        Label usuarioLabel = new Label("Usuario: " + domiciliario.getUsuario());
        Label contraseñaLabel = new Label("Contraseña: " + domiciliario.getPassword());
        Label idLabel = new Label("Id: " + domiciliario.getId());

        infoPane.add(usuarioLabel, 0, 0);
        infoPane.add(contraseñaLabel, 0, 1);
        infoPane.add(idLabel, 0, 2);

        Button editButton = new Button("Editar Información");
        editButton.setOnAction(event -> editDomicilairioInfo(domiciliario));
        infoPane.add(editButton, 0, 3);

        infoStage.initModality(Modality.APPLICATION_MODAL);
        infoStage.show();
    }

    private void editDomicilairioInfo(Usuario domiciliario) {
        Stage editStage = new Stage();
        GridPane editPane = new GridPane();
        editPane.setAlignment(Pos.CENTER);
        Scene editScene = new Scene(editPane, 400, 300);
        editStage.setScene(editScene);

        usuario1Field = new TextField(domiciliario.getUsuario());
        contraseña1Field = new TextField(domiciliario.getPassword());
        id1Field = new TextField(String.valueOf(domiciliario.getId()));


        Button saveButton = new Button("Guardar Cambios");
        saveButton.setOnAction(event -> {
            domiciliario.setUsuario(usuario1Field.getText());
            domiciliario.setPassword(contraseña1Field.getText());
            int id = 0;
            try {
                id = Integer.parseInt(id1Field.getText());
                domiciliario.setId(id);
            } catch (NumberFormatException e) {
                displayNotFoundAlert();
                return; // No cierra el escenario de edición si hay una excepción
            }
            editStage.close();
        });

        editPane.add(new Label("Usuario:"), 0, 0);
        editPane.add(usuario1Field, 1, 0);
        editPane.add(new Label("Contraseña:"), 0, 1);
        editPane.add(contraseña1Field, 1, 1);
        editPane.add(new Label("Id:"), 0, 2);
        editPane.add(id1Field, 1, 2);
        editPane.add(saveButton, 0, 4, 2, 1);

        editStage.initModality(Modality.APPLICATION_MODAL);
        editStage.show();
    }

    private void showOperatorInfo(Usuario operador) {
        Stage infoStage = new Stage();
        GridPane infoPane = new GridPane();
        infoPane.setAlignment(Pos.CENTER);
        Scene infoScene = new Scene(infoPane, 400, 300);
        infoStage.setScene(infoScene);

        Label usuarioLabel = new Label("Usuario: " + operador.getUsuario());
        Label contraseñaLabel = new Label("Contraseña: " + operador.getPassword());
        Label idLabel = new Label("Id: " + operador.getId());

        infoPane.add(usuarioLabel, 0, 0);
        infoPane.add(contraseñaLabel, 0, 1);
        infoPane.add(idLabel, 0, 2);

        Button editButton = new Button("Editar Información");
        editButton.setOnAction(event -> editOperatorInfo(operador));
        infoPane.add(editButton, 0, 3);

        infoStage.initModality(Modality.APPLICATION_MODAL);
        infoStage.show();
    }

    private void editOperatorInfo(Usuario operador) {
        Stage editStage = new Stage();
        GridPane editPane = new GridPane();
        editPane.setAlignment(Pos.CENTER);
        Scene editScene = new Scene(editPane, 400, 300);
        editStage.setScene(editScene);

        usuarioField = new TextField(operador.getUsuario());
        contraseñaField = new TextField(operador.getPassword());
        idField = new TextField(String.valueOf(operador.getId()));

        Button saveButton = new Button("Guardar Cambios");
        saveButton.setOnAction(event -> {
            operador.setUsuario(usuarioField.getText());
            operador.setPassword(contraseñaField.getText());
            int id = 0;
            try {
                id = Integer.parseInt(idField.getText());
                operador.setId(id);
            } catch (NumberFormatException e) {
                displayNotFoundAlert();
                return; // No cierra el escenario de edición si hay una excepción
            }
            editStage.close();
        });

        editPane.add(new Label("Usuario:"), 0, 0);
        editPane.add(usuarioField, 1, 0);
        editPane.add(new Label("Contraseña:"), 0, 1);
        editPane.add(contraseñaField, 1, 1);
        editPane.add(new Label("Id:"), 0, 2);
        editPane.add(idField, 1, 2);
        editPane.add(saveButton, 0, 4, 2, 1);

        editStage.initModality(Modality.APPLICATION_MODAL);
        editStage.show();
    }
    private void displayNotFoundAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Usuario no encontrado");
        alert.setHeaderText(null);
        alert.setContentText("El usuario buscado no ha sido encontrado. Por favor, intente de nuevo.");
        alert.showAndWait();
    }

    private Scene createAdddDomiziliarioScene() {
        GridPane addDomiziliariocreen = otrofuncio("CREAR DOMICILIARIO");

        usuario1Field = new TextField();
        usuario1Field.setPromptText("Usuario");
        addDomiziliariocreen.add(usuario1Field, 0, 2);

        contraseña1Field = new TextField();
        contraseña1Field.setPromptText("Contraseña");
        addDomiziliariocreen.add(contraseña1Field, 0, 3);

        id1Field = new TextField();
        id1Field.setPromptText("Id");
        addDomiziliariocreen.add(id1Field, 0, 4);
        
        addDomiziliariocreen.add(mojarraButton, 0, 5);

        Button backButton = new Button("ANTERIOR");
        backButton.setOnAction(event -> window.setScene(createManageDomiciliariozScene()));
        addDomiziliariocreen.add(backButton, 0, 6);

        return new Scene(addDomiziliariocreen, 960, 603);
    }

    private Scene createAddOperatorScene() {
        GridPane addOperatorScreen = otrofuncio("CREAR OPERADOR");

        usuarioField = new TextField();
        usuarioField.setPromptText("Usuario");
        addOperatorScreen.add(usuarioField, 0, 2);

        contraseñaField = new TextField();
        contraseñaField.setPromptText("Contraseña");
        addOperatorScreen.add(contraseñaField, 0, 3);

        idField = new TextField();
        idField.setPromptText("Id");
        addOperatorScreen.add(idField, 0, 4);

        addOperatorScreen.add(confirmAddButton, 0, 5);

        Button backButton = new Button("ANTERIOR");
        backButton.setOnAction(event -> window.setScene(createManageOperatorsScene()));
        addOperatorScreen.add(backButton, 0, 6);

        return new Scene(addOperatorScreen, 960, 603);
    }

    private Scene createAddClientesScene() {
        GridPane addClienteScreen = otrofuncio("CREAR CLIENTE");

        nombreField = new TextField();
        nombreField.setPromptText("Nombre");
        addClienteScreen.add(nombreField, 0, 2);

        direccionField = new TextField();
        direccionField.setPromptText("Dirección");
        addClienteScreen.add(direccionField, 0, 3);

        ciudadField = new TextField();
        ciudadField.setPromptText("Ciudad");
        addClienteScreen.add(ciudadField, 0, 4);

        telefonoField = new TextField();
        telefonoField.setPromptText("Teléfono");
        addClienteScreen.add(telefonoField, 0, 5);

        addClienteScreen.add(clientButton, 0, 6);

        Button backButton = new Button("ANTERIOR");
        backButton.setOnAction(event -> window.setScene(createManageOperatorsScene()));
        addClienteScreen.add(backButton, 0, 7);

        return new Scene(addClienteScreen, 960, 603);
    }

    private Scene createManageClientScene() {
        GridPane manageClientScreen = otrofuncio("GESTIONAR CLIENTE");

        Button addClienteButton = new Button("Agregar Cliente");
        addClienteButton.setOnAction(event -> {
            window.setScene(createAddClientesScene());
        });
        manageClientScreen.add(addClienteButton, 0, 1);

        Button searchClientButton = new Button("Buscar Cliente");
        searchClientButton.setOnAction(event -> {
            window.setScene(createSearchClientScene());
        });
        manageClientScreen.add(searchClientButton, 1, 1);

        Button backButton = new Button("ANTERIOR");
        backButton.setOnAction(event -> window.setScene(createThirdScreen()));
        manageClientScreen.add(backButton, 0, 4);

        return new Scene(manageClientScreen, 960, 603);
    }
    
    private Scene createSearchClientScene() {
        GridPane searchClientScreen = otrofuncio("ENCONTRAR CLIENTE");

        TextField searchField = new TextField();
        searchField.setPromptText("Buscar Cliente por Código");
        searchClientScreen.add(searchField, 0, 1);

        Button searchButton = new Button("Buscar");
        searchButton.setOnAction(event -> {
            /*String searchCode = searchField.getText();
            if (!searchCode.isEmpty()) {
                Usuario operadorEncontrado = operadorEncontrado.buscarOperadorPorusuario(searchCode);
                if (operadorEncontrado != null) {
                    showOperatorInfo(operadorEncontrado);
                } else {
                    displayNotFoundAlert();
                }
            }*/
        });

        searchClientScreen.add(searchButton, 1, 1);

        Button backButton = new Button("ANTERIOR");
        backButton.setOnAction(event -> window.setScene(createManageClientScene()));
        searchClientScreen.add(backButton, 0, 4);

        return new Scene(searchClientScreen, 960, 603);
    }
    
}


