package com.ak.mycode.leetcode;

import com.ak.mycode.tools.BinaryTreeUtil;

public class RangeSumOfBST extends BinaryTreeUtil {

    public static void main(String[] args) {
        Integer[] input = new Integer[]{10,5,15,3,7,null,18};
        RangeSumOfBST obj = new RangeSumOfBST();
        TreeNode root = addElement(input,0);
        System.out.println(BinaryTreeUtil.printTree(root));
        System.out.println(obj.rangeSumBST(root,7,15));
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        int result = 0;
        if(low<=root.val && high>=root.val) result+=root.val;
        if(root.val>=low) result+= rangeSumBST(root.left,low,high);
        if(root.val<=high) result+= rangeSumBST(root.right,low,high);
        return result;
    }
}

//link - https://leetcode.com/problems/range-sum-of-bst/

/*
Question : -
    Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

Constraints : -
    The number of nodes in the tree is in the range [1, 2 * 104].
    1 <= Node.val <= 105
    1 <= low <= high <= 105
    All Node.val are unique.
 */

/*
Example : -
    Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
    Output: 32
    Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 */

//level - easy

//algorithms used - dfs

//available in lists - tree-tag

//Time Complexity - O(n)

//Space Complexity - O(1)