package co.edu.upb.oasis.estructuras.lists;

import co.edu.upb.oasis.estructuras.interfaces.LinkedListInterface;
import co.edu.upb.oasis.estructuras.interfaces.NodeInterface;
import co.edu.upb.oasis.estructuras.node.SingleListNode;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedList<T extends Serializable> implements LinkedListInterface<T> {
    private SingleListNode<T> head;
    private SingleListNode<T> tail;
    private int size;
    private SingleListNode<T> inode;

    public LinkedList() {
        size = 0;
    }

    @Override
    public boolean add(T object) {  //Añade por la cola SKSKKSKS
        if (object != null) {
            try {
                if (isEmpty()) {                                      //LAS ASIGNACIONES SE LEEN DE DERECHA A IZQUIERDA
                    tail = head = new SingleListNode<>(object);    //Cola = Cabeza tiene una referencia a este objeto //Head apunta a SingleListNode
                } else {
                    tail.setNext(new SingleListNode<>(object));
                    tail = tail.getNext();
                }
                size++;
                return true;
            } catch (Exception e) {
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }

        return false;
    }

    @Override
    public boolean add(NodeInterface<T> node, T object) {   //Nodo es para vincular next | object es para crear el nodo
        // Adds an object into the next position of the specified node.
        Iterator<NodeInterface<T>> iterator = iterator();
        SingleListNode<T> temporal;

        if (object != null) {
            try {
                if (isEmpty()) {
                    tail = head = new SingleListNode<>(object);
                }
                if (tail.isEquals(node.getObject())) {
                    tail.setNext(new SingleListNode<>(object));
                    tail = tail.getNext();
                } else {
                    while (iterator.hasNext()) {
                        temporal = (SingleListNode<T>) iterator.next();

                        if (temporal.isEquals(node.getObject())) {

                            SingleListNode<T> nodeToAdd = new SingleListNode<>(object);

                            nodeToAdd.setNext(temporal.getNext());    //El nodo a añadir señala al siguiente al temporal

                            temporal.setNext(nodeToAdd);  //El temporal va a apuntar al nodo nuevo
                        }

                    }

                }
                size++;
                return true;
            } catch (Exception e) {
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }

        }
        return false;
    }

    @Override
    public boolean add(NodeInterface<T> node, NodeInterface<T> next) {   //Añadir nodo en un node ya especifico
        //Adds a node at the next position of the specified node.
        Iterator<NodeInterface<T>> iterator = iterator();
        if (node != null && next != null) {
            if (next.isEquals(tail.getObject())) {
                tail.setNext((SingleListNode<T>) next);
                tail = tail.getNext();
            }
            try {
                while (iterator.hasNext()) {
                    SingleListNode<T> temporal = (SingleListNode<T>) iterator.next();
                    if (temporal.isEquals(node.getObject())) {

                        SingleListNode<T> nodeToAdd = (SingleListNode<T>) next;

                        nodeToAdd.setNext(temporal.getNext());    //El nodo a añadir señala al siguiente al temporal

                        temporal.setNext(nodeToAdd);  //El temporal va a apuntar al nodo nuevo

                    }
                }
                size++;
                return true;
            } catch (Exception e) {
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }

        return false;
    }

    @Override
    public boolean add(T[] objects) {
        //Adds all the objects in an array to the end  of the list.
        if (objects != null) {
            try {
                for (T object : objects) {
                    add(object);
                }
                return true;
            } catch (Exception e) {
               // Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return false;
    }

    @Override
    public boolean add(NodeInterface<T> node, T[] objects) {
        //Adds all the objects from an array starting at the specified node.
        if (objects != null && contains(node.getObject())) {
            try {
                if (isEmpty()) {
                    for (int i = 0; i < objects.length; i++) {
                        if (head == null) {
                            tail = head = new SingleListNode<>(objects[i]);
                        } else {
                            tail.setNext(new SingleListNode<>(objects[i]));
                            tail = tail.getNext();
                        }
                        size++;
                    }
                } else {
                    Iterator<NodeInterface<T>> iterator = iterator();
                    SingleListNode<T> temporal;
                    while (iterator.hasNext()) {
                        temporal = (SingleListNode<T>) iterator.next();
                        if (temporal.isEquals(node.getObject())) {
                            for (T object : objects) {
                                if (object != null) {
                                    SingleListNode<T> nodeToAdd = new SingleListNode<>(object);
                                    nodeToAdd.setNext(temporal.getNext());
                                    temporal.setNext(nodeToAdd);
                                    temporal = nodeToAdd;
                                    size++;
                                }
                            }
                        }
                    }
                }
                return true;
            } catch (Exception e) {
               // Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return false;
    }

    @Override
    public boolean addOnHead(T object) {

        if (object != null) {
            try {
                if (isEmpty()) {
                    tail = head = new SingleListNode<>(object);
                } else {
                    SingleListNode<T> nodeToAdd = new SingleListNode<>(object);
                    nodeToAdd.setNext(head);
                    head = nodeToAdd;
                }
                size++;
                return true;
            } catch (Exception e) {
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }

        }
        return false;
    }

    @Override
    public boolean addOnHead(T[] objects) {
        if (objects != null) {
            try {
                for (T object : objects) {
                    addOnHead(object);
                }
                return true;
            } catch (Exception e) {
               // Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return false;
    }

    @Override
    public boolean clear() {
        head = null;
        tail = null;
        //clear();
        size = 0;
        return true;
    }

    @Override
    public LinkedListInterface<T> cloneList() {
        Iterator<NodeInterface<T>> iterator = iteratorObjects();
        LinkedList<T> linkedListClone = new LinkedList<>();
        while (iterator.hasNext()) {
            linkedListClone.add((T) iterator.next());
        }
        return linkedListClone;
    }

    @Override
    public boolean contains(T object) {
        Iterator<NodeInterface<T>> iterator = iterator();
        while (iterator.hasNext()) {
            if (((SingleListNode<T>) iterator.next()).isEquals(object)) {
                return true;

            }

        }
        return false;
    }

    @Override
    public boolean contains(T[] objects) {
        for (T object : objects) {
            if (contains(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public NodeInterface<T> nodeOf(T object) {
        SingleListNode<T> temporal = null;
        if (object != null) {
            try {
                Iterator<NodeInterface<T>> iterator = iterator();
                while (iterator.hasNext()) {
                    temporal = (SingleListNode<T>) iterator.next();
                    if (temporal.getObject().equals(object)) {
                        break;
                    }
                }

            } catch (Exception e) {
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
            return temporal;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public T get() {
        return head.getObject();
    }

    @Override
    public T[] get(int n) {
        if ((!isEmpty()) && (n != 0) && (n < size)) {
            try {
                T[] array = (T[]) new Object[n];
                array[0] = head.getObject(); //Comenzar el array en la cola
                SingleListNode<T> temporalNode = head;
                for (int i = 1; i < n; i++) {
                    array[i] = temporalNode.getNext().getObject();
                    temporalNode = temporalNode.getNext();
                }
                return array;
            } catch (Exception e) {
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return null;
    }

    @Override
    public T getPrevious(NodeInterface<T> node) {
        if (!isEmpty()) {
            try {
                Iterator<NodeInterface<T>> iterator = iterator();
                SingleListNode<T> nodoActual = null;
                SingleListNode<T> nodoAnterior = null;
                while (iterator.hasNext()) {
                    nodoAnterior = nodoActual;  //NodeActual = head     | NodeAnterior = null , porque anterior es cabeza
                    nodoActual = (SingleListNode<T>) iterator.next();  //Head
                    if (nodoActual.isEquals(node.getObject())) {
                        break;
                    }

                }
                Object objetoToReturn;
                try {
                    objetoToReturn = nodoAnterior.getObject();
                } catch (Exception e) {
                    objetoToReturn = null;
                }
                ;
                return (T) objetoToReturn; //Objeto;
            } catch (Exception e) {
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return null;
    }

    @Override
    public T getFromEnd() {
        try {
            if (isEmpty()) {
                return null;
            }
        } catch (Exception e) {
            //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return tail.getObject();
    }

    @Override
    public T[] getFromEnd(int n) {
        if ((!isEmpty()) && (n != 0) && (n < size)) {
            try {
                T[] array = (T[]) new Object[n];
                array[0] = tail.getObject(); //Comenzar el array en la cola
                SingleListNode<T> temporalNode = tail;
                for (int i = 1; i < n; i++) {
                    array[i] = getPrevious(temporalNode);
                    temporalNode = new SingleListNode<>(getPrevious(temporalNode));
                }
                return array;
            } catch (Exception e) {
               // Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return null;
    }

    @Override
    public T pop() {
        Object objectHead = head.getObject();
        //remove(head.getObject());
        head = head.getNext();
        size--;
        return (T) objectHead;
    }

    @Override
    public boolean remove(T object) {   //ack ackwnoledge
        boolean ack = false;
        if (object != null) {
            try {
                if (isEmpty()) {
                    ack = false;
                } else {
                    if (object.equals(head.getObject())) {
                        head = head.getNext();  //JAVA TRASH PICKER PIPIPIPIP
                        size--;
                        ack = true;
                    } else {
                        if (object.equals(tail.getObject())) {
                            T nodoTail = getPrevious(new SingleListNode<>(object));
                            tail = ((SingleListNode<T>) nodeOf(nodoTail));
                            tail.setNext(null);
                            size--;
                            ack = true;
                        } else {
                            if (contains(object)) {   //this ES LA MISMA CLASE EN LA QUE ESTOY
                                Iterator<NodeInterface<T>> iterator = iterator();
                                SingleListNode<T> nodeToRemove = null;
                                while (iterator.hasNext()) {
                                    nodeToRemove = (SingleListNode<T>) iterator.next();
                                    if (nodeToRemove.isEquals(object)) {
                                        T objectPrevious = getPrevious(nodeToRemove);
                                        ((SingleListNode<T>) nodeOf(objectPrevious)).setNext(nodeToRemove.getNext());   //El previo se vincula al siguiente siguiente
                                        size--;
                                        break;
                                    }
                                }
                                ack = true;
                            } else {
                                ack = false;
                            }
                        }
                    }
                }
            } catch (Exception e) {
               // Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }

        return ack;
    }

    @Override
    public boolean remove(NodeInterface<T> node) {
        if (!isEmpty() && node != null) {
            try {
                remove(node.getObject());
                return true;
            } catch (Exception e) {
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(T[] objects) {
        //Remueve los nodos con los objetos del array
        if (!isEmpty() && objects != null) {
            try {
                for (T object : objects) {
                    remove(object);
                }
                return true;
            } catch (Exception e) {
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return false;
    }

    @Override
    public boolean retainAll(T[] objects) {
        if (!isEmpty() && objects != null) {
            try {
                //objects = validateObjectsToRetain(objects);
                for (int i = 0; i < objects.length; i++) {
                    if (!contains(objects[i])) {
                        objects[i] = null;
                    }
                }
                clear();
                add(objects);
                return true;

            } catch (Exception e) {
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return false;
    }
    /*private T[] validateObjectsToRetain(T[] objects){
        if(!contains(objects)){
            try{
                LinkedList<T> temporalList = new LinkedList<>();
                for(T object : objects){
                    if(contains(object)){
                        temporalList.add(object);
                    }
                }
                return temporalList.toArray();
            }catch(Exception e){
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return objects;
    }*/

    @Override
    public int size() {
        return size;
    }

    @Override
    public LinkedListInterface<T> subList(NodeInterface<T> from, NodeInterface<T> to) {
        if ((validateNodes(from, to)) && (!isEmpty())) {
            try {
                Iterator<NodeInterface<T>> iterator = iterator();
                LinkedList<T> linkedListToReturn = new LinkedList<T>();
                while (iterator.hasNext()) {
                    if ((inode.isEquals(from.getObject()))) {  //inode es la posicion siguiente del iterador sin CAMBIAR
                        linkedListToReturn.add(iterator.next().getObject());
                        while (!inode.isEquals(to.getObject())) {
                            linkedListToReturn.add(iterator.next().getObject());
                        }
                        linkedListToReturn.add(iterator.next().getObject());  //Añadir el "to"
                        return linkedListToReturn;
                    }
                    iterator.next();
                }

            } catch (Exception e) {
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return null;
    }

    private boolean validateNodes(NodeInterface<T> from, NodeInterface<T> to) {
        boolean ack = false;
        if ((!isEmpty()) && (from != null) && (to != null)) {
            Iterator<NodeInterface<T>> iterator = iterator();
            NodeInterface<T> nodeTemp = iterator.next();
            while (iterator.hasNext()) {
                if (nodeTemp.isEquals(from.getObject())) {
                    ack = true;
                    break;
                } else if (nodeTemp.isEquals(to.getObject())) {
                    ack = false;
                    break;
                }
                nodeTemp = iterator.next();

            }
        }

        return ack;
    }

    @Override
    public T[] toArray() {
        SingleListNode<T> nodo = head;
        T[] array = (T[]) new Object[size];
        Iterator<NodeInterface<T>> iterator = iterator();
        int i = 0;
        while (iterator.hasNext()) {
            nodo = (SingleListNode<T>) iterator.next();
            array[i] = (T) nodo.getObject();
            i++;
        }
        return array;
    }

    @Override
    public boolean sortObjectsBySize() {
        if (!isEmpty() && size >= 2) {
            try {
                T[] arrayDeLista = toArray();
                int salto = size / 2;
                int a, b;
                while (salto > 0) {
                    for (int i = salto; i < size; i++) {
                        a = i - salto;
                        while (a >= 0) {
                            b = a + salto;
                            if (arrayDeLista[a].toString().length() > arrayDeLista[b].toString().length()) {
                                T temporal = arrayDeLista[a];
                                arrayDeLista[a] = arrayDeLista[b];
                                arrayDeLista[b] = temporal;
                                a -= salto;
                            } else {
                                a = -1;
                            }
                        }
                    }
                    salto = salto / 2;
                }
                clear();
                add(arrayDeLista);
                return true;

            } catch (Exception e) {
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return false;
    }

    public boolean sortObjectsByK(int k) {
        try {
            if ((k != 0) || (k <= size()) && (!isEmpty())) {
                SingleListNode<T> temporalNode = head;
                SingleListNode<T> nodeToSwap = temporalNode;
                SingleListNode<T> previousNode;
                SingleListNode<T> nodeNext;
                SingleListNode<T> nodeNextOfTemporal;
                SingleListNode<T>previousNodeOfTemp;
                bigloop:
                for (int i = 0; i < (size() / k); i++) {
                    outer:
                    if (k == 2) {
                        if ((temporalNode.getNext()) != null) {
                            if(temporalNode.getNext() == tail){
                                tail = temporalNode;
                            }
                            if (temporalNode == head) {
                                head = temporalNode.getNext();
                                temporalNode.setNext(head.getNext());
                                head.setNext(temporalNode);
                                temporalNode = temporalNode.getNext();  //El nodo acutal ahora es el siguiente, puesto que ya se cambio con el anterior
                                break outer;
                            } else {
                                nodeNext = temporalNode.getNext();  //Nodo siguiente = temporal.siguiente
                                temporalNode.setNext(nodeNext.getNext());
                                previousNode = (SingleListNode<T>) nodeOf(getPrevious(temporalNode));
                                previousNode.setNext(nodeNext);
                                nodeNext.setNext(temporalNode);
                                temporalNode = temporalNode.getNext();
                            }
                        }
                    } else { //SI K != 2
                        //System.out.println(nodeToSwap);

                        if (temporalNode == head) {
                            for (int j = 0; j < (k-1); j++) {
                                nodeToSwap = nodeToSwap.getNext();
                                if (nodeToSwap == null) {
                                    break bigloop;
                                }
                                if(nodeToSwap == tail){
                                    tail = temporalNode;
                                }
                                //System.out.println(nodeToSwap);
                            }
                            nodeNextOfTemporal = head.getNext();
                            previousNode = (SingleListNode<T>) nodeOf(getPrevious(nodeToSwap));
                            previousNode.setNext(temporalNode);
                            temporalNode.setNext(nodeToSwap.getNext());
                            nodeToSwap.setNext(nodeNextOfTemporal);
                            head = nodeToSwap;
                            temporalNode = temporalNode.getNext();
                        }else{
                            nodeToSwap = temporalNode;
                            for(int z=0;z< (k-1);z++){
                                nodeToSwap = nodeToSwap.getNext();
                                if (nodeToSwap == null) {
                                    break bigloop;
                                }
                                if(nodeToSwap == tail){
                                    tail = temporalNode;    //SI EL NODO QUE VAMOS A CAMBIAR (K POSICIONES) ES IGUAL A LA COLA
                                }                           //ENTONCES EL TEMPORAL (EL QUE VA A CAMBIAR, AHORA VA A SER LA COLA)
                            }
                            nodeNextOfTemporal = temporalNode.getNext();
                            previousNode = (SingleListNode<T>) nodeOf(getPrevious(nodeToSwap));
                            previousNodeOfTemp = (SingleListNode<T>) nodeOf(getPrevious(temporalNode));
                            previousNode.setNext(temporalNode);
                            temporalNode.setNext(nodeToSwap.getNext());
                            nodeToSwap.setNext(nodeNextOfTemporal);
                            previousNodeOfTemp.setNext(nodeToSwap);
                            temporalNode = temporalNode.getNext();
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("--");
           //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }


    /*public LinkedList<T> invertirAll(LinkedList<T> list){
        LinkedList<T> newList = new LinkedList<>();
        int contador = list.size();
        for (int i=0; i<contador; i++){
            newList.addOnHead(list.pop());
        }
        return newList;
    }*/
    public LinkedList<T> reverseAll(LinkedList<T> list) {
        LinkedList<T> newList = new LinkedList<>();
        int contador = list.size();
        for (int i = 0; i < contador; i++) {
            newList.addOnHead(list.pop());
        }
        return newList;
    }

    public Iterator<NodeInterface<T>> iterator() {
        inode = head;
        return new Iterator<NodeInterface<T>>() {
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

    public Iterator<NodeInterface<T>> iteratorObjects() { //Devuelve el objeto
        inode = head;
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return inode != null;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                NodeInterface<T> node = inode;
                inode = inode.getNext();
                return node.getObject();
            }
        };
    }

}


