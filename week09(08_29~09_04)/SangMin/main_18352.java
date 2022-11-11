import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    int X = Integer.parseInt(st.nextToken());
	    
	    ArrayList<Integer>[] graph = new ArrayList[N+1];
	    int[] distance = new int[N+1];
	    for(int i=0;i<=N;i++) {
	    	graph[i] = new ArrayList<>();
	    	distance[i] = -1;
	    }
	    
	    for(int i=0;i<M;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int from = Integer.parseInt(st.nextToken());
	    	int to = Integer.parseInt(st.nextToken());
	    	
	    	graph[from].add(to);
	    }
	    
	    distance[X] = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(X);
		
		while(!dq.isEmpty()) {
			int now=dq.poll();
			
			for(int next : graph[now]) {
				if(distance[next]==-1) {
					distance[next] = distance[now]+1;
					dq.add(next);
				}
			}
		}
		
		boolean check=false;
		for(int i=1;i<=N;i++) {
			if(distance[i]==K) {
				System.out.println(i);
				check=true;
			}
		}
		
		if(check==false)
			System.out.println(-1);
	}	
}