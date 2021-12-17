package com.ak.introtoalgoandds;

public class QuickSort {

    public static void main(String[] args) {
        int[] result = new QuickSort().solve(new int[]{3,2,5,3,7,4,8,10,4,6,3,7,10});
        for (int i : result) {
            System.out.println(i);
        }
    }

    private int[] solve(int[] ints) {
        return quickSort(ints,0,ints.length-1);
    }

    private int[] quickSort(int[] arr,int start,int end) {
        if(start>end) return arr;
        int pivot = arr[end];
        int newPivotPosition = start-1;

        for (int i=start;i<=end-1;i++) {
            if(arr[i] < pivot) {
                newPivotPosition++;
                int temp = arr[i];
                arr[i] = arr[newPivotPosition];
                arr[newPivotPosition] = temp;
            }
        }
        int temp = arr[newPivotPosition+1];
        arr[newPivotPosition+1] = arr[end];
        arr[end] = temp;

        arr = quickSort(arr,start,newPivotPosition);
        arr = quickSort(arr,newPivotPosition+2,end);
        return arr;
    }


}
