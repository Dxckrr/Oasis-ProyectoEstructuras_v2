package co.edu.upb.oasis.ventanita;

import co.edu.upb.oasis.clases1.DatosGraficos;
import co.edu.upb.oasis.clases1.DibGraficas;

public class MostrarDibujos {
    private int tope=0;// lleva el # de nodos creado 
    private int nodoFin;
    private int permanente;
    int n=0,nn=0,id,id2;// permite controlar que se halla dado click sobre un nodo
    private int aristaMayor;
    DatosGraficos arboles = new DatosGraficos();
    
    public static void R_repaint(int tope, DatosGraficos arboles){//pinta lo q esta antes en el panel 
        for (int j = 0; j < tope; j++) {
            for (int k = 0; k < tope; k++) {
                if(arboles.getmAdyacencia(j, k) == 1){
                     //DibGraficas.pinta_Linea(jPanel1.getGraphics(),arboles.getCordeX(j),arboles.getCordeY(j), arboles.getCordeX(k), arboles.getCordeY(k),arboles.getmCoeficiente(j, k));
                                 }
        }}
        for (int j = 0; j < tope; j++) {
            //DibGraficas.pinta_Circulo(jPanel1.getGraphics(), arboles.getCordeX(j),arboles.getCordeY(j),String.valueOf(arboles.getNombre(j)));             
   }}
}
