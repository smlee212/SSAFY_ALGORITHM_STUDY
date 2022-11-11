import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map = new int[5][5];
	static HashSet<Integer> hs = new HashSet<>();
	static int[] dy = {-1,0,1,0},
				 dx = {0,1,0,-1};
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    for(int i=0;i<5;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j=0;j<5;j++) {
	    		map[i][j] = Integer.parseInt(st.nextToken());
	    	}
	    }
	    
	    for(int i=0;i<5;i++) {
	    	for(int j=0;j<5;j++) {
	    		dfs(i,j,0,"");
	    	}
	    }
	    
	    System.out.println(hs.size());
	}
	
	static void dfs(int y, int x, int d, String res) {
		if(d>5) {
			hs.add(Integer.parseInt(res));
			return;
		}
		
		for(int i=0;i<4;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny<0||nx<0||ny>=5||nx>=5) continue;
			
			dfs(ny,nx,d+1,res+map[ny][nx]);
		}
	}
}