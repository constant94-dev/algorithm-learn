package newmind_2409;

import java.util.Arrays;

public class LongestCommonPrefix_14 {

    // Time: O(N*MlogN) → (여기서 n은 문자열의 개수, m은 가장 긴 문자열의 길이)
    // Space: O(N) → (입력 배열과 정렬 과정에서 사용되는 공간)
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String startPivot = strs[0];
        String endPivot = strs[strs.length-1];
        int idx = 0;

        while (idx < startPivot.length() && idx < endPivot.length()) { // 문자열 길이가 '0'보다 클 경우
            if (startPivot.charAt(idx) == endPivot.charAt(idx)) { // 비교하는 문자가 같을 경우
                idx++; // 다음 문자 확인
                continue;
            }
            break; // 비교하는 문자가 다를 경우 loop 종료
        }

        return startPivot.substring(0, idx); // 공통 접두사 idx 값 전 까지 반환
    }


    public static void main(String[] args) {
        LongestCommonPrefix_14 solution = new LongestCommonPrefix_14();
        String[] strs = {"aa","abc"};

        System.out.println(solution.longestCommonPrefix(strs)); // output: "a"
    }
}
