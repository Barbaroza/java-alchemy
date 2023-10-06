package com.pmb;

/**
 * @author lvrui
 */
public class Temp {
    public int[] sk(int[] arr, int k) {
        if (arr == null || arr.length <= k) {
            return arr == null ? new int[]{} : arr;
        }
        Heap heap = new Heap(k);

        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[k - i - 1] = heap.remove();
        }

        return res;
    }

    public static class Heap {
        int[] arr;
        int cnt;
        final int cap;

        public Heap(int i) {

            this.arr = new int[i + 1];
            this.cap = i;
        }

        public void add(int a) {
            if (cnt < cap) {

                arr[cnt++] = a;
//                shiftUp();
            } else {
                if (arr[1] > a) {
                    arr[1] = a;
//                    shiftDown();
                }
            }
        }

        public int remove() {
            return 0;
        }
    }

}
