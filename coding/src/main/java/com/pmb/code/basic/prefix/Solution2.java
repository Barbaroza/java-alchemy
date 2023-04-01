package com.pmb.code.basic.prefix;

import java.util.*;

/**
 * @author lvrui
 */
public class Solution2 {
    Map<String, Set<String>> graph = new HashMap<String, Set<String>>();

    Map<String, Double> weight = new HashMap<String, Double>();
    Set<String> access = new HashSet();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        for (int i = 0; i < values.length; i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double val = values[i];
            weight.put(key(from, to), val);
            weight.put(key(to, from), 1d / val);
            Set<String> d = graph.getOrDefault(from, new HashSet());
            d.add(to);
            graph.put(from, d);
            Set<String> d2 = graph.getOrDefault(to, new HashSet());
            d2.add(from);
            graph.put(to, d2);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            ans[i] = dfs(from, to, 1d);
            access.clear();
            ans[i] = ans[i] == -1d ? 1d / dfs(to, from, 1d) : ans[i];
            access.clear();

        }

        return ans;
    }


    private double dfs(String from, String to, double val) {
        Set<String> tos = graph.get(from);
        if (tos == null) {
            return -1d;
        }
        if (from.equals(to)) {
            return val;
        }
        if (!access.add(from)) {
            return -1d;
        }
        if (tos.contains(to)) {
            return weight.get(key(from, to)) * val;
        }
        for (String t : tos) {
            double r = dfs(t, to, val * weight.get(key(from, t)));
            if (r != -1d) {
                return r;
            }

        }
        access.remove(from);
        return -1d;
    }

    private String key(String n1, String n2) {
        return String.format("%s-%s", n1, n2);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        List<List<String>> equations = new ArrayList<>();
        double[] values = new double[]{2d, 3d};
        List<List<String>> queries = new ArrayList<>();
        List<String> t1 = new ArrayList<>();
        List<String> t2 = new ArrayList<>();
        t1.add("a");
        t1.add("b");
        t2.add("b");
        t2.add("c");
        equations.add(t1);
        equations.add(t2);
        List<String> t3 = new ArrayList<>();
        t3.add("b");
        t3.add("a");
        queries.add(t3);
        solution2.calcEquation(equations, values, queries);
    }

    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        Map<String, Integer> variables = new HashMap<String, Integer>();

        int n = equations.size();
        for (int i = 0; i < n; i++) {
            if (!variables.containsKey(equations.get(i).get(0))) {
                variables.put(equations.get(i).get(0), nvars++);
            }
            if (!variables.containsKey(equations.get(i).get(1))) {
                variables.put(equations.get(i).get(1), nvars++);
            }
        }

        // 对于每个点，存储其直接连接到的所有点及对应的权值
        List<Pair>[] edges = new List[nvars];
        for (int i = 0; i < nvars; i++) {
            edges[i] = new ArrayList<Pair>();
        }
        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0)), vb = variables.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1.0 / values[i]));
        }

        int queriesCount = queries.size();
        double[] ret = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                int ia = variables.get(query.get(0)), ib = variables.get(query.get(1));
                if (ia == ib) {
                    result = 1.0;
                } else {
                    Queue<Integer> points = new LinkedList<Integer>();
                    points.offer(ia);
                    double[] ratios = new double[nvars];
                    Arrays.fill(ratios, -1.0);
                    ratios[ia] = 1.0;

                    while (!points.isEmpty() && ratios[ib] < 0) {
                        int x = points.poll();
                        for (Pair pair : edges[x]) {
                            int y = pair.index;
                            double val = pair.value;
                            if (ratios[y] < 0) {
                                ratios[y] = ratios[x] * val;
                                points.offer(y);
                            }
                        }
                    }
                    result = ratios[ib];
                }
            }
            ret[i] = result;
        }
        return ret;
    }
}

class Pair {
    int index;
    double value;

    Pair(int index, double value) {
        this.index = index;
        this.value = value;
    }
}
