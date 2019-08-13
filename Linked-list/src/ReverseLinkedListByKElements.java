public class ReverseLinkedListByKElements {

    public static void main(String args[])
    {
        LinkedList<Integer> list = LinkedList.generateBasicList(1,9);
        list.printLikeLinkedList();

        System.out.println("After Reversal:");
        reverseLinkedListByKElements(list, 3);
        list.printLikeLinkedList();
    }

    private static void reverseLinkedListByKElements(LinkedList<Integer> list, int k) {

        if(k < 1 || null == list || null == list.head || null == list.head.next) { return; }

        LinkedList.Node previousL = null;
        /**LinkedList.Node previousR = null;**/
        LinkedList.Node currentL = list.head;
        LinkedList.Node currentR = get_kth_Next(list.head, k);
        LinkedList.Node aheadL;
        LinkedList.Node aheadR;

        while (currentR != null) {

            aheadL = get_kth_Next(currentL, k+1);
            aheadR = get_kth_Next(currentR, k+1);

            /**printAllStatus(previousL, previousR, currentL, currentR, aheadL, aheadR, false);**/

            currentR.next = previousL;

            previousL=currentL;
            /**previousR=currentR;**/
            currentL = aheadL;
            currentR = aheadR;

            /**printAllStatus(previousL, previousR, currentL, currentR, aheadL, aheadR, true);**/
        }

        list.head = previousL;
    }

    private static LinkedList.Node get_kth_Next(LinkedList.Node head, int k) {

        int index = k;
        LinkedList.Node node = head;

        if(null == node || null == node.next) { return null; }

        while (index-- > 1 && null != node.next) {

            node = node.next;
        }
        return node;
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
