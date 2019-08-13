import java.util.stream.Stream;

public class testAtring {

    public static void main(String x[])
    {
        Stream.of(10,20,30,40,50)
        .filter(i->i>30)
        .peek(System.out::print)
        .findFirst()
        .orElse(null);

        //FileNotFoundException
    }
//    public static void main(String x[])
//    {
//
//        String s1= "sleep";
//        String s2= fix(s1);
//        System.out.println(s1+" "+s2);
//    }

    private static String fix(String s1) {

        s1= s1+"stream";

        System.out.print(s1+" ");
        return "steem";
    }
}
