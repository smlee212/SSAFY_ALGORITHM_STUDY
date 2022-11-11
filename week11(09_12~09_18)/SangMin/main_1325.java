import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, max;
	static ArrayList<Integer>[] graph;
	static int[] cnt;
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    graph = new ArrayList[N+1];
	    for(int i=1;i<=N;i++) {
	    	graph[i] = new ArrayList<>();
	    }
	    
	    for(int i=0;i<M;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int to = Integer.parseInt(st.nextToken());
	    	int from  = Integer.parseInt(st.nextToken());
	    	
	    	graph[from].add(to);
	    }
	    
	    cnt = new int[N+1];
	    max = 0;
	    for(int i=1;i<=N;i++) {
	    	bfs(i);
	    	if(max<cnt[i]) {
	    		max = cnt[i];
	    	}
	    }
	    
	    for(int i=1;i<=N;i++) {
	    	if(max==cnt[i]) {
	    		sb.append(i).append(" ");
	    	}
	    }
	    
	    System.out.println(sb);
	}
	
	static void bfs(int i) {
		Queue<Integer> dq = new LinkedList<>();
//		Deque<Integer> dq = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		visited[i] = true;
		dq.add(i);
		
		while(!dq.isEmpty()) {
			int x = dq.poll();
			
			for(int nx : graph[x]) {
				if(!visited[nx]) {
					visited[nx] = true;
					dq.add(nx);
					cnt[i]++;
				}
			}			
		}
	}
}