package newmind_2408;

import java.util.Arrays;

public class Newmind_twosum {
    public int[] solution(int[] nums, int target) {
        int[] result = new int[2];
        int numLength = nums.length;

        for (int pivot=0; pivot<numLength; pivot++) {
            for (int compare=0; compare<numLength; compare++) {
                if (pivot == compare) continue;

                // 1. 첫 요소 부터 기준을 잡고 다음 요소를 '+' 연산
                int twoSum = nums[pivot] + nums[compare];
                if (isTarget(twoSum, target)) { // 2. 두 요소를 '+'한 값이 target과 같은지 비교
                    // 3. 같을 경우 두 요소의 인덱스 번호를 순서대로 배열로 저장
                    result[0] = pivot;
                    result[1] = compare;

                    return result;
                }
            }
        }
        return result;
    }

    private boolean isTarget(int twoSum, int target) {
        return twoSum == target;
    }


    public static void main(String[] args) {
        Newmind_twosum test = new Newmind_twosum();
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(test.solution(nums, target)));
    }
}
