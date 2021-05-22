### :star: 문제 링크 :book:

- [921. Minimum Add to Make Parentheses Valid](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/)

---

### :star2: 사용한 알고리즘

- Stack

---

### :stars: 코드

``` java
public int minAddToMakeValid(String s) {
    // empty string
    // AB, A AND B is valid
    // (A), A is valid
    
    Stack<Character> stack = new Stack<>();
    char[] charArray = s.toCharArray();
    
    int answer = 0;
    for(int i=0; i<s.length(); i++) {
        if(charArray[i] == ')') {
            if(!stack.isEmpty()) {
                stack.pop();
            }
            else {
                answer += 1;
            }
        }
        else {
            stack.add(charArray[i]);
        }
    }
    
    return stack.size() + answer;
}
```