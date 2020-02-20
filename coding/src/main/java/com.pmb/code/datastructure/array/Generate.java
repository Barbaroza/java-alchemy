package com.pmb.code.datastructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 * @author lvrui
 */
public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = null;
        if (numRows < 0) {
            return res;
        }
        res = new ArrayList<>(numRows);
        for (int index = 0; index < numRows; index++) {
            List<Integer> temp = new ArrayList<Integer>(index + 1);
            for (int i = 0; i < index + 1; i++) {
                if (i == 0 || i == index) {
                    temp.add(1);
                } else {
                    List<Integer> integers = res.get(index - 1);
                    temp.add(integers.get(i - 1) + integers.get(i));
                }

            }

            res.add(temp);
        }
        return res;
    }
}
