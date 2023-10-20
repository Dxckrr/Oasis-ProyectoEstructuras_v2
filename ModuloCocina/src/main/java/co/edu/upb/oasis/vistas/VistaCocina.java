package co.edu.upb.oasis.vistas;
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

public class VistaCocina {
    Stage window;
    //Escenas
    Scene principal,confirmarPedidos;
    //Paneles
    StackPane panelPrincipal;
    VBox panelListaPedidos;
    GridPane contenedorHornos;

    //Botones
    Button clientes;
    Button menu;
    Button pedido;
    Button domicilio;
    //LABELS
    Label textListaPedidos;

    //Arrays Horno
    Horno[] hornos = new Horno[4];
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
    //



    public Button buttonTEST;
    //Background
    BackgroundFill colorFondo = new BackgroundFill(colorSand,null,null);
    Background fondo = new Background(colorFondo);

    BackgroundFill colorFondoCocina = new BackgroundFill(colorBeige,null,null);
    Background fondoCocina = new Background(colorFondoCocina);
    public VistaCocina() {
        window = new Stage();
        initCocina();
    }

    private void initCocina(){

        //PANELES--------------------

        panelPrincipal = new StackPane();
        panelListaPedidos = new VBox();
        contenedorHornos = new GridPane();
        //ELEMENTOS----------------------
        textListaPedidos = new Label("Pedidos en cola: ");
        textListaPedidos.setFont(new Font(20));
        //Hornos-------------------------
        int ancho = 0;
        int largo = 0;
        for(int i=0;i<hornos.length;i++){
            hornos[i] = new Horno(40);
            if(i %2 == 0) {
                ancho=0;
                largo ++;
                contenedorHornos.add(hornos[i].getHorno(),ancho,largo);    //Añadir elementos al layout
                continue;    //Funcion continue para skipear el codigo y volver al for
            }
            ancho++;
            contenedorHornos.add(hornos[i].getHorno() ,ancho,largo);
        }
        //Propiedades de los paneles
        //Vbox
        panelListaPedidos.setSpacing(5);
        panelListaPedidos.setPrefWidth(100);

        //GridPane Propiedades
        contenedorHornos.setHgap(200);
        contenedorHornos.setVgap(200);

        //Rectangle para decorar

        rectangleToDecorate = new Rectangle(300,720);
        rectangleToDecorate.setFill(colorOrange);

        //Añadiendo elementos a los paneles
        panelListaPedidos.getChildren().add(textListaPedidos);
        //--------------
        contenedorHornos.getChildren().addAll();
        //Propiedades elemtnos
        textListaPedidos.setFont(new Font(20));
        buttonTEST = new Button("Click");

        panelPrincipal.getChildren().addAll(panelListaPedidos,contenedorHornos,rectangleToDecorate,buttonTEST);
        //
        panelPrincipal.setBackground(fondoCocina);
        //Panel Principal distribucion

        panelPrincipal.setAlignment(panelListaPedidos, Pos.CENTER_LEFT);
        panelPrincipal.setAlignment(rectangleToDecorate, Pos.CENTER_LEFT);
        panelPrincipal.setMargin(contenedorHornos, new Insets(0,0,0,600)); // establecer un margen (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        rectangleToDecorate.toBack();
        buttonTEST.toFront();
        //-------
        principal = new Scene(panelPrincipal,1080,720);

        window.setScene(principal);
        window.setTitle("Oasis");     //Estableciendo titulo
        window.show();
    }
}
