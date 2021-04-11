import java.util.*;

class LeetCode1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int index = 0;
        int length = groupSizes.length;
        HashMap<Integer, ArrayList> groupMap = new HashMap<>();
        for(int groupSize : groupSizes){
            ArrayList groupMember = groupMap.get(groupSize);
            if(groupMember != null){
                groupMember.add(index);
                groupMap.put(groupSize, groupMember);
            }else{
                groupMap.put(groupSize, new ArrayList<Integer>(Arrays.asList(index)));
            }
            index ++;
        }
        List<List<Integer>> ret = new ArrayList<>();

        for(int groupSize: groupMap.keySet()){
            ArrayList<Integer> groupMember = groupMap.get(groupSize);
            int i = 0;
            while(i < groupMember.size()){
                int j = 0;
                List<Integer> splitRet = new ArrayList();
                while(j < groupSize){
                    splitRet.add(groupMember.get(i++));
                    j++;
                }
                ret.add(splitRet);
            }

        }
        return ret;
    }

}