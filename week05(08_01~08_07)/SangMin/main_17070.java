import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] map;
	static int[][][] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 0 : 가로
		// 1 : 세로
		// 2 : 대각선
		dp = new int[n+1][n+1][3];
		dp[1][2][0] = 1;

		for(int i=1;i<=n;i++) {
			for(int j=3;j<=n;j++) {
				if(map[i][j]==1) continue;
				
				if(map[i][j-1]==0) 
					dp[i][j][0] += dp[i][j-1][0] +dp[i][j-1][2];
				
				if(map[i-1][j]==0)
					dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2];
				
				if(map[i-1][j]==0 && map[i][j-1]==0)
					dp[i][j][2] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
				
			}
		}
		
		System.out.println(dp[n][n][0]+dp[n][n][1]+dp[n][n][2]);
	}

}
