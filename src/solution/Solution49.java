package solution;

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
//        字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
//
//
//
//        示例 1:
//
//        输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//        输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//        示例 2:
//
//        输入: strs = [""]
//        输出: [[""]]
//        示例 3:
//
//        输入: strs = ["a"]
//        输出: [["a"]]
//

import java.util.*;

/**
 * @author Zhijian.H
 * @since 2024/11/9 下午4:16
 */
public class Solution49 {

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> groupStrs = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> charNumMap = new TreeMap<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!charNumMap.containsKey(c)) {
                    charNumMap.put(c, 1);
                } else {
                    charNumMap.put(c, charNumMap.get(c) + 1);
                }
            }

            groupStrs.computeIfAbsent(charNumMap.toString(), v -> new ArrayList<>()).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> entry : groupStrs.values()) {
            result.add(entry);
        }
        return result;
    }


    public static void main(String[] args) {

            String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
            System.out.println(groupAnagrams(strs));
            strs = new String[]{"bur", "rub"};
            System.out.println(groupAnagrams(strs));
    }
}
