import java.lang.reflect.Array;
import java.util.*;

public class GraphExample2 {


    public static void dfs(int node,ArrayList<Integer> temp,HashMap<Integer,ArrayList<Integer>> adjList,boolean[] visited){
//        System.out.println(node);

        visited[node] = true;
        temp.add(node);
        if(adjList.get(node)==null) return;

        for(Integer otherNode:adjList.get(node)){
            if(!visited[otherNode]){
                dfs(otherNode,temp,adjList,visited);
            }
        }
    }







    public static void main(String[] args){
        int n=6;


//        int adjMat[][] = new int[n][n];
//        System.out.println(Arrays.deepToString(edges));
//        //undirected
//        for(int i=0;i<edges.length;i++){
//
//                int u = edges[i][0];
//                int v = edges[i][1];
//
//                adjMat[u][v] = 1;
//                adjMat[v][u] = 1;
//
//        }
//
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(adjMat[i][j]+" ");
//            }
//            System.out.println();
//        }


        int edges[][] = {{0,1},{1,4},{2,3},{3,4},{4,5},{1,2}};

        HashMap<Integer,ArrayList<Integer>> adjList = new HashMap<>();
        for(int i=0;i<edges.length;i++){

            int u = edges[i][0];
            int v = edges[i][1];

            adjList.putIfAbsent(u,new ArrayList<>());
            adjList.get(u).add(v);

//            adjList.putIfAbsent(v,new ArrayList<>());
//            adjList.get(v).add(u);


        }

        for(int key:adjList.keySet()){
            System.out.println(key + " -> " + adjList.get(key));
        }

        boolean[] visited = new boolean[6];

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<6;i++){
            if(!visited[i]) {
                ArrayList<Integer> temp = new ArrayList<>();
                dfs(i, temp, adjList, visited);
                ans.add(temp);
            }


        }


        System.out.println(ans);

//        ArrayList<Integer> ans = new ArrayList<>();
//        Queue<Integer> q = new LinkedList<>();
//        q.add(0);
//        visited[0] = true;
//        int level= 0;
//        while(!q.isEmpty()){
//            int size = q.size();
//            while(size>0 && !q.isEmpty()){
//
//                int node = q.poll();
//                ans.add(node);
//                if(adjList.get(node)==null) continue;
//
//                for(Integer otherNode:adjList.get(node)){
//                    if(!visited[otherNode]){
//                        q.add(otherNode);
//                        visited[otherNode] = true;
//                    }
//                }
//
//
//                size--;
//            }
//            level++;
//        }
//
//        System.out.println(ans);







    }
}

/*




 */