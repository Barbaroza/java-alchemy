package com.pmb.wait;

import java.util.*;

/**
 * 218. 天际线问题
 * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回由这些建筑物形成的 天际线 。
 * <p>
 * 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
 * <p>
 * lefti 是第 i 座建筑物左边缘的 x 坐标。
 * righti 是第 i 座建筑物右边缘的 x 坐标。
 * heighti 是第 i 座建筑物的高度。
 * 天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 * <p>
 * 注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * 输出：[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * 解释：
 * 图 A 显示输入的所有建筑物的位置和高度，
 * 图 B 显示由这些建筑物形成的天际线。图 B 中的红点表示输出列表中的关键点。
 * 示例 2：
 * <p>
 * 输入：buildings = [[0,2,3],[2,5,3]]
 * 输出：[[0,3],[5,0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= buildings.length <= 104
 * 0 <= lefti < righti <= 231 - 1
 * 1 <= heighti <= 231 - 1
 * buildings 按 lefti 非递减排序
 *
 * @author lvrui
 */
public class GetSkyline {

    /**
     * 输入
     * [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
     * 输出
     * [[2,10],[3,15],[8,12],[15,10],[21,8]]
     * 预期结果
     * [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
     *
     * @param buildings
     * @return
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> skyLine = new ArrayList<>();
        int maxRight = Integer.MIN_VALUE;
        int minLeft = Integer.MAX_VALUE;
        if (buildings != null && buildings.length > 0) {
            TreeMap<Integer, Integer> heightMap = new TreeMap<>();
            for (int[] building : buildings) {
                int l = building[0];
                int r = building[1];
                int h = building[2];
                maxRight = Math.max(maxRight, r);
                minLeft = Math.min(minLeft, l);
                for (; l <= r; l++) {
                    Integer orDefault = heightMap.getOrDefault(l, h);
                    if (orDefault <= h) {
                        heightMap.put(l, h);
                    }
                    if (l == r) {
                        heightMap.put(l, 0);
                    }
                }
            }
            int preH = -1;
            for (Map.Entry<Integer, Integer> entry : heightMap.entrySet()) {

                Integer value = entry.getValue();
                Integer key = entry.getKey();
                if (value != preH) {


                    preH = value;
                    List<Integer> dot = new ArrayList<>();
                    skyLine.add(dot);
                    dot.add(key);
                    dot.add(value);
                }
            }
        }


        return skyLine;
    }


    public List<List<Integer>> getSkyline2(int[][] buildings) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        List<Integer> boundaries = new ArrayList<Integer>();
        for (int[] building : buildings) {
            boundaries.add(building[0]);
            boundaries.add(building[1]);
        }
        Collections.sort(boundaries);

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = buildings.length, idx = 0;
        for (int boundary : boundaries) {
            while (idx < n && buildings[idx][0] <= boundary) {
                pq.offer(new int[]{buildings[idx][1], buildings[idx][2]});
                idx++;
            }
            while (!pq.isEmpty() && pq.peek()[0] <= boundary) {
                pq.poll();
            }

            int maxn = pq.isEmpty() ? 0 : pq.peek()[1];
            if (ret.size() == 0 || maxn != ret.get(ret.size() - 1).get(1)) {
                ret.add(Arrays.asList(boundary, maxn));
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        GetSkyline skyline = new GetSkyline();
        List<List<Integer>> skyline1 = skyline.getSkyline2(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}});


        skyline = null;
    }

}
