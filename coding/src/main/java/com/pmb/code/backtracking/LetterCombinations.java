package com.pmb.code.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * @author lvrui
 */
public class LetterCombinations {
    private static Map<String, List<String>> map = new HashMap<>();

    static {
        map.put("2", new ArrayList<String>() {{
            add("a");
            add("b");
            add("c");
        }});
        map.put("3", new ArrayList<String>() {{
            add("d");
            add("e");
            add("f");
        }});
        map.put("4", new ArrayList<String>() {{
            add("g");
            add("h");
            add("i");
        }});
        map.put("5", new ArrayList<String>() {{
            add("j");
            add("k");
            add("l");
        }});
        map.put("6", new ArrayList<String>() {{
            add("m");
            add("n");
            add("o");
        }});
        map.put("7", new ArrayList<String>() {{
            add("p");
            add("q");
            add("r");
            add("s");
        }});
        map.put("8", new ArrayList<String>() {{
            add("t");
            add("u");
            add("v");
        }});
        map.put("9", new ArrayList<String>() {{
            add("w");
            add("x");
            add("y");
            add("z");
        }});
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits != null && !digits.isEmpty()) {
            char[] chars = digits.toCharArray();
            String stack = "";
            begin(chars, 0, res, stack);
        }
        return res;
    }

    private void begin(char[] chars, int index, List<String> res, String stack) {
        if (index == chars.length) {
            res.add(stack);
            return;
        }
        List<String> strings = map.get(String.valueOf(chars[index]));
        for (int i = 0; i < strings.size(); i++) {
            begin(chars, index + 1, res, stack + strings.get(i));
        }
    }

    /**
     * 尝试优化
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        if (digits != null && !digits.isEmpty()) {
            char[] chars = digits.toCharArray();
            StringBuilder letterBuilder = new StringBuilder();
            List<List<String>> matrix = new ArrayList<>(chars.length);
            for (char digital : chars) {
                matrix.add(map.get(String.valueOf(digital)));
            }
            dfs(matrix, 0, res, letterBuilder);


        }
        return res;
    }

    private void dfs(List<List<String>> matrix, int i, List<String> res, StringBuilder letterBuilder) {
        if (i < matrix.size()) {
            List<String> strings = matrix.get(i);
            for (String character : strings) {
                letterBuilder.append(character);
                if (letterBuilder.length() == matrix.size()) {
                    res.add(letterBuilder.toString());
                } else {
                    dfs(matrix, i + 1, res, letterBuilder);
                }
                letterBuilder.deleteCharAt(letterBuilder.length() - 1);
            }
        }
    }


    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        letterCombinations.letterCombinations("23");
    }
}
