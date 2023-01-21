package com.pmb.wait_2022_10;

import com.pmb.code.model.ListNode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * https://leetcode.cn/problems/linked-list-components/
 * 817. 链表组件
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集。
 * <p>
 * 返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: head = [0,1,2,3], nums = [0,1,3]
 * 输出: 2
 * 解释: 链表中,0 和 1 是相连接的，且 nums 中不包含 2，所以 [0, 1] 是 nums 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入: head = [0,1,2,3,4], nums = [0,3,1,4]
 * 输出: 2
 * 解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数为n
 * 1 <= n <= 104
 * 0 <= Node.val < n
 * Node.val 中所有值 不同
 * 1 <= nums.length <= n
 * 0 <= nums[i] < n
 * nums 中所有值 不同
 *
 * @author lvrui
 */
public class NumComponents {
    public int numComponents(ListNode head, int[] nums) {
        if (head == null || nums == null) {
            return 0;
        }

        Set<Integer> compents = new HashSet<>();
        IntStream.range(0, nums.length - 1).forEach(i -> compents.add(nums[i]));

        int cnt = 0;


        while (head != null) {

            if (compents.contains(head.val)) {
                cnt++;
                head = head.next;
                while (head != null && compents.contains(head.val)) {
                    head = head.next;
                }
            }
        }

        return cnt;

    }


    public int numComponents2(ListNode head, int[] nums) {
        Set<Integer> numsSet = new HashSet<Integer>();
        for (int num : nums) {
            numsSet.add(num);
        }
        boolean inSet = false;
        int res = 0;
        while (head != null) {
            if (numsSet.contains(head.val)) {
                if (!inSet) {
                    inSet = true;
                    res++;
                }
            } else {
                inSet = false;
            }
            head = head.next;
        }
        return res;
    }


}
