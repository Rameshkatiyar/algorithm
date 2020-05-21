package tech.dsa.Tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
//        BinaryTree binaryTree1 = getBinaryTree();
//        traverseTree(binaryTree1.getRoot());

        BinarySearchTree bst = getBinarySearchTree();
        traverseTree(bst.getRoot());

//        Node searched = bst.search(bst.getRoot(), 13);
//        System.out.println("Found Node: "+searched);

        bst.deleteTwoChildNode(bst.getRoot(), 12);
        traverseTree(bst.getRoot());
    }

    public static BinarySearchTree getBinarySearchTree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(6);
        bst.insert(12);
        bst.insert(8);
        bst.insert(15);
        bst.insert(11);
        bst.insert(13);
        bst.insert(1);
        bst.insert(3);
        return bst;
    }

    public static void traverseTree(Node root){
        System.out.print("InOrder: ");
        TreeTraversing.inOrderTravers(root);
        System.out.println("\n");

        System.out.print("PreOrder: ");
        TreeTraversing.preOrderTravers(root);
        System.out.println("\n");

        System.out.print("PostOrder: ");
        TreeTraversing.postOrderTravers(root);
        System.out.println("\n");

        System.out.print("Level Order: ");
        TreeTraversing.levelOrderTraversing(root);
        System.out.println("\n");
    }

    public static BinaryTree getBinaryTree() {
        BinaryTree bt = new BinaryTree(1);

        Node node1 = bt.getRoot();

        Node node2 = bt.addLeft(node1, 2);
        bt.addLeft(node2, 4);
        bt.addRight(node2, 5);

        Node node3 = bt.addRight(node1, 3);
        bt.addLeft(node3, 6);
        bt.addRight(node3,7);

        return bt;
    }
}
