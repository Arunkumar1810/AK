package com.ak.introtoalgoandds;

import java.util.List;
import java.util.ArrayList;

public class AVLTree {

    private Node head = null;

    public static class Node {
        public int val,height=1;
        public Node left,right,parent;
        public Boolean isLeft;
        public Node(int val,Node parent,Boolean isLeft) {
            this.val = val;
            this.parent = parent;
            this.isLeft = isLeft;
        }
    }

    public void insert(int val) {
        if(head == null) {
            head = new Node(val,null,null);
            return;
        }

        //inserting new node as normal bst
        Node iterator = head;
        while(true) {
            if(iterator.val >= val) {
                if(iterator.left == null) {
                    iterator.left = new Node(val,iterator,true);
                    break;
                }
                iterator = iterator.left;
            }
            else {
                if(iterator.right == null) {
                    iterator.right = new Node(val,iterator,false);
                    break;
                }
                iterator = iterator.right;
            }
        }

        balanceAVL(iterator);
    }

    public void delete(int val) {
        Node iterator = head;
        while(iterator!=null) {
            if(iterator.val == val) {
                if(iterator.left==null && iterator.right==null) {
                    if(iterator.parent==null)
                    {
                        head=null;
                        return;
                    }
                    Node parent = iterator.parent;
                    iterator.parent=null;
                    if(iterator.isLeft) {
                        parent.left = null;
                    }
                    else {
                        parent.right = null;
                    }
                    balanceAVL(parent);
                    break;
                }
                else if(iterator.left==null || iterator.right==null) {
                    Node parent = iterator.parent;
                    Node newNode = iterator.right==null? iterator.left: iterator.right;
                    newNode.parent = parent;
                    if(iterator.isLeft) {
                        parent.left = newNode;
                    }
                    else {
                        parent.right = newNode;
                    }
                    balanceAVL(parent);
                    break;
                }
                else {
                    Node changeNode;
                    if(iterator.left.height>iterator.right.height) {
                        changeNode = getMax(iterator.left);
                    }
                    else {
                        changeNode = getMin(iterator.right);
                    }
                    int temp = changeNode.val;
                    changeNode.val = iterator.val;
                    iterator.val = temp;
                    iterator = changeNode;
                }
            }
            else if(iterator.val>val) {
                iterator = iterator.left;
            }
            else {
                iterator = iterator.right;
            }
        }
    }

    private void balanceAVL(Node root) {
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        root.height = 1 + Math.max(leftHeight,rightHeight);
        int balance = leftHeight-rightHeight;
        if(balance>1 || balance<-1) {
            if(leftHeight>rightHeight) {
                if(root.left.right!=null && (root.left.left==null || getHeight(root.left.right)>getHeight(root.left.left))) {
                    rotateRight(root.left);
                }
                rotateLeft(root);
            }
            else {
                if(root.right.left!=null && (root.right.right==null || getHeight(root.right.left)>getHeight(root.right.right))) {
                    rotateLeft(root.right);
                }
                rotateRight(root);
            }
        }
        if(root.parent != null) balanceAVL(root.parent);
    }

    private void rotateLeft(Node node) {

        Node newNode = node.left;
        newNode.parent = node.parent;
        newNode.isLeft = node.isLeft;
        if(newNode.parent!=null) {
            if(newNode.isLeft) newNode.parent.left = newNode;
            else newNode.parent.right = newNode;
        }
        else {head = newNode;}

        node.left = newNode.right;
        if(node.left!=null) {
            node.left.parent = node;
            node.left.isLeft = true;
        }

        newNode.right = node;
        node.parent = newNode;
        node.isLeft = false;

        node.height = 1+ Math.max(getHeight(node.left),getHeight(node.right));
        newNode.height = 1+Math.max(getHeight(newNode.left),getHeight(newNode.right));
    }

    private void rotateRight(Node node) {

        Node newNode = node.right;
        newNode.parent = node.parent;
        newNode.isLeft = node.isLeft;
        if(newNode.parent!=null) {
            if(newNode.isLeft) newNode.parent.left = newNode;
            else newNode.parent.right = newNode;
        }
        else {head = newNode;}

        node.right = newNode.left;
        if(node.right!=null) {
            node.right.parent = node;
            node.right.isLeft = false;
        }

        newNode.left = node;
        node.parent = newNode;
        node.isLeft = true;

        node.height = 1+ Math.max(getHeight(node.left),getHeight(node.right));
        newNode.height = 1+Math.max(getHeight(newNode.left),getHeight(newNode.right));

    }

    private int getHeight(Node node) {
        if(node==null) return 0;
        return node.height;
    }

