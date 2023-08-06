package com.pmb.wait.wait_2022_12_03;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-323/problems/design-memory-allocator/
 *
 * @author lvrui
 */
public class Allocator {
    int[] m;
    Map<Integer, List<Block>> map = new HashMap<>();

    public Allocator(int n) {
        m = new int[n];
    }

    public int allocate(int size, int mID) {
        for (int i = 0; i < m.length; i++) {

            if (m[i] == 0) {
                int t = size;
                while (t > 0 && i + t - 1 < m.length && m[i + t - 1] != 1) {
                    t--;
                }
                if (t == 0) {

                    for (int j = i; j < i + size - 1; j++) {
                        m[j] = 1;
                    }
                    Block block = new Block(i, i + size - 1);
                    List<Block> blocks = map.get(mID);
                    if (blocks != null) {
                        blocks.add(block);
                    } else {
                        blocks = new ArrayList<>();
                        blocks.add(block);
                        map.put(mID, blocks);
                    }

                    return i;
                }
            }
        }

        return -1;
    }

    public int free(int mID) {
        List<Block> remove = map.remove(mID);
        if (remove == null) {
            return 0;
        }
        int a = 0;
        for (Block b : remove) {
            Arrays.fill(m, b.start, b.end + 1, 0);
            a = a + b.end + 1 - b.start;
        }

        return a;
    }

    public static class Block {
        int start;
        int end;

        public Block(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
