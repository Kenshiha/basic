package Algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Prim {

    static void prim(Graph graph){

        int n = graph.adjlst.size();

        int[] key = new int[n];
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        Arrays.fill(key,Integer.MAX_VALUE);
        int[] parent = new int[n];
        Arrays.fill(parent,-1);

        key[0] = 0;
        pq.add(new Pair(0,0));

        while (!pq.isEmpty()){

            Pair current = pq.poll();
            int u = current.vertex;

            if(visited[u]){
                continue;
            }
            visited[u] = true;

            for(Edge edge : graph.adjlst.get(u)){
                int v = edge.dest;
                int weight = edge.weight;

                if(!visited[v] && weight < key[v]){
                    key[v] = weight;
                    parent[v] = u;
                    pq.add(new Pair(v, key[v]));
                }
            }
        }
    }

    public static void main(String[] args){

    }
}
