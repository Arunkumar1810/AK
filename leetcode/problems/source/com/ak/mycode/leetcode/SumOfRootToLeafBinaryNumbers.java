package com.ak.mycode.leetcode;

import com.ak.mycode.tools.BinaryTreeUtil;

public class SumOfRootToLeafBinaryNumbers extends BinaryTreeUtil {

    public static void main(String[] args) {
        TreeNode root = addElement(new Integer[]{1,0,1,0,1,0,1},0);
        System.out.println(new SumOfRootToLeafBinaryNumbers().sumRootToLeaf(root));
    }

    public int sumRootToLeaf(TreeNode root) {
        return helper(root,0);
    }

    public int helper(TreeNode root,int sum) {
        if(root == null) return sum;
        sum = sum*2 + root.val;
        int left = helper(root.left,sum);
        int right = helper(root.right,sum);
        if(root.left==null) return right;
        if(root.right==null) return left;
        return left+right;
    }
}

//link - https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

/*
Question : -
    You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.
    For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
    For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.
    The test cases are generated so that the answer fits in a 32-bits integer.
 */

/*
Example : -
    Input: root = [1,0,1,0,1,0,1]
    Output: 22
    Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 */

//level - easy

//algorithms used - Pre-order Traversal

//available in lists -

//Time Complexity - O(n)

//Space Complexity - O(1)

//Inference -