import java.lang.reflect.Field;

public class Reflection {

    public static void main(String s[])
    {
        Class c = Graph.class;

        Field[] f = c.getFields();

        //Field fName = c.getField("vertices");

        for(Class x: c.getClasses()) {

            System.out.println(x.getName());

        }

    }
}
