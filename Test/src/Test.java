import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Test {

    int x;

    Test(int x) {
        this.x = x;
    }

    static int findMaxLen(String str) {
        int n = str.length();

        // Create a stack and push -1 as initial index to it.
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);

        // Initialize result
        int result = 0;

        // Traverse all characters of given string
        for (int i = 0; i < n; i++) {
            // If opening bracket, push index of it
            if (str.charAt(i) == '(')
                stk.push(i);

            else // If closing bracket, i.e.,str[i] = ')'
            {
                // Pop the previous opening bracket's index
                stk.pop();

                // Check if this length formed with base of
                // current valid substring is more than max
                // so far
                if (!stk.empty())
                    result = Math.max(result, i - stk.peek());

                    // If stack is empty. push current index as
                    // base for next valid substring (if any)
                else stk.push(i);
            }
        }

        return result;
    }

    // Driver method
    public static void main(String[] args) {
        String str = "()(()))(()())((()))(((";
        System.out.println(findMaxLen(str));

        str = "((()()";
        //System.out.println(findMaxLen(str));

        str = "()(()))))";
        //System.out.println(findMaxLen(str));

    }

    public static void Xmain(String s[]) throws Exception {

        List<FileObject> l1 = null;
        process(l1);

        List<FileObject> l2 = Arrays.asList(new File(), new Directory());
        process(l2);

        List<? extends FileObject> l3 = l2;
        process(l3);

        l3 = null;
        process(l3);

    }

    static void process(List<? extends FileObject> fileObjects){}
}

interface FileObject {}

class File implements FileObject{}
class Directory implements FileObject{}

//        Class c = java.util.TreeMap.class;
//        System.out.println(c.getDeclaredClasses());
//        //System.out.println(c.getAll);
//        System.out.println(c.getClasses());

//try{
// throw new RuntimeException();
//}
//finally {
//    System.out.println("in finally");
//}


//    public static void main(String s[])throws Exception{
//
//        Integer i = 200;
//        Integer j = 200;
//        System.out.println(i==j);
//        System.out.println(i.equals(j));
//
//    }

    /**
     * public static void main(String s[])throws Exception{
     *
     *         Class cls = Class.forName("Test");
     *         Test test = (Test)cls.newInstance();
     *
     *         System.out.println(test.getClass().getName());
     *     }
     */

    /**
     * public static void main(String s[])throws Exception{
     *
     *         String s1 = "";
     *         System.out.println(Class.forName("String").forName(s1));
     *     }
     */
