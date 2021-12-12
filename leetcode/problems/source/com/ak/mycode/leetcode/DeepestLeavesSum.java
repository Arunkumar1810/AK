package com.ak.mycode.leetcode;

import java.util.HashMap;

public class DeepestLeavesSum {

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
        if (index < arr.length && arr[index] != null) {
            return new TreeNode(arr[index], addElement(arr, index * 2 + 1), addElement(arr, index * 2 + 2));
        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{6,7,8,2,7,1,3,9,null,1,4,null,null,null,5};
        TreeNode root = new DeepestLeavesSum().addElement(input,0);
    }

    public int deepestLeavesSum(TreeNode root) {
        return deepestLeavesSum1(root).getKey();
    }

    private HashMap.SimpleEntry<Integer,Integer> deepestLeavesSum1(TreeNode root) {
        if(root.left==null && root.right==null)
        {
            return new HashMap.SimpleEntry<>(root.val, 1);
        }

        if(root.left==null){
            HashMap.SimpleEntry<Integer,Integer> hs = deepestLeavesSum1(root.right);
            hs.setValue(hs.getValue()+1);
            return hs;
        }

        if(root.right==null){
            HashMap.SimpleEntry<Integer,Integer> hs = deepestLeavesSum1(root.left);
            hs.setValue(hs.getValue()+1);
            return hs;
        }

        HashMap.SimpleEntry<Integer,Integer> hsLeft = deepestLeavesSum1(root.left);
        HashMap.SimpleEntry<Integer,Integer> hsRight = deepestLeavesSum1(root.right);
        if(hsLeft.getValue().equals(hsRight.getValue())) {
            return new HashMap.SimpleEntry<>(hsLeft.getKey() + hsRight.getKey(), hsLeft.getValue() + 1);
        }
        else if(hsLeft.getValue()>hsRight.getValue()) {
            return new HashMap.SimpleEntry<>(hsLeft.getKey(), hsLeft.getValue() + 1);
        }
        else {
            return new HashMap.SimpleEntry<>(hsRight.getKey(), hsRight.getValue() + 1);
        }
    }
}

//link - https://leetcode.com/problems/deepest-leaves-sum/

/*
Question : -
    Given the root of a binary tree, return the sum of values of its deepest leaves.

Constraints : -
    The number of nodes in the tree is in the range [1, 104].
    1 <= Node.val <= 100
 */

/*
Example : -
    Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
    Output: 15
 */

//level - medium

//algorithms used - divide and conquer

//available in lists - tree-tag

//Time Complexity - O(n)

//Space Complexity - O(l) where l is number of leaves
