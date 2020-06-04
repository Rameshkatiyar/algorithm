package tech.problems;

import tech.dsa.Tree.BinarySearchTree;
import tech.dsa.Tree.BinaryTreeTest;
import tech.dsa.Tree.Node;
import tech.dsa.Tree.TreeTraversing;

public class LeastCommonAncestor {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = BinaryTreeTest.getBinarySearchTree();
        Node root = binarySearchTree.getRoot();
        TreeTraversing.levelOrderTraversing(root);

        int first = 3;
        int second = 8;

        Node lcaOfTwoNodes = getLCAOfTwoNodesInBT(root, first, second);
        System.out.println("\n\nBT LCA: " +lcaOfTwoNodes.value);

        Node lcaOfTwoNodesInBST = getLCAOfTwoNodesInBST(root, first, second);
        System.out.println("\nBST LCA: " +lcaOfTwoNodesInBST.value);
    }

    public static Node getLCAOfTwoNodesInBT(Node root, int first, int second){
        if (root == null){
            return null;
        }

        if (root.value == first || root.value == second){
            return root;
        }

        Node leftLCA = getLCAOfTwoNodesInBT(root.left, first, second);
        Node rightLCA = getLCAOfTwoNodesInBT(root.right, first, second);

        if (leftLCA != null && rightLCA != null){
            return root;
        }

        return leftLCA!=null ? leftLCA : rightLCA;
    }

    public static Node getLCAOfTwoNodesInBST(Node root, int first, int second){
        if (root == null){
            return null;
        }

        if ((first < root.value && second >= root.value) || (first >= root.value && second < root.value)){
            return root;
        }

        if (first < root.value && second < root.value){
            return getLCAOfTwoNodesInBST(root.left, first, second);
        }
        else {
            return getLCAOfTwoNodesInBST(root.right, first, second);
        }
    }
}
