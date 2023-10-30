package co.edu.upb.oasis.estructuras.lists;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

import co.edu.upb.oasis.estructuras.interfaces.LinkedList1Interface;
import co.edu.upb.oasis.estructuras.interfaces.NodeInterface;
import co.edu.upb.oasis.estructuras.node.DoubleListNode;

public class LinkedList1<T extends Serializable> implements LinkedList1Interface<T>, Serializable {
    private DoubleListNode<T> head;
    private DoubleListNode<T> tail;
    private int size;
    private DoubleListNode<T> inode;

    public LinkedList1(){
        size = 0;
    }

    @Override
    public boolean add(T object) {
        if (object != null){
            try{
                DoubleListNode<T> newNode = new DoubleListNode<>(object);
                return addNode(newNode);
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    public boolean addNode(DoubleListNode<T> newNode) {
        if (newNode != null){
            try{
                if (isEmpty()){
                    tail = head = newNode;
                }
                else{
                    newNode.setPrevious(tail);
                    tail.setNext(newNode);
                    tail = tail.getNext();
                }
                size++;
                return true;
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean add(NodeInterface<T> node, T object) {
        return add(node, new DoubleListNode<>(object));
    }

    @Override
    public boolean add(NodeInterface<T> node, NodeInterface<T> next){
        if ((node != null) && (next != null) && (!isEmpty())){
            Iterator<NodeInterface<T>> iterator = iterator();
            DoubleListNode<T> temporal;
            try{
                if (tail.isEquals(node.getObject())){
                    ((DoubleListNode<T>) next).setPrevious(tail);
                    tail.setNext((DoubleListNode<T>) next);
                    tail = tail.getNext();
                } else{
                    while (iterator.hasNext()){
                        temporal = (DoubleListNode<T>) iterator.next();
                        if (temporal.isEquals(node.getObject())){
                            ((DoubleListNode<T>) next).setNext(temporal.getNext());
                            ((DoubleListNode<T>) next).setPrevious(temporal);
                            temporal.setNext((DoubleListNode<T>) next);
                            ((DoubleListNode<T>) next).getNext().setPrevious((DoubleListNode<T>) next);
                        }
                    }
                }
                size++;
                return true;
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean add(T[] objects) {
        if (objects != null){
            try{
                for (T object : objects) {
                    add(object);
                }
                return true;
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean add(NodeInterface<T> node, T[] objects) {
        if ((objects != null) && (node != null) && (!isEmpty())){
            Iterator<NodeInterface<T>> iterator = iterator();
            DoubleListNode<T> temporal;
            try{
                //add last
                if (node.isEquals(tail.getObject())){
                    for (T object : objects) {
                        if (object != null) {
                            temporal = new DoubleListNode<>(object);
                            tail.setNext(temporal);
                            temporal.setPrevious(tail);
                            tail = tail.getNext();
                            size++;
                        }
                    }
                    return true;
                }
                while (iterator.hasNext()){
                    temporal = (DoubleListNode<T>) iterator.next();
                    if (temporal.isEquals(node.getObject())){
                        for (T object : objects) {
                            if (object != null){
                                DoubleListNode<T> newNode = new DoubleListNode<>(object);
                                newNode.setNext(temporal.getNext());
                                temporal.getNext().setPrevious(newNode);
                                temporal.setNext(newNode);
                                newNode.setPrevious(temporal);
                                temporal = newNode;
                                size++;
                            }
                        }
                        return true;
                    }
                }
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean addOnHead(T object) {
        if (object != null){
            try{
                DoubleListNode<T> newNode = new DoubleListNode<>(object);
                return addNodeOnHead(newNode);
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    public boolean addNodeOnHead(DoubleListNode<T> newNode) {
        if (newNode != null){
            try{
                if (isEmpty()){
                    tail = head = newNode;
                }
                else{
                    newNode.setNext(head);
                    head.setPrevious(newNode);
                    head = newNode;
                }
                size++;
                return true;
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean addOnHead(T[] objects) {
        if (objects != null){
            try{
                for (T object : objects) {
                    addOnHead(object);
                }
                return true;
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean clear() {
        head =null;
        size=0;
        return true;
    }

    @Override
    public LinkedList1<T> cloneList() {
        if (!isEmpty()){
            try{
                LinkedList1<T> clone = new LinkedList1<>();
                Iterator<NodeInterface<T>> iterator = iterator();
                while (iterator.hasNext()){
                    clone.add(iterator.next().getObject());
                }
                return clone;
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public boolean contains(T object) {
        if ((object != null) && (!isEmpty())){
            try{
                Iterator<NodeInterface<T>> iterator = iterator();
                while (iterator.hasNext()){
                    if (iterator.next().isEquals(object)){
                        return true;
                    }
                }
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean contains(T[] objects) {
        if ((objects != null) && (!isEmpty())){
            try{
                int contador = 1;
                for (T object : objects) {
                    if (contains(object)) {
                        contador++;
                    }
                }
                if (contador == objects.length){
                    return true;
                }
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public NodeInterface<T> nodeOf(T object) {
        if ((object != null) && (!isEmpty())){
            try{
                Iterator<NodeInterface<T>> iterator = iterator();
                while (iterator.hasNext()){
                    if (inode.isEquals(object)) {
                        return iterator.next();
                    }
                    iterator.next();
                }
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return (this.head == null);
    }

    @Override
    public T get(){
        if (isEmpty()){
            return null;
        }
        return head.getObject();
    }

    @Override
    public T[] get(int n) {
        if ((n != 0) && (!isEmpty())){
            try{
                if (n > this.size){
                    throw new NoSuchElementException("Tamaño de la lista menor a la cantidad deseada.");
                }
                Iterator<NodeInterface<T>> iterator = iterator();
                int contador = 0;
                T[] array = (T[]) new Object[n];
                for (int i=0; i<n; i++){
                    array[i] = iterator.next().getObject();
                }
                return array;
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public T getPrevious(NodeInterface<T> node) {
        if ((node != null) && (!isEmpty())){
            try{
                if (node.isEquals(head.getObject())){
                    return null;
                } else if (node.isEquals(tail.getObject())) {
                    return tail.getPrevious().getObject();
                }
                Iterator<NodeInterface<T>> iterator = iterator();
                DoubleListNode<T> temporal;
                while (iterator.hasNext()){
                    temporal = (DoubleListNode<T>) iterator.next();
                    if (temporal.isEquals(node.getObject())){
                        return temporal.getPrevious().getObject();
                    }
                }
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public T getFromEnd() {
        if (isEmpty()){
            return null;
        }
        return tail.getObject();
    }

    @Override
    public T[] getFromEnd(int n) {
        if ((n != 0) && (!isEmpty())){
            try{
                if (n > this.size){
                    throw new NoSuchElementException("Tamaño de la lista menor a la cantidad deseada.");
                }
                T[] array = (T[]) new Object[n];
                Iterator<NodeInterface<T>> iterator = iteratorReverse();
                for (int i=0; i<n; i++){
                    array[i] = iterator.next().getObject();

                }
                return array;
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public T pop() {
        if (!isEmpty()){
            try{
                T temporal = head.getObject();
                head = head.getNext();
                if (head != null){
                    head.setPrevious(null);
                }
                size--;
                return temporal;
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    public DoubleListNode<T> popNode() {
        if (!isEmpty()){
            try{
                DoubleListNode<T> temporal = head;
                head = head.getNext();
                if (head != null){
                    head.setPrevious(null);
                }
                this.size--;
                return temporal;
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public boolean remove(T object) {
        if (contains(object)){
            try{
                Iterator<NodeInterface<T>> iterator = iterator();
                DoubleListNode<T> temporal = (DoubleListNode<T>) iterator.next();
                if (head.isEquals(object)){
                    head = head.getNext();
                    if (head != null){
                        head.setPrevious(null);
                    }

                } else if (tail.isEquals(object)) {
                    tail = tail.getPrevious();
                    if (tail != null){
                        tail.setNext(null);
                    }

                } else{
                    while (iterator.hasNext()){
                        if (temporal.getNext().isEquals(object)){
                            temporal.setNext(temporal.getNext().getNext());
                            temporal.getNext().setPrevious(temporal);
                            size--;
                            return true;
                        }
                        temporal = (DoubleListNode<T>) iterator.next();
                    }
                }
                size--;
                return true;


            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean remove(NodeInterface<T> node) {
        if (contains(node.getObject())){
            try{
                return remove(node.getObject());
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(T[] objects) {
        if ((objects != null) && (!isEmpty())){
            try{
                for (T object : objects) {
                    remove(object);
                }
                return true;
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean retainAll(T[] objects) {
        if ((objects != null) && (!isEmpty())){
            try{
                Iterator<NodeInterface<T>> iterator = iterator();
                DoubleListNode<T> temporal;
                T[] safeObjects = (T[]) new Object[objects.length];
                int contador = 0;

                while (iterator.hasNext()){
                    temporal = (DoubleListNode<T>) iterator.next();
                    for (T object : objects) {
                        if (temporal.isEquals(object)) {
                            safeObjects[contador] = object;
                            contador++;
                        }
                    }
                }
                clear();
                add(safeObjects);
                return true;
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public LinkedList1<T> subList(NodeInterface<T> from, NodeInterface<T> to) {
        if ((validateSubList(from, to)) && (!isEmpty())){
            try{
                Iterator<NodeInterface<T>> iterator = iterator();
                LinkedList1<T> list = new LinkedList1<>();

                while (iterator.hasNext()){
                    if (inode.isEquals(from.getObject())){
                        list.add(iterator.next().getObject());
                        while (!inode.isEquals(to.getObject())){
                            list.add(iterator.next().getObject());
                        }
                        list.add(iterator.next().getObject());
                        return list;
                    }
                    iterator.next();
                }
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    public boolean removeSubList(T from, T to){
        if ((validateSubList(new DoubleListNode<>(from), new DoubleListNode<>(to))) && (!isEmpty())) {
            try {
                DoubleListNode<T> temporal = head;
                if ((head.isEquals(from)) && (tail.isEquals(to))){
                    clear();
                    return true;
                }
                if (head.isEquals(from)){
                    while (!temporal.isEquals(to)) {
                        temporal = temporal.getNext();
                        size--;
                    }
                    size--;
                    head = temporal.getNext();
                    return true;
                }
                DoubleListNode<T> fromNode;

                for (int i = 0; i < size(); i++) {
                    if (temporal.getNext().isEquals(from)) {
                        fromNode = temporal;
                        while (!temporal.isEquals(to)) {
                            temporal = temporal.getNext();
                            size--;
                        }
                        size--;
                        if (temporal.isEquals(tail.getObject())){
                            tail = fromNode;
                            return true;
                        }
                        fromNode.setNext(temporal.getNext());
                        return true;
                    }
                    temporal = temporal.getNext();
                }

                return true;
            }catch (Exception e){
                    System.err.println("Error: " + e.getMessage());
                }
        }
        return false;
    }

    private boolean validateSubList(NodeInterface<T> from, NodeInterface<T> to){
        if ((from != null) && (to != null)){
            Iterator<NodeInterface<T>> iterator = iterator();
            NodeInterface<T> temporal = iterator.next();
            while (iterator.hasNext()){
                if (temporal.isEquals(from.getObject())){
                    return true;
                } else if (temporal.isEquals(to.getObject())) {
                    return false;
                }
                temporal = iterator.next();
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        if (!isEmpty()){
            try{
                Iterator<NodeInterface<T>> iterator = iterator();
                T[] array = (T[]) new Object[this.size];
                int i= 0;
                while (iterator.hasNext()){
                    array[i] = iterator.next().getObject();
                    i++;
                }
                return array;
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    public boolean invertir(int k){
        if ((k > 0) && (k <= size())){
            if (k == 1){
                return true;
            }
            int numeroRepeticiones = (size()/k);
            if ((k > (size()/2)) && (k < size())){
                numeroRepeticiones++;
            }
            int contador, b = 0; //B -> iterador para segundo for acorde al tamaño del array
            DoubleListNode<T> temporal = null; //Temporal -> para moverse entre los nodos
            DoubleListNode<T> iterador = head;
            DoubleListNode<T> guardarHead = null;
            //Iterar para saber cual será la cabeza final y no perder el orden
            for (int i=0; i<k; i++){
                guardarHead = iterador;
                iterador = iterador.getNext();
            }
            //Reiniciar iterador
            iterador = head;

            //For acorde al numero de subGrupos que se van a invertir en la lista
            for (int i=0; i<numeroRepeticiones; i++){
                //Guardar la cabeza para usar getPrevious mas adelante
                head = iterador;
                //Iterar acorde al tamaño de 'k' para dividir los grupos que deben cambiar
                contador = 0;
                for (;(b<size()) && (contador < k); b++, contador++){
                    temporal = iterador;
                    iterador = iterador.getNext();
                }
                //For acorde a la cantidad de nodos que se tuvieron que recorrer en el anterior ciclo
                for (int c=0; c<contador; c++){
                    tail.setNext(temporal);
                    tail = tail.getNext();
                    temporal = temporal.getPrevious();
                }
            }
            tail.setNext(null);
            head = guardarHead;
            return true;
        }
        return false;
    }

    public boolean invertirK(int k){
        try {
            //Iterator iterator = iterator();
            DoubleListNode<T> temp1 = head;
            DoubleListNode<T> temp2;
            DoubleListNode<T> iterador = head;
            int numeroRepeticiones = size()/k;
            int contador = 0;

            DoubleListNode<T> saveHead = head;
            for (int i=0; i<k-1; i++){
                saveHead = saveHead.getNext();
            }

            for (int i=0; i<size(); i++){
                contador++;
                System.out.println(iterador);
                temp2 = iterador;
                iterador = iterador.getNext();

                if (contador == k){
                    DoubleListNode<T> auxiliar = temp1.getPrevious();
                    temp2.getPrevious().setNext(temp1);
                    if (auxiliar != null){
                        auxiliar.setNext(temp2);
                    }
                    auxiliar = temp1.getNext();
                    temp1.setNext(temp2.getNext());
                    temp2.setNext(auxiliar);

                    temp2 = iterador;
                    temp1 = temp2;
                    contador = 0;
                }
            }
            head = saveHead;
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
        return false;
    }

    public boolean invertirAll(){
        if (!isEmpty()){
            try{
                LinkedList1<T> newList = new LinkedList1<>();
                int contador = size();
                for (int i=0; i<contador; i++){
                    newList.addNodeOnHead(popNode());
                }
                head = newList.head;
                tail = newList.tail;
                tail.setNext(null);
                return true;
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean sortObjectsBySize() {
        if ((!isEmpty()) && (this.size>1)){
            try{
                T[] arraySorted = toArray();
                int salto = size/2, a, b;

                while (salto > 0){
                    for (int i=salto; i<size; i++){
                        a = i-salto;
                        while (a >= 0){
                            b = a+salto;
                            if (arraySorted[a].toString().length() > arraySorted[b].toString().length()){
                                T temporal = arraySorted[a];
                                arraySorted[a] = arraySorted[b];
                                arraySorted[b] = temporal;
                                a -= salto;
                            } else {
                                a = -1;
                            }
                        }
                    }
                    salto = salto/2;
                }
                clear();
                add(arraySorted);
                return true;
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    public void imprimir(){
        Iterator<NodeInterface<T>> iterator = iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next().getObject() + "  ");
        }
    }

    public void imprimir2(){
        Iterator<NodeInterface<T>> iterator = iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getObject());
        }
    }

    public void imprimirReverse(){
        DoubleListNode<T> temp = tail;
        for (int i=size(); i>0; i--){
            System.out.println(temp);
            temp = temp.getPrevious();
        }
    }

    public Iterator<NodeInterface<T>> iterator() {
        inode = head;
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return inode != null;
            }

            @Override
            public NodeInterface<T> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                NodeInterface<T> node = inode;
                inode = inode.getNext();
                return node;
            }
        };
    }

    public Iterator<NodeInterface<T>> iteratorReverse() {
        inode = tail;
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return inode != null;
            }

            @Override
            public NodeInterface<T> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                NodeInterface<T> node = inode;
                inode = inode.getPrevious();
                return node;
            }
        };
    }

    public String listToString(){
        if (!isEmpty()){
            try {
                String retornar = "";
                Iterator<NodeInterface<T>> iterator = iterator();
                while (iterator.hasNext()){
                    retornar += iterator.next().getObject() + "\n";
                }
                return retornar;
            }
            catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

}