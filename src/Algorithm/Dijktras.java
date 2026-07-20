package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


class Edge{
    int dest;
    int weight;

    Edge(int dest, int weight){
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph{
     ArrayList<ArrayList<Edge>> adjlst;

     Graph(int vertices){
         adjlst = new ArrayList<>();

         for(int i = 0; i < vertices; i++){
             adjlst.add(new ArrayList<>());
         }
     }

     void addEdge(int src, int dest, int weight){
         adjlst.get(src).add(new Edge(dest,weight));
     }
     void removeEdge(int src, int dest, int weight){
         adjlst.get(src).removeIf(edge -> edge.dest == dest);
     }
 }

 class Pair implements Comparable<Pair> {
    int vertex;
    int distance;

    Pair(int vertex, int distance){
        this.vertex = vertex;
        this.distance = distance;
    }
    @Override
    public int compareTo(Pair other){
        return Integer.compare(this.distance, other.distance);
    }

 }

public class Dijktras {

    static void dijktras(Graph graph,int source){

        int n = graph.adjlst.size();

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[source] = 0;
        pq.add(new Pair(source,0));

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

                if(dist[u] + weight < dist[v]){
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        for(int i = 0; i < n; i++){
            System.out.println("0 -> " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args){

        Graph g = new Graph(6);

        g.addEdge(0,1,7);
        g.addEdge(0,2,4);
        g.addEdge(1,4,9);
        g.addEdge(2,3,6);
        g.addEdge(3,5,2);
        g.addEdge(4,5,5);

        dijktras(g,0);
    }
}
