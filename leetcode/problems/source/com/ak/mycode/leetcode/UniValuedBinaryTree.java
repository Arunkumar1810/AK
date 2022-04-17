package com.ak.mycode.leetcode;

public class UniValuedBinaryTree {

    public static void main(String[] args) {

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class Solution {
        public boolean isUnivalTree(TreeNode root) {
            if (root == null) return true;
            return isUnivalTree(root, root.val);
        }

        public boolean isUnivalTree(TreeNode node, int val) {
            if (node == null) return true;
            if (node.val == val) {
                if (isUnivalTree(node.left, val)) {
                    return isUnivalTree(node.right, val);
                }
                return false;
            }
            return false;
        }
    }

}
