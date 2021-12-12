package com.ak.mycode.leetcode;

import com.ak.mycode.tools.BinaryTreeUtil;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal extends BinaryTreeUtil {

    public static void main(String[] args) {
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        TreeNode root = addElement(new Integer[]{1,null,2,3},0);
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
}

//link - https://leetcode.com/problems/binary-tree-inorder-traversal

/*
Question : -
    Given the root of a binary tree, return the inorder traversal of its nodes' values.

Constraints : -
    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100
 */

/*
Example : -
    Input: root = [1,null,2,3]
    Output: [1,3,2]
 */

//level - easy

//algorithms used - dfs

//available in lists -

//Time Complexity - O(n)

//Space Complexity - O(n)