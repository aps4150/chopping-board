public class LinkedList<T> {

    Node head;

    static class Node<T> {

        Node next;
        T value;
        String printableValue;

        Node(T value) {
            this.value = value;
            printableValue = value.toString();
        }

        Node(T value, String printableValue) {
            this.value = value;
            this.printableValue = printableValue;
        }

    }

    private Node createNewNode(T value) {
        return new Node(value);
    }

    public void insertAtHead(T value) {

        Node newNode = createNewNode(value);

        newNode.next = head;
        head = newNode;
    }

    public void insert(T value) {

        if(null == head) {

            insertAtHead(value);
            return;
        }

        Node newNode = createNewNode(value);
        Node tempHead = head;

        while(tempHead.next != null) {
            tempHead = tempHead.next;
        }
        tempHead.next = newNode;
    }

    public static void main(String args[]) {

        LinkedList<Integer> linkedListAsc = new LinkedList<>();
        LinkedList<Integer> linkedListDes = new LinkedList<>();

        int i = 1;
        while(i < 10) {

            linkedListAsc.insert(i);
            linkedListDes.insertAtHead(i++);
        }

        linkedListAsc.print();
        //linkedListDes.print();
    }

    public void print() {

        Node tempHead = head;
        while (null != tempHead) {

            System.out.println(tempHead.printableValue);
            tempHead = tempHead.next;
        }
    }

    public static void print(LinkedList list) {

        Node tempHead = list.head;
        while (null != tempHead) {

            System.out.println(tempHead.printableValue);
            tempHead = tempHead.next;
        }
    }

    public static LinkedList<Integer> generateBasicList() {

        LinkedList linkedList = new LinkedList();
        Integer i = 1;

        while(i < 10) {
            linkedList.insert(i++);
        }

        return linkedList;
    }

    public static LinkedList<Integer> generateBasicList(Integer a, Integer b) {

        LinkedList linkedList = new LinkedList();
        int i = a;

        while(i <= b) {
            linkedList.insert(i++);
        }

        return linkedList;
    }
}
