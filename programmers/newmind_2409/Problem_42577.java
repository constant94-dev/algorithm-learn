package newmind_2409;

import java.util.*;

public class Problem_42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        String pivot = phone_book[0];
        // 가장 짧은 문자열 찾기
        for (String str : phone_book) {
            if (str.length() < pivot.length()) pivot = str;
        }

        int pivotLen = pivot.length();
        for (String num : phone_book) {
            if (pivot.equals(num)) continue; // 전화번호 목록과 같은 번호는 pass

            String prefix = num.substring(0, pivotLen); // 비교 문자열의 접두사 부분을 자르기
            if (pivot.equals(prefix)) {
                answer = false; // 기준이 되는 문자열과 접두사가 같으면 결과 false 변경
                return answer;
            }
        }

        // 위 과정을 마무리 후 결과 반환
        return answer;
    }

    public boolean otherSolution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : phone_book) {
            map.put(str, 1);
        }

        for (String num : phone_book) {
            for (int i = 1; i < num.length(); i++) {
                String prefix = num.substring(0, i);
                if (map.containsKey(prefix)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Problem_42577 test = new Problem_42577();
        String[] phone_book = {"119","97674223","1195524421"};

        //System.out.println(test.solution(phone_book)); // output: false
        System.out.println(test.otherSolution(phone_book));
    }
}
