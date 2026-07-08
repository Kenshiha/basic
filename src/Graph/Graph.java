package Graph;

import java.util.ArrayList;

public class Graph {

    public void main(String[] args){

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < 5;i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
    }
}
