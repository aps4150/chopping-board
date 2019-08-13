//class GFG {
//
//    static class P {}
//
//    static class C extends P{}
//
//    public static void Xmain (String[] args) {
//
//        P obj = new C();
//        /**
//        * Below is not possible
//        * C objc = new P();
//        */
//    }
//
//
//    // function to maximize the sum
//    static int maximize(int a[], int n) {
//        // stores the pre sum
//        int presum[] = new int[n];
//
//        // to store sum from 0 to i
//        int sum = 0;
//
//        // stores the maximum sum with
//        // prefix multiplication with -1.
//        int max_sum = 0;
//
//        // traverse from 0 to n
//        for (int i = 0; i < n; i++) {
//            // calculate the presum
//            presum[i] = max_sum;
//
//            // calculate sum
//            max_sum += a[i];
//            sum += a[i];
//
//            max_sum = Math.max(max_sum, -sum);
//        }
//
//        // Initialize answer.
//        int ans = Math.max(sum, max_sum);
//
//        // traverse from back to start
//        int g = 0;
//        for (int i = n - 1; i >= 0; --i) {
//            // stores the sum multiplied by (-1)
//            g -= a[i];
//
//            // stores the max of ans and
//            // presum + (-1*negative sum);
//            ans = Math.max(ans, g + presum[i]);
//        }
//
//        // returns answer
//        return ans;
//    }
//
//    // driver program to test the above function
//    public static void main(String args[]) {
//
//        //int a[] = {-4, 2, 0, 5, 0};
//        int a[] = {-1, 10, -5, 10, -2};
//        int n = a.length;
//        System.out.println(maximize(a, n));
//    }
//
//
//}


//import java.util.*;
//
//class GFG
//{
//    public static void main (String[] args) {
//        TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
//        tm.put("First", 1);
//        tm.put("Second", 2);
//        tm.put("Third", 3);
//
//        for(Map.Entry itr: tm.entrySet())
//            System.out.println(itr.getKey() + " " + itr.getValue());
//
//        TreeMap<Character, Integer> obj = new TreeMap<>();
//        obj.put('A', 1);
//        obj.put('B', 2);
//        obj.put('C', 3);
//        System.out.println(obj.entrySet());
//
//        //ArrayList<String> x = new ArrayList<>(5);
//
//    }
//
//    public static void main4 (String[] args) {
//
//        TreeSet<Integer> ts = new TreeSet<Integer>();
//        ts.add(6);
//        ts.add(5);
//        ts.add(7);
//        ts.add(8);
//        ts.add(1);
//        ts.add(2);
//
//        TreeSet<Integer> hdset = new TreeSet<Integer>();
//        hdset = (TreeSet<Integer>)ts.headSet(6);
//        Iterator itr = hdset.iterator();
//        while(itr.hasNext())
//        {
//            System.out.print(itr.next() + " ");
//        }
//    }
//    public static void main3 (String[] args) {
//        LinkedHashSet<Integer> lhs =new LinkedHashSet<Integer>();
//        lhs.add(3);
//        lhs.add(4);
//        lhs.add(3);
//        lhs.add(5);
//        lhs.add(4);
//        lhs.add(6);
//        lhs.remove(4);
//
//        Iterator itr = lhs.iterator();
//        while(itr.hasNext())
//        {
//            System.out.print(itr.next() + " ");
//        }
//    }
//    public static void main2 (String[] args) {
//        TreeSet<Integer> ts = new TreeSet<Integer>();
//        ts.add(6);
//        ts.add(5);
//        ts.add(7);
//        ts.add(8);
//        ts.add(1);
//        ts.add(2);
//
//        TreeSet<Integer> tlset = new TreeSet<Integer>();
//        tlset = (TreeSet<Integer>)ts.tailSet(5);
//        Iterator itr = tlset.iterator();
//        while(itr.hasNext())
//        {
//            System.out.print(itr.next() + " ");
//        }
//    }
//
//}

//import java.util.ArrayList;
//import java.util.Deque;
//import java.util.Iterator;
//import java.util.LinkedList;
//
//class GFG
//{
//    public static void main (String[] args) {
//
//        Deque<Integer> deq = new LinkedList<Integer>();
//        deq.push(3);
//        deq.push(4);
//        deq.push(5);
//        System.out.println(deq.pop() + " " + deq.size());
//        System.out.println(deq.peek() + " " + deq.size());
//
//        deq = new LinkedList<Integer>();
//        deq.push(3);
//        deq.push(4);
//        deq.push(5);
//
//        Iterator itr = deq.descendingIterator();
//        while(itr.hasNext())
//        {
//            System.out.print(itr.next() + " ");
//        }
//
//        deq = new LinkedList<Integer>();
//        deq.push(3);
//        deq.push(4);
//        deq.push(5);
//        System.out.print(deq.peek() + " " + deq.contains(5));
//    }
//
//    static void builder(ArrayList<Integer> arr)
//    {
//        for(int i=1; i<arr.size(); i++)
//        {
//            if(arr.get(i)>arr.get(i-1))
//            {
//                arr.set(i, arr.get(i-1));
//            }
//            System.out.print(arr.get(i);
//        }
//    }
//
//}

