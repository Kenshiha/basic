package Disjoint;

public class DSU {

    int[] parent;

    DSU(int n){
        parent = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    int find(int x){
        if(parent[x] == x){
            return x;
        }
        return find(parent[x]);
    }

    void  union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }

    public static void main(String[] args){

    }
}
