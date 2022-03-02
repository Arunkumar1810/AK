package com.ak.mycode.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DesignAnOrderedStream {

    public static void main(String[] args) {
        OrderedStream orderedStream = new OrderedStream(5);
        System.out.println();
        for (String str : orderedStream.insert(3,"ccccc")) System.out.print(str+"\t");
        System.out.println();
        for (String str : orderedStream.insert(1,"aaaaa")) System.out.print(str+"\t");
        System.out.println();
        for (String str : orderedStream.insert(2,"bbbbb")) System.out.print(str+"\t");
        System.out.println();
        for (String str : orderedStream.insert(5,"eeeee")) System.out.print(str+"\t");
        System.out.println();
        for (String str : orderedStream.insert(4,"ddddd")) System.out.print(str+"\t");
    }

    private static class OrderedStream {

        String[] stream;
        int ptr;

        public OrderedStream(int n) {
            stream = new String[n];
            ptr = 0;
        }

        public List<String> insert(int idKey, String value) {
            stream[idKey-1] = value;
            if((idKey-1)==ptr) {
                List<String> result = new ArrayList<>();
                while(ptr<stream.length && stream[ptr]!=null) {
                    result.add(stream[ptr++]);
                }
                return result;
            }
            return new ArrayList<>();
        }
    }
}
//link - https://leetcode.com/problems/design-an-ordered-stream/

/*
Question : -
    There is a stream of n (idKey, value) pairs arriving in an arbitrary order, where idKey is an integer between 1 and n and value is a string. No two pairs have the same id.
    Design a stream that returns the values in increasing order of their IDs by returning a chunk (list) of values after each insertion. The concatenation of all the chunks should result in a list of the sorted values.
    Implement the OrderedStream class:
        OrderedStream(int n) Constructs the stream to take n values.
        String[] insert(int idKey, String value) Inserts the pair (idKey, value) into the stream, then returns the largest possible chunk of currently inserted values that appear next in the order.
 */

/*
Example : -
    Input
    ["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
    [[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
    Output
    [null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]
 */

//level - easy

//algorithms used -

//available in lists - hashmap tag

//Time Complexity - o(n)

//Space Complexity - o(n)
