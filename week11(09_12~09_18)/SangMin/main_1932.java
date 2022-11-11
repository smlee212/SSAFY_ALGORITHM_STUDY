import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    int n = Integer.parseInt(br.readLine());
	    int[][] dp = new int[n+1][n+1];
	    
	    for(int i=1;i<=n;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j=1;j<=i;j++) {
	    		dp[i][j] = Integer.parseInt(st.nextToken());
	    	}
	    }
	    
	    int maxSum = 0;
	    
	    for(int i=1;i<=n;i++) {
	    	for(int j=1;j<=n;j++) {
	    		dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
	    		if(maxSum < dp[i][j])
	    			maxSum = dp[i][j];
	    	}
	    }
		
		System.out.println(maxSum);
	}
}