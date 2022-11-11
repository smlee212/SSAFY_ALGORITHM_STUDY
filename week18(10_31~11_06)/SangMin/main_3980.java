import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static final int N = 11;
	static int[][] map;
	static boolean[] visited;
	static int max;
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    int T = Integer.parseInt(br.readLine());
	    
	    for(int t=1;t<=T;t++) {
	    	map = new int[N][N];
	    	visited = new boolean[N];
	    	
	    	for(int i=0;i<N;i++) {
	    		st = new StringTokenizer(br.readLine());
	    		for(int j=0;j<N;j++) {
	    			map[i][j] = Integer.parseInt(st.nextToken());
	    		}
	    	}
	    	
	    	max = 0;
	    	
	    	dfs(0,0,0);
	    	
	    	sb.append(max).append("\n");
	    }
	    System.out.println(sb);
	}
	
	static void dfs(int now, int depth, int sum) {
		if(depth == N) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(map[now][i]>0 && !visited[i]) {
				visited[i] = true;
				dfs(now+1, depth+1, sum+map[now][i]);
				visited[i] = false;
			}
		}
	}
}