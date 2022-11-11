import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static int n, m, k, cnt;
	public static boolean[][] map;
	public static int[] dy = {0,1,0,-1};
	public static int[] dx = {1,0,-1,0};
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    k = Integer.parseInt(st.nextToken());
	    
	    map = new boolean[n][m];
	    
	    for(int t=0;t<k;t++) {
	    	st = new StringTokenizer(br.readLine());
	    	int x1 = Integer.parseInt(st.nextToken());
	    	int y1 = Integer.parseInt(st.nextToken());
	    	int x2 = Integer.parseInt(st.nextToken());
	    	int y2 = Integer.parseInt(st.nextToken());

	    	for(int i=y1;i<y2;i++) {
	    		for(int j=x1;j<x2;j++) {
	    			map[i][j] = true;
	    		}
	    	}
	    }
	    
	    ArrayList<Integer> res = new ArrayList<>();
	    
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<m;j++) {
	    		if(!map[i][j]) {
	    			cnt = 0;
	    			dfs(i,j);
	    			res.add(cnt);
	    		}
	    	}
	    }
	    
	    Collections.sort(res);
	    
	    sb.append(res.size()).append("\n");
	    for(int i : res) {
	    	sb.append(i).append(" ");
	    }
	    
	    System.out.println(sb);
	}
	
	public static void dfs(int y, int x) {
		map[y][x] = true;		
		cnt++;
		
		for(int i=0;i<4;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny<0||nx<0||ny>=n||nx>=m) continue;
			
			if(!map[ny][nx]) {
				dfs(ny,nx);
			}
		}
	}
}