import java.util.*;

public class AdjMatrixExample {

    public static void main(String[] args){

        int n = 7;
        int edges[][] = {{0, 2}, {1, 2}, {2, 3}, {3, 4}, {1, 4}, {0, 1} ,{5, 6}};

        System.out.println(Arrays.deepToString(edges));
        System.out.println();

        int[][] adjMat = new int[n][n];

        for(int i=0; i<edges.length; i++){

            int u = edges[i][0];
            int v = edges[i][1];

            adjMat[u][v]=1;
            adjMat[v][u]=1;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                System.out.print(adjMat[i][j] +" ");
            }
            System.out.println();
        }


    }

}
