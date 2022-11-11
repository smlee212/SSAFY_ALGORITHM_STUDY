import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    int v = Integer.parseInt(st.nextToken());
	    int e = Integer.parseInt(st.nextToken());

	    int[][] graph = new int[v+1][v+1];
	    for(int i=0;i<=v;i++) {
	    	for(int j=0;j<=v;j++) {
	    		graph[i][j] = 99999999;
	    	}
	    }
	    
	    for(int i=0;i<e;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int from = Integer.parseInt(st.nextToken());
	    	int to = Integer.parseInt(st.nextToken());
	    	int dist = Integer.parseInt(st.nextToken());
	    	
	    	graph[from][to] = dist;
	    }
	    
	    for(int k=1;k<=v;k++) {
	    	
	    	for(int i=1;i<=v;i++) {
	    		for(int j=1;j<=v;j++) {
	    			if(graph[i][j] > graph[i][k] + graph[k][j]) {
	    				graph[i][j] = graph[i][k] + graph[k][j];
	    			}
	    		}
	    	}
	    	
	    }
	    
	    int minRes = Integer.MAX_VALUE;
	    for(int i=1;i<=v;i++) {
	    	minRes = Math.min(minRes, graph[i][i]);
	    }
	    
	    System.out.println(minRes==99999999?-1:minRes);
	}
}