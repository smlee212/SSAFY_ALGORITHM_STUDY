import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, d, c;
	static ArrayList<Node>[] graph; 
	static int[] time;
	
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    int T = Integer.parseInt(br.readLine());
	    
	    for(int t=1;t<=T;t++) {
	    	st = new StringTokenizer(br.readLine());
	    	
	    	n = Integer.parseInt(st.nextToken());
	    	d = Integer.parseInt(st.nextToken());
	    	c = Integer.parseInt(st.nextToken());
	    	
	    	graph = new ArrayList[n+1];
	    	time = new int[n+1];
	    	
	    	for(int i=0;i<=n;i++) {
	    		graph[i] = new ArrayList<>();
	    		time[i] = Integer.MAX_VALUE;
	    	}
	    	
	    	for(int i=0;i<d;i++) {
	    		st = new StringTokenizer(br.readLine());
	    		
	    		int a = Integer.parseInt(st.nextToken());
	    		int b = Integer.parseInt(st.nextToken());
	    		int s = Integer.parseInt(st.nextToken());
	    		
	    		graph[b].add(new Node(a,s));
	    	}
	    	
	    	PriorityQueue<Node> pq = new PriorityQueue<>();
	    	pq.add(new Node(c,0));
	    	time[c] = 0;
	    	
	    	while(!pq.isEmpty()) {
	    		Node node = pq.poll();
	    		
	    		int now = node.to;
	    		int val = node.time;
	    		
	    		if(time[now] < val) continue;
	    		
	    		for(Node next : graph[now]) {
	    			if(time[next.to] > time[now] + next.time) {
	    				time[next.to] = time[now] + next.time;
	    				pq.add(new Node(next.to, time[next.to]));
	    			}
	    		}
	    	
	    		
	    	}	    	
	    	
	    	int cnt = 0;
	    	int res = 0;
	    	for(int i=1;i<=n;i++) {
	    		if(time[i] != Integer.MAX_VALUE) {
	    			cnt++;
	    			res = Math.max(res, time[i]);
	    		}
	    	}
	    	
	    	sb.append(cnt).append(" ").append(res).append("\n");
	    }
	    System.out.println(sb);
	}
	
	static class Node implements Comparable<Node>{
		int to;
		int time;
		public Node(int to, int time) {
			super();
			this.to = to;
			this.time = time;
		}
		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}
}