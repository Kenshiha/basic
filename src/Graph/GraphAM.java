package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphAM {
    int[][] graph;

        GraphAM(int vertices){
            graph = new int[vertices][vertices];
        }

        void addEdge(int u, int v){
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        void removeEdge(int u, int v){
            graph[u][v] = 0;
            graph[u][v] = 0;
         }

         void display(){

            for(int i = 0; i < graph.length; i++){
                for(int j = 0; j < graph.length; j++){
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println();
            }
         }

         void dfs(int vertex, boolean[] visited){
                visited[vertex] = true;
                System.out.print(vertex + " ");

                for(int i = 0; i< graph.length; i++){
                    if(graph[vertex][i] == 1 && !visited[i]){
                        dfs(i,visited);
                    }
                }
         }

         void bfs(int start){
             boolean[] visited = new boolean[graph.length];
             Queue<Integer> queue = new LinkedList<>();

             visited[start] = true;
             queue.offer(start);

             while (!queue.isEmpty()){
                 int vertex = queue.poll();
                 System.out.print(vertex + " ");

                 for(int i = 0; i < graph.length; i++){

                     if(graph[vertex][i] == 1 && !visited[i]){
                         visited[i] = true;
                         queue.offer(i);
                     }
                 }
             }
         }



        public static void main(String[] args){
                GraphAM g = new GraphAM(5);

                g.addEdge(0,1);
                g.addEdge(0,2);
                g.display();

                boolean[] visited = new boolean[g.graph.length];
        }
}
