package newmind_2408;

import java.util.Arrays;

public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int num : nums) { // '0'이 아닌 값을 앞으로 옮긴다
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) { // 남은 공간을 '0'으로 채운다
            nums[insertPos++] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        MoveZeroes_283 test = new MoveZeroes_283();
        int[] nums = {0,1,0,3,12}; // output [1,3,12,0,0]

        test.moveZeroes(nums);
    }
}
