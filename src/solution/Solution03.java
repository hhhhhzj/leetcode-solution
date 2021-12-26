package solution;

import java.util.*;
//Given a string s, find the length of the longest substring without repeating c
//haracters.
//
//
// Example 1:
//
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//
//
// Example 2:
//
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//
//
// Example 3:
//
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a
//substring.
//
//
// Example 4:
//
//
//Input: s = ""
//Output: 0
//
//
//
// Constraints:
//
//
// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.
//
// Related Topics Hash Table Two Pointers String Sliding Window
// 👍 14135 👎 730

import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhijian.H
 * @since 2021/5/1 下午2:14
 */
public class Solution03 {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int start = 0, end = 0;
        Set<Character> set = new HashSet<Character>();
        while (start < s.length() && end < s.length()) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            } else {
                set.add(s.charAt(end));
                end++;
                result = Math.max(result, end - start);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution03 solution = new Solution03();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("fabcbcbb"));
    }
}
