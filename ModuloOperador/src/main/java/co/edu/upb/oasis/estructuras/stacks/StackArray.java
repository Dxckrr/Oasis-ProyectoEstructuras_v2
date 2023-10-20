package co.edu.upb.oasis.estructuras.stacks;

import java.io.Serializable;

import co.edu.upb.oasis.estructuras.interfaces.StackInterface;


public class StackArray<T extends Serializable> implements StackInterface<T> {
    private T[] myArray ;
    int size;
    public StackArray(){
        size = 0;
        myArray = (T[]) new Object[size];

    }
    @Override
    public boolean clear() {
        myArray = (T[]) new Object[size];
        size=0;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T peek() {
        return myArray[(size-1)];
    }

    @Override
    public T pop() {
        try{
            if(!isEmpty()){
                T[] newArray = (T[]) new Object[size-1];
                T top = myArray[(size-1)];
                for(int i=0;i<(size-1);i++){
                    newArray[i] = myArray[i];
                }
                size--;
                myArray = newArray;
                return top;
            }
        }catch (Exception e){
           // Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(),e);
        }
        return null;
    }

    @Override
    public boolean push(T object) {
        try{
            T[] newArray = (T[]) new Object[size+1];

            for(int i=0;i<size;i++){
                newArray[i] = myArray[i];
            }
            size++;
            newArray[size-1] = object;
            myArray = newArray;
            return true;
        }catch (Exception e){
            //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(),e);
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean search(T object) {
        try{
            for(int i=0;i<size;i++){
                if(myArray[i] == (object)){
                    return true;
                }
            }
        }catch (Exception e){
           // Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(),e);
        }

        return false;
    }

    @Override
    public boolean sort() {
        try{
            if(!isEmpty()){
                boolean sorted = false;
                StackArray<T> stackToSmaller = new StackArray<>();
                StackArray<T> stackToBigger = new StackArray<>();
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

        }catch (Exception e){
           // Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(),e);
        }
        return false;
    }

    @Override
    public boolean reverse() {
        StackArray<T> newStack = new StackArray<>();
        int count = size;
        for(int i=0;i<count;i++){
            newStack.push(pop());
        }
        //System.out.println(newStack.print());
        size = count;
        myArray = newStack.myArray;
        //System.out.println(peek());
        return true;
    }

    public void print(){
        System.out.println("La pila es: ");
        for(int i=size-1;i>=0;i--){
            System.out.println(myArray[i]+ " |");
        }

    }
}

