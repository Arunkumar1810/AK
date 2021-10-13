package com.ak.mycode.leetcode.top100liked;

//https://leetcode.com/problems/maximum-depth-of-binary-tree
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        TreeNode root = maximumDepthOfBinaryTree.addElement(new Integer[]{0},0);
        System.out.println("Max Depth : "+maximumDepthOfBinaryTree.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if(root!=null) {
            return Integer.max(maxDepth(root.left),maxDepth(root.right)) +1;
        }
        return 0;
    }

    public class TreeNode {
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

    public TreeNode addElement(Integer[] arr, int index) {
        if(index<arr.length && arr[index]!=null) {
            return new TreeNode(arr[index], addElement(arr, index * 2 + 1), addElement(arr, index * 2 + 2));
        }
        return null;
    }
}
