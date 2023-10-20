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
public class VistaDomicilio {
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

    public VistaDomicilio() {
        window = new Stage();
        initDomicilio();

        clientes.setOnAction(event -> {
            Scene firstScreen = createFirstScreen();
            window.setScene(firstScreen);
        });
    }

    public void initDomicilio(){
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


}
