package tech.ds.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time = O(n)
 * Space = O(n)
 */
public class TreeTraversing {
    public static void inOrderTravers(Node root){
        if (root != null){
            inOrderTravers(root.left);
            System.out.print(root.value + " ");
            inOrderTravers(root.right);
        }
    }

    public static void preOrderTravers(Node root){
        if (root != null){
            System.out.print(root.value + " ");
            preOrderTravers(root.left);
            preOrderTravers(root.right);
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
}
