import java.util.ArrayList;
import java.util.HashMap;

public class cycleDir {
    public static void main(String[] args){

        int n = 4;
//     //   int edges[][] = {{0, 2}, {1, 2}, {2, 3}, {3, 4}, {1, 4}, {0, 1} ,{5, 6}};
        int edges[][] = {{1,2} ,{1,3}, {2,4} , {3,4}};

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


        boolean visited[] = new boolean[n+1];
        String res = "No";
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                ArrayList<Integer> temp= new ArrayList<>();
                if(dfsCyc(i,adjList,temp,visited)){
                    res="Yes";
                    break;
                }
            }
        }

        System.out.println(res);

    }

    private static boolean dfsCyc(int i, HashMap<Integer, ArrayList<Integer>> adjList, ArrayList<Integer> temp, boolean[] visited) {
        visited[i] = true;
        temp.add(i);
        if(adjList.get(i)==null) return false;
        for(Integer x:adjList.get(i)){
            if(!visited[x]){
                if(dfsCyc(x,adjList,temp,visited)){
                    return true;
                }
            }
            if(temp.contains(x)){
                return true;
            }
        }
        return false;
    }


}
