package com.ak.mycode.top100liked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/binary-tree-inorder-traversal
public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        TreeNode root = binaryTreeInorderTraversal.addElement(new Integer[]{1,null,2,3});
        List<Integer> result = binaryTreeInorderTraversal.inorderTraversal(root);
        for (Integer integer : result) System.out.println(integer);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root!=null) {
            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));
            return result;
        }
        return result;
    }

    public TreeNode addElement(Integer[] arr) {
        TreeNode root = new TreeNode();
        root.val = arr[0];
        Map<TreeNode,Integer> currentLevel = new HashMap<>();
        currentLevel.put(root,0);
        while (!currentLevel.isEmpty()) {
            Map<TreeNode,Integer> nextLevel = new HashMap<>();
            for (TreeNode head : currentLevel.keySet()) {
                int index = currentLevel.get(head);
                Integer left = null, right = null;
                if(index * 2 + 1 <arr.length) {
                    left = arr[index * 2 + 1];
                }
                if(index * 2 + 2 < arr.length) {
                    right = arr[index * 2 + 2];
                }
                index = index*2;
                if (left != null && index+1<arr.length) {
                    head.left = new TreeNode(left);
                    nextLevel.put(head.left,++index);
                }
                if(right != null && index+2<arr.length) {
                    head.right = new TreeNode(right);
                    nextLevel.put(head.right,++index);
                }
            }
            currentLevel.clear();
            currentLevel = nextLevel;
        }
        return root;
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
