import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Amazon_ShortestPathInMatrix
{
    private static  int M = 0;
    private static  int N = 0;

    private static final int row[] = { -1, 0, 0, 1 };
    private static final int col[] = { 0, -1, 1, 0 };

    public static void main(String args[]) throws Exception
    {
        int numRows = 3;
        int numColumns = 3;
        List<List<Integer>> area = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        r1.add(1);
        r1.add(0);
        r1.add(0);

        List<Integer> r2 = new ArrayList<>();
        r2.add(1);
        r2.add(0);
        r2.add(0);

        List<Integer> r3 = new ArrayList<>();
        r3.add(1);
        r3.add(9);
        r3.add(1);

        area.add(r1);
        area.add(r2);
        area.add(r3);

        System.out.println("\nResult:" + minimumDistance(numRows, numColumns, area));
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {
        M = numRows;
        N = numColumns;

        int i =0;
        int j = 0;

        boolean[][] visited = new boolean[M][N];
        Queue<Amazon_ShortestPathInMatrix_Node> q = new ArrayDeque<>();

        // mark source cell as visited and enqueue the source node
        visited[i][j] = true;
        q.add(new Amazon_ShortestPathInMatrix_Node(i, j, 0));

        // stores length of longest path from source to destination
        int min_dist = Integer.MAX_VALUE;

        // run till queue is not empty
        while (!q.isEmpty())
        {
            // pop front node from queue and process it
            Amazon_ShortestPathInMatrix_Node node = q.poll();

            // (i, j) represents current cell and dist stores its
            // minimum distance from the source
            i = node.x;
            j = node.y;
            int dist = node.dist;

            // if destination is found, update min_dist and stop
            if (area.get(i).get(j) == 9)
            {
                min_dist = dist;
                break;
            }

            // check for all 4 possible movements from current cell
            // and enqueue each valid movement
            for (int k = 0; k < 4; k++)
            {
                // check if it is possible to go to position
                // (i + row[k], j + col[k]) from current position
                if (isValid(area, visited, i + row[k], j + col[k]))
                {
                    // mark next cell as visited and enqueue it
                    visited[i + row[k]][j + col[k]] = true;
                    q.add(new Amazon_ShortestPathInMatrix_Node(i + row[k], j + col[k], dist + 1));
                }
            }
        }

        if (min_dist != Integer.MAX_VALUE) {
            System.out.print("The shortest path from source to destination "
                    + "has length " + min_dist);
        }
        else {
            System.out.print("Destination can't be reached from source");
        }

        return min_dist;
    }

    private static boolean isValid(List<List<Integer>> area, boolean visited[][],
                                   int row, int col)
    {
        return (row >= 0) && (row < M) && (col >= 0) && (col < N)
                && (area.get(row).get(col) == 1 || area.get(row).get(col) == 9)
                && !visited[row][col];
    }

    static class Amazon_ShortestPathInMatrix_Node
    {
        // (x, y) represents matrix cell coordinates
        // dist represent its minimum distance from the source
        int x, y, dist;

        Amazon_ShortestPathInMatrix_Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}

/**
* For Matrix instead of List<List<Integer>>
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Amazon_ShortestPathInMatrix
{
    private static  int M = 0;
    private static  int N = 0;

    private static final int row[] = { -1, 0, 0, 1 };
    private static final int col[] = { 0, -1, 1, 0 };

    public static void main(String args[])
    {
        int numRows = 3;
        int numColumns = 3;
        List<List<Integer>> area = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        r1.add(1);r1.add(0);r1.add(0);

        List<Integer> r2 = new ArrayList<>();
        r2.add(1);r2.add(0);r2.add(0);

        List<Integer> r3 = new ArrayList<>();
        r3.add(1);r3.add(9);r3.add(1);

        area.add(r1);area.add(r2);area.add(r3);

        System.out.println("\nResult:" + minimumDistance(numRows, numColumns, area));
    }

    static int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {
        M = numRows;
        N = numColumns;

        int [][] mat = new int [M][N];
        int i =0;
        int j = 0;

        for (int k = 0; k < M; k++) {
            for (int l = 0; l < N; l++) {
                mat[k][l] = area.get(k).get(l);
            }
        }

        boolean[][] visited = new boolean[M][N];
        Queue<Amazon_ShortestPathInMatrix_Node> q = new ArrayDeque<>();

        visited[i][j] = true;
        q.add(new Amazon_ShortestPathInMatrix_Node(i, j, 0));

        int min_dist = Integer.MAX_VALUE;
        while (!q.isEmpty())
        {
            Amazon_ShortestPathInMatrix_Node node = q.poll();
            i = node.x;
            j = node.y;
            int dist = node.dist;

            if (mat[i][j] == 9)
            {
                min_dist = dist;
                break;
            }

            for (int k = 0; k < 4; k++)
            {
                if (isValid(mat, visited, i + row[k], j + col[k]))
                {
                    visited[i + row[k]][j + col[k]] = true;
                    q.add(new Amazon_ShortestPathInMatrix_Node(i + row[k], j + col[k], dist + 1));
                }
            }
        }

        if (min_dist != Integer.MAX_VALUE) {
            return min_dist;
        }
        else {
            return -1;
        }
    }

    private static boolean isValid(int mat[][], boolean visited[][], int row, int col)
    {
        return (row >= 0) && (row < M) && (col >= 0) && (col < N)
                && (mat[row][col] == 1 || mat[row][col] == 9)
                && !visited[row][col];
    }

    static class Amazon_ShortestPathInMatrix_Node
    {
        int x, y, dist;

        Amazon_ShortestPathInMatrix_Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}

**/