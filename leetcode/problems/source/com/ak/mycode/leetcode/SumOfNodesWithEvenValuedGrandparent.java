package com.ak.mycode.leetcode;

import com.ak.mycode.tools.BinaryTreeUtil;

public class SumOfNodesWithEvenValuedGrandparent extends BinaryTreeUtil {

    public static void main(String[] args) {
        Integer[] input = new Integer[]{6,7,8,2,7,1,3,9,null,1,4,null,null,null,5};
        SumOfNodesWithEvenValuedGrandparent obj = new SumOfNodesWithEvenValuedGrandparent();
        TreeNode root = addElement(input,0);
        System.out.println(obj.sumEvenGrandparent(root));
    }

    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(1,root);
    }

    public int sumEvenGrandparent(int gpVal,TreeNode parent) {
        if(parent==null) return 0;
        TreeNode left = parent.left;
        TreeNode right = parent.right;
        int result = 0;
        if(left!=null && gpVal%2==0) {
            result+=left.val;
        }
        result+=sumEvenGrandparent(parent.val,left);
        if(right!=null && gpVal%2==0) {
            result+=right.val;
        }
        result+=sumEvenGrandparent(parent.val,right);
        return result;
    }
}

//link - https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/

/*
Question : -
    Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0.
    A grandparent of a node is the parent of its parent if it exists.

Constraints : -
    The number of nodes in the tree is in the range [1, 104].
    1 <= Node.val <= 100
 */

/*
Example : -
    Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
    Output: 18
    Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
 */

//level - medium

//algorithms used - dfs

//available in lists - tree-tag

//Time Complexity - O(n)

//Space Complexity - O(1)
