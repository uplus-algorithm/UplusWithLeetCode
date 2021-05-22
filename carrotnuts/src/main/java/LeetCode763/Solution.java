package main.java.LeetCode763;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> answer = new ArrayList<>();

        char[] chars = s.toCharArray();

        int[] lastIndex = new int[26];

        for(int i=0; i<s.length(); i++) {
            int alphabet = chars[i] - 'a';

            lastIndex[alphabet] = i;
        }

        int cnt = 0;
        int max = 0;
        for(int i=0; i<s.length(); i++) {
            int alphabet = chars[i] - 'a';
            max = Math.max(max, lastIndex[alphabet]);
            cnt += 1;
            if(i == max) {
                answer.add(cnt);
                cnt = 0;
            }
        }

        return answer;
    }
}
