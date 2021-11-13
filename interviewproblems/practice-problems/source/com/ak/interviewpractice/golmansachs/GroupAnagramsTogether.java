package com.ak.interviewpractice.golmansachs;

//https://www.faceprep.in/python/group-anagrams-together/

//medium

//Counting Sort, Hash Map

//Time Complexity : O(n*(k+26)) where n : number of string, k - characters in string

//Space Complexity : O(2n)

//Goldman Sachs Practice

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsTogether {
    public static void main(String[] args) {
        Collection<List<String>> result = new GroupAnagramsTogether().solution(new String[]{"bat","design","toc","signed","cot","tab"});
        for (List<String> list : result) {
            System.out.print("["+"    ");
            for (String string : list) {
                System.out.print(string+"    ");
            }
            System.out.println("]");
        }
    }

    private Collection<List<String>> solution(String[] input) {
        Map<String, List<String>> result = new HashMap<>();
        for (String s : input) {
            String sortedString = getSortedString(s);
            if (!result.containsKey(sortedString)) {
                result.put(sortedString, new ArrayList<>());
            }
            result.get(sortedString).add(s);
        }
        return result.values();
    }

    private String getSortedString(String s) {
        int[] charCountArray = new int['z'-'a'+1];
        char[] result = s.toCharArray();

        for (char c : result) {
            charCountArray[c-'a'] +=1;
        }
        int count = 0;
        for (int i = 0; i<charCountArray.length ; i++) {
            for (int j =0; j<charCountArray[i];j++) {
                result[count++] = (char) (i + 'a');
            }
        }
        return new String(result);
    }
}
