package co.edu.upb.oasis.estructuras.queue;

import java.io.Serializable;

import co.edu.upb.oasis.estructuras.interfaces.QueueInterface;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;
import co.edu.upb.oasis.estructuras.stacks.StackList;

public class QueueList<T extends Serializable> implements QueueInterface<T> {
    private DoubleLinkedList<T> myLinkedList;
    public QueueList(){
        myLinkedList = new DoubleLinkedList<>();
    }
    @Override
    public boolean clear() {
        return myLinkedList.clear();
    }
    @Override
    public T peek() {
        return myLinkedList.get();
    }

    @Override
    public boolean isEmpty() {
        return myLinkedList.isEmpty();
    }

    @Override
    public T extract() {
        return myLinkedList.pop();
    }

    @Override
    public boolean insert(T object) {
        return myLinkedList.add(object);
    }

    @Override
    public int size() {
        return myLinkedList.size();
    }

    @Override
    public boolean search(T object) {
        return myLinkedList.contains(object);
    }

    @Override
    public boolean sort() {
        if (!isEmpty()){
            try {
                boolean sorted = false;
                StackList<T> stackToSmaller = new StackList<>();
                StackList<T> stackToBigger = new StackList<>();
                T temp;
                int contadorSize = size();
                int contador = 0;

                while (!sorted){
                    //System.out.println("        Start");
                    temp = extract();
                    stackToBigger.push(temp);

                    for (int i=0; i<contadorSize-1; i++){
                        temp = extract();
                        if (temp.toString().length() < stackToBigger.peek().toString().length()){
                            stackToSmaller.push(temp);
                        }else {
                            stackToBigger.push(temp);
                        }
                    }
                    contador = 0;
                    temp = stackToBigger.pop();
                    insert(temp);
                    for (int i=0; i<contadorSize-1; i++){

                        if (!stackToBigger.isEmpty()){
                            temp = stackToBigger.pop();
                        } else{
                            temp = stackToSmaller.pop();
                        }
                        if (peek().toString().length() >= temp.toString().length()){
                            contador++;
                        }
                        insert(temp);
                    }
                    //System.out.println(contador);
                    if (contador == contadorSize-1){
                        sorted = true;
                    }
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
        try{
            StackList<T> newStack = new StackList<>();
            while(!isEmpty()){
                newStack.push(extract());
            }
            while(!newStack.isEmpty()){
                insert(newStack.pop());
            }
            return true;
        }catch (Exception e){
           // Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    public DoubleLinkedList<T> getLinkedList(){
        return myLinkedList;
    }
}

