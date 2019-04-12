package element;

public class Element {

    Element nextElement;

    Integer value;

    Element(){ this.nextElement = null; }

    Element(Integer value){
        // By default this.nextNode = null;
        this.value = value;
    }
}