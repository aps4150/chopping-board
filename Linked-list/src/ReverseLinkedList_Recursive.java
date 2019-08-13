/**
 * GFG
 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1
 */
public class ReverseLinkedList_Recursive {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String args[])
    {
        Node node = generateBasicList(1,3);
        printLinkedList(node);

        System.out.println("After Reversal:");

        //node = reverseLinkedList(null, node);
        node = reverseLinkedList2(node);
        printLinkedList(node);
    }

    private static Node reverseLinkedList(Node currentNode, Node nextNode) {

        if(null == nextNode ) {
            return nextNode;
        }

        if(null == nextNode.next) {
            nextNode.next = currentNode;
            return nextNode;
        }

        Node result = reverseLinkedList(nextNode, nextNode.next);
        nextNode.next = currentNode;

        return result;
    }

    private static Node reverseLinkedList2(Node head) {

        if(null == head || null == head.next) { return head; }

        Node newHeadNode = reverseLinkedList2(head.next);

        // change references for middle chain
        head.next.next = head;
        head.next = null;

        // send back new head node in every recursion
        return newHeadNode;
    }

    private static void printLinkedList(Node node) {

        Node tempNode = node;
        while (tempNode != null){

            System.out.print(tempNode.data);
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

}