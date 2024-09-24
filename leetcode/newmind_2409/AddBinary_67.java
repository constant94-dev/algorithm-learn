package newmind_2409;

public class AddBinary_67 {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        // 끝 자리 부터 연산하기 위한 포인터 지정
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0; // 올림 수

        while (i >= 0 || j >= 0) {
            int sum = carry; // 합산 값은 (carry + c1 + c2) 이기 때문에 carry 값을 먼저 대입해서 진행
            // char유형 숫자를 정수형 변환을 위한 '0' 빼는 연산 수행
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            if (sum > 1) { // 합산 값이 1보다 크면 올림 수 1 저장
                carry = 1;
            } else { // 합산 값이 1보다 작으면 올림 수 0 저장
                carry = 0;
            }

            res.append(sum % 2); // 현재 자리 연산 결과 저장
        }

        if (carry != 0) res.append(carry); // 올림 수가 남아 있다면 결과 추가

        return res.reverse().toString(); // 지금까지 저장한 이진 수는 순서가 반대이기 때문에 역순 정렬 후 반환
    }

    public static void main(String[] args) {
        AddBinary_67 solution = new AddBinary_67();
        String a = "1110110101";
        String b = "1110111011";

        System.out.println(solution.addBinary(a, b)); // output: 11101110000
    }
}