//class GFG
//{
//    public static void main (String[] args) {
//
//        Deque<Integer> deq = new LinkedList<Integer>();
//        deq.add(3);
//        deq.add(4);
//
//        Iterator itr = deq.iterator();
//        while(itr.hasNext())
//        {
//            System.out.print(itr.next() + " ");
//        }
//        System.out.println();
//        deq.push(2);
//        deq.push(1);
//
//        Iterator itr1 = deq.iterator();
//        while(itr1.hasNext())
//        {
//            System.out.print(itr1.next() + " ");
//        }
//
//    }
//}

//class GFG
//{
//    public static void main (String[] args)
//    {
//        ArrayList <String> list = new ArrayList<>();
//        list.add("geeks");
//        list.add("for");
//        list.add("geeks");
//        System.out.print(Collections.frequency(list, "geeks"));
//
//
//        list = new ArrayList<>();
//        list.add("geeks");
//        list.add("for");
//        list.add("geeks");
//        Collections.sort(list);
//        System.out.print(list);
//
//        ArrayList <Integer> arrayListlist = new ArrayList<>();
//        arrayListlist.add(3);
//        arrayListlist.add(5);
//        arrayListlist.add(2);
//        arrayListlist.add(1);
//        arrayListlist.add(6);
//        System.out.print(Collections.binarySearch(arrayListlist, 2) + " ");
//        Collections.sort(list);
//        System.out.print(Collections.binarySearch(arrayListlist, 2));
//    }
//}


import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

class GFG
{
    public static Comparator customComparator = new Comparator<Test>() {

        @Override
        public int compare(Test e1, Test e2) {
            return e2.x-e1.x;
        }
    };

    public static void main (String[] args)
    {
        PriorityQueue <Integer> pq  = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(6);
        pq.add(5);
        pq.offer(3);
        pq.offer(4);

        //System.out.print(pq.peek() + " " + pq.size());

        TreeSet<Test> t= new TreeSet<>(customComparator);
        t.add(new Test(5123));
        t.add(new Test(5456));

        t.stream().forEach(i-> System.out.println(i.x));
    }


}

//import java.math.BigInteger;
//class GFG
//{
//    public static void main (String[] args)
//    {
//        int n = 19, n2 = 23;
//        BigInteger val = BigInteger.valueOf(n);
//        BigInteger val2 = BigInteger.valueOf(n2);
//        System.out.print(val.compareTo(val2));
//    }
//}
//import java.math.*;
//
//class GFG
//{
//    public static void main (String[] args)
//    {
//        int n = 19;
//        BigInteger val = BigInteger.valueOf(n);
//        System.out.println(val.nextProbablePrime());
//    }
//}

//import java.math.*;
//
//public class GFG {
//
//    public static void main(String[] args)
//    {
//        BigInteger biginteger = new BigInteger("16");
//        System.out.println(biginteger.bitLength());
//    }
//}

//import java.math.BigInteger;
//
//class GFG
//{
//    static boolean checkPrime(long n)
//    {
//        BigInteger b = new BigInteger(String.valueOf(n));
//        return b.isProbablePrime(1);
//    }
//    public static void main (String[] args)
//    {
//        long n = 17;
//        System.out.println(checkPrime(n));
//    }
//}

//import java.math.BigInteger;
//class GFG
//{
//    public static void main (String[] args)
//    {
//        int x = 44;
//        BigInteger A = BigInteger.valueOf(x);
//        System.out.print(A.bitCount()); // line 1
//    }
//}

//import java.math.BigInteger;
//class GFG
//{
//    public static void main (String[] args)
//    {
//        int x = 5, y = 3;
//        BigInteger A = BigInteger.valueOf(x);
//        System.out.print(A.min(BigInteger.valueOf(3))); // line 1
//    }
//}

//
//import java.math.BigInteger;
//class GFG
//{
//    public static void main (String[] args)
//    {
//        int x = 2;
//        BigInteger A = BigInteger.valueOf(x);
//        System.out.print(A.multiply(BigInteger.valueOf(3))); // line 1
//    }
//}

//import java.util.HashSet;
//import java.util.LinkedHashSet;
//
//class Geeks
//{
//    static void findPairs(long arr[],int n,long sum)
//    {
//        boolean shown = false;
//
//        HashSet<Long> set = new LinkedHashSet<>();
//        long c;
//        for(int i=0; i<n; i++)
//        {
//            c = sum - arr[i];
//            if(set.contains(c))
//            {
//                shown=true;
//                System.out.println(c+" "+arr[i]+" "+sum);
//            }
//            else
//            {
//                set.add(arr[i]);
//            }
//        }
//        if(!shown)
//        {
//            System.out.println("-1");
//        }
//    }
//
//    public static void main(String args[])
//    {
//        long arr[] = {1, 2, 3, 4,5};
//        findPairs(arr, 5, 7);
//    }
//}

