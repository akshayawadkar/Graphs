import java.util.*;
import java.util.Map.Entry;

public class Disjiskktra {
	
	private static class Pair{
		int v;
		String psf;
		int wsf;
		public Pair(int v, String psf, int wsf) {
			super();
			this.v = v;
			this.psf = psf;
			this.wsf = wsf;
		}
		
		
	}

	private static class Edge{
		int src;
		int dest;
		int wt;
		public Edge(int src, int dest, int wt) {
			super();
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}
		@Override
		public String toString() {
			return "Edge [src=" + src + ", dest=" + dest + ", wt=" + wt + "]";
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
	  
		
		int[][] arr = 	{{0, 3,40},
						 {0, 1, 10}, 
						 {1, 2, 10},
						 {2, 3, 10},
						 {3, 4, 3},
						 {4, 5, 3},
						 {5, 6, 3},
						 {4, 6, 8}};

		Map<Integer, List<Edge>> map = new HashMap<>();
		buildGraph(arr, map);
		
//		for(Entry entry : map.entrySet()) {
//			System.out.println(entry.getKey() + "  " + entry.getValue().toString());
//		}
		 
		
//		System.out.println(map.size());
//		System.out.println(map.get(0));
		dijisktra(map, map.size() + 1, 0);
		
		
	}

	private static void buildGraph(int[][] arr, Map<Integer, List<Edge>> map) {
	 
		for(int[] a : arr) {
			int src = a[0];
			int dest = a[1];
			int wt = a[2];
			
			if(map.containsKey(src)) {
				map.get(src).add(new Edge(src, dest, wt));
			}else {
				map.put(src, new ArrayList<>());
				map.get(src).add(new Edge(src, dest, wt));
			}
			
			map.putIfAbsent(dest, new ArrayList<>());
			
		}
		
	}

	private static void dijisktra(Map<Integer, List<Edge>> map, int v, int src) {
		 
		
		PriorityQueue<Pair> pq = new PriorityQueue<Disjiskktra.Pair>((a, b) ->{
			return a.wsf - b.wsf;
		});
		boolean[] visited = new boolean[v];
		
		
		pq.add(new Pair(src, 0 + "", 0));
		
		 
		while(!pq.isEmpty()) {
			
			Pair curr = pq.poll();
			
			if(visited[curr.v]) {
				continue;
			}
			
			if(map.get(curr.v) == null) {
				continue;
			}
			
			
			visited[curr.v] = true;
			System.out.println(src + " to " + curr.v + "  " + curr.wsf + " using path " + curr.psf);
			
			for(Edge child : map.get(curr.v)) {
				if(!visited[child.dest]) {
					pq.add(new Pair(child.dest, curr.psf + child.dest, curr.wsf + child.wt));
				}
			}
			
		}
		System.out.println();
	
	}

}
