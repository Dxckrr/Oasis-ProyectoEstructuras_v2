package co.edu.upb.oasis.clases1;


public class DibGraficas {

    public DibGraficas() {}

    public static void pinta_Circulo(/*Graphics g,*/ int x, int y, String n) {
        //g.setColor(Color.ORANGE);
        //((Graphics2D) g).setStroke(new BasicStroke(2));// le da el grosor al círculo
        //g.fillOval(x, y, 15, 15);
        //g.setColor(Color.BLACK);
       // g.drawOval(x, y, 15, 15);

        //g.setColor(Color.BLUE);
        //Font fuente = new Font("Monospaced", Font.BOLD, 16);
        //g.setFont(fuente);
        //g.drawString(n, x, y);
    }

    public static void pinta_Linea(/*Graphics g,*/ int x1, int y1, int x2, int y2, double tam) {
        int xAux = 0;
        int yAux = 0;
        //((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //BasicStroke stroke = new BasicStroke(1);
        //((Graphics2D) g).setStroke(stroke);
        //g.drawLine(x1 + 10, y1 + 10, x2 + 10, y2 + 10);
        if (x1 <= x2) {
            xAux = ((x2 - x1) / 2) + x1;
        }
        if (x1 > x2) {
            xAux = ((x1 - x2) / 2) + x2;
        }
        if (y1 < y2) {
            yAux = ((y2 - y1) / 2) + y1;
        }
        if (y1 >= y2) {
            yAux = ((y1 - y2) / 2) + y2;
        }
        //g.setColor(Color.BLUE);// PINTANDO TEXTO DE VÉRTICES(TAMAÑO)
        //Font fuente = new Font("Monospaced", Font.PLAIN, 12);
        //g.setFont(fuente);
        //g.drawString(String.valueOf(tam), xAux, yAux);
    }

    /*public static void pinta_Camino(/*Graphics g,*/ //int x1, int y1, int x2, int y2, /*Color color*/) {
        //((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //BasicStroke stroke = new BasicStroke(3);
        //((Graphics2D) g).setStroke(stroke);
        //g.setColor(color);*/
        //g.drawLine(x1 + 10, y1 + 10, x2 + 10, y2 + 10);
    //}

    // Pintando nodos que son recorridos
    /*public static void seleccionNodo(/*Graphics g*/ //int x, int y/*String n, /*Color co*/) {
        //g.setColor(co);
        //((Graphics2D) g).setStroke(new BasicStroke(2));// le da el grosor del contorno al círculo
        //g.fillOval(x, y, 15, 15);// tamaño del círculo
        //g.setColor(Color.BLUE);
        //g.drawOval(x, y, 15, 15);*/
    //}
}


