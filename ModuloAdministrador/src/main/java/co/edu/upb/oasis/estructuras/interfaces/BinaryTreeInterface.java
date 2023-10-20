package co.edu.upb.oasis.estructuras.interfaces;
import java.io.Serializable;

import co.edu.upb.oasis.estructuras.lists.DoubleLinkedList;

public interface BinaryTreeInterface<T extends Serializable> {

    public DoubleLinkedList<T> preOrder();
    public DoubleLinkedList<T> inOrder();
    public DoubleLinkedList<T> posOrder();

    public DoubleLinkedList<T> levelOrder();

    public int getHeight();

    public boolean isFull();
    
    public boolean isComplete();

}