package com.pmb.code;

import java.util.*;

/**
 * Task Scheduler
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * <p>
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的最短时间。
 * <p>
 * 示例 1：
 * <p>
 * 输入: tasks = ['A','A','A','B','B','B'], n = 2
 * 输出: 8
 * 执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 * 注：
 * <p>
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 *
 * @author lvrui
 */
public class LeastInterval {

    public static int leastInterval(char[] tasks, int n) {
        int res = 0;
        if (tasks != null) {
            if (n == 0) {
                return tasks.length;
            } else {
                int[] taskMap = new int[26];
                for (char task : tasks) {
                    taskMap[task - 'A']++;
                }
                Arrays.sort(taskMap);
                while (taskMap[25] > 0) {


                    int index = 0;
                    while (index <= n) {
                        if (taskMap[25] == 0) {
                            break;
                        }
                        if (index < 25 && taskMap[25 - index] > 0) {
                            taskMap[25 - index]--;
                        }
                        res++;
                        index++;
                    }
                    Arrays.sort(taskMap);
                }
            }
        }
        return res;
    }

    public static int leastInterval3(char[] tasks, int n) {
        int res = 0;
        if (tasks != null) {
            if (n == 0) {
                return tasks.length;
            } else {
                int[] taskMap = new int[26];
                for (char task : tasks) {
                    taskMap[task - 'A']++;
                }
                PriorityQueue<Integer> queue = new PriorityQueue<>(26, Comparator.naturalOrder());
                for (int value : taskMap) {
                    queue.add(value);
                }
                Integer peek = queue.peek();
                List < Integer > temp = new ArrayList < > ();
                while (!queue.isEmpty()) {
                    int i = 0;
                    while (i <= n) {
                        if (queue.peek() > 1) {
                            temp.add(queue.poll() - 1);
                        } else {
                            queue.poll();
                        }
                        res++;
                        if (queue.isEmpty() && temp.size() == 0)
                            break;
                        i++;
                        for (int l: temp)
                            queue.add(l);

                    }
                }
            }
        }
        return res;
    }

    public int leastInterval2(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[25] == 0)
                    break;
                if (i < 26 && map[25 - i] > 0)
                    map[25 - i]--;
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }

    public static void main(String[] args) {
        leastInterval(new char[]{'A', 'A', 'A'}, 1);
    }
}
