package com.pmb.wait.wait_2022_12_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/contest/biweekly-contest-93/problems/minimum-total-cost-to-make-arrays-unequal/
 *
 * @author lvrui
 */
public class MinimumTotalCost {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        int cost = 0;
        LinkedList<Integer> same = new LinkedList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[i]) {
                same.add(i);
            }
        }
        LinkedList<Integer> temp = new LinkedList<>();

        while (!same.isEmpty()) {
            Integer last = same.getLast();
            Integer head = same.removeFirst();
            boolean flag = false;

            temp.add(head);
            while (!head.equals(last)) {
                if (nums1[head] != nums2[last] && nums1[last] != nums2[head]) {
                    swap(nums1, head, last);
                    temp.removeLast();
                    cost += head;
                    cost += last;
                    flag = true;
                    break;
                } else {
                    head = same.removeFirst();
                    temp.add(head);
                }

            }
            while (!temp.isEmpty()) {
                same.addFirst(temp.removeLast());
            }
            if (!flag) {
                for (int i = 0; i < nums1.length; i++) {
                    if (nums1[i] != nums2[last] && nums1[last] != nums2[i]) {
                        swap(nums1, i, last);
                        cost += i;
                        cost += last;
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                return -1;
            }
            same.removeLast();
        }


        return cost;

    }

    public long minimumTotalCost2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] cou = new int[n + 1];
        int su = 0;
        int max = 0;
        int ma = 0;
        List<Integer> ano = new ArrayList<>();
        long ret = 0L;
        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[i]) {
                int x = nums1[i];
                ret += i;
                cou[x]++;
                su++;
                if (cou[x] > max) {
                    max = cou[x];
                    ma = x;
                }
            } else {
                ano.add(i);
            }
        }
        if (max * 2 <= su) {

        } else {
            max -= (su - max);
            for (int i : ano) {
                if (nums1[i] != ma && nums2[i] != ma && max > 0) {
                    max--;
                    ret += i;
                }
            }
            if (max > 0) {
                return -1L;
            }
        }
        return ret;

    }

    //class Solution {
    //public:
    //    using ll = long long;
    //    long long minimumTotalCost(vector<int>& nums1, vector<int>& nums2) {
    //        // 1. 先看某个数字和是否大于长度
    //        map<int, int> cnt;
    //        int n = nums1.size();
    //        for (int num : nums1) {
    //            ++cnt[num];
    //        }
    //        for (int num : nums2) {
    //            ++cnt[num];
    //        }
    //        for (auto&[k, v] : cnt) {
    //            if (v > n) {
    //                return -1;
    //            }
    //        }
    //        // 统计相同重复的数
    //        vector<int> diff;
    //        map<int, vector<int>> same;
    //        for (int i = 0; i < n; ++i) {
    //            if (nums1[i] != nums2[i]) {
    //                diff.push_back(i);
    //            } else {
    //                same[nums1[i]].push_back(i);
    //            }
    //        }
    //        // 最多的
    //        int mx = 0, idx = -1;
    //        int total = 0;
    //        ll ans = 0;
    //        for (auto& [k, v] : same) {
    //            if (v.size() > mx) {
    //                mx = v.size();
    //                idx = k;
    //            }
    //            total += v.size();
    //            for (int j : v) {
    //                ans += j;
    //            }
    //        }
    //        if (mx <= total - mx) {
    //            // 如果没有一个数字占据大多数
    //            // 两个数字的话肯定相等， 三个数字的话找一个和0换就行了
    //            return ans;
    //        }
    //        // 有一个数字占据大多数, idx
    //        int remain = mx - (total - mx);
    //        // 要不起来
    //        for (int i : diff) {
    //            if (nums1[i] != idx && remain > 0) {
    //                --remain;
    //                ans += i;
    //            }
    //        }
    //        return ans;
    //
    //    }
    //};

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        MinimumTotalCost minimumTotalCost = new MinimumTotalCost();
        minimumTotalCost.minimumTotalCost(new int[]{4, 2, 3, 2, 2, 2, 2, 5, 4, 4}, new int[]{4, 2, 3, 2, 2, 2, 2, 5, 4, 4});
    }
}
