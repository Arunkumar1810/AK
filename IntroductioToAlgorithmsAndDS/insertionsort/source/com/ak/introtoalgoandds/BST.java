package com.ak.introtoalgoandds;

//fast insertion on a sorted array

import java.util.Arrays;

/*
    Definition :
    For all nodes x, if y is in the left subtree of x key(y)<=key(x), if y is in th right subtree of x key(y)>=key(x).
 */
public class BST {

    private static class BSTNode {
        int val;
        BSTNode left;
        BSTNode right;
        BSTNode parent;
        int subTreeSize;
    }

    BSTNode head = null;

    //Time Complexity - O(h) not O(log n) where h is the height of the tree
    public void insert(int val) {
        if(head==null) {
            head = new BSTNode();
            head.val = val;
            head.subTreeSize = 1;
            return;
        }
        BSTNode iterator = head;
        while (true) {
            if(iterator.val<=val) {
                if(iterator.right==null) {
                    iterator.right = new BSTNode();
                    iterator.right.val = val;
                    iterator.right.parent = iterator;
                    iterator.subTreeSize++;
                    iterator.right.subTreeSize = 1;
                    return;
                }
                iterator.subTreeSize++;
                iterator = iterator.right;
            }
            else {
                if(iterator.left==null) {
                    iterator.left = new BSTNode();
                    iterator.left.val = val;
                    iterator.left.parent = iterator;
                    iterator.subTreeSize++;
                    iterator.left.subTreeSize = 1;
                    return;
                }
                iterator.subTreeSize++;
                iterator = iterator.left;
            }
        }
    }

    //O(h)
    public int findMin() {
        BSTNode iter = head;
        while (iter.left!=null) {
            iter = iter.left;
        }
        return iter.val;
    }

    //O(h)
    public int findMax() {
        BSTNode iter = head;
        while (iter.right!=null) {
            iter = iter.right;
        }
        return iter.val;
    }

    //O(h)
    public int firstElementLargerThanOrEqualTo(int val) {
        if(head==null) return Integer.MAX_VALUE;
        return firstElementLargerThanOrEqualTo(val,head);
    }

    private int firstElementLargerThanOrEqualTo(int val,BSTNode iterator) {
        if(iterator.val<val) {
            if(iterator.right!=null) return firstElementLargerThanOrEqualTo(val,iterator.right);
            return Integer.MAX_VALUE;
        }
        else {
            int result = iterator.val;
            if(iterator.left!=null) {
                result = Math.min(result,firstElementLargerThanOrEqualTo(val,iterator.left));
            }
            if(iterator.right!=null) {
                result = Math.min(result,firstElementLargerThanOrEqualTo(val,iterator.right));
            }
            return result;
        }
    }

    //O(h)
    public int firstElementSmallerThanOrEqualTo(int val)
    {
        if(head==null) return Integer.MIN_VALUE;
        return firstElementSmallerThanOrEqualTo(val,head);
    }

    private int firstElementSmallerThanOrEqualTo(int val,BSTNode iterator) {
        if(iterator.val>val) {
            if(iterator.right!=null) return firstElementSmallerThanOrEqualTo(val,iterator.right);
            return Integer.MIN_VALUE;
        }
        else {
            int result = iterator.val;
            if(iterator.left!=null) {
                result = Math.max(result,firstElementSmallerThanOrEqualTo(val,iterator.left));
            }
            if(iterator.right!=null) {
                result = Math.max(result,firstElementSmallerThanOrEqualTo(val,iterator.right));
            }
            return result;
        }
    }

    //O(h)
    public int elementsLargerThan(int val) {
        if(head==null) return 0;
        return elementsLargerThan(val,head);
    }

    private int elementsLargerThan(int val,BSTNode iterator) {
        int result = 0;
        if(iterator.val>=val) {
            result = 1;
            if(iterator.right!=null) {
                result+=iterator.right.subTreeSize;
            }
            if(iterator.left!=null) {
                result += elementsLargerThan(val,iterator.left);
            }
        }
        else {
            if(iterator.right!=null) result = elementsLargerThan(val,iterator.right);
        }
        return result;
    }

