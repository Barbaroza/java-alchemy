package com.pmb.code.backtracking;

import java.util.*;
import java.util.stream.Collectors;

/**https://leetcode.cn/problems/zlDJc7/solution/kai-mi-ma-suo-by-leetcode-solution-b964/
 * @author lvrui
 */
public class OpenLock {

    public int openLock(String[] deadends, String target) {

        Set<String> deads = Arrays.stream(deadends).collect(Collectors.toSet());
        if (target.equals("0000")) {
            return 0;
        }

        if (!deads.add("0000")) {
            return -1;
        }

        return bfs(deads, target);
    }

    private int bfs(Set<String> deads, String target) {
        LinkedList<String> deque = new LinkedList<>();
        Set<String> access = new HashSet<>();
        deque.add("0000");
        int step = 0;
        while (!deque.isEmpty()) {
            step++;
            int a = deque.size();
            while (a > 0) {
                a--;
                String poll = deque.removeLast();


                for (int i = 0; i < 4; i++) {
                    String turn = turn(poll, i, 1);
                    String turn1 = turn(poll, i, 2);

                    if (deads.add(turn)) {
                        deque.addFirst(turn);
                        if (target.equals(turn)) {
                            return step;
                        }
                    }
                    if (deads.add(turn1)) {
                        deque.addFirst(turn1);
                        if (target.equals(turn1)) {
                            return step;
                        }
                    }


                }
            }

        }


        return -1;
    }


    private String turn(String val, int l, int act) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < val.length(); i++) {
            if (i != l) {

                sb.append(val.charAt(i));
            } else {
                Integer num = Integer.valueOf(val.substring(l, l + 1));
                if (act == 1) {
                    num = (num + 1) % 10;
                } else if (act == 2) {
                    num--;
                    if (num < 0) {
                        num += 10;
                    }
                }
                sb.append(num);
            }
        }
        return sb.toString();

    }

    public int openLock2(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }

        Set<String> dead = new HashSet<String>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        if (dead.contains("0000")) {
            return -1;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer("0000");
        Set<String> seen = new HashSet<String>();
        seen.add("0000");

        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String status = queue.poll();
                for (String nextStatus : get(status)) {
                    if (!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if (nextStatus.equals(target)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }

        return -1;
    }

    public char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }

    // 枚举 status 通过一次旋转得到的数字
    public List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char num = array[i];
            array[i] = numPrev(num);
            ret.add(new String(array));
            array[i] = numSucc(num);
            ret.add(new String(array));
            array[i] = num;
        }
        return ret;
    }
}
