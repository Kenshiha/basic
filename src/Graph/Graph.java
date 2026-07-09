package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    ArrayList<ArrayList<Integer>> graph;

    Graph(int vertices){
        graph = new ArrayList<>();

        for(int i = 0; i < vertices; i++){
            graph.add(new ArrayList<>());
        }
    }

    // Two Way connection
    void addEdges(int u,int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    void removeEdge(int u, int v){
        graph.get(u).remove(Integer.valueOf(v));
        graph.get(v).remove(Integer.valueOf(u));
    }
    void printGraph(){

        for(int i = 0; i < graph.size();i++){
            System.out.println(i + "-->" + graph.get(i));
        }
    }
    void dfs(int vertex, boolean[] visited){
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for(int neighbor : graph.get(vertex)){
            if(!visited[neighbor]){
                dfs(neighbor,visited);
            }
        }

    }

    void bfs(int start){
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()){
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for(int neighbor : graph.get(vertex)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args){

        Graph g = new Graph(5);

        g.addEdges(0, 1);
        g.addEdges(0, 2);
        g.addEdges(1, 3);
        g.addEdges(2, 4);

        g.printGraph();
        boolean[] visited = new boolean[g.graph.size()];
        g.dfs(0,visited);
    }
}
