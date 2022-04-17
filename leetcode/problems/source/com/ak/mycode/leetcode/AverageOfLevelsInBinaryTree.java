package com.ak.mycode.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsInBinaryTree {

    public static void main(String[] args) {

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            if (root == null) return null;
            List<Double> result = new ArrayList<>();
            List<TreeNode> currentLevel = new ArrayList<>();
            currentLevel.add(root);
            while (!currentLevel.isEmpty()) {
                List<TreeNode> nextLevel = new ArrayList<>();
                double levelTotal = 0, levelCount = 0;
                for (TreeNode node : currentLevel) {
                    levelTotal += node.val;
                    levelCount++;
                    if (node.left != null) nextLevel.add(node.left);
                    if (node.right != null) nextLevel.add(node.right);
                }
                result.add(levelTotal / levelCount);
                currentLevel = nextLevel;
            }
            return result;
        }
    }
}
