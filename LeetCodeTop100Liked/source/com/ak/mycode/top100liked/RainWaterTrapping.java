package com.ak.mycode.top100liked;

import java.util.ArrayList;

public class RainWaterTrapping {

    public static void main(String[] args)
    {
        int[] height = {5,4,1,2};
        System.out.println("Trapped Rain Water : "+trapRainWater(height));
    }

    public static int trapRainWater(int[] height) {
        if(height.length > 0) {
            int prevNum = height[0];
            ArrayList<Integer> decreasingHeight = new ArrayList<>();
            decreasingHeight.add(prevNum);
            int count = 0;
            for (int i = 1; i < height.length; i++) {
                int num = height[i];
                if (prevNum < num) {
                    if (decreasingHeight.get(0) >= num) {
                        for (int j = decreasingHeight.size() - 1; j > 0; j--) {
                            if (decreasingHeight.get(j) < num) {
                                count = count + num - decreasingHeight.get(j);
                                decreasingHeight.set(j, num);
                            } else {
                                break;
                            }
                        }
                    } else {
                        for (int j = 1; j < decreasingHeight.size(); j++) {
                            count = count + decreasingHeight.get(0) - decreasingHeight.get(j);
                        }
                        decreasingHeight.clear();
                    }
                }
                decreasingHeight.add(num);
                prevNum = num;
            }
            System.out.println(count);
            return count;
        }
        return 0;
    }
}


/*

Question

url : https://leetcode.com/problems/trapping-rain-water/

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.


Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
0 <= n <= 3 * 104
0 <= height[i] <= 105
 */