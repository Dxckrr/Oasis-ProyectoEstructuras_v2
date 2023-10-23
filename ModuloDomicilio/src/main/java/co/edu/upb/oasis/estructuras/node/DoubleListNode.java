package co.edu.upb.oasis.estructuras.node;

import java.io.Serializable;

public class DoubleListNode<T extends Serializable> extends Node<T> {
    DoubleListNode<T> next;
    DoubleListNode<T> previous;

    public DoubleListNode(){
        super();
        this.next = this.previous = null;
    }
    public DoubleListNode(T object){
        super(object);
        this.next = this.previous = null;
    }
    public DoubleListNode(T object, DoubleListNode<T> next){
        super(object);
        this.next = next;
        this.previous = null;
    }
    public DoubleListNode(T object, DoubleListNode<T> next,DoubleListNode<T> previous){
        super(object);
        this.next = next;
        this.previous = previous;
    }

    public DoubleListNode<T> getNext(){
        return this.next;
    }
    public DoubleListNode<T> getPrevious(){
        return this.previous;
    }
    public void setNext(DoubleListNode<T> next){
        this.next = next;
    }
    public void setPrevious(DoubleListNode<T> previous){
        this.previous = previous;
    }
}
