package com.ak.mycode.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MinimumHeightTrees {

    public static void main(String[] args) {
        List<Integer> result = new MinimumHeightTrees().findMinHeightTrees(6,new int[][]{
                {3,0},
                {3,1},
                {3,2},
                {3,4},
                {5,4}
        });
        for (Integer i : result) System.out.println(i);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges==null || n==0) return new ArrayList<>();
        if (n == 1) return Collections.singletonList(0);
        HashSet<Integer>[] adjSet = new HashSet[n];

        for(int i=0;i<n;i++) adjSet[i] = new HashSet<>();

        for(int[] edge : edges) {
            adjSet[edge[0]].add(edge[1]);
            adjSet[edge[1]].add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();

        for(int i=0;i<n;i++) {
            if(adjSet[i].size()==1) {
                leaves.add(i);
            }
        }

        while (n>2) {
            n-=leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(Integer leaf : leaves){
                Integer parent = adjSet[leaf].iterator().next();
                adjSet[parent].remove(leaf);
                if(adjSet[parent].size()==1) {
                    newLeaves.add(parent);
                }
            }
            leaves=newLeaves;
        }

        return leaves;
    }
}

//link - https://leetcode.com/problems/minimum-height-trees/

/*
Question : -
    A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

    Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

    Return a list of all MHTs' root labels. You can return the answer in any order.

    The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */

/*
Example : -
    Input: n = 4, edges = [[1,0],[1,2],[1,3]]
    Output: [1]
    Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
 */

//level - medium

//algorithms used - bfs(from leaves)

//available in lists -

//Time Complexity - O(n)

//Space Complexity - O(n)
