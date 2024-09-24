package newmind_2409;

public class AddBinary_67 {
    private int raise = 0;

    public String addBinary(String a, String b) {
        // 뮨자열 a,b를 정수 변환
        long numA = Long.parseLong(a);
        long numB = Long.parseLong(b);
        long sum = numA + numB; // 변환된 두 정수 합 구하기

        // 합산 값을 이진 문자열로 변환
        String sumStr = String.valueOf(sum);

        int length = sumStr.length() - 1;
        for (int idx = length; idx >= 0; idx--) {
            if (raise == 0) {
                sumStr = operRaiseZero(sumStr, idx);
                continue;
            }
            if (raise == 1) {
                sumStr = operRaiseOne(sumStr, idx);
            }
        }

        if (raise == 1) {
            return "1" + sumStr;
        }
        return sumStr;
    }

    private String operRaiseOne(String sumStr, int idx) {
        if (sumStr.charAt(idx) == '2') {
            raise = 1;
            return sumStr.substring(0, idx) + "1" + sumStr.substring(idx + 1);
        }
        if (sumStr.charAt(idx) == '1') {
            raise = 1;
            return sumStr.substring(0, idx) + "0" + sumStr.substring(idx + 1);
        }

        raise = 0;
        return sumStr.substring(0, idx) + "1" + sumStr.substring(idx + 1);
    }

    private String operRaiseZero(String sumStr, int idx) {
        if (sumStr.charAt(idx) == '2') {
            raise = 1;
            return sumStr.substring(0, idx) + "0" + sumStr.substring(idx + 1);
        }
        return sumStr;
    }

    public static void main(String[] args) {
        AddBinary_67 solution = new AddBinary_67();
        String a = "1110110101";
        String b = "1110111011";

        System.out.println(solution.addBinary(a, b)); // output: 11101110000
    }
}
