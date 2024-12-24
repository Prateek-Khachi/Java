import java.util.*;
import java.lang.reflect.Array;


public class GraphBFS {

    public static void  main(String[] args) {

        int n = 7;
        int edges[][] = {{0, 2}, {1, 2}, {2, 3}, {3, 4}, {1, 4}, {0, 1} ,{5, 6}};


        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(v);

            adjList.putIfAbsent(v,new ArrayList<>());
            adjList.get(v).add(u);

        }
        System.out.println(adjList.keySet().size());
        for (int key : adjList.keySet()) {
            System.out.println(key + "->" + adjList.get(key));
        }


       ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ansS = new ArrayList<>();

        boolean[] visited = new boolean[n];
        int level = 0;
        Queue<Integer> q = new LinkedList<>();

       for (int i = 0; i < n; i++) {
           if (visited[i] && i!=0) {
               continue;
           } else {
               q.add(i);
               visited[i] = true;
           }



           while (!q.isEmpty()) {
               int size = q.size();

               while (size > 0 && !q.isEmpty()) {

                   Integer node = q.poll();

                   ansS.add(node);

                   if (adjList.get(node) == null) {
                       continue;
                   }

                   for (Integer othernode : adjList.get(node)) {

                       if (!visited[othernode]) {
                           q.add(othernode);
                           visited[othernode] = true;
                       }

                   }

                   size--;
               }

               level++;

           }

           System.out.println(ansS);
           ans.add((ArrayList<Integer>) ansS.clone());
           ansS.clear();

//           ans.add(new ArrayList<>(ansS));

       }

       System.out.println(ans);


    }
}

