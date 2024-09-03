package newmind_2408;

public class ValidPalindrome_125 {

    // Time: O(N)
    // Space: O(1)
    public boolean isPalindrome(String s) {
        // 1. 입력으로 주어진 문자열을 영어 문자와 숫자 문자만 남기고 제거
        String alphanumeric = s.replaceAll("[^a-zA-Z0-9]","");
        // 2. 영어 대문자를 소문자로 변경
        String alphanumericLower = alphanumeric.toLowerCase();

        int length = alphanumericLower.length();
        int endIndex = length - 1;
        for (int index=0; index<length; index++) {
            // 3. 시작요소와 끝요소를 짝으로 비교
            // 3-1. 시작요소 인덱스가 끝요소 인덱스보다 같거나 클 경우 true 반환
            if (index >= endIndex) return true;
            if (alphanumericLower.charAt(index) != alphanumericLower.charAt(endIndex)) {
                return false; // 3-2. 시작요소와 끝요소 짝이 다르면 false 반환
            }
            endIndex--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome_125 test = new ValidPalindrome_125();
        String s = "   "; // output: true

        System.out.println(test.isPalindrome(s));
    }
}
