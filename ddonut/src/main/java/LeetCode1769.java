class LeetCode1769 {
    public int[] minOperations(String boxes) {
        List<String> boxArray = Arrays.asList(boxes);
        int boxIndex = 0 ;
        ArrayList<Integer> ballExistArray = new ArrayList<>();
        for(char boxItem: boxes.toCharArray()){
            if(boxItem == '1'){
                ballExistArray.add(boxIndex);
            }
            boxIndex ++;
        }

        int[] ret = new int[boxes.length()];
        for(int i=0; i< boxes.length(); i++){
            int sum = 0;
            for(int item: ballExistArray){

                sum += Math.abs(item-i);
            }
            ret[i] = sum;
        }
        return ret;

    }
}