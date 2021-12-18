package com.ak.mycode.leetcode;

import com.ak.mycode.tools.BinaryTreeUtil;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees extends BinaryTreeUtil {

    public static void main(String[] args) {
        List<TreeNode> binaryTrees = new AllPossibleFullBinaryTrees().allPossibleFBT(7);
        for (TreeNode head : binaryTrees) {
            System.out.println(printTree(head));
            System.out.println("-----------------------------------------------------");
        }
    }

    List<List<TreeNode>> dp = new ArrayList<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2==0) return new ArrayList<>();
        if(dp.size()>n) return dp.get(n);
        List<TreeNode> result = new ArrayList<>();
        if(n<=1) {
            result.add(new TreeNode(0));
            dp.add(0,result);
            return result;
        }
        for(int left=1;left<n;left+=2) {
            List<TreeNode> leftList = allPossibleFBT(left);
            List<TreeNode> rightList = allPossibleFBT(n-left-1);
            for(TreeNode leftNode : leftList) {
                for(TreeNode rightNode : rightList) {
                    TreeNode node = new TreeNode(0,leftNode,rightNode);
                    result.add(node);
                }
            }
        }
        dp.add(n-1,result);
        return result;
    }
}

//link - https://leetcode.com/problems/all-possible-full-binary-trees/

/*
Question : -
    Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.
    Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.
    A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 */

/*
Example : -
    Input: n = 7
    Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 */

//level - medium

//algorithms used - dp-memoization

//available in lists - dp-tag

//Time Complexity - O(n)

//Space Complexity - O(n)
