import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class 섬연결하기 {

    public int solution(int n, int[][] costs) {

        List<Edge> edges = new ArrayList<>();
        for(int i =  0; i < costs.length; i++){
            edges.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }

        edges.sort( (Edge o1, Edge o2) -> {return o1.distance - o2.distance;} );

        int [] cycle = new int[n];
        for(int i =0; i < cycle.length; i++) {
            cycle[i] = i;
        }

        AtomicInteger sum = new AtomicInteger();

        edges.stream().forEach(o -> {
            if(!find(cycle, o.start, o.end)) {
                sum.addAndGet(o.distance);
                unionParent(cycle, o.start, o.end);
            }
        });

        return sum.get();
    }

    public void unionParent(int cycle[], int start, int end) {
        start = getParent(cycle,start);
        end = getParent(cycle, end);
        if(start < end) cycle[end] = start;
        else cycle[start] = end;
    }

    public int getParent(int cycle[], int x) {
        if(cycle[x] == x) return x;
        return cycle[x] = getParent(cycle, cycle[x]);
    }

    public boolean find(int cycle[], int start, int end) {
        start = getParent(cycle, start);
        end = getParent(cycle, end);
        if (start == end) return true;
        else return false;
    }

    public class Edge {
        public int start;
        public int end;
        int distance;

        public Edge(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
}


