package com.ak.mycode.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountItemsMatchingARule {

    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        List<String> item = new ArrayList<>();
        item.add("phone");
        item.add("blue");
        item.add("pixel");
        items.add(item);
        item = new ArrayList<>();
        item.add("computer");
        item.add("silver");
        item.add("lenovo");
        items.add(item);
        System.out.println(new CountItemsMatchingARule().countMatches(items,"color","silver"));
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ruleKeyNum = 0;
        if(ruleKey.equals("color")) {
            ruleKeyNum = 1;
        }
        else if(ruleKey.equals("name")) {
            ruleKeyNum = 2;
        }
        int result =0;
        for(List<String> item : items) {
            if(item.get(ruleKeyNum).equals(ruleValue)) {
                result++;
            }
        }
        return result;
    }
}
//link - https://leetcode.com/problems/count-items-matching-a-rule/

/*
Question : -
    You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.
    The ith item is said to match the rule if one of the following is true:
    ruleKey == "type" and ruleValue == typei.
    ruleKey == "color" and ruleValue == colori.
    ruleKey == "name" and ruleValue == namei.
    Return the number of items that match the given rule.
 */

/*
Example : -
    Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
    Output: 1
    Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
 */

//level - easy

//algorithms used -

//available in lists - string tag

//Time Complexity - O(n)

//Space Complexity - O(1)
