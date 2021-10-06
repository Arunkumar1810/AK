package com.ak.mycode;

import java.util.HashMap;

//https://leetcode.com/problems/jewels-and-stones/
public class JewelsAndStones {

    public static void main(String[] args) {
        System.out.println(new JewelsAndStones().numJewelsInStones("z","ZZ"));
    }

    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> jewelsStonesCount = new HashMap<>();

        for(int i=0;i<jewels.length();i++) {
            jewelsStonesCount.put(jewels.charAt(i),0);
        }

        for(int i=0;i<stones.length();i++) {
            Character stone = stones.charAt(i);
            if(jewelsStonesCount.containsKey(stone)) {
                jewelsStonesCount.put(stone,jewelsStonesCount.get(stone)+1);
            }
        }

        int result = 0;

        for (Integer count: jewelsStonesCount.values()) {
            result+=count;
        }
        return result;
    }
}
