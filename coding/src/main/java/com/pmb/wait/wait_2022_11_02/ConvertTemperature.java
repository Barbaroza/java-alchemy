package com.pmb.wait.wait_2022_11_02;

/**
 * https://leetcode.cn/contest/weekly-contest-319/problems/convert-the-temperature/
 *
 * @author lvrui
 */
public class ConvertTemperature {

    private double add1 = 273.15;
    private double add2 = 32.00;

    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + add1, celsius * 1.8 + add2};
    }
}
