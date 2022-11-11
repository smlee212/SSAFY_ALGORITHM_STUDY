import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int[] num = new int[n+1];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=1;i<=n;i++) {
	    	num[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int[] dp = new int[n+1];
	    dp[1] = 1;
	    
	    int cnt = 1;
	    for(int i=2;i<=n;i++){
	    	dp[i] = 1;
	    	for(int j=1;j<i;j++) {
	    		if(num[j]<num[i] && dp[j]>=dp[i]) {
	    			dp[i] = dp[j]+1;
	    		}
	    	}
	    	cnt = Math.max(cnt, dp[i]);
	    }
	    
	    System.out.println(cnt);
	}
}