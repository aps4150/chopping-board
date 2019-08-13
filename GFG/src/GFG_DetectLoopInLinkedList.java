/**
 * GFG
 * https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1/?ref=self
 * Proof : https://math.stackexchange.com/questions/913499/proof-of-floyd-cycle-chasing-tortoise-and-hare
 *
 */
public class GFG_DetectLoopInLinkedList {

    static class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public static void main(String args[])
    {
        Node node = generateBasicList(1,8);
        //printLikeLinkedList(node);
        node.next.next.next.next.next.next.next.next= node.next.next.next;

        System.out.println((detectLoop(node) == 1)?"Loop detected!":"No loop exist");

        System.out.println("After Loop removal (if there was loop):");

        LOGIC_2_removeTheLoop(node);
        printLikeLinkedList(node);
    }

    static int detectLoop(Node head) {

        Node slowhead = head;
        Node fastHead = head;

        while (null != slowhead && null != fastHead && null != fastHead.next) {

            slowhead = slowhead.next;
            fastHead = fastHead.next.next;

            if(slowhead == fastHead) { return 1; }
        }
        return 0;
    }

    public static void removeTheLoop(Node head)
    {
        Node previousToSlowHead = null;
        Node slowhead = head;
        Node fastHead = head;
        boolean loopDetected = false;

        while (null != slowhead && null != fastHead && null != fastHead.next) {

            previousToSlowHead = slowhead;
            slowhead = slowhead.next;
            fastHead = fastHead.next.next;

            if(slowhead == fastHead) {
                loopDetected = true;
                break;
            }
        }

        if(!loopDetected) { return; }

        fastHead = head;
        while (slowhead != fastHead) {
            slowhead = slowhead.next;
            fastHead = fastHead.next;
            previousToSlowHead = previousToSlowHead.next;
        }

        previousToSlowHead.next = null;
    }

    public static void LOGIC_2_removeTheLoop(Node head)
    {
        Node slowhead = head;
        Node fastHead = head;
        boolean loopDetected = false;

        while (null != slowhead && null != fastHead && null != fastHead.next) {

            slowhead = slowhead.next;
            fastHead = fastHead.next.next;

            if(slowhead == fastHead) {
                loopDetected = true;
                break;
            }
        }

        if(!loopDetected) {
            System.out.println("No Loop found!");
            return;
        }

        fastHead = head;
        while (slowhead.next != fastHead.next) {
            slowhead = slowhead.next;
            fastHead = fastHead.next;
        }

        System.out.println("Removing Loop found at "+slowhead.next.data+":");
        slowhead.next = null;
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

    private static void printLikeLinkedList(Node node) {

        Node tempNode = node;

        while (tempNode != null)
        {
            System.out.print(tempNode.data);
            System.out.print((tempNode.next==null)?".\n":" -> ");
            tempNode = tempNode.next;
        }
    }
}
