class Solution {
    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        
        for(int i =0; i < boxes.length(); i++){
            if(boxes.charAt(i) == '1') {
                for(int j = 0; j < boxes.length(); j++){
                    result[j] += Math.abs(i-j);
                }
            }
        }
        
        return result;
    }
}
