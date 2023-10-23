package co.edu.upb.oasis.estructuras.node;

import java.io.Serializable;


public class BinaryTreeNode<T extends Serializable>{

    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    int level;
    T object;

    public BinaryTreeNode(){
        left = right = null;
        level = 0;
    }
    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    


    
}
