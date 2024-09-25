package newmind_2409;

import java.util.Arrays;

public class CountingBits_338 {
    // Time: O(NlogN)
    // Space: O(N)
    public int[] countBits(int n) {
        int[] ans = new int[n+1]; // 결과 정수 배열 생성
        // 정수 n까지 순회
        for (int i=0; i<=n; i++) {
            String binary = Integer.toBinaryString(i); // 이진표현 변경
            int sum = sumBinary(binary);
            ans[i] = sum; // 합산 값 배열 저장
        }

        // 위 과정 마무리 후 결과 반환
        return ans;
    }

    private int sumBinary(String binary) {
        int sum = 0;
        for (char c : binary.toCharArray()) {
            if ((c - '0') == 1) sum++; // 이진표현 숫자 '1'만 합산
        }

        return sum;
    }

    // Time: O(N)
    // Space: O(N)
    public int[] otherCountBits(int n) {
        int[] ans = new int[n+1];

        // 첫번째 요소는 '0'이기 때문에 연산 필요없어 1부터 순회
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i & (i-1)] + 1; // 비트 연산과 동적 프로그래밍 기법 사용
        }

        return ans;
    }

    public static void main(String[] args) {
        CountingBits_338 solution = new CountingBits_338();
        int n = 2;

        //System.out.println(Arrays.toString(solution.countBits(n))); // output: [0,1,1]
        System.out.println(Arrays.toString(solution.otherCountBits(n)));
    }
}
