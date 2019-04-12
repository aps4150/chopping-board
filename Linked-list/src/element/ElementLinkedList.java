package element;

public class ElementLinkedList {

    Element head = null;

    public static void main(String args[]) {

        ElementLinkedList linkedList = new ElementLinkedList();

        linkedList.head = new Element();

        Element tempHead = linkedList.head;
        for (int i = 1; i < 11; i++) {

            tempHead.nextElement = new Element(i);
            tempHead = tempHead.nextElement;

        }

        printLinkedList(linkedList);

    }

    private static void printLinkedList(ElementLinkedList linkedList) {

        Element tempHead;
        tempHead = linkedList.head;
        while (null != tempHead.nextElement){

            System.out.println(tempHead.value);

            tempHead = tempHead.nextElement;

        }
    }
}

