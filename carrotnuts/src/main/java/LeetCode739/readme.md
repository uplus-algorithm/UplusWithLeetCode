### :star: 문제 링크 :book:

- [739. Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)

---

### :star2: 사용한 알고리즘

- dp, back tracking

---

### :stars: 코드

``` java
public int[] dailyTemperatures(int[] temperatures) {
    int[] dp = new int[temperatures.length];
    int[] idx = new int[temperatures.length];
    
    for(int i = temperatures.length - 2; i>=0; i--) {
        if(temperatures[i] < temperatures[i+1]) {
            dp[i] = 1;
            idx[i] = i+1;
        }
        else {
            int next = idx[i+1];
            while(next != 0) {
                if(temperatures[i] < temperatures[next]) {
                    dp[i] = next - i;
                    idx[i] = next;
                    break;
                }
                
                next = idx[next];
            }
        }
    }
    
    return dp;
}
```