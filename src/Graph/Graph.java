package Graph;

import java.util.ArrayList;

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
        graph.get(v).remove(Integer.valueOf(v));
    }


    public void main(String[] args){

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < 5;i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
    }
}
