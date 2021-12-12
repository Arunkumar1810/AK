package com.ak.mycode.leetcode;

import com.ak.mycode.tools.BinaryTreeUtil;

public class MergeTwoBinaryTrees extends BinaryTreeUtil {

    public static void main(String[] args) {
        MergeTwoBinaryTrees mergeTwoBinaryTrees = new MergeTwoBinaryTrees();
        TreeNode root1 = addElement(new Integer[]{1,3,2,5},0);
        TreeNode root2 = addElement(new Integer[]{2,1,3,null,4,null,7},0);
        TreeNode result = mergeTwoBinaryTrees.mergeTrees(root1,root2);
        System.out.println(printTree(result));
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
}

//link - https://leetcode.com/problems/merge-two-binary-trees/

/*
Question : -
    You are given two binary trees root1 and root2.
    Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
    Return the merged tree.
    Note: The merging process must start from the root nodes of both trees.

Constraints : -
    The number of nodes in both trees is in the range [0, 2000].
    -10^4 <= Node.val <= 10^4
 */

/*
Example : -
    Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
    Output: [3,4,5,5,4,null,7]
 */

//level - easy

//algorithms used - dfs

//available in lists -

//Time Complexity - O(n)

//Space Complexity - O(1)


