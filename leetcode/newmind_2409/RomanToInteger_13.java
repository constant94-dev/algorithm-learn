package newmind_2409;

import java.util.Map;

public class RomanToInteger_13 {
    // Time: O(N)
    // Space: O(N)
    public int romanToInt(String s) {
        // 로마 문양과 숫자를 가지는 Map 생성
        Map<Character, Integer> romanNumerals = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        int result = 0; // 결과 저장 변수

        // input 문자열 한 문자씩 순회하며 로마 문양 확인
        for (int i = 0; i < s.length(); i++) {
            // 6가지 사례 확인
            if ((i+1) < s.length() && isUsedSubtraction(s.charAt(i), s.charAt(i + 1))) { // 6가지 사례 해당하는 경우 (다음문자 정수변환 값 - 현재문자 정수변환 값) 결과 누적
                result += (romanNumerals.get(s.charAt(i + 1)) - romanNumerals.get(s.charAt(i)));
                i ++; // 인덱스 + 2 후 continue
                continue;
            }

            result += romanNumerals.get(s.charAt(i)); // 6가지 사례 해당 안하는 경우 (현재문자 정수변환 값) 결과 누적
        }

        // 위 과정을 마무리 후 누적 결과 반환
        return result;
    }

    private boolean isUsedSubtraction(char before, char after) {
        if (before == 'I' && (after == 'V' || after == 'X')) return true;
        if (before == 'X' && (after == 'L' || after == 'C')) return true;

        return before == 'C' && (after == 'D' || after == 'M');
    }

    // Time: O(N)
    // Space: O(N)
    public int otherSolution(String s) {
        // 로마 문양과 숫자를 가지는 Map 생성
        Map<Character, Integer> romanNumerals = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        int result = 0; // 결과 저장 변수
        int prevValue = 0; // 이전 문자에 해당하는 숫자

        int startIdx = s.length()-1; // 역순 순회를 위한 index
        // input 문자열 한 문자씩 순회하며 로마 문양 확인
        for (int i = startIdx; i >= 0; i--) {
          int currValue = romanNumerals.get(s.charAt(i)); // 현재 비교할 문자에 정수 변환 값

            // 만약 현재 값이 이전 값보다 작으면, 이는 subtractive notation을 의미
            if (currValue < prevValue) {
              result -= currValue;
          } else {
              result += currValue;
          }
          prevValue = currValue; // 현재 값을 이전 값으로 갱신
        }

        // 누적된 결과 반환
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger_13 solution = new RomanToInteger_13();
        String s = "III";

        // System.out.println(solution.romanToInt(s)); // output: 3
        System.out.println(solution.otherSolution(s)); // output: 3
    }
}
