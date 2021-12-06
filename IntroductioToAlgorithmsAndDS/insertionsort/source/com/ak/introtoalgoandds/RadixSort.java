package com.ak.introtoalgoandds;

public class RadixSort {

    public int[] solve(int[] input) {
        int max=Integer.MIN_VALUE;
        int n = input.length;
        for (int i : input) {
            max = Math.max(max, i);
        }

        int k = max,numOfDig=1;

        while (k >=n) {
            k=max/n;
            numOfDig*=n;
        }

        for (int i=1;i<=numOfDig;i*=n) {
            input = countingSort(input,i);
        }
        return input;
    }

    private int[] countingSort(int[] input,int digToSort) {
        int[] counter = new int[input.length];

        for (int i : input) {
            int q = i/digToSort;
            int r = q%input.length;
            counter[r]++;
        }

        for (int i=1;i<input.length;i++) {
            counter[i]+=counter[i-1];
        }

        int[] output = new int[input.length];

        for (int i=input.length-1;i>=0;i--) {
            int q = input[i] / digToSort;
            int r = q % input.length;
            output[counter[r]-1] = input[i];
            counter[r]--;
        }

        return output;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,5,1,7,4,8,2,10,0,18,15,182,34,2,31};
        int[] result = new RadixSort().solve(input);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
