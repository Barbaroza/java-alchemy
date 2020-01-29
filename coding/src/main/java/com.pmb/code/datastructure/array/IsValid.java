package com.pmb.code.datastructure.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lvrui
 */
public class IsValid {
    Map<Character, Character> positiveMap = new HashMap<>();
    Map<Character, Character> oppositeMap = new HashMap<>();

    public IsValid() {
        positiveMap.put(new Character('{'), new Character('}'));
        positiveMap.put(new Character('('), new Character(')'));
        positiveMap.put(new Character('['), new Character(']'));
        oppositeMap.put(new Character(']'), new Character('['));
        oppositeMap.put(new Character('}'), new Character('{'));
        oppositeMap.put(new Character(')'), new Character('('));
    }

    public boolean isValid(String s) {

        if (s == null || s.isEmpty()) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> current = new Stack<>();

        for (char c : chars) {
            if (positiveMap.containsKey(c)) {
                current.push(c);
            } else if (oppositeMap.containsKey(c)) {
                if (current.isEmpty()) {
                    return false;
                }
                Character pop = current.pop();
                if (!oppositeMap.get(c).equals(pop)) {
                    return false;
                }
            }

        }
        return current.isEmpty();

    }

}
