package solution;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//        请注意 ，必须在不复制数组的情况下原地对数组进行操作。
//
//
//
//        示例 1:
//
//        输入: nums = [0,1,0,3,12]
//        输出: [1,3,12,0,0]
//        示例 2:
//
//        输入: nums = [0]
//        输出: [0]
//
//
//        提示:
//
//        1 <= nums.length <= 104
//        -231 <= nums[i] <= 231 - 1
//
//
//        进阶：你能尽量减少完成的操作次数吗？

/**
 * @author Zhijian.H
 * @since 2024/11/9 下午10:51
 */
public class Solution238 {

    public static void moveZeroes(int[] nums) {

        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                for (int j = zeroIndex; j < nums.length && j < i; j++) {
                    if (nums[j] == 0) {
                        swap(nums, i, j);
                        zeroIndex = j + 1;
                        break;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
       int[] nums = new int[]{0,1,0,3,12};
       moveZeroes(nums);
       System.out.println(nums);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
