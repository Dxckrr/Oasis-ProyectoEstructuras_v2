package co.edu.upb.oasis.estructuras.node;

import java.io.Serializable;

public class SingleListNode<T extends Serializable> extends Node<T>{

    SingleListNode<T> next;

    public SingleListNode(){
        super();
        this.next = null;
    }
    public SingleListNode(T object){
        super(object);
        this.next = null;
    }
    public SingleListNode(T object, SingleListNode<T> next){
        super(object);
        this.next = next;
    }
    public SingleListNode<T> getNext(){
        return this.next;
    }
    public void setNext(SingleListNode<T> next){
        this.next = next;
    }
}
