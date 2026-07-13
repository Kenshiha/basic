package Graph;

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



        public static void main(String[] args){
                GraphAM g = new GraphAM(5);

                g.addEdge(0,1);
                g.addEdge(0,2);
                g.display();
        }
}
