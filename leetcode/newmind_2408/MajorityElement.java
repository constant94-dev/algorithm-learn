package newmind_2408;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numByMajors = new HashMap();

        int majorAppear = nums.length / 2; // 1. 주요 요소 출연 수 계산
        for (int num : nums) { // 2. 배열 순회하며 출연 수 계산
            operAppears(numByMajors, num);
        }

        for (Map.Entry<Integer, Integer> numByMajor : numByMajors.entrySet()) {
            if (numByMajor.getValue() > majorAppear) {
                return numByMajor.getKey(); // 3. 각 요소 출연 수 중 주요 요소 출연 수 보다 큰 수 반환
            }
        }

        return 0;
    }

    private void operAppears(Map<Integer, Integer> numByMajor, int num) {
        if (numByMajor.getOrDefault(num, -1) == -1) {
            numByMajor.put(num, 1);
            return;
        }

        numByMajor.put(num, numByMajor.get(num)+1);
    }

    public static void main(String[] args) {
        MajorityElement test = new MajorityElement();
        int[] nums = {2,2,1,1,1,2,2}; // output 2

        System.out.println(test.majorityElement(nums));
    }
}
