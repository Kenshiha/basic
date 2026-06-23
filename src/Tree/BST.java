package Tree;

public class BST {
    private TreeNode root;
    private int size;

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    BST(){
        root = null;
        size = 0;
    }

    public void insert(int val){
        //logic for inserting value into tree
        TreeNode newNode = new TreeNode(val);

        if(root == null){
            root = newNode;
            return;
        } else if (root.val >= newNode.val) {
            root.left = newNode;
        }

    }

    public void display(TreeNode root){
        if(root == null){
            return;
        }

        display(root.left);
        System.out.print(root.val + " ");
        display(root.right);
    }

    public static void main(String[] args){

        BST myTree = new BST();

//        myTree.insert(5);
//        myTree.insert(4);
//        myTree.insert(3);
//        myTree.display(myTree.root);

    }
}
