package main.java.LeetCode684;

import java.util.*;

public class Solution {

    public int[] parent; // 부모를 저장하기 위한 배열

    public int find(int x) {
        if (x == parent[x]) {
            // 만약 본인이 부모라면
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return false;
        } else {
            parent[y] = x;
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int[] answer = new int[2];

        for (int[] edge : edges) {
            boolean isUnion = union(edge[0], edge[1]);
            if (!isUnion) {
                answer[0] = edge[0];
                answer[1] = edge[1];
            }
        }

        return answer;
    }
}
