package solution;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid.
//
// An input string is valid if:
//
//
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
//
//
//
// Example 1:
//
//
//Input: s = "()"
//Output: true
//
//
// Example 2:
//
//
//Input: s = "()[]{}"
//Output: true
//
//
// Example 3:
//
//
//Input: s = "(]"
//Output: false
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.
//
// Related Topics String Stack
// 👍 10316 👎 411


import java.util.Stack;

/**
 * @author Zhijian.H
 * @since 2021/12/26 下午2:32
 */
public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                characterStack.add(c);
                continue;
            }

            if (characterStack.isEmpty()) {
                return false;
            }
            Character character = characterStack.pop();
            if (!isCouple(character, c)) {
                return false;
            }
        }

        if (!characterStack.isEmpty()) {
            return false;
        }

        return true;
    }

    private boolean isCouple(Character first, Character second) {
        if (first == '[' && second == ']') {
            return true;
        }
        if (first == '{' && second == '}') {
            return true;
        }
        if (first == '(' && second == ')') {
            return true;
        }
        return false;
    }
}
