package com.ak.mycode.binarysearch;

//https://binarysearch.com/problems/Left-Side-View-of-a-Tree

//medium

//Binary Tree

//Your code took 58 milliseconds — faster than 85.24% in Java

//Top Interview Problems
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeftSideViewOfATree {

    public static void main(String[] args) {
        int[] result = new LeftSideViewOfATree().solve(addElement(new Integer[]{8,5,2,null,null,null,1}));
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] solve(Tree root) {
        List<Tree> currentLevelElements = new ArrayList<>();
        currentLevelElements.add(root);
//        List<Integer> result = new ArrayList<>();
//        result.add(root.val);
        int[] resultList = new int[100];
        int resultSize = 0;
        resultList[resultSize++] = root.val;
        while (!currentLevelElements.isEmpty()) {
            List<Tree> nextLevel = new ArrayList<>();
            for (Tree iter : currentLevelElements) {
                if (iter.left != null) {
                    nextLevel.add(iter.left);
                }
                if (iter.right != null) {
                    nextLevel.add(iter.right);
                }
            }
            if(!nextLevel.isEmpty()) {
//                result.add(nextLevel.get(0).val);
                if(resultSize>=resultList.length) {
                    int[] newResult = new int[resultSize+100];
                    System.arraycopy(resultList,0,newResult,0,resultList.length);
                    resultList = newResult;
                }
                resultList[resultSize++] = nextLevel.get(0).val;
            }
            currentLevelElements = nextLevel;
        }
        return Arrays.copyOfRange(resultList,0,resultSize);
//        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static class Tree {
        int val;
        Tree left;
        Tree right;
    }

    public static Tree addElement(Integer[] arr) {
        Tree root = new Tree();
        root.val = arr[0];
        Map<Tree,Integer> currentLevel = new HashMap<>();
        currentLevel.put(root,0);
        while (!currentLevel.isEmpty()) {
            Map<Tree,Integer> nextLevel = new HashMap<>();
            for (Tree head : currentLevel.keySet()) {
                int index = currentLevel.get(head);
                Integer left = null, right = null;
                if(index * 2 + 1 <arr.length) {
                    left = arr[index * 2 + 1];
                }
                if(index * 2 + 2 < arr.length) {
                    right = arr[index * 2 + 2];
                }
                index = index*2;
                if (left != null && index+1<arr.length) {
                    head.left = new Tree();
                    head.left.val = left;
                    nextLevel.put(head.left,++index);
                }
                if(right != null && index+2<arr.length) {
                    head.right = new Tree();
                    head.right.val = right;
                    nextLevel.put(head.right,++index);
                }
            }
            currentLevel.clear();
            currentLevel = nextLevel;
        }
        return root;
    }
}
