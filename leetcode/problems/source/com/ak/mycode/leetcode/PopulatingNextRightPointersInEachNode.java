package com.ak.mycode.leetcode;

import com.ak.mycode.tools.BinaryTreeUtil;

public class PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {
        Node root = addElement(new Integer[]{1,2,3,4,5,6,7},0);

    }

    public Node connect(Node root) {
        if(root==null)
            return null;
        if(root.left!=null)
            root.left.next=root.right;
        if(root.right!=null&&root.next!=null)
            root.right.next=root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }

    public static Node addElement(Integer[] arr, int index) {
        if (index < arr.length && arr[index] != null) {
            return new Node(arr[index], addElement(arr, index * 2 + 1), addElement(arr, index * 2 + 2));
        }
        return null;
    }

    public static class Node {
        public Node next;
        public Integer val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
