import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int[] dp = new int[1001];
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    dp[1]=1; dp[2]=2; dp[3]=1; dp[4]=1;
	    
	    for(int i=5;i<=n;i++) {
	    	dp[i] = 2;
	    	if(dp[i-1]==2 || dp[i-3]==2 || dp[i-4]==2) {
	    		dp[i] = 1;
	    	}
	    }
	    
	    System.out.println(dp[n]==1?"SK":"CY");
	}
}