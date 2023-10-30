package co.edu.upb.oasis.estructuras.grafo;

import java.util.Iterator;
import java.util.LinkedList;

import co.edu.upb.oasis.estructuras.node.NodeLinkedList;
import co.edu.upb.oasis.estructuras.node.NodoInterface;
import co.edu.upb.oasis.estructuras.stacks.StackArray;

public class Grafo {
    
    /*private LinkedList<LinkedList<Integer>> grafo;
    int numeroVertices;

    public Grafo(int numVertices) {
        this.numeroVertices = numVertices;
        grafo = new LinkedList<>();
        for (int i = 0; i < numVertices; i++) {

            LinkedList<Integer> ffe = new LinkedList();
            ffe.add(i + 1);
            grafo.add(ffe);
        }
    }

    public boolean addConexion(int vertice, int verticeConect) {

        Iterator iterador = grafo.iterator();
        NodeLinkedList<LinkedList> nodo = null;

        while (iterador.hasNext()) {

            nodo = (NodeLinkedList<LinkedList>) iterador.next();

            if ((int) nodo.getObject().get(verticeConect) == vertice) {

                nodo.getObject().add(verticeConect);

                return true;

            }

        }

        return false;
    }

    public <T> boolean removeConexion(int vertice, T verticeConect) {

        Iterator iterador = grafo.iterator();
        NodeLinkedList<LinkedList> nodo = null;

        while (iterador.hasNext()) {

            nodo = (NodeLinkedList<LinkedList>) iterador.next();
            if ((int) nodo.getObject().get(vertice) == vertice) {

                nodo.getObject().remove(verticeConect);
                return true;

            }

        }

        return false;
    }

    public LinkedList<Integer> recorrido(int inicial, int fin) {
        StackArray<Integer> colita = new StackArray<>();
        boolean[] visitados = new boolean[numeroVertices];
        LinkedList<Integer> record = new LinkedList<>();
        colita.push(inicial);
        while (!colita.isEmpty()) {
            visitados[inicial] = true;
            int valid = colita.pop();
            record.add(valid);
            if (valid == fin) {
                return record;
            }
            // System.out.println("vea");
            Iterator<LinkedList<Integer>> iter = grafo.iterator();
            LinkedList<Integer> indexgrafo = null;
            // System.out.println("vea2");
            while (iter.hasNext()) {
                // System.out.println("glls");
                indexgrafo = iter.next();
    
                Iterator<NodeLinkedList<Integer>> iterador = ((NodoInterface<LinkedList>) indexgrafo).getObject().iterator();
    
                if (indexgrafo.getObject().getHead().getObject() == valid) {
    
                    NodeLinkedList<Integer> indexlista = null;
    
                    while (iterador.hasNext()) {
                        // System.out.println("flag");
                        indexlista = iterador.next();
                        if (indexlista.getObject() == fin) {
                            record.add(indexlista.getObject());
                            return record;
                        }
                        colita.push(indexlista.getObject());
                    }
                }
    
            }
    
        }
    
        return record;
    }
    

    public void imprimir(LinkedList rec) {
        Iterator iterador = rec.iterator();
        NodeLinkedList bb = null;
        while (iterador.hasNext()) {
            bb = (NodeLinkedList) iterador.next();
            System.out.println(bb.getObject());
        }
    }*/
}
