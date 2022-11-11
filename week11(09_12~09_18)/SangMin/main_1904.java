import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    long[] dp = new long[n+1];
	   
	    if(n==1) {
	    	System.out.println(1);
	    }
	    else if(n==2) {
	    	System.out.println(2);
	    }
	    else {
	    	dp[1] = 1;
		    dp[2] = 2;
		    
		    for(int i=3;i<=n;i++) {
		    	dp[i] = (dp[i-1] + dp[i-2]) % 15746;
		    }
		    
		    System.out.println(dp[n]); 
	    }
	}
}