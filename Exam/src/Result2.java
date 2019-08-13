public class Result2 {

    public static int count(int a[], int n, int m)
    {
        int p[] = new int[n];

        int count = 0;

        int odd = 0;

        for(int i=0; i<n; i++)
        {
            p[odd]++;

            if((a[i] & 1)==1)
                odd++;

            if(odd >= m)
            {
                count = count+p[odd - m];
            }
        }
        return count;
    }

}
