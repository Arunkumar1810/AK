package com.ak.mycode.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/merge-two-binary-trees/
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        MergeTwoBinaryTrees mergeTwoBinaryTrees = new MergeTwoBinaryTrees();
        TreeNode root1 = mergeTwoBinaryTrees.addElement(new Integer[]{1,3,2,5},0);
        TreeNode root2 = mergeTwoBinaryTrees.addElement(new Integer[]{2,1,3,null,4,null,7},0);
        TreeNode result = mergeTwoBinaryTrees.mergeTrees(root1,root2);
        mergeTwoBinaryTrees.printElements(result);
    }

    public TreeNode addElement(Integer[] arr, int index) {
        if(index<arr.length && arr[index]!=null) {
            return new TreeNode(arr[index], addElement(arr, index * 2 + 1), addElement(arr, index * 2 + 2));
        }
        return null;
    }
    public void printElements(TreeNode root) {
        List<TreeNode> currLevel = new ArrayList<>();
        currLevel.add(root);
        int level = 1;
        while(currLevel.size() > 0) {

            // Output
            currLevel.forEach(x -> System.out.print(x.val + " "));

            // Preparation for next level
            List<TreeNode> nextLevel = new ArrayList<>();
            for (int i = currLevel.size() - 1; i >= 0; i--) {
                TreeNode left = currLevel.get(i).left;
                TreeNode right = currLevel.get(i).right;

                if (level % 2 == 0) {
                    if (left != null) nextLevel.add(left);
                    if (right != null) nextLevel.add(right);
                } else {
                    if (right != null) nextLevel.add(right);
                    if (left != null) nextLevel.add(left);
                }
            }
            currLevel.clear();
            currLevel.addAll(nextLevel);

            level++;
        }
        System.out.println("");
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null) {
            return root2;
        }
        else if(root2==null) {
            return root1;
        }
        else {
            return new TreeNode(root1.val+root2.val,mergeTrees(root1.left,root2.left),mergeTrees(root1.right,root2.right));
        }
    }

    static class TreeNode {
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


