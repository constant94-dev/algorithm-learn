package newmind_2409;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class LongestPalindrome_409 {

    // Time: O(N)
    // Space: O(N)
    public int longestPalindrome(String s) {
        // 1. 입력 문자열의 문자 빈도 수를 저장하는 Map 생성
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) +1);
        }

        if (charCount.entrySet().size() == 1) return charCount.get(s.charAt(0));

        // 2. Map 객체 순회하며 값이 짝수인 경우 결과에 추가
        int evenResult = charCount.values().stream()
                .filter(this::isEvenNumber)
                .mapToInt(num -> num)
                .sum();

        System.out.println("짝수 합 결과: "+evenResult);

        int oddResult = charCount.values().stream()
                .filter(this::isOddNumber)
                .mapToInt(num -> {
                    int mok = num / 2;
                    int remain = num % 2;
                    if (mok >= remain) return (num - remain);
                    return mok;
                })
                .sum();

        System.out.println("홀수 합 결과: "+oddResult);

        int result = evenResult + oddResult;

        // 3. Map 객체 값 중 홀수가 하나라도 존재하면 반환 전 +1
        if (charCount.values().stream()
                .anyMatch(this::isOddNumber)) {
            result++;
        }
        // 4. 위 과정을 마무리한 후 결과 반환
        return result;
    }

    private boolean isEvenNumber(int value) {
        return value % 2 == 0;
    }

    private boolean isOddNumber(int value) {
        return value % 2 == 1;
    }

    // Time: O(N)
    // Space: O(N)
    public int otherSolution(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        if (charCount.size() == 1) return s.length(); // 입력 문자열이 단일 문자 구성일 경우 입력 문자열 길이 반환

        AtomicBoolean hasOdd = new AtomicBoolean(false);
        // 빈도 수 값을 2로 나누었을 때
        // 짝수일 경우, 빈도 수 그대로 추가
        // 홀수일 경우, (빈도 수 - 1) 추가
        int result = charCount.values().stream()
                .mapToInt(frequency -> {
                    if (frequency % 2 == 0) return frequency;
                    hasOdd.set(true);
                    return (frequency - 1);
                })
                .sum();

        // 빈도 수 값의 홀수가 있을 경우 (결과+1)
        if (hasOdd.get()) result += 1;

        return result;
    }

    public static void main(String[] args) {
        LongestPalindrome_409 solution = new LongestPalindrome_409();
        String s = "cccdddeee";

        //System.out.println(solution.longestPalindrome(s)); // output: 7
        System.out.println(solution.otherSolution(s)); // output: 7
    }
}
