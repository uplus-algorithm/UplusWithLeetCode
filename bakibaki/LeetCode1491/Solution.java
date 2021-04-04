package LeetCode1491;

class Solution {
    public double average(int[] salary) {
        double out = 0;
        int min = salary[0];
        int max = salary[0];
        for(int i =0; i < salary.length; i++){
            out += salary[i];
            if(salary[i] < min) min = salary[i];
            if(salary[i] > max) max = salary[i];
        }

        return (out-min-max)/(salary.length-2);
    }
}