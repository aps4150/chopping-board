/**
 * GFG
 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1
 */
public class GFG_ReverseLinkedList {

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String args[])
    {
        Node node = generateBasicList(1,5);
        printLinkedList(node);
        System.out.println("After Reversal:");
        node = reverseLinkedList(node);
        printLinkedList(node);
    }

    private static void printLinkedList(Node node) {

        Node tempNode = node;
        while (tempNode != null){

            System.out.print(tempNode.value);
            System.out.print((tempNode.next == null)?".":" -> ");

            tempNode = tempNode.next;
        }
    }

    private static Node generateBasicList(int a, int b) {

        Node node = new Node(a);
        Node tempNode = node;

        for (int i = a+1; i <= b; i++) {

            Node newNode = new Node(i);
            tempNode.next = newNode;

            tempNode = tempNode.next;
        }

        return node;
    }

    private static Node reverseLinkedList(Node node) {

        if(null == node) { return null; }

        Node previous = null;
        Node current = node;
        Node ahead;

        while (current != null) {

            ahead = current.next;
            current.next = previous;

            previous = current;
            current = ahead;
        }
        return previous;
    }
}