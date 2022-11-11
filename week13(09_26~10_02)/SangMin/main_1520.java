import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n, m;
	static int[][] map, dp;
	static int[] dy = {1,0,-1,0},
			 	 dx = {0,1,0,-1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		map = new int[n][m];
		dp = new int[n][m];
		
		for(int i=0;i<n;i++) {
			input = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(input[j]);
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0,0));
	}
	
	static int dfs(int y, int x) {
		if(y==n-1 && x==m-1) {
			return 1;
		}
		
		if(dp[y][x] != -1) {
			return dp[y][x];
		}
		
		dp[y][x] = 0;
		
		for(int i=0;i<4;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny<0||nx<0||ny>=n||nx>=m) continue;
			
			if(map[y][x] > map[ny][nx]) {		
				dp[y][x] += dfs(ny,nx);
			}
		}
		
		return dp[y][x];
	}

}
