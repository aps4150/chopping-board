public class ReverseKElementBlocksOfLinkedList {

    public static void main(String args[])
    {
        LinkedList<Integer> list = LinkedList.generateBasicList(1,10);
        list.printLikeLinkedList();

        System.out.println("After Reversal:");
        reverseKElementBlocksOfLinkedList(list, 3);
        list.printLikeLinkedList();
    }

    private static void reverseKElementBlocksOfLinkedList(LinkedList<Integer> list, int k) {

        if(k < 1 || null == list || null == list.head || null == list.head.next) { return; }

        LinkedList.Node blockStart = list.head;
        LinkedList.Node previousBlockStart = list.head;

        LinkedList.Node previousNode = null;
        LinkedList.Node currentNode = list.head;
        LinkedList.Node aheadNode;

        int i = 1;

        while (currentNode != null) {

            aheadNode = currentNode.next;

            currentNode.next = previousNode;

            previousNode = currentNode;
            currentNode = aheadNode;

            if(i == k) {
                list.head = previousNode;
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
    }

    /**
    Ignore below methods, they are for logging & testing.
    private static void printAllStatus(LinkedList.Node pl, LinkedList.Node pr, LinkedList.Node cl, LinkedList.Node cr, LinkedList.Node al, LinkedList.Node ar,  boolean changeLine) {

        printStatus(pl, pr, false);
        printStatus(cl, cr, false);
        printStatus(al, ar, false);

        System.out.print((changeLine)?" \n ":" >> ");
    }

    private static void printStatus(LinkedList.Node left, LinkedList.Node right, boolean changeLine) {

        String x, y;
        x=" | ";
        y="\n";

        String l="", r="", z;


        l=(null == left)?"":left.printableValue;
        r=(null == right)?"":right.printableValue;

        z=(changeLine)?y:x;

        System.out.print("["+l + ", " + r +"]" + z);
    }
    **/
}
