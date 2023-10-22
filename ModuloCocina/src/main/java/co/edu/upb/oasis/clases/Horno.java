package co.edu.upb.oasis.clases;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Horno {
    ImageView horno;
    Image pictureHorno = new Image(
            "file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\hornos\\HornoRapido_Apagado.png");
    boolean isLento;
    boolean isOn;
    Producto producto;

    public Horno(int ancho, int alto) {
        horno = new ImageView(pictureHorno);
        horno.setFitWidth(ancho);
        horno.setFitHeight(alto);
    }

    public ImageView getHorno() {
        return horno;
    }

    public void setHornoImage(Image hornoEncendido) {
        // Aqui debe estar la nueva imagen de un horno con fuego
        horno.setImage(hornoEncendido);
    }

    public void turnOnRapido() {
        horno.setImage(new Image("file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\hornos\\HornoRapido_Encendido.png"));
        this.isOn = true;
    }

    public void turnOnLento() {
        horno.setImage(new Image("file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\hornos\\HornoLento_Encendido.png"));
        this.isOn = true;

    }

    public boolean setIsLento() {
        horno.setImage(new Image("file:src\\main\\java\\co\\edu\\upb\\oasis\\images\\hornos\\HornoLento_Apagado.png"));
        return this.isLento = true;
    }

    public void resetHorno() {
        this.isOn = false;

        if (isLento()) {
            setIsLento();
        } else {
            horno.setImage(pictureHorno);
        }
    }

    public boolean isLento() {
        return isLento;
    }

    public boolean isOn() {
        return isOn;
    }

    public Producto getProductoCooked(){
        return producto;
    }

    public void setProductoCook(Producto producto){
        this.producto = producto;
    }
}
