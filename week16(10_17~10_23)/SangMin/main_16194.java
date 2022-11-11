import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int[] dp = new int[n+1];
	    
	    st = new StringTokenizer(br.readLine());
	    
	    for(int i=1;i<=n;i++) {
	    	dp[i] = Integer.parseInt(st.nextToken());
	    	for(int j=i;j>=1;j--) {
	    		dp[i] = Math.min(dp[i], dp[i-j] + dp[j]);
	    	}
	    }
	    
	    System.out.println(dp[n]);
	}
	
}