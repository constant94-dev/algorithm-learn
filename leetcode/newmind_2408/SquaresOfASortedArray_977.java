package newmind_2408;

import java.util.Arrays;

public class SquaresOfASortedArray_977 {

    // Time: O(NlogN)
    // Space: O(1)
    public int[] sortedSquares(int[] nums) {
        // 1. 배열 순회하며 각 요소 제곱 후 저장
        int length = nums.length;
        for (int num=0; num<length; num++) {
            nums[num] = (int) Math.pow(nums[num], 2);
        }

        // 2. 오름차순 정렬 후 반환
        Arrays.sort(nums);
        return nums;
    }

    // Time: O(N)
    // Space: O(N)
    public int[] otherSolution(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int l = 0;
        int r = length - 1;

        // 좌,우 요소 제곱 값을 확인해보며 더 큰 수를 결과 배열의 하나씩 저장
        for (int num = length-1; num>=0; num--) {
            int currMax = Math.max(nums[r]*nums[r], nums[l]*nums[l]);
            res[num] = currMax;

            if (res[num] == nums[r]*nums[r]) { // 결과 배열 끝 요소가 입력 배열 끝 요소와 같을 경우
                r--; // 입력 배열 끝 요소 한 단계 전 요소로 위치 이동
            } else { // 결과 배열 끝 요소가 입력 배열 끝 요소와 다를 경우
                l++; // 입력 배열 시작 요소 한 단계 후 요소로 위치 이동
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SquaresOfASortedArray_977 test = new SquaresOfASortedArray_977();
        int[] nums = {-4,-1,0,3,10}; // output [0,1,9,16,100]
        int[] otherNums = {-4,-1,0,3,10}; // output [0,1,9,16,100]

        System.out.println("solution: " + Arrays.toString(test.sortedSquares(nums)));
        System.out.println("otherSolution: " + Arrays.toString(test.otherSolution(otherNums)));
    }
}
