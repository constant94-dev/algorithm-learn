package newmind_2408;

import java.util.Arrays;

public class MoveZeroes_283 {
    private int end = 0; // 현재 zero 위치
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        end = length-1;
        // 1. 정수 배열 순회
        for (int num=0; num < length; num++) {
            if (num >= end) break;
            if (nums[num] == 0) zeroSwap(nums, num); // 2. 숫자 '0'을 만나면 정수 배열 끝 요소와 swap
        }

        // 6. 위 과정이 마무리 되면 정수 배열의 최초 '0' 요소 인덱스 까지 정렬
        System.out.println("정렬 전 배열: "+Arrays.toString(nums));
        System.out.println("정렬 전 end: "+end);
        Arrays.sort(nums, 0, end);

        // 최종 결과 출력
        System.out.println(Arrays.toString(nums));
    }

    private void zeroSwap(int[] nums, int zeroIndex) {
        int temp;
        if (nums[end] == 0) { // 3. 끝 요소가 '0'이면 끝 요소가 '0'이 아닌 요소 찾기
            int noZeroIndex = searchNoZero(nums);
            if (noZeroIndex == 0) { // FIXME 1,0,0 은 통과 하지만 0,1,0,1 통과 안됨
                end = 0;
                return;
            }
            System.out.println("현재 noZeroIndex: "+noZeroIndex);
            // 5-1. 찾은 인덱스 요소와 swap
            temp = nums[zeroIndex];
            nums[zeroIndex] = nums[noZeroIndex];
            nums[noZeroIndex] = temp;

            end = noZeroIndex;
            return;
        }
        // 3-1. 끝 요소가 '0'이 아니면 swap
        temp = nums[zeroIndex];
        nums[zeroIndex] = nums[end];
        nums[end] = temp;
    }

    private int searchNoZero(int[] nums) {
        for (int num=end; num > 0; num--) { // 4. 정수 배열 끝 요소 부터 순회
            if (nums[num] != 0) return num; // 5. 숫자 '0'이 아닌 수를 만나면 해당 인덱스 요소 반환
        }

        return 0;
    }

    public static void main(String[] args) {
        MoveZeroes_283 test = new MoveZeroes_283();
        int[] nums = {1,0,0}; // output [1,0,0]

        test.moveZeroes(nums);
    }
}
