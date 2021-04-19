package main.java.LeetCode1817;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    // 여러 유저(ID)는 동시에 행동 가능하다.
    // 한 유저(ID)는 한번에 여러 행동을 할 수 있다.
    // 이때, user active minutes(UAM)이란, 유저가 수행한 행동의 유니크한 시간의 갯수이다.
    // 즉, 1번 유저가 2분, 4분, 2분에 행동했다면, UAM은 2이다.
    //
    // @Output: array의 index는 UAM 수를 가치키고, value는 각 UAM이 등장한 횟수이다.
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int[] arr : logs) {
            int id = arr[0];
            int action = arr[1];

            if(!map.containsKey(id)) {
                map.put(id, new HashSet<>());
            }

            map.get(id).add(action);
        }

        int[] answer = new int[k];

        for(int e : map.keySet()) {
            Set<Integer> set = map.get(e);
            answer[set.size()-1] += 1;
        }

        return answer;
    }
}
