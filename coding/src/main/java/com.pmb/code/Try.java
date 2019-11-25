package com.pmb.code;

/**
 * @author lvrui
 */
public class Try {
    /**
     * 主要方法
     */
    public static void main(String[] args) {
        // 调用 测试方法
        int result = get();
        // 打印 测试方法返回的结果
        System.out.println(result);
    }

    @SuppressWarnings({"finally", "unused"})
    public static int get() {
        int value = 0;
        try {
            value++;
            System.out.println("try……"+value);

            //等式1/0 ：分母为0 的明显错误          ——制造错误（用于抛异常）
//            int result = value / 0;
            return value;

        } catch (Exception e) {
            value++;
            System.out.println("catch……"+value);

//            return value;
        } finally {
            value++;

            System.out.println("finally……"+value);
//            return value;
        }
        return value;

//    return "2123";
    }
}
