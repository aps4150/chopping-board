public class ReverseLinkedList {

    public static void main(String args[])
    {
        LinkedList<Integer> list = LinkedList.generateBasicList(1,5);
        list.print();

        System.out.println("After Reversal:");
        reverseLinkedList(list);
        list.print();
    }

    private static void reverseLinkedList(LinkedList<Integer> list) {

        if(null == list || null == list.head || null == list.head.next) { return; }

        LinkedList.Node previous = null;
        LinkedList.Node current = list.head;
        LinkedList.Node ahead;

        while (current != null) {

            ahead = current.next;
            //printStatus(previous, current, ahead, false);

            current.next = previous;

            previous = current;
            current = ahead;

            //printStatus(previous, current, ahead, true);
        }

        list.head = previous;
    }

    private static void printStatus(LinkedList.Node previous, LinkedList.Node current, LinkedList.Node ahead, boolean changeLine) {

        String x, y;
        x=" >> ";
        y="\n";

        String p="", c="", a="", r;


        p=(null == previous)?"":previous.printableValue;
        c=(null == current)?"":current.printableValue;
        a=(null == ahead)?"":ahead.printableValue;

        r=(changeLine)?y:x;

        System.out.print(p + " | " + c +" | " + a + r);
    }


}