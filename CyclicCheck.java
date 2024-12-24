import java.util.*;

public class CyclicCheck {

    public static boolean cycleCheck(int node, HashMap<Integer, ArrayList<Integer>> adjList, boolean[] visited, boolean[] pathVisited, int parentNode){

        visited[node] = true;
        pathVisited[node] = true;

        if(adjList.get(node) == null) return false;

        for( int othernode : adjList.get(node)) {
           if (!visited[othernode]) {
               if (cycleCheck(othernode, adjList, visited, pathVisited, node)) {
                   return true;
               }
           } else if (pathVisited[othernode]) {
               return true;
           }

            pathVisited[node]= false;
        }
        return false;
    }


    public static void main(String[] args){

        int n = 4;
//     //   int edges[][] = {{0, 2}, {1, 2}, {2, 3}, {3, 4}, {1, 4}, {0, 1} ,{5, 6}};
        int edges[][] = {{1,2} ,{2,3}, {3,4}};

        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<Integer, ArrayList<Integer>>();

        for(int i=0; i<edges.length; i++){

            int u = edges[i][0];
            int v = edges[i][1];

            adjList.putIfAbsent(u,new ArrayList<>());
            adjList.get(u).add(v);

        }

        for(int key: adjList.keySet()) {
            System.out.println(key + "->" + adjList.get(key));
        }

        boolean[] visited = new boolean[n+1];
        int node;
        boolean[] pathVisited = new boolean[n+1];
        boolean ans = false;

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                node = i;
                if(cycleCheck(node, adjList, visited, pathVisited,-1)){
                    ans = true;
                    break;
                }

            }

        }

        System.out.println(ans);
    }

}
