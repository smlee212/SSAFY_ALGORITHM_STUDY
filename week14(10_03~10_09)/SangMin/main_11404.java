import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    
	    int n = Integer.parseInt(br.readLine());
    	int m = Integer.parseInt(br.readLine());
    	
    	int[][] graph = new int[n+1][n+1];	    	
    	int[][] dp = new int[n+1][n+1];
    	
    	for(int i=0;i<=n;i++) {
    		for(int j=0;j<=n;j++) {
    			graph[i][j] = INF;
    		}
    	}

    	for(int i=0;i<m;i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());

    		graph[a][b] = graph[a][b]!=INF?Math.min(c, graph[a][b]):c;
    	}	    	
    	
    	for(int k=1;k<=n;k++) {
    		for(int i=1;i<=n;i++) {
    			if(i==k) continue;
    			for(int j=1;j<=n;j++) {
    				if(j==i) continue;
    				if(graph[i][k]!=INF && graph[k][j]!=INF)
    					graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
    			}
    		}
    	}
    	
    	for(int i=1;i<=n;i++) {
    		for(int j=1;j<=n;j++) {
    			sb.append(graph[i][j]!=INF?graph[i][j]:0).append(" ");
    		}
    		sb.append("\n");
    	}    	
    	System.out.println(sb);
	}
}