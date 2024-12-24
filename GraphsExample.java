import java.lang.reflect.Array;
import java.util.*;

public class GraphsExample {


    public static boolean dfs(int node,HashMap<Integer,ArrayList<Integer>> adjList,boolean[] visited,int parent){
//        System.out.println(node);

        visited[node] = true;

        if(adjList.get(node)==null) return false;

        for(Integer otherNode:adjList.get(node)){
            if(!visited[otherNode]){
                if(dfs(otherNode,adjList,visited,node)==true){
                    return true;
                }
            }
            else if(otherNode!=parent){
                return true;
            }
        }

        return false;
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


        int edges[][] = {{0,1},{1,4},{2,3},{3,4},{4,5}};

        HashMap<Integer,ArrayList<Integer>> adjList = new HashMap<>();
        for(int i=0;i<edges.length;i++){

            int u = edges[i][0];
            int v = edges[i][1];

            adjList.putIfAbsent(u,new ArrayList<>());
            adjList.get(u).add(v);

            adjList.putIfAbsent(v,new ArrayList<>());
            adjList.get(v).add(u);


        }

//        for(int key:adjList.keySet()){
//            System.out.println(key + " -> " + adjList.get(key));
//        }
//
//        boolean[] visited = new boolean[6];
//
//        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
//        for(int i=0;i<6;i++){
//            if(!visited[i]) {
//                ArrayList<Integer> temp = new ArrayList<>();
//                dfs(i, temp, adjList, visited);
//                ans.add(temp);
//            }
//
//
//        }
//
//
//        System.out.println(ans);

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

        //cycle detection
        boolean[] visited = new boolean[n+1];
        boolean f = false;
        for(int i=0;i<6;i++){
            if(!visited[i]){
                if(dfs(i,adjList,visited,-1)){
                    f=true;
                    System.out.println("Cycle Exists");
                    break;
                }
            }
        }

        if(!f){
            System.out.println("Cycle Doesn't Exist");
        }







    }
}

/*

 1--------------2


*/