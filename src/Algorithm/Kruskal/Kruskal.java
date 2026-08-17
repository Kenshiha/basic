package Algorithm.Kruskal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Edge implements Comparable<Edge>{
    int src;
    int dest;
    int weight;

            Edge(int src, int dest, int weight){
                this.src = src;
                this.dest = dest;
                this.weight = weight;
            }

            @Override
            public int compareTo(Edge other){
                return Integer.compare(this.weight, other.weight);
            }
}

class Graph{
    ArrayList<Edge> edges;

        Graph(){
            edges = new ArrayList<>();
        }

        void addEdge(int src, int dest, int weight){
            edges.add(new Edge(src, dest, weight));
        }
}

class Disjoint{

    int[] parent;

        Disjoint(int n){
            parent = new int[n];
        }

        int find(int x){
            if(parent[x] == x){
                return x;
            }
            return find(parent[x]);
        }

        void union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);

            if(rootA != rootB){
                parent[rootB] = rootA;
            }
        }
}
public class Kruskal {

    static void kruskal(Graph graph, int vertices){

        Collections.sort(graph.edges);
        Disjoint ds = new Disjoint(vertices);
        int totalWeight = 0;

        for(Edge edge : graph.edges){
            if(ds.find(edge.src) != ds.find(edge.dest)){
                ds.union(edge.src, edge.dest);

                totalWeight += edge.weight;

                System.out.println(edge.src + " " + edge.dest + " " + edge.weight);
            }
        }

        System.out.println("Total Weight = " + totalWeight);

    }

        public static void main(String[] args){
            Graph g = new Graph();

            g.addEdge(0,1,2);
            g.addEdge(2,3,3);
            g.addEdge(1,2,4);
            g.addEdge(0,3,5);
            g.addEdge(2,4,2);
            kruskal(g,5);

        }
}
