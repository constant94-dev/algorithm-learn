package newmind_2409;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {

    // Time: O(N)
    // Space: O(N)
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> charAppear = new HashMap<>();// 1. 각 문자의 출현 수를 저장하는 Map 생성
        // 2. 입력 문자열 각 문자 출현 수 저장
        for (char c : s.toCharArray()) {
            charAppear.put(c, charAppear.getOrDefault(c, 0) + 1);
        }
        // 3. 비교 문자열 각 문자 확인 출현 수 차감
        for (char c : t.toCharArray()) {
            charAppear.put(c, charAppear.getOrDefault(c, 0) - 1);
        }

        // 4. Map 저장된 모든 문자 출현 수가 '0'일 경우 Ture 반대경우 False
        return charAppear.entrySet().stream()
                .allMatch(entry -> entry.getValue() == 0);
    }

    // Time: O(N+M) → (두 문자열의 길이에 비례)
    // Space: O(N) → (Map, Stream 처리 중 Map 사용에 의해 결정됨, Stream은 추가 메모리 사용 안함)
    // Question: Unicode 문자가 포함되면 어떻게 처리할까?
    public boolean otherSolution(String s, String t) {
        // 길이가 다르면 애너그램이 아님
        if (s.codePointCount(0, s.length()) != t.codePointCount(0, t.length())) return false;

        Map<Integer, Integer> codePointCount = new HashMap<>();

        s.codePoints().forEach(codePoint ->
                codePointCount.put(codePoint, codePointCount.getOrDefault(codePoint, 0) + 1)
        );
        t.codePoints().forEach(codePoint ->
                codePointCount.put(codePoint, codePointCount.getOrDefault(codePoint, 0) - 1)
        );

        return codePointCount.values().stream().allMatch(count -> count == 0);
    }

    public static void main(String[] args) {
        ValidAnagram_242 solution = new ValidAnagram_242();
        String s = "anagram";
        String t = "nagaram";

        //System.out.println(solution.isAnagram(s, t)); // output: true
        System.out.println(solution.otherSolution(s, t)); // output: true
    }
}
