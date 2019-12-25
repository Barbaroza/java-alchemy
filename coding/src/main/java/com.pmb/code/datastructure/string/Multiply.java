package com.pmb.code.datastructure.string;

/**
 * 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * @author lvrui
 */
public class Multiply {
    Integer maxLength = String.valueOf(Integer.MAX_VALUE).length();

    public String multiply(String num1, String num2) {
        String res = "";
        if (num1.length() >= maxLength - 1) {
            int mid = num1.length() / 2;
            String prefix = num1.substring(0, mid);
            String suffix = num1.substring(mid, num1.length());
            res = plus(multiply(prefix, num2) + generateZero(suffix), multiply(suffix, num2));
        } else {
            for (int index = 0; index < num2.length(); index++) {
                String current = num2.substring(index, index + 1);
                String suffix = num2.substring(index + 1);
                int plus = Integer.valueOf(num1) * Integer.valueOf(current);
                res = plus(res, plus == 0 ? String.valueOf(plus) : plus + generateZero(suffix));
            }
        }


        return res;

    }

    private String plus(String num1, String num2) {
        if (num1 == null || num1.isEmpty()) {
            return num2;
        }
        if (num2 == null || num2.isEmpty()) {
            return num1;
        }
        if (num1.equals("0") && num2.equals(num1)) {
            return "0";
        }
        Integer maxLength = Math.max(num1.length(), num2.length());
        StringBuilder sb = new StringBuilder();
        int ad = 0;
        for (int index = 0; index <= maxLength; index++) {
            Integer num11 = 0, num22 = 0;
            if (num1.length() - 1 - index >= 0) {
                num11 = Integer.valueOf(num1.substring(num1.length() - 1 - index, num1.length() - index));
            }
            if (num2.length() - 1 - index >= 0) {
                num22 = Integer.valueOf(num2.substring(num2.length() - 1 - index, num2.length() - index));
            }
            String s = String.valueOf(num11 + num22 + ad);
            ad = 0;
            //注意char转int的技巧
            if (index == maxLength && s.equals("0")) {

                continue;


            }
            if (s.length() > 1) {
                sb.insert(0, s.charAt(1));
                ad = s.charAt(0) - '0';
            } else {
                sb.insert(0, s);
            }
        }
        return sb.toString();
    }

    private String generateZero(String suffix) {
        String res = "";
        if (suffix != null && !suffix.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int index = 0; index < suffix.length(); index++) {
                sb.append("0");
            }
            res = sb.toString();
        }
        return res;
    }
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 保存计算结果
        String res = "0";

        // num2 逐位与 num1 相乘
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            // 保存 num2 第i位数字与 num1 相乘的结果
            StringBuilder temp = new StringBuilder();
            // 补 0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            int n2 = num2.charAt(i) - '0';

            // num2 的第 i 位数字 n2 与 num1 相乘
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);
                carry = (n1 * n2 + carry) / 10;
            }
            // 将当前结果与新计算的结果求和作为新的结果
            res = addStrings(res, temp.reverse().toString());
        }
        return res;
    }

    /**
     * 对两个字符串数字进行相加，返回字符串形式的和
     */
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        String multiply1 = multiply.multiply("881095803",
                "61");

        multiply1 = null;
    }
}
