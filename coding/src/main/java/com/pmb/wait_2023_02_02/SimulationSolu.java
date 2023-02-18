package com.pmb.wait_2023_02_02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lvrui
 */
public class SimulationSolu {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }

    public int minmumNumberOfHost(int n, int[][] startEnd) {
        int A[] = new int[n];
        int k = 0;
        Arrays.sort(startEnd, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                int[] one = (int[]) o1;
                int[] two = (int[]) o2;
                if (one[0] > two[0]) return 1;
                if (one[0] == two[0]) return 0;
                else return -1;
            }
        });
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        q.offer(Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            if (q.peek() <= startEnd[i][0])
                q.poll();
            q.offer(startEnd[i][1]);
        }
        return q.size();
    }

    public int[] solve(int n, int m, int[] a) {
        int index = m % n;

        if (a == null || index == 0) {
            return a;
        }

        reverse(a, 0, a.length - 1);
        reverse(a, 0, index - 1);
        reverse(a, index, a.length - 1);

        return a;
    }

    private void reverse(int[] a, int s, int e) {
        while (s < e) {
            int t = a[s];
            a[s] = a[e];
            a[e] = t;
            s++;
            e--;
        }
    }


    private void swap(int i, int j, int[] a) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public int search(int[] arr, int target) {
        if (arr[0] == target) {
            return 0;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] == target) {
                while (mid > 1 && arr[mid - 1] == arr[mid]) {
                    mid--;
                }
                return mid;
            } else if (arr[mid] > arr[left]) {
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (arr[mid] < arr[left]) {
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }
        }
        return -1;
    }

    public int search2(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = r - (r - l) >> 1;

            if (arr[mid] == target) {
                while (mid > 1 && arr[mid - 1] == arr[mid]) {
                    mid--;
                }
                return mid;
            } else if (arr[mid] > arr[l]) {
                if (arr[mid] > target && arr[l] <= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }


            } else if (arr[mid] < arr[l]) {
                if (arr[mid] < target && target <= arr[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }

            } else {
                l++;
            }


        }


        return -1;
    }

}
