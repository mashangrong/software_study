package tree;

import util.TreeNode;

public class InvertTree {
    /**
     * 这是一道很经典的二叉树问题。显然，我们从根节点开始，递归地对树进行遍历，并从叶子节点先开始翻转。
     * 如果当前遍历到的节点root 的左右两棵子树都已经翻转，那么我们只需要交换两棵子树的位置，
     * 即可完成以root 为根节点的整棵子树的翻转。
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
