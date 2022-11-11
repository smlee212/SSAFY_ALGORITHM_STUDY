import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer; 


class Main {
    static int n, k;
    static int maxRes=Integer.MIN_VALUE, maxDp=Integer.MIN_VALUE;
    static int[] train;    
    static int[][] dp;
    
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		train = new int[n+1];
		dp = new int[3+1][n+1];
	
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			train[i] = train[i-1] + Integer.parseInt(st.nextToken());
		}
		
		k = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=3;i++) {
			for(int j=i*k;j<=n;j++) {
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-k] + train[j] - train[j-k]);
			}
		}
		
		
		System.out.println(dp[3][n]);
	}
}