/**
 * GFG
 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
 */

public class GFG_ReverseKElementBlocksOfLinkedList {

    static class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }

    public static void main(String args[])
    {
        Node node = generateBasicList(1,1);
        printLikeLinkedList(node);

        if(1!=1)return;

        System.out.println("After Reversal:");
        printLikeLinkedList(reverseKElementBlocksOfLinkedList(node, 1));
    }

    private static void printLikeLinkedList(Node node) {

        Node tempNode = node;

        while (tempNode != null)
        {
            System.out.print(tempNode.data);
            System.out.print((tempNode.next==null)?".":" -> ");
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

    private static Node reverseKElementBlocksOfLinkedList(Node node, int k) {

        if(k < 1 || null == node) { return null; }

        Node blockStart = node;
        Node previousBlockStart = node;

        Node previousNode = null;
        Node currentNode = node;
        Node aheadNode;

        Node headNode = null;

        int i = 1;

        while (currentNode != null) {

            aheadNode = currentNode.next;

            currentNode.next = previousNode;

            previousNode = currentNode;
            currentNode = aheadNode;

            if(i == k) {
                headNode = previousNode;
                blockStart = currentNode;
                previousNode = null;
            }
            else if(i%k == 0) {

                previousBlockStart.next = previousNode;
                previousBlockStart = blockStart;
                blockStart = currentNode;
                previousNode = null;
            }

            i++;
        }

        previousBlockStart.next = previousNode;

        return headNode;
    }
}
