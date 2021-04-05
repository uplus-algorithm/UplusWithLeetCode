package main.java.LeetCode1282;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // 각 사람들은 유일한 ID를 가진다.
    // N명의 사람들을 임의의 숫자의 그룹으로 나눈다.
    // groupSize[i] = X, i번 사람은 무조건 X크기의 그룹에 속해야 한다.
    // 답이 여러개일 경우 아무거나 하나를 리턴한다.
    // 답은 무조건 하나 이상 있음을 보장한다.

    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> answer = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<groupSizes.length; i++) {
            int groupSize = groupSizes[i];

            if(!map.containsKey(groupSize))
                map.put(groupSize, new ArrayList<>());

            map.get(groupSize).add(i);
        }

        for(int e : map.keySet()) {
            List<Integer> list = map.get(e);
            if(list.size() == e) {
                answer.add(list);
            }
            else {
                int head = 0;
                int tail = e;
                while(tail <= list.size()) {
                    answer.add(list.subList(head, tail));
                    head += e;
                    tail += e;
                }
            }
        }

        return answer;

    }
}
