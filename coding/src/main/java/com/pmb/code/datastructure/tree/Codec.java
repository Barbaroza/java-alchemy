package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

import java.util.*;

/**
 * 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例:
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 * @author lvrui
 */
public class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String format = "[%s]";
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            List<TreeNode> queue = new ArrayList<>();
            queue.add(root);
            List<TreeNode> layer = new ArrayList<>();
            int layerCount = 0;
            int layerNullCount = 0;
            while (!queue.isEmpty()) {
                TreeNode pop = queue.remove(0);
                if (pop == null) {
                    list.add(null);
                    layer.add(null);
                    layer.add(null);
                    layerNullCount++;
                    layerNullCount++;

                } else {
                    list.add(pop.val);
                    layer.add(pop.left);
                    layer.add(pop.right);
                }
                if (queue.isEmpty() && !layer.isEmpty()) {
                    layerCount = layer.size();
                    if (layerCount != layerNullCount) {
                        layer.forEach(e -> {

                            queue.add(e);
                        });
                    }
                    layer.clear();
                    layerNullCount = 0;
                    layerCount = 0;
                }
            }
        }
        int lastIndex = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            Integer integer = list.get(i);
            if (integer != null) {
                lastIndex = i;
                break;
            }
        }
        return list.subList(0, lastIndex + 1).toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.length() < 3) {
            return null;
        }
        String[] split = data.substring(1, data.length() - 1).split(",");
        int startIndex = 1;
        TreeNode root = null;
        if (!"null".equals(split[0])) {
            Integer val = Integer.valueOf(split[0]);
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            root = new TreeNode(val);
            queue.add(root);
            while (startIndex < split.length) {
                TreeNode pop = queue.pop();
                if (pop == null) {
                    startIndex = startIndex + 2;
                } else {
                    String s = split[startIndex];
                    if (!s.equals("null")) {
                        pop.left = new TreeNode(Integer.valueOf(s));
                        queue.add(pop.left);
                    }
                    startIndex++;
                    if (startIndex < split.length) {
                        String ss = split[startIndex];
                        if (!ss.equals("null")) {
                            pop.right = new TreeNode(Integer.valueOf(ss));
                            queue.add(pop.right);
                        }
                    }
                    startIndex++;
                }
            }
        }
        return root;
    }
    public String serialize2(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder builder = new StringBuilder();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                TreeNode node = queue.removeFirst();
                //这个优化点很重要，当遍历到null时，不要往队列写入null子节点，减少生成的字符串大小
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                    builder.append(",").append(node.val);
                } else {
                    builder.append(",null");
                }
            }
        }
        //删除第一个逗号
        builder.deleteCharAt(0);
        //下面的代码通过正则匹配字符串末尾的null,这些null可以省略
        //Pattern pattern = Pattern.compile("[,null]+$");
        //Matcher matcher = pattern.matcher(builder.toString());
        //return matcher.replaceFirst("");
        return builder.toString();
    }



    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode deserialize = codec.deserialize("[1,2,3,null,null,4,5]");
        String serialize = codec.serialize(deserialize);
    }
}
