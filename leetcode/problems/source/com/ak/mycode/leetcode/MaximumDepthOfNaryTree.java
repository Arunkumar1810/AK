package com.ak.mycode.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumDepthOfNaryTree {

    public static void main(String[] args) {

    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private static class Solution {
        public int maxDepth(Node root) {
            return dfsSolution(root);
        }

        public int dfsSolution(Node root) {
            if (root == null) return 0;
            if (root.children == null || root.children.isEmpty()) return 1;

            int result = 0;

            for (Node node : root.children) result = Math.max(result, maxDepth(node));

            return result + 1;
        }

        public int bfsSolution(Node root) {
            if (root == null) return 0;
            if (root.children == null || root.children.isEmpty()) return 1;

            List<Node> nodesInCurrentLevel = new ArrayList<>();
            nodesInCurrentLevel.add(root);
            int result = 0;
            while (!nodesInCurrentLevel.isEmpty()) {
                result++;
                List<Node> nodesInNextLevel = new ArrayList<>();
                for (Node parent : nodesInCurrentLevel) {
                    if (parent.children == null || parent.children.isEmpty()) continue;
                    nodesInNextLevel.addAll(parent.children);
                }
                nodesInCurrentLevel = nodesInNextLevel;
            }
            return result;
        }
    }
}
