public class SegregateOddEven {

    public static void main(String args[])
    {
        LinkedList<Integer> list = LinkedList.generateBasicList(1,5);
            list.print();

        System.out.println("After Segregation:");
            segregate(list);
            list.print();
    }

    private static void segregate(LinkedList<Integer> list) {

        if(null == list || null == list.head || null == list.head.next)
        { return; }

        LinkedList.Node currentOddNode = list.head;
        LinkedList.Node evenHeadNode = list.head.next;
        LinkedList.Node tempEvenNode = list.head.next;

        while (null != tempEvenNode && null != tempEvenNode.next) {

            if (null != tempEvenNode.next) {
                currentOddNode.next = tempEvenNode.next;
                currentOddNode = tempEvenNode.next;
            }

            if (null != currentOddNode) {
                tempEvenNode.next = currentOddNode.next;
                tempEvenNode = currentOddNode.next;
            }
        }
        currentOddNode.next = evenHeadNode;

/*
LOGIC 2 for above LOGIC 1
        while (null != tempEvenNode)
        {
            if(null == tempEvenNode.next)
            { break;}
            currentOddNode.next = tempEvenNode.next;
            currentOddNode = currentOddNode.next;

            if(null == currentOddNode)
            { break;}
            tempEvenNode.next = currentOddNode.next;
            tempEvenNode = tempEvenNode.next;
        }

        if(null == currentOddNode)
        { currentOddNode = evenHeadNode; }
        else
        { currentOddNode.next = evenHeadNode; }
*/
    }

}
