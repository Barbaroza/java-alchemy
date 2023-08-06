package com.pmb.wait.wait_2022_10;

/**
 * ####
 * https://leetcode.cn/problems/k-th-symbol-in-grammar/
 * 779. 第K个语法符号
 * 我们构建了一个包含 n 行( 索引从 1  开始 )的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 *
 * 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
 * 给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始）
 *
 *
 * 示例 1:
 *
 * 输入: n = 1, k = 1
 * 输出: 0
 * 解释: 第一行：0
 * 示例 2:
 *
 * 输入: n = 2, k = 1
 * 输出: 0
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 示例 3:
 *
 * 输入: n = 2, k = 2
 * 输出: 1
 * 解释:
 * 第一行: 0
 * 第二行: 01
 *
 *
 * 提示:
 *
 * 1 <= n <= 30
 * 1 <= k <= 2n - 1
 * @author lvrui
 */
public class KthGrammar {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return (k + 1) % 2;
        }

        int[] pre = new int[]{0};
        int[] preXor = new int[1];

        for (int i = 3; i <= n; ++i) {
            for (int x = 0; x < pre.length; ++x) {
                preXor[x] = 1 ^ pre[x];
            }
            int[] cur = new int[1 << (i - 2)];

            System.arraycopy(pre, 0, cur, 0, pre.length);
            System.arraycopy(preXor, 0, cur, cur.length / 2, preXor.length);

            pre = cur;

            preXor = new int[cur.length];


        }
        int i = pre[(k-1) / 2];
        return i == 0 ? (k % 2 == 0 ? 1 : 0) : (k % 2 == 0 ? 0 : 1) ;
    }


    /**
     * 首先题目给出一个 nn 行的表（索引从 11 开始）。并给出表的构造规则为：第一行仅有一个 00，然后接下来的每一行可以由上一行中 00 替换为 0101，11 替换为 1010 来生成。
     *
     * 比如当 n = 3n=3 时，第 11 行是 00，第 22 行是 0101，第 33 行是 01100110。
     * 现在要求表第 nn 行中第 kk 个数字，1 \le k \le 2 ^ n1≤k≤2
     * n
     *  。首先我们可以看到第 ii 行中会有 2^{i-1}2
     * i−1
     *   个数字，1 \le i \le n1≤i≤n，且其中第 jj 个数字按照构造规则会生第 i + 1i+1 行中的第 2*j - 12∗j−1 和 2*j2∗j 个数字，1 \le j \le 2^{i-1}1≤j≤2
     * i−1
     *  。即对于第 i + 1i+1 行中的第 xx 个数字 \textit{num}_1num
     * 1
     * ​
     *  ，1 \le x \le 2^i1≤x≤2
     * i
     *  ，会被第 ii 行中第 \lfloor \frac{x + 1}{2} \rfloor⌊
     * 2
     * x+1
     * ​
     *  ⌋ 个数字 \textit{num}_2num
     * 2
     * ​
     *   生成。且满足规则：
     *
     * 当 \textit{num}_2 = 0num
     * 2
     * ​
     *  =0 时，\textit{num}_2num
     * 2
     * ​
     *   会生成 0101：
     * \textit{num}_1 = \begin{cases} 0, & x \equiv 1 \pmod{2} \\ 1, & x \equiv 0 \pmod{2} \\ \end{cases}
     * num
     * 1
     * ​
     *  ={
     * 0,
     * 1,
     * ​
     *
     * x≡1(mod2)
     * x≡0(mod2)
     * ​
     *
     *
     * 当 num_2 = 1num
     * 2
     * ​
     *  =1 时，\textit{num}_2num
     * 2
     * ​
     *   会生成 1010：
     * \textit{num}_1 = \begin{cases} 1, & x \equiv 1 \pmod{2} \\ 0, & x \equiv 0 \pmod{2} \\ \end{cases}
     * num
     * 1
     * ​
     *  ={
     * 1,
     * 0,
     * ​
     *
     * x≡1(mod2)
     * x≡0(mod2)
     * ​
     *
     *
     * 并且进一步总结我们可以得到：\textit{num}_1 = (x \And 1) \oplus 1 \oplus \textit{num}_2num
     * 1
     * ​
     *  =(x&1)⊕1⊕num
     * 2
     * ​
     *  ，其中 \And& 为「与」运算符， \oplus⊕ 为「异或」运算符。那么我们从第 nn 不断往上递归求解，并且当在第一行时只有一个数字，直接返回 00 即可。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/k-th-symbol-in-grammar/solution/di-kge-yu-fa-fu-hao-by-leetcode-solution-zgwd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @param k
     * @return
     */
    public int kthGrammar2(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (k & 1) ^ 1 ^ kthGrammar(n - 1, (k + 1) / 2);
    }

}
