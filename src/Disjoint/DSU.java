package Disjoint;

public class DSU {

    int[] parent;

        DSU(int n){
            parent = new int[n];
        }

        int find(int x){
            if(parent[x]==x){
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

    public static void main(String[] args){

            DSU set = new DSU(5);

            set.union(0,1);
            set.union(2,3);
    }
}
