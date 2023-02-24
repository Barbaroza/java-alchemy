package com.pmb.code.datastructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 *
 * @author lvrui
 */
public class LastRemaining {
    public int lastRemaining(int n, int m) {
        List<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(i);
        }
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            index = (index + m - 1) % (n - i);
            arr.remove(index);
        }
        return arr.get(0);
    }

    public int lastRemaining2(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        LastRemaining lastRemaining = new LastRemaining();
        lastRemaining.lastRemaining2(5, 3);
        lastRemaining.lastRemaining(5, 3);
    }
}
