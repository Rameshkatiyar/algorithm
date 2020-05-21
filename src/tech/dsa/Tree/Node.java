package tech.dsa.Tree;

public class Node {
    public int value;
    public Node left;
    public Node right;
    int height; //For AVL tree.

    public Node(int value){
        this.value = value;
        left = null;
        right = null;
    }
}
