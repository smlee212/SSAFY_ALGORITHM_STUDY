import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] map;
	static boolean[] visited;
	static ArrayList<Integer> arr = new ArrayList<>();
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
	    StringTokenizer st; 	    
	    
	    n = Integer.parseInt(br.readLine());
	    map = new int[n+1];
	    for(int i=1;i<=n;i++) {
	    	map[i] = Integer.parseInt(br.readLine());
	    }
	    
	    for(int i=1;i<=n;i++) {
			visited = new boolean[n+1];
		    dfs(i,i,0);
	    }

	    Collections.sort(arr);
	    
	    sb.append(arr.size()).append("\n");
	    
	    for(int i : arr) {
	    	sb.append(i).append("\n");
	    }
	    
	    System.out.println(sb.toString());
	}
	
	public static void dfs(int start, int now, int cnt) {
		if(cnt > 0 && start == now) {
			for(int i=1;i<=n;i++) {
				if(visited[i] && !arr.contains(i)) {					
					arr.add(i);
				}
			}
			return;
		}
		
		int next = map[now];
		
		if(!visited[next]) {
			visited[next] = true;
			dfs(start,next,cnt+1);
		}		
	}
}
