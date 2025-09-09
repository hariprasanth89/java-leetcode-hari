package org.example.dinesh;

import java.util.*;

public class InterSectionofArrays {
    public static int[] getIntersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1)
            map.put(n, map.getOrDefault(n, 0) + 1);

        for (int n : nums2) {
            if (map.containsKey(n) && map.get(n) > 0) {
                list.add(n);
                map.put(n, map.get(n) - 1);
            }
        }

        int[] res = new int[list.size()];
        for (int i=0; i<list.size(); i++)
            res[i] = list.get(i);
        return res;

    }
    public static void main (String[] args) {
        int[] num1 = {1, 1, 2, 2, 1, 1};
        int[] num2 = {1, 1, 2, 2};

        int[] output = getIntersection(num2, num1);
        System.out.println("Intersection output...");
        for (int o : output)
            System.out.print(o + " ");

    }
}
