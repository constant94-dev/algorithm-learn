package newmind_2409;

import java.util.*;

public class BackspaceStringCompare_844 {
    public boolean backspaceCompare(String s, String t) {
        Object[] sResult = removeCharacters(s);
        Object[] tResult = removeCharacters(t);
        System.out.println("param1: "+Arrays.toString(sResult));
        System.out.println("param2: "+Arrays.toString(tResult));
        // 최종 결과 s와 t가 같을 경우 T 다를경우 F
        return Arrays.equals(sResult, tResult);
    }

    private Object[] removeCharacters(String origin) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : origin.toCharArray()) {
            if (c == '#') {
                if (stack.isEmpty()) continue;
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        return stack.toArray();
    }

    public static void main(String[] args) {
        BackspaceStringCompare_844 solution = new BackspaceStringCompare_844();
        String s = "a##c";
        String t = "#a#c";

        System.out.println(solution.backspaceCompare(s, t)); // output: true
    }
}
