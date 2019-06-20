package problem.leetcoderegular;

import java.util.*;

import static util.PrintUtil.printArr;

/**
 * Leetcode 210
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 */
public class CourseOrder {

    public static void main(String[] args){
        CourseOrder courseOrder = new CourseOrder();
        printArr(courseOrder.findOrder(2, new int[][] {{1,0}}));
    }

    /**
     * 有向图的拓扑排序
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        DirectedGraph g = new DirectedGraph(numCourses);
        for (int[] edge: prerequisites) g.addEdge(edge);
        return g.getTopologySort();
    }

    class DirectedGraph{
        Map<Integer, LinkedList<Integer>> edges;
        int[] inDegree;
        int size;
        public DirectedGraph(int size){
            edges = new HashMap<>();
            inDegree = new int[size];
            this.size = size;
            for (int i =0; i<size; i++) edges.put(i, new LinkedList<>());

        }

        public void addEdge(int[] edge){
            edges.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;

        }

        public int[] getTopologySort(){
            int[] res = new int[size];
            int i = 0;
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> vertices =  edges.keySet();
            for (Integer v: vertices){
                if (inDegree[v] == 0) queue.add(v);
            }

            while ( i < size && !queue.isEmpty()){
                if(queue.isEmpty()) return new int[0];
                while (!queue.isEmpty()){
                    res[i] = queue.poll();
                    for (Integer n: edges.get(res[i])){
                        inDegree[n]--;
                        if(inDegree[n] == 0) queue.add(n);
                    }
                    i++;
                }
            }
            return i == size? res: new int[0];
        }
    }
}
