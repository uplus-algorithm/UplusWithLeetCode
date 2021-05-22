package main.java.LeetCode260;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] singleNumber(int[] nums) {

        int[] answer = new int[2];
        Map<Integer, Boolean> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.replace(num, true);
            } else {
                map.put(num, false);
            }
        }

        int idx = 0;
        for (int e : map.keySet()) {
            if (!map.get(e))
                answer[idx++] = e;
        }

        return answer;
    }
}