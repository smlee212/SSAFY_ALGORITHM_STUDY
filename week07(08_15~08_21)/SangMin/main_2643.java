import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		dp = new int[1001][1001];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x>y)
				dp[x][y] = -1;
			else
				dp[y][x] = -1;
		}
		
		for(int i=1;i<=1000;i++) {
			for(int j=1;j<=1000;j++) {
				if(dp[i][j]<0) 
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + 1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
			}
		}
		System.out.println(dp[1000][1000]);
	}
}