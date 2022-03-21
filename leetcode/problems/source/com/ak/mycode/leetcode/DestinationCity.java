package com.ak.mycode.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {

    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add("London");
        path.add("New York");
        paths.add(path);
        path = new ArrayList<>();
        path.add("New York");
        path.add("Lima");
        paths.add(path);
        path = new ArrayList<>();
        path.add("Lima");
        path.add("Sao Paulo");
        paths.add(path);
        System.out.println(new Solution().destCity(paths));
    }
    private static class Solution {
        public String destCity(List<List<String>> paths) {
            Set<String> sourceCities = new HashSet<>(), destinationCities = new HashSet<>();
            for(List<String> path : paths) {
                sourceCities.add(path.get(0));
                destinationCities.remove(path.get(0));

                if(!sourceCities.contains(path.get(1))) {
                    destinationCities.add(path.get(1));
                }
            }

            return destinationCities.iterator().next();
        }
    }
}
//link - https://leetcode.com/problems/destination-city/

/*
Question : -
    You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi.
    Return the destination city, that is, the city without any path outgoing to another city.
    It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
 */

/*
Example : -
    Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
    Output: "Sao Paulo"
    Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city.
        Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
 */

//level - easy

//algorithms used - HashTable

//available in lists - HashTable Tag

//Time Complexity - O(n)

//Space Complexity - O(n)
