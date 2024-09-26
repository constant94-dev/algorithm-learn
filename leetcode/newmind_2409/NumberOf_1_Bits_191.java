package newmind_2409;

public class NumberOf_1_Bits_191 {
    // Time: O(logN)
    // Space: O(logN)
    public int hammingWeight(int n) {
        int count = 0; // 이진수 표현에 비트 설정된 수
        String binaryStr = Integer.toBinaryString(n); // 정수를 이진수로 변환
        for (char c : binaryStr.toCharArray()) {
            if ((c - '0') == 1) { // 이진수 표현을 순회하며 숫자 '1' 만나면 카운트 1 증가
                count++;
            }
        }

        // 위 과정을 마무리 후 카운트 반환
        return count;
    }

    // Time: O(h) (여기서 h는 1의 개수)
    // Space: O(1)
    public int otherHammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOf_1_Bits_191 solution = new NumberOf_1_Bits_191();
        int n = 11;

        //System.out.println(solution.hammingWeight(n)); // output: 3
        System.out.println(solution.otherHammingWeight(n));
    }
}
