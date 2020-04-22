package tech.ds.Tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
//        BinaryTree binaryTree1 = getBinaryTree1();
//        traverseTree(binaryTree1.getRoot());

        int[] a = new int[]{10, 6, 12, 8, 15, 11, 13, 1, 3};
        BinaryTree bst = BinaryTree.buildBST(a);
        traverseTree(bst.getRoot());
    }

    private static void traverseTree(Node root){
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

    private static BinaryTree getBinaryTree1() {
        BinaryTree bt = new BinaryTree(1);
        Node root = bt.getRoot();

        Node node2 = bt.addLeft(root, 2);
        bt.addLeft(node2, 4);
        bt.addRight(node2, 5);

        Node node3 = bt.addRight(root, 3);
        bt.addLeft(node3, 6);
        bt.addRight(node3,7);

        return bt;
    }
}
