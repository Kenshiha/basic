package Tree;

public class Tree {
   private  TreeNode root;
   private int size;
   private int loop;

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    Tree(){
        root = null;
        size = 0;
        loop= 1;
    }
    public void inorder(TreeNode root){              // left -> root -> right

        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);

       // System.out.println("Iteration = " + loop++);

        //System.out.println();
    }

    public void preOrder(TreeNode root){          //root -> left -> right

        if(root == null){
            return;
        }

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
       // System.out.println();
    }

    public  void postOrder(TreeNode root){          // left -> right -> root
        if(root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    public int bst(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int m = left + (right - left) / 2;

            if(arr[m] == target){
                return m;
            } else if (arr[m] < target) {
                left = m+1;
            }else{
                right = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){

        Tree myTree = new Tree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        myTree.inorder(root);
        myTree.preOrder(root);
        myTree.postOrder(root);

        int[] arr = {1,2,3,4,5,6,7,8,9};
        int ans = myTree.bst(arr,9);
        System.out.println(ans);

    }
}
