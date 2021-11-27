package com.ak.introtoalgoandds;

//insertion sort takes O(n^2) time when we consider comparison and swap takes same amount of time.
//But what if comparison alone takes O(n) then for all comparisons O(n^2) insertion sort time will be O(n^3).
//To improve this we can add binary search for comparison

//insert a[i] into sorted array a[i-1] by binary search on the sorted array a[i-1] to find the element and do pairwise swaps down to that position.

//Time Complexity - O(n^2) ~ O(n) * (O(n) + O(log n))

public class BinaryInsertionSort {
    public static void main(String[] args) {
        int[] result = new BinaryInsertionSort().solve(new int[]{3,2,5,3,7,4,8,10,4,6,3,7});
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] solve(int[] arr) {
        for (int i = 1;i<arr.length;i++) {
            if(arr[i]<arr[i-1]) {

                //binary search to find position to swap
                int posToSwap = i-1;
                for (int j=0;posToSwap-j>=2;) {
                    int mid = (j+posToSwap)/2;
                    if(arr[mid]>arr[i]) {
                        posToSwap = mid;
                    }
                    else {
                        j=mid;
                    }
                }

                //swap until the position found from binary search
                for (int j=i;j>posToSwap;j--) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }
}
