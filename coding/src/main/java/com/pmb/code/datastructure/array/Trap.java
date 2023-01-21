package com.pmb.code.datastructure.array;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * @author lvrui
 */
public class Trap {
    public int trap(int[] height) {
        int index = 0;
        int res = 0;
        int[] layer = new int[1];
        while (getLayer(index++, height, layer)) {
            res = layer[0] + res;
        }

        return res;
    }

    private boolean getLayer(int index, int[] height, int[] layer) {
        int preIndex = -1;
        int layerRes = 0;
        boolean flag = false;
        for (int i = 0; i < height.length; i++) {
            if (height[i] - index > 0) {
                if (preIndex < 0) {
                    preIndex = i;
                } else {
                    flag = true;
                    int sub = i - preIndex - 1;
                    layerRes = (sub > 0 ? sub : 0) + layerRes;
                    preIndex = i;
                }
            }
        }
        layer[0] = layerRes;
        return flag;
    }

    public int trap2(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Trap trap = new Trap();
        trap.trap(new int[]{4, 2, 3});
    }
}
