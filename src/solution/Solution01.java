package solution;

import java.util.Arrays;

//Given an array of integers nums and an integer target, return indices of the t
//wo numbers such that they add up to target.
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice.
//
// You can return the answer in any order.
//
//
// Example 1:
//
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//
// Example 2:
//
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//
//
// Example 3:
//
//
//Input: nums = [3,3], target = 6
//Output: [0,1]
//
//
//
// Constraints:
//
//
// 2 <= nums.length <= 103
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.
//
// Related Topics Array Hash Table
// 👍 20600 👎 723


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * @author Zhijian.H
 * @since 2021/4/28 下午10:15
 */
public class Solution01 {

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1} ;
    }

    public static void main(String[] args) {
        Solution01 solution = new Solution01();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 3}, 6)));

    }
}