//class GFG
//{
//    public static void main(String args[])
//    {
//        int x = 5, y = 10;
//        while(y != 0)
//        {
//            int carry = x & y;
//            x = x ^ y;
//            y = carry << 1;
//        }
//        System.out.print(x);
//
//    }
//}

//import java.lang.*;
//class GFG
//{
//    public static void main (String[] args)
//    {
//        int a,b,c;
//        a=4;b=5;c=6;
//        System.out.println((a+a)^(a+b)^(a+c)^(b+a)^(b+b)^(b+c)^(c+a)^(c+b)^(c+c));
//        System.out.println((a+a)^(a+b)^(a+c)^(b+b)^(b+c)^(c+c));
//        System.out.println(a^b^c);
//        System.out.print((a+b)^(a+c)^(b+c));
//    }
//}


//import java.lang.*;
//class GFG
//{
//    public static void main (String[] args)
//    {
//        StringBuffer str1 = new StringBuffer("Fork Java");
//        char ch[] = {'O', 'n', 'l', 'i', 'n','e', ' ', 'C', 'o', 'u', 'r', 's', 'e'};
//        str1.append(ch, 5, 8);
//        System.out.print(str1);
//    }
//}

//class GFG
//{
//    public static void main (String[] args)
//    {
//        int a = 5;
//        int b = 7;
//        int x = a^b;
//        int y = x-a;
//
//        System.out.println(x + " " + y);
//
//        System.out.println("x | a :" + (x | a) );
//        System.out.println("x ^ a :" + (x ^ a) );
//        System.out.println("x & b :" + (x & b) );
//
//    }
//}


//class GFG
//{
//    public static void main (String[] args)
//    {
//        int arr[] = new int[]{2, 9, 8, 4, 6};
//        int i;
//        for(i = 0; i < arr.length; i++)
//        {
//            if(arr[i] == 8)
//                break;
//        }
//        // cout << i << endl;
//        for(int j = i; j < arr.length-1; j++)
//        {
//            arr[j] = arr[j+1];
//        }
//        for(int k = 0; k < arr.length; k++)
//            System.out.print(arr[k] + " ");
//
//    }
//}

//class GFG
//{
//    public static void main (String[] args)
//    {
//        int a[] = {2, 9, 8, 4, 6, 1, 7, 5, 3, 0};
//        //System.out.println("i\ti/2\ti/3\t\ta[i/3]\ta[i/3]/3\ta[a[i/3]/3]\ta[a[i/3]/3]/3\ta[a[a[i/3]/3]/3]\n");
//        for(int i = 0; i < a.length; i++)
//        {
//            //System.out.println(i+"\t"+i/2+"\t"+i/3+"\t\t"+a[i/3]+"\t\t"+a[i/3]/3+"\t\t\t"+a[a[i/3]/3]+"\t\t\t"+a[a[i/3]/3]/3+"\t\t\t\t"+a[a[a[i/3]/3]/3]);
//            a[i/2] = a[a[a[i/3]/3]/3];
//        }
//
//        System.out.print("\n\n");
//        for(int i = 0; i < a.length; i++)
//            System.out.print(a[i] + " ");
//
//    }
//}

//class GFG
//{
//    public static void main(String args[])
//    {
//        int arr[2];
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//    }
//}

//class GFG
//{
//    public static void main(String args[])
//    {
////        int t;
////        System.out.println(t);
//
//        Integer t;
//        System.out.println(t);
//    }
//}

//class GFG
//{
//    public static void main(String args[])
//    {
//        System.out.print(10*20 + "GeeksQuiz");
//        System.out.println("GeeksQuiz" + 10*20);
//
//        for(int i = 0; 0; i++)
//        {
//            System.out.println("Hello");
//            break;
//        }
//
//    }
//}

//public class GFG
//{
//    public static void main(String args[])
//    {
//        int a = 20, b = 10, c = 5;
//        if((a >> 1 == b) && (b << 1 == a))  // line 1
//            System.out.println("Possible");
//        else
//            System.out.println("Not Possible");
//
//        System.out.print(20+ 1.34f + "A" + "B");
//    }
//}

//class GFG {
//    public static void main(String[] args)
//    {
//        int x = 10;
//        if (++x < 10 && (x / 0 > 10)) {
//            System.out.println("Ankit");
//        } else {
//            System.out.println("GEEKS");
//        }
//    }
//}

//
//class GFG
//{
//    public static void main(String args[])
//    {
//        int var1 = 5;
//        int var2 = 6;
//
//        if ((var2 = 1) == var1)
//            System.out.print("true"+var2);
//        else
//            System.out.print(++var2);
//
//    }
//
//}
