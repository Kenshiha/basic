package Tree;

public class BST {
    private static TreeNode root;
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
        root = insert(root, val);
    }

    private TreeNode insert(TreeNode node, int val){
        if(node == null){
            size++;
            return new TreeNode(val);
        }

        if(val < node.val){
            node.left = insert(node.left,val);
        } else if (val > node.val) {
            node.right = insert(node.right,val);
        }
        return node;
    }

    public void delete(int val){
        root = delete(root, val);
    }

    private TreeNode delete(TreeNode node, int val){
        if(node == null){
            return null;
        }

        if(val < node.val){
            node.left = delete(node.left,val);
        } else if (val > node.val) {
            node.right = delete(node.right, val);
        } else{

            if(node.left == null){
                size--;
                return node.right;
            }
            if(node.right == null){
                size--;
                return node.left;
            }

            TreeNode successor = findMin(node.right);
            node.val = successor.val;
            node.right = delete(node.right, successor.val);
        }

        return node;
    }

    private TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    //new method search BST

    public static boolean search(int val){
           return search(root, val);
    }

    private static boolean search(TreeNode node, int val){
        if (node == null)
            return false;

        if (node.val == val)
            return true;

        if (val < node.val)
            return search(node.left, val);

        return search(node.right, val);

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

        myTree.insert(10);
        myTree.insert(5);
        myTree.insert(3);
        myTree.insert(15);
        myTree.insert(12);
        myTree.insert(20);
        myTree.insert(7);
        myTree.insert(12);
        myTree.delete(15);
        myTree.display(myTree.root);

        System.out.println(search(15));
    }
}
