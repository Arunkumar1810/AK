package com.ak.interviewpractice.amazon;

import com.ak.mycode.tools.BinaryTreeUtil;

import java.util.LinkedList;
import java.util.List;

public class BoundaryTraversalOfBinaryTree extends BinaryTreeUtil {

    public static void main(String[] args) {
        TreeNode root = addElement(new Integer[]{20, 8, 22, 4, 12,null, 25,null,null, 10, 14}, 0);
        System.out.println(printTree(root));
        List<Integer> result = new BoundaryTraversalOfBinaryTree().boundaryOfBinaryTree(root);
        for (Integer i : result) System.out.println(i);
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        LinkedList<Integer> resultFirstHalf = new LinkedList<>();
        LinkedList<Integer> resultSecondHalf = new LinkedList<>();
        LinkedList<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.addLast(root);
        while (!currentLevel.isEmpty()) {

            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            for (TreeNode node : currentLevel) {
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }

            if (nextLevel.isEmpty()) {
                currentLevel.forEach(node -> resultFirstHalf.add(node.val));
            } else {
                resultFirstHalf.add(currentLevel.getFirst().val);
                if (currentLevel.size() > 1) {
                    resultSecondHalf.addFirst(currentLevel.getLast().val);
                }
            }
            currentLevel = nextLevel;
        }
        resultFirstHalf.addAll(resultSecondHalf);
        return resultFirstHalf;
    }
}

//link - https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/

/*
Question : -
    Print the boundary of a binary tree in anti-clockwise direction
 */

/*
Example : -
    Input :
        20
        ├──8
        │  ├──4
        │  └──12
        │     ├──10
        │     └──14
        └──22
        └──25
    Output : 20 8 4 10 14 25 22
 */

//level - medium

//algorithms used - level order traversal

//available in lists - amazon-questions

//Time Complexity - O(n)

//Space Complexity - O(n)