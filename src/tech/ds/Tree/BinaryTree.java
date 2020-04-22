package tech.ds.Tree;

public class BinaryTree {
    private Node root;

    public BinaryTree(int root){
        this.root = new Node(root);
    }

    public Node getRoot() {
        return root;
    }

    public Node addLeft(Node currentNode, int value){
        if (currentNode == null){
            return new Node(value);
        }

        if (currentNode.left == null){
            currentNode.left = new Node(value);
            return currentNode.left;
        }else {
            addLeft(currentNode.left, value);
        }
        return currentNode;
    }

    public Node addRight(Node currentNode, int value){
        if (currentNode == null){
            return new Node(value);
        }

        if (currentNode.right == null){
            currentNode.right = new Node(value);
            return currentNode.right;
        }else {
            addRight(currentNode.right, value);
        }
        return currentNode;
    }
}
