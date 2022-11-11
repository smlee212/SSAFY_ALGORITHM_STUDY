import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st ;

	    st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());

		ArrayList<Node>[] graph = new ArrayList[N+1];
		int[] distance = new int[N+1];
		
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Node(to,weight));
			graph[to].add(new Node(from,weight));
		}
		
	    PriorityQueue<Node> pq = new PriorityQueue<>();
	    boolean[] visited = new boolean[N+1];
	    
	    distance[1] = 0;
	    pq.add(new Node(1,distance[1]));
		
	    while(!pq.isEmpty()) {
	    	
	    	Node now = pq.poll();
	    	if(visited[now.to]) continue;
	    	visited[now.to] = true;
	    	
	    	for(Node next : graph[now.to]) {
	    		if(!visited[next.to] && distance[next.to] > next.weight + distance[now.to]) {
	    			distance[next.to] = next.weight + distance[now.to];
	    			pq.add(new Node(next.to,distance[next.to]));
	    		}
	    	}
	    }
	    
	    System.out.println(distance[N]);
	    
	}
}

class Node implements Comparable<Node>{
	int to;
	int weight;
	public Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node o) {
		return weight-o.weight;
	}
	
}