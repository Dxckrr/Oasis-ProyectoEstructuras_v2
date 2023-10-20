package co.edu.upb.oasis.estructuras.queue;

import java.io.Serializable;

public class PriorityQueue<T extends Serializable> {
    QueueList<T>[] myPriorityCola;

    public PriorityQueue(int size){
        myPriorityCola = new QueueList[size];
        for(int i=0;i<size;i++){
            myPriorityCola[i] = new QueueList<>();
        }
    }

    public boolean add(T object, int  priority){
        if((priority >=0) && (priority < myPriorityCola.length)){
            return myPriorityCola[priority].insert(object);
        }
        return false;
    }

    public T extract(){
        try {
            for(int i=0;i<myPriorityCola.length;i++){
                if(!myPriorityCola[i].isEmpty()){
                    return (T) myPriorityCola[i].extract();
                }
            }
        }catch (Exception e){
           // Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }

        return null;
    }

    public boolean isEmpty(){

        for(int i=0;i<myPriorityCola.length;i++){
            if(!myPriorityCola[i].isEmpty()){
                return false;
            }
        }
        return true;
    }

    public void print(){
        for(int i=0;i<myPriorityCola.length;i++){
            myPriorityCola[i].getLinkedList().imprimir();
        }
    }
}
