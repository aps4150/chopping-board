package medium;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestInBST_230 {

    ArrayList<Integer> inorder = new ArrayList<>();

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {

        populateInorder(root,k);
        return inorder.get(k-1);
    }

    public void populateInorder(TreeNode root, int k) {

        if(null == root) { return; }

        populateInorder(root.left, k);
        inorder.add(root.val);
        if(inorder.size() < k )
        populateInorder(root.right, k);
    }

    public void populateInorderIterative(TreeNode root, int k) {

        if (root == null || k == 0)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || stack.size() > 0)
        {

            while (current !=  null)
            {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            k--;
            inorder.add(current.val);

            current = current.right;
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || stack.size() > 0)
        {

            while (current !=  null)
            {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();

            result.add(current.val);

            current = current.right;
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if(null == root) { return result; }

        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);

        return result;
    }

    public static void main(String s[]) {

        //TreeNode a = new TreeNode(1);
    }
}
