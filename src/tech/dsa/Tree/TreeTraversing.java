package tech.dsa.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Time = O(n)
 * Space = O(n)
 */
public class TreeTraversing {

    public static void main(String[] args) {
        BinaryTree binaryTree = getBinaryTree();
        postOrderTravers(binaryTree.getRoot());
        System.out.println("\n");
        itrPostOrderTravers(binaryTree.getRoot());
    }

    public static void inOrderTravers(Node root){
        if (root != null){
            inOrderTravers(root.left);
            System.out.print(root.value + " ");
            inOrderTravers(root.right);
        }
    }

    public static void itrInOrderTravers(Node root) {
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;

        // 1. check if stack is not empty or current is not null
        while (!stack.isEmpty() || currentNode != null) {

            // 2. If current has left, then push left into stack and make current = left
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            // 3. If current has null, then pop from stack and print and start from right.
            else {
                currentNode = stack.pop();
                System.out.print(currentNode.value + " ");
                currentNode = currentNode.right;
            }
        }
    }

    public static void preOrderTravers(Node root){
        if (root != null){
            System.out.print(root.value + " ");
            preOrderTravers(root.left);
            preOrderTravers(root.right);
        }
    }

    //This is with single stack. With two stack, its easy.
    public static void itrPostOrderTravers(Node root) {
        Node current = root;
        Stack<Node> stack = new Stack<>();

        // 1. check if stack is not empty or current is not null
        // 2. If current has left, then push left into stack and make current = left
        // 3. If current has null, then check the stack peek has right or not.
        // 4. If stack peek has right then process from right node (go to step 2).
        // 5. If stack peek dose not has right means it is a leaf node.
        // 5a. Then pop top element and print.
        // 5b. While: Now check the current top element of stack is a right of previous printed/proceed node. (And stack is not empty)
        // 5c. If yes then then pop top element and print.

        // 1
        while (!stack.isEmpty() || current != null) {
            // 2
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else { // 3
                Node temp = stack.peek().right;
                // 4
                if (temp != null) {
                    current = temp;
                } else { // 5
                    // 5a
                    temp = stack.pop();
                    System.out.print(temp.value+" ");

                    // 5b : Important
                    while (!stack.isEmpty() && stack.peek().right == temp) {
                        // 5c
                        temp = stack.pop();
                        System.out.print(temp.value+" ");
                    }
                }
            }
        }

    }

    public static void postOrderTravers(Node root){
        if (root != null){
            postOrderTravers(root.left);
            postOrderTravers(root.right);
            System.out.print(root.value + " ");
        }
    }

    public static void levelOrderTraversing(Node root){
        Queue<Node> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            Node ele = que.remove();
            System.out.print(ele.value + " ");

            if(ele.left != null)
                que.add(ele.left);

            if(ele.right != null)
                que.add(ele.right);
        }
    }

    public static BinaryTree getBinaryTree() {
        BinaryTree bt = new BinaryTree(11);

        Node node1 = bt.getRoot();

        Node node2 = bt.addLeft(node1, 22);
        bt.addLeft(node2, 44);
        bt.addRight(node2, 55);

        Node node3 = bt.addRight(node1, 33);
        bt.addLeft(node3, 66);
        bt.addRight(node3,77);

        return bt;
    }
}
