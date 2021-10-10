package com.ak.mycode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {
    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode root = invertBinaryTree.addElement(new Integer[]{4, 2, 7, 1, 3, 6, 9}, 0);
        root = invertBinaryTree.invertTree(root);
        invertBinaryTree.printElements(root);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (root.left != null) invertTree(root.left);
            if (root.right != null) invertTree(root.right);
            return root;
        }
        return null;
    }

    public TreeNode addElement(Integer[] arr, int index) {
        if (index < arr.length && arr[index] != null) {
            return new TreeNode(arr[index], addElement(arr, index * 2 + 1), addElement(arr, index * 2 + 2));
        }
        return null;
    }

    public void printElements(TreeNode root) {
        List<TreeNode> currLevel = new ArrayList<>();
        currLevel.add(root);
        System.out.println(root.val);
        while (currLevel.size() > 0) {
            List<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode head : currLevel) {
                TreeNode left = head.left;
                TreeNode right = head.right;
                if (left != null) {
                    System.out.println(left.val);
                    nextLevel.add(left);
                }
                if (right != null) {
                    System.out.println(right.val);
                    nextLevel.add(right);
                }
            }
            currLevel.clear();
            currLevel.addAll(nextLevel);
        }
        System.out.println("");
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
}
