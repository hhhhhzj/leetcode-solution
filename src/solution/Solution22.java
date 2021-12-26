package solution;

//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
//
//
// Example 1:
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:
// Input: n = 1
//Output: ["()"]
//
//
// Constraints:
//
//
// 1 <= n <= 8
//
// Related Topics String Dynamic Programming Backtracking
// 👍 10859 👎 424


import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhijian.H
 * @since 2021/12/26 下午2:32
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(3, 3, "", result);
        return result;
    }

    private void dfs(int left, int right, String res, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(res);
            return;
        }
        if (left > 0) {
            dfs(left - 1, right + 1, res + "(", result);
        }
        if (right > 0) {
            dfs(left, right - 1, res + ")", result);
        }
    }
}
