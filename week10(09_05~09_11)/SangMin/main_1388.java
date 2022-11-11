import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static char[][] map;
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	   
	    st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    map = new char[n][m];
	    
	    for(int i=0;i<n;i++) {
	    	map[i] = br.readLine().toCharArray();
	    }
	    
	    int cnt = 0;
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<m;j++) {
	    		if(map[i][j]!='.') {
	    			dfs(i,j,map[i][j]);
	    			cnt++;	    			
	    		}
	    	}
	    }
	    
	    System.out.println(cnt);
	}
	
	static void dfs(int y, int x, char val) {
		map[y][x] = '.';
		
		if(val=='-' && x+1<m && map[y][x+1]==val) {
			dfs(y,x+1,val);
		}
		else if(val=='|' && y+1<n && map[y+1][x]==val) {
			dfs(y+1,x,val);
		}
	}
}