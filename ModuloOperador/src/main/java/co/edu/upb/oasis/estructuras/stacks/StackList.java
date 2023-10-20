package co.edu.upb.oasis.estructuras.stacks;

import java.io.Serializable;

import co.edu.upb.oasis.estructuras.interfaces.StackInterface;
import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;


public class StackList<T extends Serializable> implements StackInterface<T> {
    private DoubleLinkedList<T> myLinkedList;
    public StackList(){
        myLinkedList = new DoubleLinkedList<>();
    }
    @Override
    public boolean clear() {
        //Clears the list
        return myLinkedList.clear();
    }

    @Override
    public boolean isEmpty() {
        return myLinkedList.isEmpty();
    }

    @Override
    public T peek() {
        //Shows the first Object on the top
        return myLinkedList.get();
    }

    @Override
    public T pop() {
        //Returns top and deletes it
        return myLinkedList.pop();
    }

    @Override
    public boolean push(T object) {
        //Add on top
        return myLinkedList.addOnHead(object);
    }

    @Override
    public int size() {
        //Return size
        return myLinkedList.size();
    }

    @Override
    public boolean search(T object) {
        //Search if the stack contains an objects
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
                    temp = pop();
                    stackToBigger.push(temp);

                    for (int i=0; i<contadorSize-1; i++){
                        temp = pop();
                        if (temp.toString().length() < stackToBigger.peek().toString().length()){
                            stackToSmaller.push(temp);
                        }else {
                            stackToBigger.push(temp);
                        }
                    }
                    contador = 0;
                    temp = stackToBigger.pop();
                    push(temp);
                    for (int i=0; i<contadorSize-1; i++){

                        if (!stackToBigger.isEmpty()){
                            temp = stackToBigger.pop();
                        } else{
                            temp = stackToSmaller.pop();
                        }
                        if (peek().toString().length() >= temp.toString().length()){
                            contador++;
                        }
                        push(temp);
                    }
                    //System.out.println(contador);
                    if (contador == contadorSize-1){
                        sorted = true;
                    }
                }
                return true;
            }
            catch (Exception e){
              //  Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(),e);
            }
        }
        return false;
    }

    @Override
    public boolean reverse() {
        try{
            StackList<T> newStack = new StackList<>();
            while(!isEmpty()){
                newStack.push(pop());
            }
            myLinkedList = newStack.myLinkedList;
            return true;
        }catch (Exception e){
           // Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;

    }
    public void print(){
        myLinkedList.imprimir();
    }
}

