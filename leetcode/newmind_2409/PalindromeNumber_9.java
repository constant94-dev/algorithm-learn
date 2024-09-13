package newmind_2409;

public class PalindromeNumber_9 {
    // Time: O(logN)
    // Space: O(1)
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x); // input 정수를 문자열로 변환
        int left = 0, right = str.length() - 1;

        while (left <= right) { // left 인덱스 <= right 인덱스 loop
            // left 문자 != right 문자 false 반환
            if (str.charAt(left) != str.charAt(right)) return false;

            // left 1 증가, right 1 감소
            left++;
            right--;
        }

        // 위 과정을 마무리 후 true 반환
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber_9 solution = new PalindromeNumber_9();
        int x = -121;

        System.out.println(solution.isPalindrome(x)); // output: false
    }
}
