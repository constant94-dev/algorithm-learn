package newmind_2409;

import java.util.*;

public class ValidParentheses_20 {
    // Time: O(N)
    // Space: O(N)
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>(); // 스택 생성

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') { // 열린 괄호일 경우 스택 추가
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) return false; // 스택이 비어있을 경우 열린 괄호가 없으니 false 반환

            char top = stack.peek();
            if ((c == ')' && top == '(') || (c == '}' && top == '{') || (c == ']' && top == '[')) {
                stack.pop(); // 상응하는 괄호를 스택에서 제거
                continue;
            }
            return false; // 상응하는 괄호가 없으므로 false 반환
        }

        // 모든 스택 요소 탐색 후 비어 있을 경우 T 비어 있지 않을 경우 F
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses_20 solution = new ValidParentheses_20();
        String s = "()";

        System.out.println(solution.isValid(s)); // output: true
    }
}
