public class Patterns {

    public static void p1(int n){

        for(int i = 0; i <= n; i++ ){
            //System.out.println(i);
            for(int j = i; j <= n; j++){
                //System.out.print( i+" ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args){

        p1(5);
    }
}
