### :star: 문제 링크 :book:

- [1833. Maximum Ice Cream Bars](https://leetcode.com/problems/maximum-ice-cream-bars/)

---

### :star2: 사용한 알고리즘

- Priority Queue

---

### :stars: 코드

``` java
public int maxIceCream(int[] costs, int coins) {
    
    int answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    for(int e : costs) {
        pq.add(e);
    }
    
    while((!pq.isEmpty() && coins >= 0)) {
        coins -= pq.poll();
        answer += 1;
    }
    
    if(coins < 0) {
        answer -= 1;
    }
    
    return answer;
}
```