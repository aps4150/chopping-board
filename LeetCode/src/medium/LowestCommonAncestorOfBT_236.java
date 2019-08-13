package medium;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LowestCommonAncestorOfBT_236 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String s[])
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
            root.left.left = new TreeNode(6);
            root.left.right = new TreeNode(2);

        root.right = new TreeNode(1);
            root.right.left = new TreeNode(0);
            root.right.right = new TreeNode(8);

        System.out.println(lowestCommonAncestor(root, root.left, root.right).val);
    }

    /**
     * 1 THIS IS THE FASTEST ONE
     */

    static TreeNode LCA;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        backtrackNodeFinder(root, p, q);
        return LCA;
    }

    private static boolean backtrackNodeFinder(TreeNode currentNode, TreeNode p, TreeNode q) {

        if (currentNode == null) {
            return false;
        }

        int right = 0;

        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        int left = backtrackNodeFinder(currentNode.left, p, q) ? 1 : 0;

        if(mid + left < 2) {
            right = backtrackNodeFinder(currentNode.right, p, q) ? 1 : 0;
        }

        if (mid + left + right >= 2) {
            LCA = currentNode;
        }

        return (mid + left + right > 0);
    }

    /**
     * 2
     */

    // Three static flags to keep track of post-order traversal.

    // Both left and right traversal pending for a node.
    // Indicates the nodes children are yet to be traversed.
    private static int BOTH_PENDING = 2;

    // Left traversal done.
    private static int LEFT_DONE = 1;

    // Both left and right traversal done for a node.
    // Indicates the node can be popped off the stack.
    private static int BOTH_DONE = 0;

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        Stack<Pair<TreeNode, Integer>> stack = new Stack<Pair<TreeNode, Integer>>();

        // Initialize the stack with the root node.
        stack.push(new Pair<TreeNode, Integer>(root, LowestCommonAncestorOfBT_236.BOTH_PENDING));

        // This flag is set when either one of p or q is found.
        boolean one_node_found = false;

        // This is used to keep track of the LCA.
        TreeNode LCA = null;

        // Child node
        TreeNode child_node = null;

        // We do a post order traversal of the binary tree using stack
        while (!stack.isEmpty()) {

            Pair<TreeNode, Integer> top = stack.peek();
            TreeNode parent_node = top.getKey();
            int parent_state = top.getValue();

            // If the parent_state is not equal to BOTH_DONE,
            // this means the parent_node can't be popped off yet.
            if (parent_state != LowestCommonAncestorOfBT_236.BOTH_DONE) {

                // If both child traversals are pending
                if (parent_state == LowestCommonAncestorOfBT_236.BOTH_PENDING) {

                    // Check if the current parent_node is either p or q.
                    if (parent_node == p || parent_node == q) {

                        // If one_node_found was set already, this means we have found
                        // both the nodes.
                        if (one_node_found) {
                            return LCA;
                        } else {
                            // Otherwise, set one_node_found to True,
                            // to mark one of p and q is found.
                            one_node_found = true;

                            // Save the current top element of stack as the LCA.
                            LCA = stack.peek().getKey();
                        }
                    }

                    // If both pending, traverse the left child first
                    child_node = parent_node.left;
                } else {
                    // traverse right child
                    child_node = parent_node.right;
                }

                // Update the node state at the top of the stack
                // Since we have visited one more child.
                stack.pop();
                stack.push(new Pair<TreeNode, Integer>(parent_node, parent_state - 1));

                // Add the child node to the stack for traversal.
                if (child_node != null) {
                    stack.push(new Pair<TreeNode, Integer>(child_node, LowestCommonAncestorOfBT_236.BOTH_PENDING));
                }
            } else {

                // If the parent_state of the node is both done,
                // the top node could be popped off the stack.
                // Update the LCA node to be the next top node.
                if (LCA == stack.pop().getKey() && one_node_found) {
                    LCA = stack.peek().getKey();
                }

            }
        }

        return null;
    }

    /**
     * 3
     */

     public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null)
            return root;

        List<TreeNode> pathToP = find(root, p);
        List<TreeNode> pathToQ = find(root, q);

        int pI = pathToP.size()-1;
        int qI = pathToQ.size()-1;
        TreeNode LCA = null;

        while (pI>=0 && qI>=0)
        {
            if(pathToP.get(pI).equals(pathToQ.get(qI)))
            {
                LCA = pathToP.get(pI);
            }
            pI--;
            qI--;
        }

        return LCA;
    }

    private static ArrayList<TreeNode> find(TreeNode currentNode, TreeNode targetNode) {

        if(null == currentNode)
        {
            return null;
        }
        if(currentNode == targetNode)
        {
            ArrayList<TreeNode> path = new ArrayList<>();
            path.add(targetNode);
            return path;
        }

        ArrayList<TreeNode> leftPath = find(currentNode.left, targetNode);

        ArrayList<TreeNode> rightPath = (null == leftPath || leftPath.size() == 0)?find(currentNode.right, targetNode):null;
        ArrayList<TreeNode> resultPath = new ArrayList<>();

        if(null != leftPath && leftPath.size() != 0)
        {
            resultPath = leftPath;
        }
        if(null != rightPath && rightPath.size() != 0)
        {
            resultPath = rightPath;
        }

        if(resultPath.size()!=0)
            resultPath.add(currentNode);
        return resultPath;
    }
}
