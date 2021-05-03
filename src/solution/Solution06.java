package solution;

import java.util.*;
//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number o
//f rows like this: (you may want to display this pattern in a fixed font for bett
//er legibility)
//
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//
//
// And then read line by line: "PAHNAPLSIIGYIR"
//
// Write the code that will take a string and make this conversion given a numbe
//r of rows:
//
//
//string convert(string s, int numRows);
//
//
//
// Example 1:
//
//
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
//
//
// Example 2:
//
//
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
//
//
// Example 3:
//
//
//Input: s = "A", numRows = 1
//Output: "A"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// s consists of English letters (lower-case and upper-case), ',' and '.'.
// 1 <= numRows <= 1000
//
// Related Topics String
// 👍 2334 👎 5785


/**
 * @author Zhijian.H
 * @since 2021/5/1 下午2:32
 */
public class Solution06 {

    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<StringBuffer> rows = new ArrayList<StringBuffer>();
        for(int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuffer());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);

            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }

            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuffer row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Solution06 solution06 = new Solution06();
        System.out.println(solution06.convert("PAYPALISHIRING", 3));
        System.out.println(solution06.convert("PAYPALISHIRING", 4));
        System.out.println(solution06.convert("A", 1));
    }
}
