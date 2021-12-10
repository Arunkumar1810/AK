package com.ak.introtoalgoandds;

//insert a[i] into sorted array a[i-1] by pairwise swaps down to the correct position

//Time Complexity - O(n^2) - O(n) steps or key positions and each step has O(n) swaps

//Space Complexity - O(1)

public class InsertionSort {

    public static void main(String[] args) {
        int[] result = new InsertionSort().solve(new int[]{3,2,5,3,7,4,8,10,4,6,3,7});
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] solve(int[] arr) {
        for (int i = 1;i<arr.length;i++) {
            if(arr[i]<arr[i-1]) {
                for (int j=i;j>0 && arr[j]<arr[j-1];j--) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }
}
