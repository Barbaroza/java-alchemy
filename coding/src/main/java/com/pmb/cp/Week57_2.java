package com.pmb.cp;

import java.util.*;

/**
 * @author lvrui
 */
public class Week57_2 {

    /**
     * 5823. 字符串转化后的各位数字之和
     * 给你一个由小写字母组成的字符串 s ，以及一个整数 k 。
     * <p>
     * 首先，用字母在字母表中的位置替换该字母，将 s 转化 为一个整数（也就是，'a' 用 1 替换，'b' 用 2 替换，... 'z' 用 26 替换）。接着，将整数 转换 为其 各位数字之和 。共重复 转换 操作 k 次 。
     * <p>
     * 例如，如果 s = "zbax" 且 k = 2 ，那么执行下述步骤后得到的结果是整数 8 ：
     * <p>
     * 转化："zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
     * 转换 #1：262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
     * 转换 #2：17 ➝ 1 + 7 ➝ 8
     * 返回执行上述操作后得到的结果整数。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "iiii", k = 1
     * 输出：36
     * 解释：操作如下：
     * - 转化："iiii" ➝ "(9)(9)(9)(9)" ➝ "9999" ➝ 9999
     * - 转换 #1：9999 ➝ 9 + 9 + 9 + 9 ➝ 36
     * 因此，结果整数为 36 。
     * 示例 2：
     * <p>
     * 输入：s = "leetcode", k = 2
     * 输出：6
     * 解释：操作如下：
     * - 转化："leetcode" ➝ "(12)(5)(5)(20)(3)(15)(4)(5)" ➝ "12552031545" ➝ 12552031545
     * - 转换 #1：12552031545 ➝ 1 + 2 + 5 + 5 + 2 + 0 + 3 + 1 + 5 + 4 + 5 ➝ 33
     * - 转换 #2：33 ➝ 3 + 3 ➝ 6
     * 因此，结果整数为 6 。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 100
     * 1 <= k <= 10
     * s 由小写英文字母组成
     *
     * @param s
     * @param k
     * @return
     */

