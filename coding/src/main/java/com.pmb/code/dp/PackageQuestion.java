package com.pmb.code.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 背包问题
 *
 * @author lvrui
 */
public class PackageQuestion {

    public int getMaxValue(int limit, int[] weights, int[] values) {
        int res = 0;
        res = greedy(limit, weights, values);

        return res;
    }

    class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.value = value;
            this.weight = weight;
        }
    }

    private int greedy(int limit, int[] weights, int[] values) {
        List<Item> list = new ArrayList<>(weights.length);
        for (int index = 0; index < weights.length; index++) {
            list.add(new Item(weights[index], values[index]));
        }
        Collections.sort(list, (item, item2) -> {
            double c1 = (double) item.value / (double) item.weight;
            double c2 = (double) item2.value / (double) item2.weight;
            if (c1 > c2) {
                return -1;
            } else if (c1 == c2) {
                return item.weight > item2.weight ? -1 : 1;
            } else {
                return 1;
            }
        });
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            int cp = limit;
            int value = 0;
            if (list.get(i).value * (list.size() - i) < res) {
                break;
            }
            for (int j = i; j < list.size(); j++) {
                if (list.get(j).weight < cp) {
                    value += list.get(j).value;
                    cp -= list.get(j).weight;
                } else {
                    break;
                }
            }
            res = Math.max(value, res);
        }
        return res;
    }


    public static void main(String[] args) {
        PackageQuestion packageQuestion = new PackageQuestion();
        packageQuestion.getMaxValue(90, new int[]{50, 50, 40, 41}, new int[]{51, 50, 40, 39});
    }
}
