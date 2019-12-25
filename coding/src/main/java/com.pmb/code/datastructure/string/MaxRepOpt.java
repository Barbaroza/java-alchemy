package com.pmb.code.datastructure.string;

/**
 * 1156. 单字符重复子串的最大长度
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (27)
 * 题解(20)
 * 提交记录
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 * <p>
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "ababa"
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：text = "aaabaaa"
 * 输出：6
 * 示例 3：
 * <p>
 * 输入：text = "aaabbaaa"
 * 输出：4
 * 示例 4：
 * <p>
 * 输入：text = "aaaaa"
 * 输出：5
 * 示例 5：
 * <p>
 * 输入：text = "abcdef"
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 20000
 * text 仅由小写英文字母组成。
 *
 * @author lvrui
 * @star
 */
public class MaxRepOpt {
    public int maxRepOpt(String text) {
        int[] total = new int[26]; // 关键的地方。先记录下每个字母的出现次数
        char[] chars = text.toCharArray();
        for (char c : chars) {
            total[c - 'a']++;
        }
        /** 声明一堆变量 */
        int index = 0; // 遍历用的游标
        int next = 1; // 下个窗口的起始位置
        int count = 1; // 窗口内计数
        boolean fake = false; // 是否替换了。
        int max = 0; // 结果
        char c = chars[0]; // 用于比较的char

        while (index < chars.length - 1) { // 遍历到倒数第二个。

            if (c != chars[index + 1]) { // 下一个char 是否与c 相同，相同的话，直接++。
                if (fake) { // 如果已经替换过了。那么就直接求Max，并重置所有变量
                    max = Math.max(max, Math.min(count, total[c - 'a']));
                    index = next;
                    count = 1;
                    c = chars[index];
                    fake = false;
                } else {
                    fake = true; // 标注替换。
                    next = index + 1; // 记录下此窗口的开始的坐标。
                    count++;
                    index++;
                }
            } else {
                count++;
                index++;
            }
        }
        max = Math.max(max, Math.min(count, total[c - 'a']));
        return max;

    }

    /**
     * 1.使用total数组记录下每个字符出现的总次数
     * 2.用left数组记录索引i(其对应的时arr[i])位置的左边从0开始到i位置出现的连续重复字符的个数
     * 用right数组记录从len-1到i位置出现的连续重复字符的个数，记录最长的重复字符的个数（不出现aaabccc这种case时的）
     * 3.arr[i]的左边left[i-1]和arr[i]的右边right[i+1]的对比：
     * total[i-1]>left[i-1] -->result = max(result,left[i-1]+1)
     * 如abaaacddd中 i=6时为c，total[6-1] =4 left[6-1] =3 4>3 可以把第0个a与c交换或与b交换，abaaacddd-->baaaacddd
     * 同理，total[i+1]>right[i+1]-->result = max(result,right[i+1]+1)
     * 如abaaacddded i=6为c total[6+1]=4 right[6+1]=3 4>3 可以把第10个d与第9个e进行交换，abaaacddded-->abaaacdddde
     * 如果出现arr[i-1]=arr[i+1] & arr[i-1]!=arr[i] 这时需要判断total[i-1]与left[i-1]+right[i+1]的大小，
     * 相等的话，证明只能此left[i-1]的开头拿走字符或是从right[i+1]的结尾拿走字符
     * 如aaacaaaa 如i=3时为c,要想组成最长的连续单一字符，需要从前面部分[0-2] 或是后面部分[4-7] 拿走a与c进行调换aaacaaaa--->caaaaaaa
     * 不相等的话，说明其他的地方有空余
     * 如abaaacaaaa 如i=5时为c，第0个a与第5个c进行调换abaaacaaaa-->cbaaaaaaaa
     * <p>
     * 作者：a-fei-8
     * 链接：https://leetcode-cn.com/problems/swap-for-longest-repeated-character-substring/solution/xiang-xi-de-jie-shi-jia-shang-yi-xie-li-zi-by-a-fe/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @return
     */
    public int maxRepOpt1(String text) {
        char[] chas = text.toCharArray();
        int len = chas.length;
        int[] total = new int[26];
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 0; i < len; i++) total[chas[i] - 'a']++;
        int result = 1;
        int cnt = 1;
        left[0] = 1;//初始化left
        for (int i = 1; i < len; i++) {
            if (chas[i] == chas[i - 1]) cnt++;
            else cnt = 1;
            left[i] = cnt;
            result = Math.max(result, left[i]);
        }
        cnt = 1;
        right[len - 1] = 1;//初始化right
        for (int i = len - 2; i >= 0; i--) {
            if (chas[i] == chas[i + 1]) cnt++;
            else cnt = 1;
            right[i] = cnt;
            result = Math.max(result, right[i]);
        }
        for (int i = 1; i < len - 1; i++) {
            if (total[chas[i - 1] - 'a'] > left[i - 1]) {
                result = Math.max(result, left[i - 1] + 1);
            }
            if (total[chas[i + 1] - 'a'] > right[i + 1]) {
                result = Math.max(result, right[i + 1] + 1);
            }
            if (chas[i - 1] == chas[i + 1] && chas[i - 1] != chas[i]) {
                if (total[chas[i - 1] - 'a'] > (left[i - 1] + right[i + 1])) {
                    result = Math.max(result, left[i - 1] + right[i + 1] + 1);
                } else {
                    result = Math.max(result, left[i - 1] + right[i + 1]);
                }
            }

        }
        return result;
    }


    public static void main(String[] args) {
        MaxRepOpt maxRepOpt = new MaxRepOpt();
        maxRepOpt.maxRepOpt("aabbaa");
    }
}
