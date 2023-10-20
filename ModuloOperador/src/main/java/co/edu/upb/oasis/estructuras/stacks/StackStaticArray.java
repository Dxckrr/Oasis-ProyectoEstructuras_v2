package co.edu.upb.oasis.estructuras.stacks;

import java.io.Serializable;

import co.edu.upb.oasis.estructuras.interfaces.StackInterface;


public class StackStaticArray<T extends Serializable> implements StackInterface<T> {
    public T[] myArray;
    int numberOfObjects;
    public StackStaticArray(int size){
        myArray = (T[]) new Object[size];
        numberOfObjects =0;
    }
    @Override
    public boolean clear() {
        for(int i=0;i< myArray.length;i++){
            myArray[i] = null;
        }
        numberOfObjects =0;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return myArray[0] == null ;
    }

    @Override
    public T peek() {
        return myArray[numberOfObjects-1];
    }

    @Override
    public T pop() {
        try{
            if(!isEmpty()){
                T top = myArray[(numberOfObjects-1)];
                myArray[numberOfObjects-1] = null;
                numberOfObjects--;
                return top;
            }
        }catch (Exception e){
            //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(),e);
        }
        return null;
    }

    @Override
    public boolean push(T object) {
        try{
            if(!(numberOfObjects >= myArray.length)){
                myArray[numberOfObjects] = object;
                numberOfObjects++;
            }
            return true;
        }catch (Exception e){
           // Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(),e);
        }
        return false;
    }

    @Override
    public int size() {
        return numberOfObjects;
    }

    @Override
    public boolean search(T object) {
        try{
            for(int i=0;i< myArray.length;i++){
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
        StackStaticArray<T> newStack = new StackStaticArray<>(myArray.length);
        int count = numberOfObjects;
        for(int i=0;i< count;i++){
            newStack.push(pop());
        }
        numberOfObjects = count;
        myArray = newStack.myArray;
        return true;
    }
    public void print(){
        System.out.println("La pila es: ");
        for(int i= numberOfObjects-1;i>=0;i--){
            System.out.println("| " +myArray[i]+ "|");
        }
    }
}
