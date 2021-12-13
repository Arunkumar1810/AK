package com.ak.mycode.leetcode;

import com.ak.mycode.tools.BinaryTreeUtil;

public class BinarySearchTreeToGreaterSumTree extends BinaryTreeUtil {

    public static void main(String[] args) {
        BinarySearchTreeToGreaterSumTree obj = new BinarySearchTreeToGreaterSumTree();
        TreeNode root = addElement(new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8}, 0);
        System.out.println("Input : ");
        System.out.println(printTree(root));
        root = obj.bstToGst(root);
        System.out.println("Result : ");
        System.out.println(printTree(root));
        System.out.println("Expected Result : ");
        System.out.println(printTree(addElement(new Integer[]{30,36,21,36,35,26,15,null,null,null,33,null,null,null,8},0)));
    }

    public TreeNode bstToGst(TreeNode root) {
        if(root==null) return null;
        bstToGst1(0,root);
        return root;
    }

    public int bstToGst1(int gst,TreeNode root) {
        if(root.right!=null) root.val += bstToGst1(gst,root.right);
        if(root.right==null) root.val+=gst;
        if(root.left!=null) return bstToGst1(root.val,root.left);
        return root.val;
    }
}

//link - https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

/*
Question : -
    Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
    As a reminder, a binary search tree is a tree that satisfies these constraints:
    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
 */

/*
Example : -
    Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
4
├──1
│  ├──0
│  └──2
│     └──3
└──6
   ├──5
   └──7
      └──8

    Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
30
├──36
│  ├──36
│  └──35
│     └──33
└──21
   ├──26
   └──15
      └──8

 */

//level - medium

//algorithms used - inorder traversal(reverse)

//available in lists - tree-tag

//Time Complexity - O(n)

//Space Complexity - O(1)
