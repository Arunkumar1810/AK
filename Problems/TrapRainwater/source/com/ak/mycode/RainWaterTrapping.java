package com.ak.mycode;

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