    //LEVEL-ORDER TRAVERSAL
    //level vise iteration of binary tree
    public void levelOrderTraversal() {
        System.out.println("LEVEL-ORDER TRAVERSAL");
        List<Node> nodesInCurrentLevel = new ArrayList<>();
        nodesInCurrentLevel.add(head);
        while(!nodesInCurrentLevel.isEmpty()) {
            List<Node> nodesInNextLevel = new ArrayList<>();

            for (Node node : nodesInCurrentLevel) {
                if(node.left!=null) nodesInNextLevel.add(node.left);
                if(node.right!=null) nodesInNextLevel.add(node.right);
            }
            printNodes(nodesInCurrentLevel);

            nodesInCurrentLevel.clear();
            nodesInCurrentLevel.addAll(nodesInNextLevel);
        }
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    //IN-ORDER TRAVERSAL
    //interation of binary tree in the order left -> root -> right
    public void inOrderTraversal() {
        System.out.println("IN-ORDER TRAVERSAL");
        List<Node> nodes = new ArrayList<>(4);
        inOrderTraversal(head,nodes);
        if(nodes.size()>0)
            printNodes(nodes);
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public void inOrderTraversal(Node root,List<Node> nodes) {
        if(nodes.size()>=6) {
            printNodes(nodes);
            nodes.clear();
        }
        if(root.left!=null) inOrderTraversal(root.left,nodes);
        if(nodes.size()>=6) {
            printNodes(nodes);
            nodes.clear();
        }
        nodes.add(root);
        if(nodes.size()>=6) {
            printNodes(nodes);
            nodes.clear();
        }
        if(root.right!=null) inOrderTraversal(root.right,nodes);
        if(nodes.size()>=6) {
            printNodes(nodes);
            nodes.clear();
        }
    }

    //PRE-ORDER TRAVERSAL
    //interation of binary tree in the order left -> root -> right
    public void preOrderTraversal() {
        System.out.println("PRE-ORDER TRAVERSAL");
        List<Node> nodes = new ArrayList<>(4);
        preOrderTraversal(head,nodes);
        if(nodes.size()>0)
            printNodes(nodes);
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public void preOrderTraversal(Node root,List<Node> nodes) {
        if(nodes.size()>=6) {
            printNodes(nodes);
            nodes.clear();
        }
        nodes.add(root);
        if(nodes.size()>=6) {
            printNodes(nodes);
            nodes.clear();
        }
        if(root.left!=null) preOrderTraversal(root.left,nodes);
        if(nodes.size()>=6) {
            printNodes(nodes);
            nodes.clear();
        }
        if(root.right!=null) preOrderTraversal(root.right,nodes);
        if(nodes.size()>=6) {
            printNodes(nodes);
            nodes.clear();
        }
    }

    //POST-ORDER TRAVERSAL
    //interation of binary tree in the order left -> root -> right
    public void postOrderTraversal() {
        System.out.println("POST-ORDER TRAVERSAL");
        List<Node> nodes = new ArrayList<>(4);
        postOrderTraversal(head,nodes);
        if(nodes.size()>0)
            printNodes(nodes);
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public void postOrderTraversal(Node root,List<Node> nodes) {
        if(nodes.size()>=6) {
            printNodes(nodes);
            nodes.clear();
        }
        nodes.add(root);
        if(nodes.size()>=6) {
            printNodes(nodes);
            nodes.clear();
        }
        if(root.right!=null) postOrderTraversal(root.right,nodes);
        if(nodes.size()>=6) {
            printNodes(nodes);
            nodes.clear();
        }
        if(root.left!=null) postOrderTraversal(root.left,nodes);
        if(nodes.size()>=6) {
            printNodes(nodes);
            nodes.clear();
        }
    }

    public void printNodes(List<Node> nodes) {
        int charsOccupiedByEachNode = 20;

        for (Node node : nodes) {
            String val = "value : "+node.val;
            val+= new String(new char[charsOccupiedByEachNode-val.length()]).replaceAll("\0"," ");
            val+="|";
            System.out.print(val);
        }
        System.out.println();

        for (Node node : nodes) {
            String height = "height : "+node.height;
            height+= new String(new char[charsOccupiedByEachNode-height.length()]).replaceAll("\0"," ");
            height+="|";
            System.out.print(height);
        }
        System.out.println();

        for (Node node : nodes) {
            String parent = "parent : "+(node.parent!=null?node.parent.val+"":"null");
            parent+= new String(new char[charsOccupiedByEachNode-parent.length()]).replaceAll("\0"," ");
            parent+="|";
            System.out.print(parent);
        }
        System.out.println();

        for (Node node : nodes) {
            String direction = node.isLeft!=null?(node.isLeft?"left":"right"):"null";
            direction+= new String(new char[charsOccupiedByEachNode-direction.length()]).replaceAll("\0"," ");
            direction+="|";
            System.out.print(direction);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public int getMax() {
        return getMax(head).val;
    }
    private Node getMax(Node root) {
        if(root.right==null) return root;
        return getMax(root.right);
    }

    public int getMin() {
        return getMin(head).val;
    }
    private Node getMin(Node root) {
        if(root.left==null) return root;
        return getMin(root.left);
    }

    public int getKThSmallerThan(int val) {
        return 0;
    }


    public int getImmediateLargerTo(int val) {
        return getImmediateLargerTo(val,head).val;
    }
    private Node getImmediateLargerTo(int val,Node root) {
        if(root==null) return new Node(Integer.MAX_VALUE,null,null);
        if(root.val <= val) {
            return getImmediateLargerTo(val,root.right);
        }
        Node immediateLargeNode = getImmediateLargerTo(val,root.left);
        if(root.val<immediateLargeNode.val) return root;
        return immediateLargeNode;
    }

    public int getImmediateSmallerTo(int val) {
        return getImmediateSmallerTo(val,head);
    }
    private int getImmediateSmallerTo(int val,Node root) {
        if(root==null) return Integer.MIN_VALUE;
        if(root.val >= val) {
            return getImmediateSmallerTo(val,root.left);
        }
        return Math.max(getImmediateSmallerTo(val,root.right),root.val);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,2,6,3,7,8,10,5};
        AVLTree avlTree = new AVLTree();
        for(int i : arr) avlTree.insert(i);
        avlTree.levelOrderTraversal();

        avlTree.delete(4);

        avlTree.levelOrderTraversal();

        avlTree.inOrderTraversal();
        avlTree.preOrderTraversal();
        avlTree.postOrderTraversal();

        System.out.println("Immediate Larger to 2 : "+avlTree.getImmediateLargerTo(2));
        System.out.println("Immediate Smaller to 7 : "+avlTree.getImmediateSmallerTo(7));
    }
}