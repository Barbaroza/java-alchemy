package com.pmb.code.datastructure.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvrui
 */
public class Reverse {
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }


        List<Integer> stack = new ArrayList<Integer>();
        while (x != 0) {
            stack.add(x % 10);
            x /= 10;
        }
        int res = 0;
        for (int i = 0; i < stack.size(); i++) {


            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && stack.get(i) > 7))
                return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && stack.get(i) < -8))
                return 0;
            res = res * 10 + stack.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        reverse.reverse(-321);
    }
}
