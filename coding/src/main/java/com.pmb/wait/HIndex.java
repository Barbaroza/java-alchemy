package com.pmb.wait;

/**
 * 275. H 指数 II
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照 升序排列 。编写一个方法，计算出研究者的 h 指数。
 * <p>
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: citations = [0,1,3,5,6]
 * 输出: 3
 * 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
 * 由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 如果 h 有多有种可能的值 ，h 指数是其中最大的那个。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 这是 H 指数 的延伸题目，本题中的 citations 数组是保证有序的。
 * 你可以优化你的算法到对数时间复杂度吗？
 * 通过次数37,884提交次数83,347
 *
 * @author lvrui
 */
public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return -1;
        }

        int size = citations.length;
        int maxHIndex = size;
        for (int index = size - 1; index >= 0; index--) {
            if (citations[size - 1 - index] >= maxHIndex) {
                return maxHIndex;
            } else {
                maxHIndex--;
            }
        }

        return 0;
    }

    public int hIndex3(int[] citations) {
        int n = citations.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (l - r) / 2;
            if (citations[m] >= n - m) {
                r = m - 1;
            }else {
                l = m + 1;
            }
        }

        return n - l;
    }

    public int hIndex2(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        hIndex.hIndex(new int[]{0, 1});
    }
}

