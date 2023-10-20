package co.edu.upb.oasis.estructuras.lists;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

import co.edu.upb.oasis.estructuras.interfaces.DoubleLinkedListInterface;
import co.edu.upb.oasis.estructuras.interfaces.NodeInterface;
import co.edu.upb.oasis.estructuras.node.DoubleListNode;


public class DoubleLinkedCircularList<T extends Serializable> implements DoubleLinkedListInterface<T> {
    private DoubleListNode<T> head; 
    private DoubleListNode<T> tail;
    private int size;
    private DoubleListNode<T> inode;

    public DoubleLinkedCircularList() {
        size = 0;
        head=tail=null;
    }

    @Override
    public boolean add(T object) {  //Añade por la cola SKSKKSKS
        if (object != null) {
            try {
                if (isEmpty()) {                                      //LAS ASIGNACIONES SE LEEN DE DERECHA A IZQUIERDA
                    tail = head = new DoubleListNode<T>(object);

                } else {
                    tail.setNext(new DoubleListNode<>(object));
                    tail.getNext().setPrevious(tail);
                    tail = tail.getNext();
                    tail.setNext(head);
                    head.setPrevious(tail);
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
        DoubleListNode<T> temporal;

        if (object != null) {
            try {
                if (isEmpty()) {
                    tail = head = new DoubleListNode<>(object);
                }
                if (tail.isEquals(node.getObject())) {
                    tail.setNext(new DoubleListNode<>(object));
                    tail.getNext().setPrevious(tail);
                    tail = tail.getNext();
                    tail.setNext(head);
                    head.setPrevious(tail);
                } else {
                    while (iterator.hasNext()) {
                        temporal = (DoubleListNode<T>) iterator.next();

                        if (temporal.isEquals(node.getObject())) {

                            DoubleListNode<T> nodeToAdd = new DoubleListNode<>(object);

                            nodeToAdd.setNext(temporal.getNext());    //El nodo a añadir señala al siguiente al temporal
                            nodeToAdd.getNext().setPrevious(nodeToAdd);
                            temporal.setNext(nodeToAdd);  //El temporal va a apuntar al nodo nuevo
                            nodeToAdd.setPrevious(temporal);
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
        //.................
        //Adds a node at the next position of the specified node.
        Iterator<NodeInterface<T>> iterator = iterator();
        try{
            if (node != null && next != null) {
                add(node,next.getObject());
            }
            return true;
        }catch (Exception e){
            //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
            /*if (next.isEquals(tail.getObject())) {
                tail.setNext((DoubleListNode<T>) next);
                tail.getNext().setPrevious(tail);
                tail = tail.getNext();
            }
            try {
                while (iterator.hasNext()) {
                    DoubleListNode<T> temporal = (DoubleListNode<T>) iterator.next();
                    if (temporal.isEquals(node.getObject())) {

                        DoubleListNode<T> nodeToAdd = (DoubleListNode<T>) next;

                        nodeToAdd.setNext(temporal.getNext());    //El nodo a añadir señala al siguiente al temporal
                        nodeToAdd.getNext().setPrevious(nodeToAdd);
                        temporal.setNext(nodeToAdd);  //El temporal va a apuntar al nodo nuevo
                        nodeToAdd.setPrevious(temporal);
                    }
                }
                size++;
                return true;
            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }*/

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
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
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
                    add(objects);
                } else {
                    Iterator<NodeInterface<T>> iterator = iterator();
                    DoubleListNode<T> temporal;
                    while (iterator.hasNext()) {
                        temporal = (DoubleListNode<T>) iterator.next();
                        if (temporal.isEquals(node.getObject())) {
                            for (T object : objects) {
                                if (object != null) {
                                    DoubleListNode<T> nodeToAdd = new DoubleListNode<>(object);
                                    nodeToAdd.setNext(temporal.getNext());
                                    nodeToAdd.getNext().setPrevious(temporal);
                                    temporal.setNext(nodeToAdd);
                                    nodeToAdd.setPrevious(temporal);
                                    temporal = nodeToAdd;
                                    size++;
                                }
                            }
                        }
                    }
                }
                return true;
            } catch (Exception e) {
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return false;
    }

    @Override
    public boolean addOnHead(T object) {

        if (object != null) {
            try {
                if (isEmpty()) {
                    tail = head = new DoubleListNode<>(object);
                } else {
                    DoubleListNode<T> nodeToAdd = new DoubleListNode<>(object);
                    nodeToAdd.setNext(head);
                    head.setPrevious(nodeToAdd);
                    head = nodeToAdd;
                    tail.setNext(head);
                    head.setPrevious(tail);
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
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
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
    public DoubleLinkedCircularList<T> cloneList() {
        Iterator<NodeInterface<T>> iterator = iterator();
        DoubleLinkedCircularList<T> linkedListClone = new DoubleLinkedCircularList<>();
        while (iterator.hasNext()) {
            linkedListClone.add((iterator.next().getObject()));
        }
        return linkedListClone;
    }

    @Override
    public boolean contains(T object) {
        Iterator<NodeInterface<T>> iterator = iterator();
        while (iterator.hasNext()) {
            if (((DoubleListNode<T>) iterator.next()).isEquals(object)) {
                return true;

            }

        }
        return false;
    }

    @Override
    public boolean contains(T[] objects) {
        int contador =0;
        for (T object : objects) {
            if (contains(object)) {
                contador++;
            }
            if(contador ==objects.length){
                return true;
            }
        }
        return false;
    }

    @Override
    public NodeInterface<T> nodeOf(T object) {
        DoubleListNode<T> temporal = null;
        if (object != null && contains(object)) {
            try {
                Iterator<NodeInterface<T>> iterator = iterator();
                while (iterator.hasNext()) {
                    temporal = (DoubleListNode<T>) iterator.next();
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
                DoubleListNode<T> temporalNode = head;
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
            return ((DoubleListNode<T>) node).getPrevious().getObject();
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
                DoubleListNode<T> temporalNode = tail;
                for (int i = 1; i < n; i++) {
                    array[i] = getPrevious(temporalNode);
                    temporalNode = temporalNode.getPrevious();
                }
                return array;
            } catch (Exception e) {
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return null;
    }

    @Override
    public T pop() {
        if(!isEmpty()){
            try{
                T objectHead = head.getObject();
                //remove(head.getObject());
                if(size == 1){
                    head =null;
                }else{
                    head = head.getNext();
                }
                if(head != null){
                    tail.setNext(head);
                    head.setPrevious(tail);
                }
                if(head == tail){
                    tail.setNext(head);
                    head.setPrevious(tail);
                }
                size--;
                return objectHead;
            }catch (Exception e){
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }

        }
        return null;
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
                        tail.setNext(head);
                        head.setPrevious(tail);
                        size--;
                        ack = true;
                    } else {
                        if (object.equals(tail.getObject())) {
                            tail = tail.getPrevious();
                            tail.setNext(head);
                            head.setPrevious(tail);
                            size--;
                            ack = true;
                        } else {
                            if (contains(object)) {   //this ES LA MISMA CLASE EN LA QUE ESTOY
                                Iterator<NodeInterface<T>> iterator = iterator();
                                DoubleListNode<T> nodeToRemove = null;
                                while (iterator.hasNext()) {
                                    nodeToRemove = (DoubleListNode<T>) iterator.next();
                                    if (nodeToRemove.isEquals(object)) {
                                        nodeToRemove.getPrevious().setNext(nodeToRemove.getNext());
                                        nodeToRemove.getNext().setPrevious(nodeToRemove.getPrevious());
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
               // Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
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
               // Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
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
    public DoubleLinkedListInterface<T> subList(NodeInterface<T> from, NodeInterface<T> to) {
        if ((validateNodes(from, to)) && (!isEmpty())) {
            try {
                Iterator<NodeInterface<T>> iterator = iterator();
                DoubleLinkedCircularList<T> linkedListToReturn = new DoubleLinkedCircularList<T>();
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
               // Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
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
        DoubleListNode<T> nodo = head;
        T[] array = (T[]) new Object[size];
        Iterator<NodeInterface<T>> iterator = iterator();
        int i = 0;
        while (iterator.hasNext()) {
            array[i] = iterator.next().getObject();
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
               // Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return false;
    }

   /* public boolean sortObjectsByK(int k) {
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
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }*/


    /*public LinkedList<T> invertirAll(LinkedList<T> list){
        LinkedList<T> newList = new LinkedList<>();
        int contador = list.size();
        for (int i=0; i<contador; i++){
            newList.addOnHead(list.pop());
        }
        return newList;
    }*/
    public DoubleLinkedCircularList<T> reverseAll(DoubleLinkedCircularList<T> list) {
        DoubleLinkedCircularList<T> newList = new DoubleLinkedCircularList<>();
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
                if(inode == head){
                    inode = null;
                }
                return node;
            }
        };
    }
    public Iterator<NodeInterface<T>> iteratorToBack(){
        inode = tail;
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
                inode = inode.getPrevious();
                if(inode == head){
                    inode = null;
                }
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
                if(inode == head){
                    inode = null;
                }
                return node.getObject();
            }
        };
    }

}
