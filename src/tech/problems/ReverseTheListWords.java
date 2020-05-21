package tech.problems;

import java.util.List;

public class ReverseTheListWords {

    public static void main(String[] args) {
        Node head = testList();
        printList(head);
        Node newHead = reverseListWithWords(head);
        System.out.println("\n");
        printList(newHead);
    }

    private static void printList(Node head) {
        while (head != null){
            System.out.print(head.value+"->");
            head = head.next;
        }
    }

    public static Node reverseListWithWords(Node head){
        //1. take two pointer first, mid and last; Initially both are on node position;
        Node newHead = null;
        Node last = head;
        Node first = head;

        //2. loop till last is not null;
        while(last.next != null){
            //3. chekc if current not has space value =>
            //3a. if not then increment last;
            if(last.next.value != ' '){
                last = last.next;
            }else{
//                addAtFirst(newHead, first);
//                addAtFirst(newHead, getSpaceNode());
                Node temp = last;
                last = last.next.next;

                temp.next = newHead;
                newHead = first;

                Node spaceNode = getSpaceNode();
                spaceNode.next = newHead;
                newHead = spaceNode;

                first = last;
            }

        }
        return newHead;
    }

    public static Node getSpaceNode(){
        return new Node(' ');
    }

    public static void addAtFirst(Node head, Node node) {
        node.next = head;
        head = node;
    }

    static class Node{
        Node next;
        char value;

        public Node(char value){
            this.next = null;
            this.value = value;
        }
    }

    public static Node testList(){
        Node node1 = new Node('a');
        Node node2 = new Node('b');
        Node node3 = new Node(' ');
        Node node4 = new Node('c');
        Node node5 = new Node('d');
        Node node6 = new Node(' ');
        Node node7 = new Node('e');
        Node node8 = new Node('f');
        Node node9 = new Node('g');

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = null;

        return node1;
    }
}
