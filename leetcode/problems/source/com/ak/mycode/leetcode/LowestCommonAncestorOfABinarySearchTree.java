package com.ak.mycode.leetcode;

import com.ak.mycode.tools.BinaryTreeUtil;

public class LowestCommonAncestorOfABinarySearchTree extends BinaryTreeUtil {

    public static void main(String[] args) {
        LowestCommonAncestorOfABinarySearchTree obj = new LowestCommonAncestorOfABinarySearchTree();
        TreeNode root = addElement(new Integer[]{2,1,3},0);
        TreeNode result = obj.lowestCommonAncestor(root, getNode(root,3),getNode(root,1) );
        System.out.println("Result : "+result.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val.equals(p.val) || root.val.equals(q.val)) {
            return root;
        }

        if(root.val> p.val && root.val<q.val) {
            return root;
        }

        if(root.val< p.val && root.val>q.val) {
            return root;
        }

        if(root.val<p.val) {
            return lowestCommonAncestor(root.right,p,q);
        }

        return lowestCommonAncestor(root.left,p,q);

    }
}

//link - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

/*
Question : -
    Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Constraints : -
    The number of nodes in the tree is in the range [2, 105].
    -10^9 <= Node.val <= 10^9
    All Node.val are unique.
    p != q
    p and q will exist in the BST.
 */

/*
Example : -
    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    Output: 6
    Explanation: The LCA of nodes 2 and 8 is 6.
 */

//level - easy

//algorithms used - dfs

//available in lists -

//Time Complexity - O(n)

//Space Complexity - O(1)