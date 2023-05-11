package com.pmb.code.datastructure.heap;

/**
 * @author lvrui
 */
public class SmallestK {
    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (k >= arr.length) {
            return arr;
        }

        Heap heap = new Heap(k);
        for (int v : arr) {
            heap.insert(v);
        }

        return heap.data();
    }

    public static class Heap {
        int[] data;
        final int cap;
        int size;

        public Heap(int cap) {
            this.size = 0;
            this.cap = cap;
            data = new int[cap + 1];
        }


        public int size() {
            return this.size;
        }

        public void insert(int v) {
            if (size < cap) {
                this.data[++size] = v;
                shiftUp();
            } else {
                if (data[1] > v) {
                    data[1] = v;
                    shiftDown();
                }
            }

        }

        public int[] data() {
            int[] ans = new int[cap];
            System.arraycopy(this.data, 1, ans, 0, data.length - 1);
            return ans;
        }

        private void shiftUp() {
            int k = this.size;
            while (k != 1 && this.data[k / 2] < data[k]) {
                int t = data[k];
                data[k] = data[k / 2];
                data[k / 2] = t;
                k /= 2;
            }
        }

        private void shiftDown() {
            int k = 1;
            while (2 * k <= size) {
                int j = 2 * k;
                if (j + 1 <= size && data[j + 1] > data[j]) {
                    j++;
                }
                if (data[k] > data[j]) {
                    break;
                }
                int t = data[k];
                data[k] = data[j];
                data[j] = t;
                k = j;
            }
        }

    }
}
