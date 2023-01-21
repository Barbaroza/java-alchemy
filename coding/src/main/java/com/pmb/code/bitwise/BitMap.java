package com.pmb.code.bitwise;

/**
 * @author lvrui
 */
public class BitMap {
    private int[] bitMap;
    private int size = 0;


    private BitMap() {
    }

    public BitMap(int maxNum) {
        bitMap = new int[(maxNum >> 5) + 1];
    }

    public int size() {
        return this.size;
    }

    public boolean isExist(int num) {
        //确定数组 index
        int arrayIndex = num >> 5;
        //确定bit index
        int bitIndex = num & (32 - 1);
        //判断是否存在
        return isExist(arrayIndex, bitIndex);
    }

    private boolean isExist(int arrayIndex, int bitIndex) {
        return (bitMap[arrayIndex] & ((1 << bitIndex))) != 0 ? true : false;
    }

    public void set(int num) {
        //确定数组 index
        int arrayIndex = num >> 5;
        //确定bit index
        int bitIndex = num & (32 - 1);
        if (!isExist(arrayIndex, bitIndex)) {
            bitMap[arrayIndex] |= (1 << bitIndex);
            size++;
        }

    }

    public void remove(int num) {
        //确定数组 index
        int arrayIndex = num >> 5;
        //确定bit index
        int bitIndex = num & (32 - 1);
        if (isExist(arrayIndex, bitIndex)) {
            bitMap[arrayIndex] &= ~(1 << bitIndex);
            size--;
        }
    }

    public int[] reverse() {
        int[] reverse = new int[size];
        int reverseIndex = 0;
        for (int arrayIndex = 0; arrayIndex < bitMap.length; arrayIndex++) {
            int value = bitMap[arrayIndex];
            for (int bitIndex = 0; bitIndex < 32; bitIndex++) {
                if (value > 0) {
                    if ((value & 1) == 1) {
                        reverse[reverseIndex] = arrayIndex * 32 + bitIndex;
                        reverseIndex++;
                    }
                    value >>= 1;
                }
            }
        }
        return reverse;
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(281390122);
        boolean exist = bitMap.isExist(28323);
        bitMap.set(9);
        boolean exist1 = bitMap.isExist(9);
        bitMap.remove(28323);
        boolean exist2 = bitMap.isExist(28323);
        bitMap.set(28323);
        bitMap.set(28325);
        bitMap.set(28324);
        bitMap.set(28327);
        bitMap.set(28329);
        bitMap.set(28322);
        bitMap.set(28322);
        bitMap.set(28322);
        bitMap.set(28322);
        bitMap.set(28321232);
        bitMap.set(28312322);
        bitMap.set(28312322);
        bitMap.set(28312322);
        bitMap.set(28322);
        bitMap.set(123);
        bitMap.set(28322);
        bitMap.set(283);
        bitMap.set(2837122);
        bitMap.set(283822);
        bitMap.set(281390122);
        int[] reverse = bitMap.reverse();


    }
}
