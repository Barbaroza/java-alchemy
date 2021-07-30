package com.pmb.cp;

import java.util.*;

/**
 * @author lvrui
 */
public class Week57_1 {

    /**
     * * 5806. 描述绘画结果
     * * 给你一个细长的画，用数轴表示。这幅画由若干有重叠的线段表示，每个线段有 独一无二 的颜色。给你二维整数数组 segments ，其中 segments[i] = [starti, endi, colori] 表示线段为 半开区间 [starti, endi) 且颜色为 colori 。
     * * <p>
     * * 线段间重叠部分的颜色会被 混合 。如果有两种或者更多颜色混合时，它们会形成一种新的颜色，用一个 集合 表示这个混合颜色。
     * * <p>
     * * 比方说，如果颜色 2 ，4 和 6 被混合，那么结果颜色为 {2,4,6} 。
     * * 为了简化题目，你不需要输出整个集合，只需要用集合中所有元素的 和 来表示颜色集合。
     * * <p>
     * * 你想要用 最少数目 不重叠 半开区间 来 表示 这幅混合颜色的画。这些线段可以用二维数组 painting 表示，其中 painting[j] = [leftj, rightj, mixj] 表示一个 半开区间[leftj, rightj) 的颜色 和 为 mixj 。
     * * <p>
     * * 比方说，这幅画由 segments = [[1,4,5],[1,7,7]] 组成，那么它可以表示为 painting = [[1,4,12],[4,7,7]] ，因为：
     * * [1,4) 由颜色 {5,7} 组成（和为 12），分别来自第一个线段和第二个线段。
     * * [4,7) 由颜色 {7} 组成，来自第二个线段。
     * * 请你返回二维数组 painting ，它表示最终绘画的结果（没有 被涂色的部分不出现在结果中）。你可以按 任意顺序 返回最终数组的结果。
     * * <p>
     * * 半开区间 [a, b) 是数轴上点 a 和点 b 之间的部分，包含 点 a 且 不包含 点 b 。
     * * <p>
     * * <p>
     * * <p>
     * * 示例 1：
     * * <p>
     * * <p>
     * * 输入：segments = [[1,4,5],[4,7,7],[1,7,9]]
     * * 输出：[[1,4,14],[4,7,16]]
     * * 解释：绘画借故偶可以表示为：
     * * - [1,4) 颜色为 {5,9} （和为 14），分别来自第一和第二个线段。
     * * - [4,7) 颜色为 {7,9} （和为 16），分别来自第二和第三个线段。
     * * 示例 2：
     * * <p>
     * * <p>
     * * 输入：segments = [[1,7,9],[6,8,15],[8,10,7]]
     * * 输出：[[1,6,9],[6,7,24],[7,8,15],[8,10,7]]
     * * 解释：绘画结果可以以表示为：
     * * - [1,6) 颜色为 9 ，来自第一个线段。
     * * - [6,7) 颜色为 {9,15} （和为 24），来自第一和第二个线段。
     * * - [7,8) 颜色为 15 ，来自第二个线段。
     * * - [8,10) 颜色为 7 ，来自第三个线段。
     * * 示例 3：
     * * <p>
     * * <p>
     * * 输入：segments = [[1,4,5],[1,4,7],[4,7,1],[4,7,11]]
     * * 输出：[[1,4,12],[4,7,12]]
     * * 解释：绘画结果可以表示为：
     * * - [1,4) 颜色为 {5,7} （和为 12），分别来自第一和第二个线段。
     * * - [4,7) 颜色为 {1,11} （和为 12），分别来自第三和第四个线段。
     * * 注意，只返回一个单独的线段 [1,7) 是不正确的，因为混合颜色的集合不相同。
     * * <p>
     * * <p>
     * * 提示：
     * * <p>
     * * 1 <= segments.length <= 2 * 104
     * * segments[i].length == 3
     * * 1 <= starti < endi <= 105
     * * 1 <= colori <= 109
     * * 每种颜色 colori 互不相同。
     * * 通过次数709提交次数2,330
     * *
     *
     * @param segments
     * @return
     */
    public List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Integer, ArrayList<Integer>[]> map = new TreeMap<>();
        for (int i = 0; i < segments.length; i++) {
            if (!map.containsKey(segments[i][0])) {
                map.put(segments[i][0], new ArrayList[]{new ArrayList<>(), new ArrayList<>()});
            }
            map.get(segments[i][0])[0].add(i);
            if (!map.containsKey(segments[i][1])) {
                map.put(segments[i][1], new ArrayList[]{new ArrayList<>(), new ArrayList<>()});
            }
            map.get(segments[i][1])[1].add(i);
        }
        ArrayList<List<Long>> result = new ArrayList<>();
        long prev = 0, count = 0;
        for (int i : map.keySet()) {
            if (count > 0) {
//                result.add(List.of(prev, (long) i, count));
            }
            for (int j : map.get(i)[0]) {
                count += segments[j][2];
            }
            for (int j : map.get(i)[1]) {
                count -= segments[j][2];
            }
            prev = i;
        }
        return result;
    }

    /**
     * 5805. 最小未被占据椅子的编号
     * 有 n 个朋友在举办一个派对，这些朋友从 0 到 n - 1 编号。派对里有 无数 张椅子，编号为 0 到 infinity 。当一个朋友到达派对时，他会占据 编号最小 且未被占据的椅子。
     * <p>
     * 比方说，当一个朋友到达时，如果椅子 0 ，1 和 5 被占据了，那么他会占据 2 号椅子。
     * 当一个朋友离开派对时，他的椅子会立刻变成未占据状态。如果同一时刻有另一个朋友到达，可以立即占据这张椅子。
     * <p>
     * 给你一个下标从 0 开始的二维整数数组 times ，其中 times[i] = [arrivali, leavingi] 表示第 i 个朋友到达和离开的时刻，同时给你一个整数 targetFriend 。所有到达时间 互不相同 。
     * <p>
     * 请你返回编号为 targetFriend 的朋友占据的 椅子编号 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：times = [[1,4],[2,3],[4,6]], targetFriend = 1
     * 输出：1
     * 解释：
     * - 朋友 0 时刻 1 到达，占据椅子 0 。
     * - 朋友 1 时刻 2 到达，占据椅子 1 。
     * - 朋友 1 时刻 3 离开，椅子 1 变成未占据。
     * - 朋友 0 时刻 4 离开，椅子 0 变成未占据。
     * - 朋友 2 时刻 4 到达，占据椅子 0 。
     * 朋友 1 占据椅子 1 ，所以返回 1 。
     * 示例 2：
     * <p>
     * 输入：times = [[3,10],[1,5],[2,6]], targetFriend = 0
     * 输出：2
     * 解释：
     * - 朋友 1 时刻 1 到达，占据椅子 0 。
     * - 朋友 2 时刻 2 到达，占据椅子 1 。
     * - 朋友 0 时刻 3 到达，占据椅子 2 。
     * - 朋友 1 时刻 5 离开，椅子 0 变成未占据。
     * - 朋友 2 时刻 6 离开，椅子 1 变成未占据。
     * - 朋友 0 时刻 10 离开，椅子 2 变成未占据。
     * 朋友 0 占据椅子 2 ，所以返回 2 。
     * <p>
     * <p>
     * 提示：
     * <p>
     * n == times.length
     * 2 <= n <= 104
     * times[i].length == 2
     * 1 <= arrivali < leavingi <= 105
     * 0 <= targetFriend <= n - 1
     * 每个 arrivali 时刻 互不相同 。
     *
     * @param times
     * @param targetFriend
     * @return
     */
    public int smallestChair(int[][] times, int targetFriend) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            list.add(new int[]{i, 0});
            list.add(new int[]{i, 1});
        }
        Collections.sort(list,
                (a, b) -> times[a[0]][a[1]] == times[b[0]][b[1]] ? b[1] - a[1] : times[a[0]][a[1]] - times[b[0]][b[1]]);
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] i : list) {
            //如果是进来
            if (i[1] == 0) {
                //{人index,0}
                map.put(i[0], set.isEmpty() ? map.size() : set.pollFirst());
                if (i[0] == targetFriend) {
                    return map.get(i[0]);
                }
            } else {
                set.add(map.remove(i[0]));
            }
        }
        return 0;
    }


    /**
     * 5196. 队列中可以看到的人数
     * 有 n 个人排成一个队列，从左到右 编号为 0 到 n - 1 。给你以一个整数数组 heights ，每个整数 互不相同，heights[i] 表示第 i 个人的高度。
     * <p>
     * 一个人能 看到 他右边另一个人的条件是这两人之间的所有人都比他们两人 矮 。更正式的，第 i 个人能看到第 j 个人的条件是 i < j 且 min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]) 。
     * <p>
     * 请你返回一个长度为 n 的数组 answer ，其中 answer[i] 是第 i 个人在他右侧队列中能 看到 的 人数 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：heights = [10,6,8,5,11,9]
     * 输出：[3,1,2,1,1,0]
     * 解释：
     * 第 0 个人能看到编号为 1 ，2 和 4 的人。
     * 第 1 个人能看到编号为 2 的人。
     * 第 2 个人能看到编号为 3 和 4 的人。
     * 第 3 个人能看到编号为 4 的人。
     * 第 4 个人能看到编号为 5 的人。
     * 第 5 个人谁也看不到因为他右边没人。
     * 示例 2：
     * <p>
     * 输入：heights = [5,1,2,3,10]
     * 输出：[4,1,1,1,0]
     * <p>
     * <p>
     * 提示：
     * <p>
     * n == heights.length
     * 1 <= n <= 105
     * 1 <= heights[i] <= 105
     * heights 中所有数 互不相同 。
     * 通过次数625提交次数1,466
     */
    public int[] canSeePersonsCount(int[] heights) {
            int n = heights.length;
            int[] ans = new int[n];
            Deque<Integer> dq = new ArrayDeque<>(n);
            for (int i = n - 1; i >= 0; i--) {
                int h = heights[i];
                int pop = 0;
                while (!dq.isEmpty() && dq.peekFirst() <= h) {
                    pop++;
                    dq.removeFirst();
                }
                if (!dq.isEmpty()) {
                    pop++;
                }
                ans[i] = pop;
                dq.addFirst(h);
            }
            return ans;
    }

    /**
     * /**
     * * 5804. 检查是否所有字符出现次数相同
     * * 给你一个字符串 s ，如果 s 是一个 好 字符串，请你返回 true ，否则请返回 false 。
     * *
     * * 如果 s 中出现过的 所有 字符的出现次数 相同 ，那么我们称字符串 s 是 好 字符串。
     * *
     * *
     * *
     * * 示例 1：
     * *
     * * 输入：s = "abacbc"
     * * 输出：true
     * * 解释：s 中出现过的字符为 'a'，'b' 和 'c' 。s 中所有字符均出现 2 次。
     * * 示例 2：
     * *
     * * 输入：s = "aaabb"
     * * 输出：false
     * * 解释：s 中出现过的字符为 'a' 和 'b' 。
     * * 'a' 出现了 3 次，'b' 出现了 2 次，两者出现次数不同。
     * * @author lvrui
     */


    public boolean areOccurrencesEqual(String s) {
        char[] chars = s.toCharArray();
        int[] cntMap = new int[26];
        Set<Character> keys = new HashSet<>();
        for (char lex : chars) {
            cntMap[lex - 'a']++;
            keys.add(lex);
        }
        int pre = -1;
        for (Character cnt : keys) {
            int index = cnt - 'a';
            pre = pre == -1 ? cntMap[index] : pre;
            if (cntMap[index] != pre) {
                return false;
            }
        }
        return true;
    }
}
