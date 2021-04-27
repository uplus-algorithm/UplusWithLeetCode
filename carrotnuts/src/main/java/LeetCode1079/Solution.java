package main.java.LeetCode1079;

import java.util.*;

public class Solution {
    public int numTilePossibilities(String tiles) {
        int answer = -1;

        int[] alphabets = new int[26];
        for(int i=0; i<tiles.length(); i++) {
            alphabets[tiles.charAt(i) - 'A'] += 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(alphabets);
        while(!queue.isEmpty()) {
            int[] state = queue.poll();
            answer += 1;

            for(int i=0; i<26; i++) {
                if(state[i] > 0) {
                    int[] next = state.clone();
                    next[i] -= 1;
                    queue.offer(next);
                }
            }
        }

        return answer;
    }
}