    //O(h)
    public int elementsSmallerThan(int val)
    {
        if(head==null) return 0;
        return elementsSmallerThan(val,head);
    }

    private int elementsSmallerThan(int val,BSTNode iterator) {
        int result = 0;
        if(iterator.val<=val) {
            result = 1;
            if(iterator.left!=null) {
                result+=iterator.left.subTreeSize;
            }
            if(iterator.right!=null) {
                result += elementsLargerThan(val,iterator.right);
            }
        }
        else {
            if(iterator.left!=null) result = elementsLargerThan(val,iterator.left);
        }
        return result;
    }

    /*
        Depth First Traversals
        1. In Order Traversal : left -> root -> right or right -> root -> left
        2. Pre Order Traversal : root -> left -> right
        3. Post Order Traversal : left -> right -> root
     */

    //In Order Traversal : left -> root -> right or right -> root -> left
    public int[] inOrderTraversal() {
        if(head==null) return new int[]{};
        else return inOrderTraversal(head,new int[head.subTreeSize],0);
    }
    private int[] inOrderTraversal(BSTNode node,int[] result,int index) {
        if(node.left!=null) {
            result = inOrderTraversal(node.left,result,index);
            index+=node.left.subTreeSize;
        }
        result[index++] = node.val;
        if(node.right!=null) {
            result = inOrderTraversal(node.right,result,index);
        }
        return result;
    }

    //Pre-Order Traversal root -> left -> right
    public int[] preOrderTraversal() {
        if (head==null) return new int[]{};
        return preOrderTraversal(head,new int[head.subTreeSize],0);
    }
    private int[] preOrderTraversal(BSTNode node,int[] result,int index) {
        result[index++] = node.val;
        if(node.left!=null) {
            result = preOrderTraversal(node.left,result,index);
            index+=node.left.subTreeSize;
        }
        if(node.right!=null) {
            result = preOrderTraversal(node.right,result,index);
        }
        return result;
    }

    //Post-Order Traversal left -> right -> root
    public int[] postOrderTraversal() {
        if (head==null) return new int[]{};
        return postOrderTraversal(head,new int[head.subTreeSize],0);
    }
    private int[] postOrderTraversal(BSTNode node,int[] result,int index) {
        if(node.left!=null) {
            result = postOrderTraversal(node.left,result,index);
            index+=node.left.subTreeSize;
        }
        if(node.right!=null) {
            result = postOrderTraversal(node.right,result,index);
            index+=node.right.subTreeSize;
        }
        result[index] = node.val;
        return result;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] input = {3,2,5,3,7,4,8,10,4,6,3,7};
        for (int i : input) bst.insert(i);

        System.out.println("Max : "+bst.findMax());
        System.out.println("Min : "+bst.findMin());

        System.out.println(bst.firstElementSmallerThanOrEqualTo(9));
        System.out.println(bst.firstElementLargerThanOrEqualTo(9));

        System.out.println("Elements larger than "+5+" are "+bst.elementsLargerThan(5));
        System.out.println("Elements smaller than "+5+" are "+bst.elementsSmallerThan(5));

        int[] inOrderTraversalResult = bst.inOrderTraversal();
        System.out.println("In-Order Traversal Result Of BST :");
        for (int i : inOrderTraversalResult) System.out.print("\t"+i);
        System.out.println();
        int[] preOrderTraversalResult = bst.preOrderTraversal();
        System.out.println("Pre-Order Traversal Result Of BST :");
        for (int i : preOrderTraversalResult) System.out.print("\t"+i);
        System.out.println();
        int[] postOrderTraversalResult = bst.postOrderTraversal();
        System.out.println("Post-Order Traversal Result Of BST :");
        for (int i : postOrderTraversalResult) System.out.print("\t"+i);
        System.out.println();
    }
}
