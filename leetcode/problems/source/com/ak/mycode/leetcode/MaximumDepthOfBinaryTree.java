package com.ak.mycode.leetcode;

import com.ak.mycode.tools.BinaryTreeUtil;

public class MaximumDepthOfBinaryTree extends BinaryTreeUtil {

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        TreeNode root = addElement(new Integer[]{0},0);
        System.out.println("Max Depth : "+maximumDepthOfBinaryTree.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if(root!=null) {
            return Integer.max(maxDepth(root.left),maxDepth(root.right)) +1;
        }
        return 0;
    }
}

//link - https://leetcode.com/problems/maximum-depth-of-binary-tree

/*
Question : -
    Given the root of a binary tree, return its maximum depth.
    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Constraints : -
    The number of nodes in the tree is in the range [0, 10^4].
    -100 <= Node.val <= 100
 */

/*
Example : -
    Input: root = [3,9,20,null,null,15,7]
    Output: 3
 */

//level - easy

//algorithms used - dfs

//available in lists -

//Time Complexity - O(n)

//Space Complexity - O(1)
