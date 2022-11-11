import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, D, distance[];
	static ArrayList<Node>[] graph;
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	   
	    distance = new int[10001];
	    graph = new ArrayList[10001];
	    for(int i=0;i<10001;i++) {
	    	distance[i] = i;
	    	graph[i] = new ArrayList<>();
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    D = Integer.parseInt(st.nextToken());
	    
	    for(int i=0;i<N;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int from = Integer.parseInt(st.nextToken());
	    	int to = Integer.parseInt(st.nextToken());
	    	int dist = Integer.parseInt(st.nextToken());
	    	
	    	graph[from].add(new Node(to,dist));
	    }
	    
	    for(int i=0;i<=D;i++) {
	    	dijkstra(i);
	    }
	    
	    System.out.println(distance[D]);
	}
	
	static void dijkstra(int now) {
		
		if(distance[now+1] > distance[now] + 1) {
			distance[now+1] = distance[now] + 1;
		}
		
		for(Node next : graph[now]) {
			if(distance[next.to] > distance[now] + next.dist) {
				distance[next.to] = distance[now] + next.dist;
			}
		}		
	}
	
}

class Node{
	int to;
	int dist;
	public Node(int to, int dist) {
		super();
		this.to = to;
		this.dist = dist;
	}
}