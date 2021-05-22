### :star: 문제 링크 :book:

- [260. Single Number III](https://leetcode.com/problems/single-number-iii/)

---

### :star2: 사용한 알고리즘

- HashMap

---

### :stars: 코드

``` java
public int[] singleNumber(int[] nums) {

    int[] answer = new int[2];
    Map<Integer, Boolean> map = new HashMap<>();

    for (int num : nums) {
        if (map.containsKey(num)) {
            map.replace(num, true);
        } else {
            map.put(num, false);
        }
    }

    int idx = 0;
    for (int e : map.keySet()) {
        if (!map.get(e))
            answer[idx++] = e;
    }

    return answer;
}
```