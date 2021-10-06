package com.ak.mycode;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LowestCommonAncestorOfABinarySearchTree {

    public static void main(String[] args) {
        LowestCommonAncestorOfABinarySearchTree lowestCommonAncestorOfABinarySearchTree = new LowestCommonAncestorOfABinarySearchTree();
        TreeNode root = lowestCommonAncestorOfABinarySearchTree.addAndGetRootNode(new Integer[]{2,1,3});
        TreeNode result = lowestCommonAncestorOfABinarySearchTree.lowestCommonAncestor(root, lowestCommonAncestorOfABinarySearchTree.getElement(root,3),lowestCommonAncestorOfABinarySearchTree.getElement(root,1) );
        System.out.println("Result : "+result.val);
    }

    public TreeNode addAndGetRootNode(Integer[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        for(int i=1;i<arr.length;i++) {
            addElement(root,arr[i]);
        }
        return root;
    }

    public void addElement(TreeNode root, Integer element) {
        if(element == null) return;
        if(root.val<element) {
            if(root.right!=null) {
                addElement(root.right,element);
            }
            else {
                root.right = new TreeNode(element);
            }
        }
        else {
            if(root.left!=null) {
                addElement(root.left,element);
            }
            else {
                root.left = new TreeNode(element);
            }
        }
    }

    public TreeNode getElement(TreeNode root, Integer value) {
        if(root.val == value) {
            return root;
        }
        else if(root.val>value) {
            return getElement(root.left,value);
        }
        else {
            return getElement(root.right,value);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root.val==p.val || root.val==q.val) {
            return root;
        }

        if(root.val> p.val && root.val<q.val) {
            return root;
        }

        if(root.val< p.val && root.val>q.val) {
            return root;
        }

        if(root.val<p.val && root.val<q.val) {
            return lowestCommonAncestor(root.right,p,q);
        }

        if(root.val>p.val && root.val>q.val) {
            return lowestCommonAncestor(root.left,p,q);
        }

        return null;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}