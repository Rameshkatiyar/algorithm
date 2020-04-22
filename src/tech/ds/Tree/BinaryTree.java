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
        if (currentNode.left == null){
            currentNode.left = new Node(value);
            return currentNode.left;
        }else {
            addLeft(currentNode.left, value);
        }
        return currentNode;
    }

    public Node addRight(Node currentNode, int value){
        if (currentNode.right == null){
            currentNode.right = new Node(value);
            return currentNode.right;
        }else {
            addRight(currentNode.right, value);
        }
        return currentNode;
    }

    public static BinaryTree buildBST(int[] a){
        if(a.length <= 0)
            return null;

        BinaryTree bt = new BinaryTree(a[0]);
        Node root = bt.getRoot();

        for(int i = 1; i < a.length; i++){
            addNodeInBST(root, a[i]);
        }

        return bt;
    }

    private static void addNodeInBST(Node root, int value){

        if(root.value > value && root.left == null){
            root.left = new Node(value);
        }else if (root.value > value){
            addNodeInBST(root.left, value);
        }

        if(root.value <= value && root.right == null){
            root.right = new Node(value);
        }else if (root.value <= value){
            addNodeInBST(root.right, value);
        }
    }
}
