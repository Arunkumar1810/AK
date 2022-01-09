package com.ak.mycode.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        FirstUniqueCharacterInAString obj = new FirstUniqueCharacterInAString();
        System.out.println(obj.firstUniqChar("leetcode"));
    }

    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++) {
            char c = arr[i];
            if(map.containsKey(c)) {
                map.put(c,-1);
            }
            else {
                map.put(c,i);
            }
        }
        int result = Integer.MAX_VALUE;
        for(Character c : map.keySet()) {
            int index = map.get(c);
            if(index!=-1) {
                result = Math.min(result,index);
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}

//link - https://leetcode.com/problems/first-unique-character-in-a-string/

/*
Question : -
    Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 */

/*
Example : -
    Input: s = "leetcode"
    Output: 0
 */

//level - easy

//algorithms used - hash table

//available in lists - amazon-questions

//Time Complexity - O(n)

//Space Complexity - O(n)