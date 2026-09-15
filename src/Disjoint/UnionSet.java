package Disjoint;

public class UnionSet {
    int[] parent;
    int[] rank;

    UnionSet(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
       return parent[x];
    }
    void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB){
            return;
        }
        if(rank[rootA] < rank[rootB]){
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        }else {
            parent[rootB] = rootA;
            rank[rootA]++;

        }
    }


    public static void main(String[] args){
        DSU set = new DSU(5);
        set.union(0,1);
        set.union(2,3);
        set.union(0,4);
    }
}
