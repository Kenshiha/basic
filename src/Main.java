import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public static int BS(int[] arr,int target){
      int left = 0;
      int right = arr.length - 1;
       while(left <= right){

           int m = left + (right - left)/ 2;
           
           if(arr[m] == target){
               return m;
           } else if (arr[m] < target) {
               left = m + 1;
           }else {
               right = m -1;
           }
       }
      
      return -1;
  }
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8};

        int res = BS(nums,3);
        System.out.println(res);
    }
}