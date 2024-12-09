package solution;

import java.util.*;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的
 * 异位词
 *  的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 *
 * 提示:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */

/**
 * @author Zhijian.H
 * @since 2024/11/10 下午11:51
 */
public class Solution438 {

    public List<Integer> findAnagrams(String s, String p) {

        if (s.length() < p.length()) {
            return Collections.emptyList();
        }

        Map<Character, Integer> slidFreq = new HashMap<>();
        Map<Character, Integer> pFreq = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            addCharacter(pFreq, p.charAt(i));
            addCharacter(slidFreq, s.charAt(i));
        }
        List<Integer> result = new ArrayList<>();

        if (slidFreq.equals(pFreq)) {
            result.add(0);
        }

        for (int j = p.length(); j < s.length(); j++) {
            addCharacter(slidFreq, s.charAt(j));
            int startIndex = j - p.length();
            removeCharacter(slidFreq, s.charAt(startIndex));
            if (slidFreq.equals(pFreq)) {
                result.add(startIndex + 1);
            }
        }

        return result;
    }

    private void addCharacter(Map<Character, Integer> pFreq, Character c) {
        if (!pFreq.containsKey(c)) {
            pFreq.put(c, 1);
        } else {
            pFreq.put(c, pFreq.get(c) + 1);
        }
    }

    private void removeCharacter(Map<Character, Integer> pFreq, Character c) {
        pFreq.put(c, pFreq.get(c) - 1);
        if (pFreq.get(c) <= 0) {
            pFreq.remove(c);
        }
    }



    public static void main(String[] args) {
        Solution438 solution = new Solution438();
        String s = "cbaebabacd", p = "abc";
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println(result);
    }
}
