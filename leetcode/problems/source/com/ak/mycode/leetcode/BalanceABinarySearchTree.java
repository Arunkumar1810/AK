package com.ak.mycode.leetcode;

import com.ak.mycode.tools.BinaryTreeUtil;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree extends BinaryTreeUtil {

    public static void main(String[] args) {
        TreeNode root = addElement(new Integer[]{1, null, 2, null, 3, null, 4, null, null}, 0);
        BalanceABinarySearchTree obj = new BalanceABinarySearchTree();
        root = obj.balanceBST(root);
        System.out.println(printTree(root));
    }

    List<TreeNode> sortedArr = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorderTraverse(root);
        return sortedArrayToBST(0, sortedArr.size() - 1);
    }
    void inorderTraverse(TreeNode root) {
        if (root == null) return;
        inorderTraverse(root.left);
        sortedArr.add(root);
        inorderTraverse(root.right);
    }
    TreeNode sortedArrayToBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = sortedArr.get(mid);
        root.left = sortedArrayToBST(start, mid - 1);
        root.right = sortedArrayToBST(mid + 1, end);
        return root;
    }

}

//link - https://leetcode.com/problems/balance-a-binary-search-tree/

/*
Question : -
    Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.
    A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
 */

/*
Example : -
    Input: root = [1,null,2,null,3,null,4,null,null]
    Output: [2,1,3,null,null,null,4]
    Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
 */

//level - medium

//algorithms used - Inorder Traversal, BST

//available in lists - greedy-tag

//Time Complexity - O(n log n)

//Space Complexity - O(n)

//Inference - think about what the input structure itself provide