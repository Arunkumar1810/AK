package com.ak.mycode.leetcode;

import java.util.HashMap;

public class SortIntegersByPowerValue {

    public static void main(String[] args) {
        System.out.println("Ans : "+new SortIntegersByPowerValue().getKth(1,1,1));
    }

    public HashMap<Integer,Integer> dp = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        int[] powers = new int[k],result = new int[k];
        for(int i=lo;i<=hi;i++) {
            int power = i==1 ? 1 : findPower(i);
            int curr = i;
            for(int j=0;j<k&&power!=0;j++) {
                if(powers[j]==0) {
//                    System.out.println(power);
//                    System.out.println(i);
                    powers[j] = power;
                    result[j] = curr;
                    power=0;
                }
                else if(powers[j]>power) {
//                    System.out.println(power);
//                    System.out.println(i);
                    int temp = power;
                    int currTemp = curr;
                    power = powers[j];
                    curr = result[j];
                    powers[j] = temp;
                    result[j] = currTemp;
                }
            }
        }
        return result[k-1];
    }

    public int findPower(int n) {
        if(dp.containsKey(n)) return dp.get(n);
        int power=0;
        if(n!=1) {
            if(n%2==0) {
                power = findPower(n/2)+1;
            }
            else {
                power = findPower(n*3+1)+1;
            }
        }
        dp.put(n,power);
        return power;
    }
}
