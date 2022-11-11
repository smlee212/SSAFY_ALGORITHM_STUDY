import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
	    int T = Integer.parseInt(br.readLine());
	    
	    int[] num = new int[T];
	    int maxNum = 0;
	    for(int t=0;t<T;t++) {
	    	num[t] = Integer.parseInt(br.readLine());
	    	maxNum = Math.max(maxNum, num[t]);
	    }
	    
	    long[] dp = new long[maxNum+1];
	    dp[1] = 1;
	    dp[2] = 2;
	    dp[3] = 4;
	    
	    if(maxNum >= 4) {
		    for(int i=4;i<=maxNum;i++) {
		    	dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])%1000000009;
		    }
	    }
	    
	    for(int n : num) {
	    	sb.append(dp[n]).append("\n");
	    }
	    System.out.println(sb);
	}
}