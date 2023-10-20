package co.edu.upb.oasis.clases;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Horno {
    ImageView horno;
    Image pictureHorno = new Image("file:src/main/java/co/edu/upb/oasis/images/Horno.jpg");
    public Horno(int size){
        horno = new ImageView(pictureHorno);
        horno.setFitWidth(size);
        horno.setFitHeight(size);
    }

    public ImageView getHorno(){
        return horno;
    }
    public void setHornoImage(Image hornoEncendido){
        //Aqui debe estar la nueva imagen de un horno con fuego
        horno.setImage(hornoEncendido);
    }
}
