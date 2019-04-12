public class EnhancePrintableValue<T>{

    public static void main(String args[]) {

        LinkedList linkedList = new LinkedList();

        LinkedList.Node tempHead = null;
        int i = 1;

        while(i < 10) {

            linkedList.insert(i++);

            /*
            LOGIC 1: Filling printableValue on creation

            if(null == tempHead && null != linkedList.head)
            {
                tempHead = linkedList.head;
                tempHead.printableValue = getPrintableValue(tempHead.value);
            }
            else
            {
                tempHead = tempHead.next;
                tempHead.printableValue = getPrintableValue(tempHead.value);
            }
            */
        }

        //LOGIC 2: Filling printableValue after creation of LinkedList
        tempHead = linkedList.head;
        while (null != tempHead)
        {
            tempHead.printableValue = getPrintableValue(tempHead.value);
            tempHead = tempHead.next;
        }

        linkedList.print();
    }

    /**
     * Test method for generating printable values other than toString() ones
     * @param value
     * @return
     */
    public static String getPrintableValue(Object value) {

        if(value instanceof Integer == false)
            return "";

        Integer intValue = (Integer) value;
        if(intValue == 2)
            return "Two";

        else if(intValue == 1)
            return "One";

        else if(intValue%2 == 0)
            return intValue + " is Even";

        else if(intValue%2 != 0)
            return intValue + " is Odd";

        else
            return intValue.toString();

    }
}