    public int getLucky(String s, int k) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int v = s.charAt(i) - 'a' + 1;
            while (v > 0) {
                ans += v % 10;
                v /= 10;
            }
        }
        for (int i = 1; i < k; i++) {
            int next = 0;
            while (ans > 0) {
                next += ans % 10;
                ans /= 10;
            }
            ans = next;
        }
        return ans;
    }


    /**
     * 1946. 子字符串突变后可能得到的最大整数
     * 给你一个字符串 num ，该字符串表示一个大整数。另给你一个长度为 10 且 下标从 0  开始 的整数数组 change ，该数组将 0-9 中的每个数字映射到另一个数字。更规范的说法是，数字 d 映射为数字 change[d] 。
     * <p>
     * 你可以选择 突变  num 的任一子字符串。突变 子字符串意味着将每位数字 num[i] 替换为该数字在 change 中的映射（也就是说，将 num[i] 替换为 change[num[i]]）。
     * <p>
     * 请你找出在对 num 的任一子字符串执行突变操作（也可以不执行）后，可能得到的 最大整数 ，并用字符串表示返回。
     * <p>
     * 子字符串 是字符串中的一个连续序列。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：num = "132", change = [9,8,5,0,3,6,4,2,6,8]
     * 输出："832"
     * 解释：替换子字符串 "1"：
     * - 1 映射为 change[1] = 8 。
     * 因此 "132" 变为 "832" 。
     * "832" 是可以构造的最大整数，所以返回它的字符串表示。
     * 示例 2：
     * <p>
     * 输入：num = "021", change = [9,4,3,5,7,2,1,9,0,6]
     * 输出："934"
     * 解释：替换子字符串 "021"：
     * - 0 映射为 change[0] = 9 。
     * - 2 映射为 change[2] = 3 。
     * - 1 映射为 change[1] = 4 。
     * 因此，"021" 变为 "934" 。
     * "934" 是可以构造的最大整数，所以返回它的字符串表示。
     * 示例 3：
     * <p>
     * 输入：num = "5", change = [1,4,7,5,3,2,5,6,9,4]
     * 输出："5"
     * 解释："5" 已经是可以构造的最大整数，所以返回它的字符串表示。
     *
     * @param num
     * @param change
     * @return
     */
    public String maximumNumber(String num, int[] change) {
        char[] s = num.toCharArray();
        for (int i = 0; i < s.length; i++) {
            s[i] -= '0';
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= change[s[i]]) {
                continue;
            }
            int j = i;
            while (j < s.length && s[j] <= change[s[j]]) {
                s[j] = (char) change[s[j]];
                j++;
            }
            break;
        }
        for (int i = 0; i < s.length; i++) {
            s[i] += '0';
        }
        return new String(s);
    }

    /**
     * 1948. 删除系统中的重复文件夹
     * 由于一个漏洞，文件系统中存在许多重复文件夹。给你一个二维数组 paths，其中 paths[i] 是一个表示文件系统中第 i 个文件夹的绝对路径的数组。
     * <p>
     * 例如，["one", "two", "three"] 表示路径 "/one/two/three" 。
     * 如果两个文件夹（不需要在同一层级）包含 非空且相同的 子文件夹 集合 并具有相同的子文件夹结构，则认为这两个文件夹是相同文件夹。相同文件夹的根层级 不 需要相同。如果存在两个（或两个以上）相同 文件夹，则需要将这些文件夹和所有它们的子文件夹 标记 为待删除。
     * <p>
     * 例如，下面文件结构中的文件夹 "/a" 和 "/b" 相同。它们（以及它们的子文件夹）应该被 全部 标记为待删除：
     * /a
     * /a/x
     * /a/x/y
     * /a/z
     * /b
     * /b/x
     * /b/x/y
     * /b/z
     * 然而，如果文件结构中还包含路径 "/b/w" ，那么文件夹 "/a" 和 "/b" 就不相同。注意，即便添加了新的文件夹 "/b/w" ，仍然认为 "/a/x" 和 "/b/x" 相同。
     * 一旦所有的相同文件夹和它们的子文件夹都被标记为待删除，文件系统将会 删除 所有上述文件夹。文件系统只会执行一次删除操作。执行完这一次删除操作后，不会删除新出现的相同文件夹。
     * <p>
     * 返回二维数组 ans ，该数组包含删除所有标记文件夹之后剩余文件夹的路径。路径可以按 任意顺序 返回。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：paths = [["a"],["c"],["d"],["a","b"],["c","b"],["d","a"]]
     * 输出：[["d"],["d","a"]]
     * 解释：文件结构如上所示。
     * 文件夹 "/a" 和 "/c"（以及它们的子文件夹）都会被标记为待删除，因为它们都包含名为 "b" 的空文件夹。
     * 示例 2：
     * <p>
     * <p>
     * 输入：paths = [["a"],["c"],["a","b"],["c","b"],["a","b","x"],["a","b","x","y"],["w"],["w","y"]]
     * 输出：[["c"],["c","b"],["a"],["a","b"]]
     * 解释：文件结构如上所示。
     * 文件夹 "/a/b/x" 和 "/w"（以及它们的子文件夹）都会被标记为待删除，因为它们都包含名为 "y" 的空文件夹。
     * 注意，文件夹 "/a" 和 "/c" 在删除后变为相同文件夹，但这两个文件夹不会被删除，因为删除只会进行一次，且它们没有在删除前被标记。
     * 示例 3：
     * <p>
     * <p>
     * 输入：paths = [["a","b"],["c","d"],["c"],["a"]]
     * 输出：[["c"],["c","d"],["a"],["a","b"]]
     * 解释：文件系统中所有文件夹互不相同。
     * 注意，返回的数组可以按不同顺序返回文件夹路径，因为题目对顺序没有要求。
     * 示例 4：
     * <p>
     * <p>
     * 输入：paths = [["a"],["a","x"],["a","x","y"],["a","z"],["b"],["b","x"],["b","x","y"],["b","z"]]
     * 输出：[]
     * 解释：文件结构如上所示。
     * 文件夹 "/a/x" 和 "/b/x"（以及它们的子文件夹）都会被标记为待删除，因为它们都包含名为 "y" 的空文件夹。
     * 文件夹 "/a" 和 "/b"（以及它们的子文件夹）都会被标记为待删除，因为它们都包含一个名为 "z" 的空文件夹以及上面提到的文件夹 "x" 。
     * 示例 5：
     * <p>
     * <p>
     * 输入：paths = [["a"],["a","x"],["a","x","y"],["a","z"],["b"],["b","x"],["b","x","y"],["b","z"],["b","w"]]
     * 输出：[["b"],["b","w"],["b","z"],["a"],["a","z"]]
     * 解释：本例与上例的结构基本相同，除了新增 "/b/w" 文件夹。
     * 文件夹 "/a/x" 和 "/b/x" 仍然会被标记，但 "/a" 和 "/b" 不再被标记，因为 "/b" 中有名为 "w" 的空文件夹而 "/a" 没有。
     * 注意，"/a/z" 和 "/b/z" 不会被标记，因为相同子文件夹的集合必须是非空集合，但这两个文件夹都是空的。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= paths.length <= 2 * 104
     * 1 <= paths[i].length <= 500
     * 1 <= paths[i][j].length <= 10
     * 1 <= sum(paths[i][j].length) <= 2 * 105
     * path[i][j] 由小写英文字母组成
     * 不会存在两个路径都指向同一个文件夹的情况
     * 对于不在根层级的任意文件夹，其父文件夹也会包含在输入中
     *
     * @param paths
     * @return
     */


    public static void main(String[] args) {

    }

    Random random = new Random();
    Map<String, Long> map = new HashMap<>();
    Map<Long, Long> hash = new HashMap<>();
    Map<Long, Integer> occur = new HashMap<>();

    public long next() {
        return (long) Math.floor(random.nextDouble() * mod) % mod;
    }

    public long random(String s) {
        Long ans = map.get(s);
        if (ans == null) {
            ans = next();
            map.put(s, ans);
        }
        return ans;
    }

    public long hash(long v) {
        Long ans = hash.get(v);
        if (ans == null) {
            ans = next();
            hash.put(v, ans);
        }
        return ans;
    }

    long mod = 2305843009213693951L;

    public long sum(long a, long b) {
        long ans = a + b;
        if (ans >= mod) {
            ans -= mod;
        }
        return ans;
    }

    Node getNode(Node root, List<String> list, int i) {
        if (i == list.size()) {
            return root;
        }
        String name = list.get(i);
        Node next = root.adj.computeIfAbsent(name, Node::new);
        return getNode(next, list, i + 1);
    }

    long dfs(Node root) {
        long sum = 0;
        for (Node node : root.adj.values()) {
            sum = sum(sum, dfs(node));
        }
        root.childHash = hash(sum);
        root.hash = sum(random(root.name), hash(sum));
        occur.put(root.childHash, occur.getOrDefault(root.childHash, 0) + 1);
        return root.hash;
    }

    void tag(Node root, boolean delete) {
        if (root.adj.size() > 0 && occur.get(root.childHash) > 1) {
            delete = true;
        }
        root.deleted = delete;
        for (Node node : root.adj.values()) {
            tag(node, delete);
        }
    }

    void collect(Node root, List<String> path, List<List<String>> collector) {
        if (root.deleted) {
            return;
        }
        path.add(root.name);
        collector.add(new ArrayList<>(path.subList(1, path.size())));
        for (Node node : root.adj.values()) {
            collect(node, path, collector);
        }
        path.remove(path.size() - 1);
    }


    public List<List<String>> deleteDuplicateFolder2(List<List<String>> paths) {
        Node root = new Node("");
        for (List<String> p : paths) {
            getNode(root, p, 0);
        }
        List<List<String>> res = new ArrayList<>();
        dfs(root);
        tag(root, false);
        collect(root, new ArrayList<>(), res);
        return res.subList(1, res.size());
    }


    class Node {
        String name;

        public Node(String name) {
            this.name = name;
        }

        long hash;
        long childHash;
        boolean deleted;
        Map<String, Node> adj = new LinkedHashMap<>();
    }

    /**
     * 1947. 最大兼容性评分和
     * 有一份由 n 个问题组成的调查问卷，每个问题的答案要么是 0（no，否），要么是 1（yes，是）。
     * <p>
     * 这份调查问卷被分发给 m 名学生和 m 名导师，学生和导师的编号都是从 0 到 m - 1 。学生的答案用一个二维整数数组 students 表示，其中 students[i] 是一个整数数组，包含第 i 名学生对调查问卷给出的答案（下标从 0 开始）。导师的答案用一个二维整数数组 mentors 表示，其中 mentors[j] 是一个整数数组，包含第 j 名导师对调查问卷给出的答案（下标从 0 开始）。
     * <p>
     * 每个学生都会被分配给 一名 导师，而每位导师也会分配到 一名 学生。配对的学生与导师之间的兼容性评分等于学生和导师答案相同的次数。
     * <p>
     * 例如，学生答案为[1, 0, 1] 而导师答案为 [0, 0, 1] ，那么他们的兼容性评分为 2 ，因为只有第二个和第三个答案相同。
     * 请你找出最优的学生与导师的配对方案，以 最大程度上 提高 兼容性评分和 。
     * <p>
     * 给你 students 和 mentors ，返回可以得到的 最大兼容性评分和 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：students = [[1,1,0],[1,0,1],[0,0,1]], mentors = [[1,0,0],[0,0,1],[1,1,0]]
     * 输出：8
     * 解释：按下述方式分配学生和导师：
     * - 学生 0 分配给导师 2 ，兼容性评分为 3 。
     * - 学生 1 分配给导师 0 ，兼容性评分为 2 。
     * - 学生 2 分配给导师 1 ，兼容性评分为 3 。
     * 最大兼容性评分和为 3 + 2 + 3 = 8 。
     * 示例 2：
     * <p>
     * 输入：students = [[0,0],[0,0],[0,0]], mentors = [[1,1],[1,1],[1,1]]
     * 输出：0
     * 解释：任意学生与导师配对的兼容性评分都是 0 。
     * <p>
     * <p>
     * 提示：
     * <p>
     * m == students.length == mentors.length
     * n == students[i].length == mentors[j].length
     * 1 <= m, n <= 8
     * students[i][k] 为 0 或 1
     * mentors[j][k] 为 0 或 1
     * 通过次数2,809提交次数5,505
     */

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int[] index = new int[students.length];
        for (int i = 1; i < index.length; i++) {
            index[i] = i;
        }
        return maxCompatibilitySum(0, index, students, mentors);
    }

    private int maxCompatibilitySum(int i, int[] index, int[][] students, int[][] mentors) {
        if (i == index.length) {
            int count = 0;
            for (int j = 0; j < index.length; j++) {
                for (int k = 0; k < students[0].length; k++) {
                    if (students[j][k] == mentors[index[j]][k]) {
                        count++;
                    }
                }
            }
            return count;
        }
        int max = 0;
        for (int j = i; j < index.length; j++) {
            index[i] = index[j] + 0 * (index[j] = index[i]);
            max = Math.max(max, maxCompatibilitySum(i + 1, index, students, mentors));
            index[i] = index[j] + 0 * (index[j] = index[i]);
        }
        return max;
    }


}
