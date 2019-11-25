package bobo.algo;

public class Main {

    // 测试我们的Bellman-Ford最短路径算法
    public static void main(String[] args) {

        String filename = "testG2.txt";
        //String filename = "testG_negative_circle.txt";
        int V = 5;

        SparseWeightedGraph<Integer> g = new SparseWeightedGraph<Integer>(V, true);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        System.out.println("Test Bellman-Ford:\n");
        BellmanFord<Integer> bellmanFord = new BellmanFord<Integer>(g,0);
        if( bellmanFord.negativeCycle() )
            System.out.println("The graph contain negative cycle!");
        else
            for( int i = 1 ; i < V ; i ++ ){
                if(bellmanFord.hasPathTo(i)) {
                    System.out.println("Shortest Path to " + i + " : " + bellmanFord.shortestPathTo(i));
                    bellmanFord.showPath(i);
                }
                else
                    System.out.println("No Path to " + i );

            System.out.println("----------");
        }

    }
}
