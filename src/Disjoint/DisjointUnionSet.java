package Disjoint;

public class DisjointUnionSet {
    int[] parent;
    int[] rank;

    DisjointUnionSet(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    private int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB){
            return;
        }
        if(rank[rootA] > rank[rootB]){
            parent[rootB] = rootA;
        } else if (rank[rootB] > rank[rootA]) {
            parent[rootA] = rootB;
        }else{
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }
}
