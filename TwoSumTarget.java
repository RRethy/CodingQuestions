/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSumTarget {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.get(target - nums[i]) != null) {
                return new int[] {map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }
}
