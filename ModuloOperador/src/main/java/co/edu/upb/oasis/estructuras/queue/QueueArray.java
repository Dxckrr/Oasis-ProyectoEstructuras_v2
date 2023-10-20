package co.edu.upb.oasis.estructuras.queue;

import java.io.Serializable;

import co.edu.upb.oasis.estructuras.interfaces.QueueInterface;
import co.edu.upb.oasis.estructuras.stacks.StackArray;
import co.edu.upb.oasis.estructuras.stacks.StackList;
import co.edu.upb.oasis.estructuras.stacks.StackStaticArray;


public class QueueArray<T extends Serializable> implements QueueInterface<T> {
    private T[] myArray;

    int head;
    int tail;
    int numberOfObjects;
    public QueueArray(int size){
        myArray = (T[]) new Object[size];
        numberOfObjects = 0;
        tail =0;
        head=0;
    }
    @Override
    public boolean clear() {
        myArray[head] = null;
        myArray[tail] = null;
        head =0;
        tail=0;
        numberOfObjects=0;
        /*for(int i=0;i< myArray.length;i++){
            myArray[i] = null;
        }*/
        return true;
    }

    @Override
    public boolean isEmpty() {
        return myArray[head] ==null;
    }

    @Override
    public T peek() {
        return myArray[head];
    }

    @Override
    public T extract() {
        if(!isEmpty()){
            try{
                T object = myArray[head];
                myArray[head] = null;
                head++;
                if(head >= myArray.length){
                    head--;
                }
                numberOfObjects--;
                return object;
            }catch (Exception e){
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(),e);
            }
        }
        return null;
    }

    @Override
    public boolean insert(T object) {
        try{
            if(numberOfObjects < myArray.length){
                myArray[tail] = object;
                tail++;
                numberOfObjects++;
                if(tail >= myArray.length){
                    tail=0;
                }
            }
            return true;
        }catch (Exception e){
            //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(),e);
        }

        return false;
    }

    @Override
    public int size() {
        return numberOfObjects;
    }

    @Override
    public boolean search(T object) {
        if(!isEmpty()){
            try{
                int posicion = head;
                for(int i=0;i<numberOfObjects;i++){
                    if(myArray[posicion] == object){
                        return true;
                    }
                    posicion++;
                    if(posicion == myArray.length){
                        posicion = 0;
                    }
                }
                return true;
            }catch (Exception e){
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(),e);
            }
        }
        return false;
    }

    @Override
    public boolean sort() {
        if (!isEmpty()){
            try {
                StackStaticArray<T> newPilaArray = new StackStaticArray<>(myArray.length);
                for(int i=0;i< myArray.length;i++){
                    newPilaArray.push(extract());
                }
                newPilaArray.sort();
                myArray = newPilaArray.myArray;
                head = 0;
                numberOfObjects = newPilaArray.size();
                tail = numberOfObjects;
                if(tail == myArray.length){
                    tail = 0;
                }

                return true;
            }
            catch (Exception e){
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(),e);
            }
        }
        return false;
    }

    @Override
    public boolean reverse() {
        StackStaticArray<T> newPilaArray = new StackStaticArray<>(myArray.length);
        if(!isEmpty()){
            try{
                for(int i=0;i< myArray.length;i++){
                    newPilaArray.push(extract());
                }
                newPilaArray.reverse();
                myArray = newPilaArray.myArray;
                numberOfObjects = newPilaArray.size();
                head = 0;
                tail = numberOfObjects;
                if(tail == myArray.length){
                    tail = 0;
                }
                return true;
            }catch (Exception e){
                //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(),e);
            }
        }
        return false;
    }
    public void print(){
        int posicion = head;
        for (int i=0; i<numberOfObjects; i++){
            System.out.println(myArray[posicion]);
            posicion++;
            if (posicion == myArray.length){
               posicion = 0;
            }
        }
    }


}
