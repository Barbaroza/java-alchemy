package com.pmb.wait.wait_2023_08;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author lvrui
 */
public class Week357 {
    public String finalString(String s) {
        int iCnt = 0;
        LinkedList<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'i') {
                iCnt++;
                continue;
            }
            if (iCnt % 2 == 0) {
                deque.addLast(c);
            } else {
                deque.addFirst(c);
            }
        }

        StringBuilder appender = new StringBuilder();

        while (deque.size() > 0) {

            appender.append(deque.removeFirst());
        }

        if (iCnt % 2 == 1) {
            appender.reverse();
        }

        return appender.toString();

    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        List<List<Integer>> tArr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    List<Integer> tPoint = new ArrayList<>();
                    tPoint.add(i);
                    tPoint.add(j);
                    tArr.add(tPoint);
                }
            }
        }

        int[][] cost = costBFS(tArr, m, n);


        return maxValueBFS(cost, m, n);

    }

    private int maxValueBFS(int[][] cost, int m, int n) {
        int res = 0;
        Set<String> accessed = new HashSet<>();

        LinkedList<int[]> deque = new LinkedList<>();

        accessed.add("0-0");
        final String keyFormat = "%s-%s";
        deque.add(new int[]{0, 0});

        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                int[] ints = deque.removeFirst();
                size--;

                int x = ints[0];
                int y = ints[1];
                if (x + 1 >= 0 && x + 1 < m && accessed.add(String.format(keyFormat, x + 1, y))) {
                    int v1 = cost[x][y];
                    int v2 = y - 1 >= 0 && y - 1 < n ? cost[x + 1][y - 1] : 0;
                    cost[x + 1][y] = Math.max(v1, v2) + cost[x + 1][y];
                    deque.add(new int[]{x + 1, y});
                }

                if (y + 1 >= 0 && y + 1 < m && accessed.add(String.format(keyFormat, x, y + 1))) {
                    int v1 = cost[x][y];
                    int v2 = x - 1 >= 0 && x - 1 < n ? cost[x - 1][y + 1] : 0;
                    cost[x][y + 1] = Math.max(v1, v2) + cost[x][y + 1];
                    deque.add(new int[]{x, y + 1});
                }
            }
        }


        return cost[m - 1][n - 1];
    }

    private int[][] costBFS(List<List<Integer>> tArr, int m, int n) {
        int[][] cost = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int res = Integer.MAX_VALUE;

                for (List<Integer> point : tArr) {

                    res = Math.min(res, Math.abs(i - point.get(0)) + Math.abs(j - point.get(1)));
                }
                cost[i][j] = res;
            }
        }
        return cost;
    }


    public static void main(String[] args) {

        String a = "{\"stationList\":[1,2,3]}";
        String stationList = (String)ExtraData.toMap(a).get("stationList");

        Week357 w = new Week357();
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> input1 = new ArrayList<>();
        List<Integer> input2 = new ArrayList<>();
        List<Integer> input3 = new ArrayList<>();
        input1.add(1);
        input1.add(0);
        input1.add(0);
        input2.add(0);
        input2.add(0);
        input2.add(0);
        input3.add(0);
        input3.add(0);
        input3.add(1);
        input.add(input1);
        input.add(input2);
        input.add(input3);

        w.maximumSafenessFactor(input);
    }


    public static class ExtraData {


        public static final String STATION_LIST_KEY = "stationList";


        public static ExtraDataBuilder extraDataBuilder() {
            return new ExtraDataBuilder();
        }


        public static Map<String, Object> toMap(String str) {
            return (Map<String, Object>) Optional.ofNullable(JSON.parseObject(str, Map.class))
                    .map(HashMap::new)
                    .orElse(new HashMap<>());
        }

        public static class ExtraDataBuilder {
            private Map<String, String> map = null;

            public ExtraDataBuilder instance() {
                this.map = new HashMap<>();
                return this;
            }


            public ExtraDataBuilder append(String key, String obj) {
                this.map.put(key, obj);
                return this;
            }

            public Map<String, String> build() {
                return this.map;
            }
        }

    }




}
