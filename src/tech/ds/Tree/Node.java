package tech.ds.Tree;

public class Node {
    int value;
    Node left;
    Node right;
    int height; //For AVL tree.

    public Node(int value){
        this.value = value;
        left = null;
        right = null;
    }
}
