import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int bst(int[] nums,int target){

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int middle = left + ( right - left) / 2;

            if(nums[middle] == target){
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            }else {
                left = middle + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8};

        int res = bst(nums,3);
        System.out.println(res);
    }
}