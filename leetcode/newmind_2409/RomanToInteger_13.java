package newmind_2409;

import java.util.Map;

public class RomanToInteger_13 {
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
            if (isUsedSubtraction(s.charAt(i), s.charAt(i + 1))) { // 6가지 사례 해당하는 경우 (다음문자 정수변환 값 - 현재문자 정수변환 값) 결과 누적
                result += (romanNumerals.get(s.charAt(i + 1)) - romanNumerals.get(s.charAt(i)));
                System.out.println("6가지 사례 o: "+ result);
                i += 2; // 인덱스 + 2 후 continue
                continue;
            }

            result += romanNumerals.get(s.charAt(i)); // 6가지 사례 해당 안하는 경우 (현재문자 정수변환 값) 결과 누적
            System.out.println("6가지 사례 x: "+ result);
        }

        // 위 과정을 마무리 후 누적 결과 반환
        return result;
    }

    private boolean isUsedSubtraction(char before, char after) {
        if (before == 'I' && (after == 'V' || after == 'X')) return true;
        if (before == 'X' && (after == 'L' || after == 'C')) return true;

        return before == 'C' && (after == 'D' || after == 'M');
    }

    public static void main(String[] args) {
        RomanToInteger_13 solution = new RomanToInteger_13();
        String s = "MCMXCIV";

        System.out.println(solution.romanToInt(s)); // output: 1994
    }
}
