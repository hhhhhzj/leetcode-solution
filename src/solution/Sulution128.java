package solution;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
//        请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//
//
//
//        示例 1：
//
//        输入：nums = [100,4,200,1,3,2]
//        输出：4
//        解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//        示例 2：
//
//        输入：nums = [0,3,7,2,5,8,4,6,0,1]
//        输出：9
//
//
//        提示：
//
//        0 <= nums.length <= 105
//        -109 <= nums[i] <= 109


import java.util.HashMap;

/**
 * @author Zhijian.H
 * @since 2024/11/9 下午9:51
 */
public class Sulution128 {

    /**
     * 第一想法是：是排序，再遍历。题目中限制了复杂度为O(n), 任何排序都不行。这个时候能想到空间换时间。最开始的想法是使用bit。再看一下题目中数字数量10w级别，范围，
     * 不太划算。
     * 这道题很巧妙，用哈希表存储每个端点值对应连续区间的长度
     * 若数已在哈希表中：跳过不做处理
     * 若是新数加入：
     * 取出其左右相邻数已有的连续区间长度 left 和 right
     * 计算当前数的区间长度为：cur_length = left + right + 1
     * 根据 cur_length 更新最大长度 max_length 的值
     * 更新区间两端点的长度值

     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.get(num - 1) == null ? 0 : map.get(num - 1);
                int right = map.get(num + 1) == null ? 0 : map.get(num + 1);
                int cur = 1 + left + right;
                if (cur > res) {
                    res = cur;
                }
                map.put(num, cur);
                map.put(num - left, cur);
                map.put(num + right, cur);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));

    }

}
