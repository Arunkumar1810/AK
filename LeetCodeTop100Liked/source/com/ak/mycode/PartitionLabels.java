package com.ak.mycode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/partition-labels/
public class PartitionLabels {
    public static void main(String[] args) {
        List<Integer> result = new PartitionLabels().partitionLabels("caedbdedda");
        for (int i : result) System.out.println(i);
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> partitionLengths = new ArrayList<>();
        int[] lastIndexes = new int[26];
        for (int i=0;i<s.length();i++) {
            lastIndexes[s.charAt(i)-'a'] = i;
        }

        int i=0;
        while (i < s.length()) {
            int end = lastIndexes[s.charAt(i)-'a'];
            int j = i;
            while (j!=end) {
                end = Math.max(end,lastIndexes[s.charAt(j++) - 'a']);
            }
            partitionLengths.add(j-i+1);
            i = j+1;
        }
        return partitionLengths;
    }
}
