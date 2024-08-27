package newmind_2408;

import java.util.*;

public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> duplicateNum = new HashSet<>();
        for (int num : nums) {
            if (duplicateNum.contains(num)) return true;
            duplicateNum.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate_217 test = new ContainsDuplicate_217();
        int[] nums = {3,3}; // output true

        System.out.println(test.containsDuplicate(nums));
    }
}
