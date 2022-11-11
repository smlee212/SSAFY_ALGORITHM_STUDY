import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static final int lENGTH = 100; 
	public static int N, M;
	public static int[] map;
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st ;
	    
	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    map = new int[lENGTH+1];
	    
	    for(int i=0;i<N+M;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int a = Integer.parseInt(st.nextToken());
	    	int b = Integer.parseInt(st.nextToken());
	    	
	    	map[a] = b;
	    }
	    
	    bfs(1);
	}
	
	public static void bfs(int x) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(x);
		
		boolean[] visited = new boolean[lENGTH+1];
		visited[x] = true;
		
		int time = 0;
		
		while(!dq.isEmpty()) {
			
			int size = dq.size();
			
			for(int s=0;s<size;s++) {
				x = dq.poll();

				if(x==lENGTH) {
					System.out.println(time);
					return;
				}
				
				for(int i=1;i<=6;i++) {
					int nx = x + i;
					
					if(nx>lENGTH) continue;
					
					if(map[nx]==0 && !visited[nx]){
						visited[nx] = true;
						dq.add(nx);
					}
					else if(map[nx]>0 && !visited[map[nx]]) {
						visited[map[nx]] = true;
						dq.add(map[nx]);
					}
				}
			}
			time++;
		}
	}
}