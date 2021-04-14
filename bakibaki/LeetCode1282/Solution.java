class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList();
        HashMap<Integer, List<List<Integer>>> map = new HashMap();
        
       for(int i = 0; i < groupSizes.length; i++){
           if(map.containsKey(groupSizes[i])){
               List<List<Integer>> outerList = map.get(groupSizes[i]);
               List<Integer> innerList = outerList.get(outerList.size()-1);
               if(innerList.size() < groupSizes[i]){
                   innerList.add(i);
               }
               else {
                   List<Integer> newerList = new ArrayList();
                   newerList.add(i);
                   outerList.add(newerList);
               }
           } else {
               List<List<Integer>> outerList = new ArrayList();
               List<Integer> innerList = new ArrayList();
               innerList.add(i);
               outerList.add(innerList);
               map.put(groupSizes[i], outerList);
           }
       }
        
        for(int k : map.keySet()){
            map.get(k).stream().forEach(o -> {
                result.add(o);
            });
        }
        
        return result;
        
    }
}
