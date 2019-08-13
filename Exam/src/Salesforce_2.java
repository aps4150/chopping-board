public class Salesforce_2 {

    public static int fun(int N)
    {

        if(N <=6)
            return N;

        int res = 0;
        int temp;
        for (int i = N-3; i >=1 ; i--) {
            temp = (N-i-1) * fun(i);
            if(temp > res)
                res = temp;
        }
        return res;
    }
}
