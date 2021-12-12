package com.ak.mycode.leetcode;

import com.ak.mycode.tools.BinaryTreeUtil;

public class InvertBinaryTree extends BinaryTreeUtil {
    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode root = addElement(new Integer[]{4, 2, 7, 1, 3, 6, 9}, 0);
        root = invertBinaryTree.invertTree(root);
        System.out.println(BinaryTreeUtil.printTree(root));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) invertTree(root.left);
        if (root.right != null) invertTree(root.right);
        return root;
    }
}

//link - https://leetcode.com/problems/invert-binary-tree/

/*
Question : -
    Given the root of a binary tree, invert the tree, and return its root.
 */

/*
Example : -
    Input: root = [4,2,7,1,3,6,9]
        Visualize :
            4
            ├──2
            │  ├──1
            │  └──3
            └──7
               ├──6
               └──9
    Output: [4,7,2,9,6,3,1]
        Visualize :
            4
            ├──7
            │  ├──9
            │  └──6
            └──2
               ├──3
               └──1
 */

//level - easy

//algorithms used - dfs

//available in lists -

//Time Complexity - O(n)

//Space Complexity - O(1)
