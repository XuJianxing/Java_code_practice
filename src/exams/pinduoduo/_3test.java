package exams.pinduoduo;

import java.util.*;

public class _3test {
}

// 图的拓扑排序
 class E3 {
    static class Task {
        int seq;
        int weight;
        public Task(int n, int w) {
            seq = n;
            weight = w;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            Task[] t = new Task[n+1];
            for(int i = 1; i < n+1; ++i) {
                t[i] = new Task(i, in.nextInt());
            }
            // construct dependency raph
            Map<Integer, List<Integer>> graph = new HashMap<>();
            int[] indegree = new int[n+1];
            for(int i = 0; i < m; ++i) {
                int u = in.nextInt();
                int v = in.nextInt();
                if(graph.containsKey(u)) {
                    graph.get(u).add(v);
                } else {
                    List<Integer> edges = new ArrayList<>();
                    edges.add(v);
                    graph.put(u, edges);
                }
                indegree[v]++;
            }
            //topological sort
            PriorityQueue<Task> queue = new PriorityQueue<>(new Comparator<Task>() {
                @Override
                public int compare(Task o1, Task o2) {
                    return o1.weight-o2.weight;
                }
            });
            for(int i = 1; i < n+1; ++i) {
                if(indegree[i] == 0) queue.offer(t[i]);
            }
            List<Integer> res = new ArrayList<>();
            while(!queue.isEmpty()) {
                Task complete = queue.poll();
                res.add(complete.seq);
                if(graph.containsKey(complete.seq)) {
                    for(int i : graph.get(complete.seq)){
                        if(--indegree[i] == 0) {
                            queue.offer(t[i]);
                        }
                    }
                }
            }
            for(int i = 0; i < n; ++i) {
                System.out.print(res.get(i));
                if(i != n-1) System.out.print(" ");
            }
        }
    }
}