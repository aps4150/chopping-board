package easy;

import java.util.LinkedList;
import java.util.Queue;

public class SecondMinimumInBT_671 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String s[]) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(1);

        root.right = new TreeNode(3);
            root.right.left = new TreeNode(3);
            root.right.right = new TreeNode(4);

        System.out.println(findSecondMinimumValue(root));
    }

    public static int findSecondMinimumValue(TreeNode root) {


        if(null == root) { return -1; }

        int result = Integer.MAX_VALUE;
        boolean found = false;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node;

        queue.add(root);
        while (!queue.isEmpty()) {

            node = queue.poll();
            if(null != node && node.val > root.val && node.val <= result)
            {
                result = node.val;
                found = true;
            }

            if(null != node.left)
                queue.add(node.left);
            if(null != node.right)
                queue.add(node.right);
        }

        return (found)?result:-1;
    }


    public int findSecondMinimumValueInBST(TreeNode root) {

        if(null == root) { return 0; }
        int secondMin = root.val;
        while(null != root.left) {
            root = root.left;
        }
        return root.val;
    }
}
