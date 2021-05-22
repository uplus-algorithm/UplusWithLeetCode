package main.java.LeetCode1833;

import java.util.PriorityQueue;

public class Solution {
    public int maxIceCream(int[] costs, int coins) {

        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int e : costs) {
            pq.add(e);
        }

        while((!pq.isEmpty() && coins >= 0)) {
            coins -= pq.poll();
            answer += 1;
        }

        if(coins < 0) {
            answer -= 1;
        }

        return answer;
    }
}
