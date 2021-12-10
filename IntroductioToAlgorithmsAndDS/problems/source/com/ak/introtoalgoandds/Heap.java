package com.ak.introtoalgoandds;

/*
Definition

    Heap is an implementation of a priority queue.
    Heap is an array visualized as nearly complete binary tree.

    root of the tree : first element (i=0)
    parent of any element i = (i-1)/2
    left child of any element i = 2i + 1
    right child of any element i = 2i + 2

    Max-Heap : The key of any node is greater than or equal to the keys of it's children.

    Max-Heap : The key of any node is lesser than or equal to the keys of it's children.
 */

/*
Operations that can be performed on heap.

    Insert(S,x) : insert element x into set S.
    max(S) : returns element of S with largest key. - Trivial
    extract-max(S) : returns element of S with largest key and removes it from S.
    update-key(S,x,k) : update the val of x's key to new value k.
 */

//This is a max heap
public class Heap {

    private int[] keys = null;

    Heap(int[] keys) {
        this.keys = buildMaxHeap(keys);
    }

    //maxHeapify from the fist parent from the leaf to the root
    //Time complexity - O(n) (it will seem like O(n log n) but it is actually O(n))
    /*
            Observe maxHeapify takes O(1) for nodes that are one level above leaves.
            In general maxHeapify takes O(l) for nodes that are l level above leaves.

            n/4 nodes with level 1, n/8 nodes with level 2, ..... 1 node with log n level.

            As the level increases the work done per node increases and number of nodes decreases.

            T(n) = n(1C)/4 + n(2C)/8 + ......+ 1 * log n * C

            set n/4 = 2^k

            log n = (k+1)/2^k

            T(n) = C2^k(1/(2^0) + 2/(2^1) + ..... + (k+1)/2^k) - convergent series bounded by a constant.
                 = C 2^k (2)
                 = C n/4 2
                 = C n
                 O(n)
     */
    public int[] buildMaxHeap(int[] keys) {
        for (int i = keys.length / 2; i >= 0; i--) keys = maxHeapify(keys, i);
        return keys;
    }

    //assuming left and right children are already max heap
    //Time complexity O(log n)
    private int[] maxHeapify(int[] keys, int pos) {
        int left = 2*pos +1, right = 2*pos+2;
        if (left < keys.length && keys[pos] < keys[left] && (right>=keys.length || keys[left]>keys[right])) {
            int temp = keys[pos];
            keys[pos] = keys[left];
            keys[left] = temp;
            return maxHeapify(keys, left);
        }

        if (right < keys.length && keys[pos] < keys[right]) {
            int temp = keys[pos];
            keys[pos] = keys[right];
            keys[right] = temp;
            return maxHeapify(keys, right);
        }
        return keys;
    }

    //Heap Sort
    /*
        1. Build max heap - O(n)
        2. take max into result;
        3. swap first and last element and decrement heap size -1
        4. repeat step 2.
     */
    //Time complexity O(n log n)
    public int[] sort() {
        int[] result = new int[keys.length];
        for(int i=0;i<result.length;i++) {
            result[i] = keys[0];
            keys[0] = keys[keys.length-1];
            keys[keys.length-1] = Integer.MIN_VALUE;
            keys = maxHeapify(keys,0);
        }
        return result;
    }

    public static void main(String[] args) {
        Heap result = new Heap(new int[]{3, 2, 5, 3, 7, 4, 8, 10, 4});
        for (int i : result.sort()) {
            System.out.println(i);
        }
    }

}
