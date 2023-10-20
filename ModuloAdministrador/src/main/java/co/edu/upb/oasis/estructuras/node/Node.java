package co.edu.upb.oasis.estructuras.node;

import java.io.Serializable;

import co.edu.upb.oasis.estructuras.interfaces.NodeInterface;

public class Node<T extends Serializable> implements NodeInterface<T> {
    private T object;
    public Node(){
        this.object = null;
    }
    public Node(T object){
        this.object = object;
    }
    @Override
    public boolean setObject(T object) {
        try {
            this.object = object;
            return true;
        }
        catch (Exception e){
           // Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(),e);
            return false;
        }
    }

    @Override
    public T getObject() {
        return this.object;
    }

    @Override
    public boolean isEquals(T object) {
        try {
            return this.object.toString().equals(object.toString());
        }
        catch (Exception e){
            //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(),e);
            return false;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Node<T> getClone() {
        try{
            if(this.object !=null){

                return (Node<T>)this.clone();
            }
        }
        catch (CloneNotSupportedException e){
            // Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(),e);
        }
        return null;
    }
    @Override
    public String toString(){
        return "Node [object="+ object+ "]";
    }
}
