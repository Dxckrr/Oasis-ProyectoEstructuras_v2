package co.edu.upb.oasis.clases1;
import java.util.Arrays;
import javafx.scene.paint.Color;
/**
 * Class that gives the best route
 * @author
 */
public class AlgoritmoDijkstra {

    private final DatosGraficos arboles;
    private int subTope;
    private Nodo Nodoauxiliar = null;
    private double auxiliarAumulado; // es un acumulado auxiliar
    private double subtotalAcomulado;
    private final Nodo nodo[];
    private final int tope;
    private int Origen;
    private final int nodoFinal;

    public AlgoritmoDijkstra(DatosGraficos arboles, int tope, int permanente, int nodoFin) {
        this.arboles = arboles;
        this.tope = tope;
        this.nodo = new Nodo[tope];
        this.Origen = permanente;
        this.nodoFinal = nodoFin;

    }

    public double getAcumulado() {
        return nodo[nodoFinal].getAcumulado();
    }

    public int getNombre() {
        return nodo[nodoFinal].getNombre();
    }
    /**
     * 
     */
    public void dijkstra() {
        for (int i = 0; i < tope; i++) // creacion del vector nodo del tamaño del numero de nodos pintados 
        {
            nodo[i] = new Nodo();
        }
            //jPanel1.paint(jPanel1.getGraphics());
            //PintarFiguras(tope, arboles);
            //DibGraficas.seleccionNodo(jPanel1.getGraphics(), 
                   // arboles.getCordeX(Origen), 
                    //arboles.getCordeY(Origen), null, Color.GREEN); // pinta de color el nodo de Origen

            nodo[Origen].setVisitado(true);
            nodo[Origen].setNombre(Origen);

            do {
                subtotalAcomulado = 0;
                auxiliarAumulado = 2000000000; // lo igualamos a esta cifra ya q el acomulado de los nodos, a la que nunca sera mayor 
                nodo[Origen].setEtiqueta(true);
                for (int j = 0; j < tope; j++) {
                    if (arboles.getmAdyacencia(j, Origen) == 1) {
                        subtotalAcomulado = nodo[Origen].getAcumulado() + arboles.getmCoeficiente(j, Origen);
                        
                        if (subtotalAcomulado <= nodo[j].getAcumulado() && nodo[j].isVisitado() == true && nodo[j].isEtiqueta() == false) {
                            nodo[j].setAcumulado(subtotalAcomulado);
                            nodo[j].setVisitado(true);
                            nodo[j].setNombre(j);
                            nodo[j].setPredecesor(nodo[Origen]);
                        } else if (nodo[j].isVisitado() == false) {
                            nodo[j].setAcumulado(subtotalAcomulado);
                            nodo[j].setVisitado(true);
                            nodo[j].setNombre(j);
                            nodo[j].setPredecesor(nodo[Origen]);
                        }
                    }
                }
                
                //Encontrando Camino mas corto
                for (int i = 0; i < tope; i++) { // buscamos cual de los nodos visitado tiene el acomulado menor par escogerlo como camino
                    if (nodo[i].isVisitado() == true && nodo[i].isEtiqueta() == false) {
                        if (nodo[i].getAcumulado() <= auxiliarAumulado) {
                            Origen = nodo[i].getNombre();
                            auxiliarAumulado = nodo[i].getAcumulado();
                        }
                    }
                }
                subTope++;
            } while (subTope < tope + 1);

            Nodoauxiliar = nodo[nodoFinal];
            
            //Pintando caminos recorridos
            while (Nodoauxiliar.getPredecesor() != null) {
                //DibGraficas.pinta_Camino(jPanel1.getGraphics(), 
                        
                //arboles.getCordeX(Nodoauxiliar.getNombre()),
                        //arboles.getCordeY(Nodoauxiliar.getNombre()),
                       // arboles.getCordeX(Nodoauxiliar.getPredecesor().getNombre()), 
                        //arboles.getCordeY(Nodoauxiliar.getPredecesor().getNombre()), Color.BLUE);
                
                //DibGraficas.seleccionNodo(jPanel1.getGraphics(), 
                       // arboles.getCordeX(Nodoauxiliar.getNombre()), 
                      //  arboles.getCordeY(Nodoauxiliar.getNombre()), null, Color.BLUE);
                Nodoauxiliar = Nodoauxiliar.getPredecesor();
            }//fin de while Recorriendo caminos
            
            //DibGraficas.seleccionNodo(jPanel1.getGraphics(), 
                   // arboles.getCordeX(nodoFinal), 
                    //arboles.getCordeY(nodoFinal), null, Color.RED);//Pintando Nodo del destino
        
    }

class DijkstraAlgorithm {

    private static final int V = 18;
    private static final String[] places = {"Cabecera del Llano", "San Alonso", "La Ciudadela", "Lagos del Cacique",
            "San Francisco", "La Joya", "Cañaveral", "Ciudad Valencia", "Girardot", "El Bosque",
            "Los Cambulos", "Junin", "Ciudadela Comfenalco", "La Salle", "Centro", "La Feria"};

    int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    void printSolution(int dist[]) {
        System.out.println("Vertex \t\t Distance from Cambulo");
        for (int i = 0; i < V; i++)
            System.out.println(places[i] + " \t\t " + dist[i] + " meters");
    }

    void dijkstra(int graph[][], int src) {
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);

            sptSet[u] = true;

            for (int v = 0; v < V; v++)

                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        printSolution(dist);
    }
        int graph[][] = new int[][] {
            {0, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {500, 0, 300, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 300, 0, 250, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 250, 0, 200, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 200, 0, 150, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 150, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 100, 0, 120, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 120, 0, 80, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 80, 0, 60, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 60, 0, 40, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 40, 0, 30, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 20, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 15, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, 10, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 5, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 3, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0}
        };
}
}
