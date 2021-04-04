public class LeetCode1491 {
    public double Solution(int[] salary) {
        int max = salary[0];
        int min = salary[0];
        int sum = 0;
        for (int salaryItem : salary) {
            if (salaryItem > max) {
                max = salaryItem;
            } else if (salaryItem < min) {
                min = salaryItem;
            }
            sum += salaryItem;
        }
        sum = sum - min - max;
        return sum / (salary.length - 2);

    }
}
