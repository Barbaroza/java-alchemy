package com.pmb.code.datastructure.array;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lvrui
 */
public class FindMinDifference {
    private static final Integer MINS_OF_ONE_DAY = 60 * 24;

    public int findMinDifference(List<String> timePoints) {

        List<Integer> mins = timePoints.stream().map(this::toMin).sorted(Comparator.comparingInt(a -> a)).collect(Collectors.toList());
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < mins.size(); i++) {
            ans = Math.min(ans, getMin(mins.get(i), mins.get(i - 1)));
        }

        ans = Math.min(ans, getMin(mins.get(0), mins.get(mins.size() - 1)));


        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    private int toMin(String time) {
        assert time != null;
        String[] p = time.split(":");
        assert p.length == 2;

        return Integer.valueOf(p[0]) * 60 + Integer.valueOf(p[1]);

    }


    private int getMin(int time1, int time2) {
        int diffs = Math.abs(time1 - time2);
        return Math.min(diffs, MINS_OF_ONE_DAY - diffs);
    }

}
