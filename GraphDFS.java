import java.util.*;

public class GraphDFS {

    public static void dfsCode (Integer node,ArrayList<Integer> temp, HashMap<Integer,ArrayList<Integer>> adjList, boolean visited[],Stack<Integer> st){

        visited[node] = true;
        temp.add(node);

        if(adjList.get(node) == null) return;

        for(Integer othernode : adjList.get(node)){
            if(!visited[othernode]){
                dfsCode(othernode, temp, adjList, visited, st);
            }
        }
        st.add(node);
    }

    public static void main(String[] args){

        int n = 7;
        int edges[][] = {{0, 2}, {1, 2}, {2, 3}, {3, 4}, {1, 4}, {0, 1} ,{5, 6}};

        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        for(int i=0; i< edges.length; i++){

            int u = edges[i][0];
            int v = edges[i][1];

            adjList.putIfAbsent(u,new ArrayList<Integer>());
            adjList.get(u).add(v);

//            adjList.putIfAbsent(v,new ArrayList<Integer>());
//            adjList.get(v).add(u);
        }

        for(Integer key : adjList.keySet()){
            System.out.println(key + " -> " + adjList.get(key));
        }

        boolean[] visited = new boolean[n];

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        Stack<Integer> st = new Stack<>();

        for(int i=0 ; i<n ; i++){

            if(!visited[i]){
                ArrayList<Integer> temp = new ArrayList<>();
                dfsCode(i, temp, adjList, visited,st);
                ans.add(temp);
            }

        }

        System.out.println(ans);

    }
}
