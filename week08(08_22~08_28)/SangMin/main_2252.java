import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st ;

	    st = new StringTokenizer(br.readLine());
	   
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    int[] degree = new int[N+1];
	    
	    ArrayList<Integer>[] graph = new ArrayList[N+1];
	    for(int i=0;i<=N;i++) {
	    	graph[i] = new ArrayList<>();
	    }
	    
	    for(int i=0;i<M;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int from = Integer.parseInt(st.nextToken());
	    	int to = Integer.parseInt(st.nextToken());
	    	
	    	graph[from].add(to);
	    	degree[to]++;
	    }
	    
	    Deque<Integer> dq = new ArrayDeque<>();
	    for(int i=1;i<=N;i++) {
	    	if(degree[i]==0) {
	    		dq.add(i);
	    	}
	    }
	    
	    while(!dq.isEmpty()) {
	    	int now = dq.poll();
	    	
	    	sb.append(now).append(" ");
	    	
	    	for(int next : graph[now]) {
	    		if(--degree[next]==0) {
	    			dq.add(next);
	    		}
	    	}
	    }
	   
	    System.out.println(sb);
	    
	}
}