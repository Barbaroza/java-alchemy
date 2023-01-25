package com.pmb.wait_2023_01_01;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/contest/biweekly-contest-94/problems/reward-top-k-students/
 *
 * @author lvrui
 */
public class TopStudents {
    public static class St {
        int id;
        int score;

        public St(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {

        PriorityQueue<St> priorityQueue = new PriorityQueue<>(k, (a, b) -> {
            int c = b.score - a.score;
            int c2 = a.id - b.id;
            return c == 0 ? (c2 > 0 ? 1 : -1) : (c > 0 ? 1 : -1);
        });
        Set<String> pSet = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> nSet = new HashSet<>(Arrays.asList(negative_feedback));
        for (int i = 0; i < student_id.length; i++) {
            String r = report[i];
            String[] s = r.split(" ");
            int score = 0;
            for (String subStr : s) {
                if (pSet.contains(subStr)) {
                    score += 3;
                }
                if (nSet.contains(subStr)) {
                    score -= 1;
                }
            }

            priorityQueue.add(new St(student_id[i], score));

        }
        List<Integer> queue = new ArrayList<>();
        while (k > 0) {
            queue.add(priorityQueue.poll().id);

        }
        return queue;

    }

}
