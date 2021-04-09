package leetcode1282;
import java.util.*;
public class Main {

    public static Map<Integer, List<Integer>> m;

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        m = new HashMap<>();
        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < groupSizes.length; i++) {
            int si = groupSizes[i];
            if(m.containsKey(si)) {
                List<Integer> temp = m.get(si);
                temp.add(i);
                m.replace(si, temp);
            }else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                m.put(si, temp);
            }
            if(m.get(si).size() == si) {
                answer.add(m.get(si));
                m.remove(si);
            }
        }

        return answer;
    }
}
