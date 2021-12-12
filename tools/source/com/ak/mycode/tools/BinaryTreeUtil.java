package com.ak.mycode.tools;

import java.util.Scanner;

public class BinaryTreeUtil {
    
    public static class TreeNode {
        public Integer val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode addElement(Integer[] arr, int index) {
        if (index < arr.length && arr[index] != null) {
            return new TreeNode(arr[index], addElement(arr, index * 2 + 1), addElement(arr, index * 2 + 2));
        }
        return null;
    }

    public static String printTree(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        String pointerRight = "└──";
        String pointerLeft = (root.right != null) ? "├──" : "└──";

        printTree(sb, "", pointerLeft, root.left, root.right != null);
        printTree(sb, "", pointerRight, root.right, false);

        return sb.toString();
    }

    private static void printTree(StringBuilder sb, String padding, String pointer, TreeNode node, boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.val);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.right != null) ? "├──" : "└──";

            printTree(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            printTree(sb, paddingForBoth, pointerRight, node.right, false);
        }
    }

    public static TreeNode getNode(TreeNode root,int val) {
        if(root==null) return null;

        if(root.val==val) return root;
        else {
            TreeNode result = getNode(root.left,val);
            if(result==null) {
                result = getNode(root.right,val);
            }
            return result;
        }
    }

    private static void getMainInput() {
        System.out.println("Enter your choice : ");
        System.out.println("1. Print Array As Binary Tree");
        System.out.println("-1. Exit");
    }

    public static void main(String[] args) {
        getMainInput();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (choice!=-1) {
            switch (choice) {
                case 1:
                    System.out.println("Enter The Element As Comma Separated");
                    scanner = new Scanner(System.in);
                    String inputLine = scanner.nextLine();
                    String[] inputValues = inputLine.split(",");
                    Integer[] inputInts = new Integer[inputValues.length];
                    for (int i = 0; i < inputValues.length; i++) {
                        String val = inputValues[i].trim();
                        if(val.equalsIgnoreCase("null")) {
                            inputInts[i] = null;
                        }
                        else {
                            inputInts[i] = Integer.parseInt(inputValues[i].trim());
                        }
                    }
                    TreeNode root = addElement(inputInts, 0);
                    System.out.println(printTree(root));
                    break;

                default:
                    System.out.println("Enter A Proper Choice.");
            }
            getMainInput();
            scanner = new Scanner(System.in);
            choice = scanner.nextInt();
        }
        scanner.close();
    }
}
