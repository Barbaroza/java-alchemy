package com.pmb.wait;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 842. 将数组拆分成斐波那契序列
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * <p>
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 * <p>
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * <p>
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："123456579"
 * 输出：[123,456,579]
 * 示例 2：
 * <p>
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * 示例 3：
 * <p>
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * 示例 4：
 * <p>
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * 示例 5：
 * <p>
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 字符串 S 中只含有数字。
 * 通过次数25,966提交次数52,734
 *
 * @author lvrui
 */
public class SplitIntoFibonacci {
    public List<Integer> splitIntoFibonacci(String S) {
        LinkedList<Integer> deque = new LinkedList<>();
        backTrack(0, deque, S.toCharArray());
        return deque;
    }

    private boolean backTrack(int index, LinkedList<Integer> deque, char[] s) {
        if (index == s.length && deque.size() >= 3) {
            return true;
        }
        for (int i = index; i < s.length; i++) {
            if (i > index && s[i] == '0') {
                break;
            }
            long num = subArray(s, index, i + 1);
            if (num > Integer.MAX_VALUE) {
                break;
            }

            int size = deque.size();

            if (size > 1 && deque.get(size - 1) + deque.get(size - 2) < num) {
                break;
            }
            if (size < 2 || deque.get(size - 1) + deque.get(size - 2) == num) {
                deque.addLast((int) num);
                if (backTrack(i + 1, deque, s)) {
                    return true;
                }
                deque.removeLast();
            }

        }

        return false;
    }

    private long subArray(char[] nums, int start, int end) {
        long res = 0;
        while (start < end) {
            res = res * 10 + nums[start] - '0';
            start++;
        }
        return res;
    }

    public List<Integer> splitIntoFibonacci2(String S) {
        List<Integer> list = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backTrack(list, path, 0, S);

        return list;
    }

    private boolean backTrack(List<Integer> list, LinkedList<Integer> path, int start, String str) {
        if (path.size() > 2 && start == str.length()) {
            list.addAll(path);
            return true;
        }
        boolean flag = false;
        for (int i = start + 1; i <= str.length() && !flag; i++) {
            String substring = str.substring(start, i);
            if (substring.startsWith("0")) {
                break;
            }
            Integer slice = Integer.valueOf(substring);
            if ((path.size() > 1 && path.get(path.size() - 1) + path.get(path.size() - 2) == slice) || path.size() < 2) {
                path.addLast(slice);
                flag = backTrack(list, path, i, str);
                path.removeLast();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SplitIntoFibonacci fibonacci = new SplitIntoFibonacci();
        List<Integer> integers = fibonacci.splitIntoFibonacci("123456579");
    }
}
