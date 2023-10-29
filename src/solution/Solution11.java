package solution;

//Given n non-negative integers a1, a2, ..., an , where each represents a point
//at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of
// the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x
//-axis forms a container, such that the container contains the most water.
//
// Notice that you may not slant the container.
//
//
// Example 1:
//
//
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
//3,7]. In this case, the max area of water (blue section) the container can conta
//in is 49.
//
//
// Example 2:
//
//
//Input: height = [1,1]
//Output: 1
//
//
// Example 3:
//
//
//Input: height = [4,3,2,1,4]
//Output: 16
//
//
// Example 4:
//
//
//Input: height = [1,2,1]
//Output: 2
//
//
//
// Constraints:
//
//
// n == height.length
// 2 <= n <= 105
// 0 <= height[i] <= 104
//
// Related Topics Array Two Pointers
// 👍 9556 👎 718


//import com.sun.tools.javac.util.Assert;

/**
 * @author Zhijian.H
 * @since 2021/12/26 下午2:32
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int maxArea = 0;

        for (int i = 0, j = height.length - 1; i < j; ) {

            if (height[i] <= height[j]) {
                int currentArea = height[i] * (j - i);
                maxArea = currentArea > maxArea ? currentArea : maxArea;
                i++;
            }

            if (height[i] > height[j]) {
                int currentArea = height[j] * (j - i);
                maxArea = currentArea > maxArea ? currentArea : maxArea;
                j--;
            }
        }

        return maxArea;
    }

//    public static void main(String[] args) {
//        Solution11 solution11 = new Solution11();
//        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
//        Assert.check(solution11.maxArea(height) == 49);
//
//        height = new int[]{2,3,4,5,18,17,6};
//        Assert.check(solution11.maxArea(height) == 17);
//    }

}
