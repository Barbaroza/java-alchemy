package com.pmb.code.datastructure.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 找到 K 个最接近的元素
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 *
 *
 * 示例 2:
 *
 * 输入: [1,2,3,4,5], k=4, x=-1
 * 输出: [1,2,3,4]
 *
 *
 * 说明:
 *
 * k 的值为正数，且总是小于给定排序数组的长度。
 * 数组不为空，且长度不超过 104
 * 数组里的每个元素与 x 的绝对值不超过 104
 *
 *
 * 更新(2017/9/19):
 * 这个参数 arr 已经被改变为一个整数数组（而不是整数列表）。 请重新加载代码定义以获取最新更改。
 * @author lvrui
 */
public class FindClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<Integer>();
        if (arr == null) {
            return res;
        }
        if (arr.length <= k) {
            for (int num : arr) {
                res.add(num);
            }
            return res;
        }

        int start = 0, end = arr.length - 1;
        if (arr[end] <= x) {
            start = end - k;
        } else if (arr[start] >= x) {
            start = 0;
        } else {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == x) {
                    start = mid;
                    break;
                } else if (arr[mid] < x) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        if (arr[start] < x && start < arr.length - 1) {
            start = (arr[start] + arr[start + 1]) < 2 * x ? start : start + 1;
        } else if (arr[start] > x && start > 0) {
            start = (arr[start] + arr[start - 1]) < 2 * x ? start : start - 1;
        }
        if (start >= k) {
            start = start - k;
        } else {
            start = 0;
        }
        for (int i = start; i < start + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        FindClosestElements findClosestElements = new FindClosestElements();
        findClosestElements.findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9);
        findClosestElements.findClosestElements2(new int[]{1, 1, 1, 10, 10, 10}, 1, 9);
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int n = ret.size();
        if (x <= ret.get(0)) {
            return ret.subList(0, k);
        } else if (ret.get(n - 1) <= x) {
            return ret.subList(n - k, n);
        } else {
            int index = Collections.binarySearch(ret, x);
            if (index < 0)
                index = -index - 1;
            int low = Math.max(0, index - k - 1), high = Math.min(ret.size() - 1, index + k - 1);

            while (high - low > k - 1) {
                if ((x - ret.get(low)) <= (ret.get(high) - x))
                    high--;
                else if ((x - ret.get(low)) > (ret.get(high) - x))
                    low++;
                else
                    System.out.println("unhandled case: " + low + " " + high);
            }
            return ret.subList(low, high + 1);
        }
    }

}
