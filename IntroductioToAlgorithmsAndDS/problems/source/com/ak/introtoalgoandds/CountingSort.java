package com.ak.introtoalgoandds;

public class CountingSort {

    public int[] solve(int[] input) {
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for (int i : input) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int k = max-min+1;
        int[] counter = new int[k];
        for (int i : input) {
            counter[i-min]++;
        }

        for (int i=0,j=0;i<counter.length;) {
            if(counter[i]>0) {
                input[j] = i+min;
                counter[i]--;
                j++;
            }
            else {
                i++;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,5,1,7,4,8,2,10,0};
        int[] result = new CountingSort().solve(input);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
