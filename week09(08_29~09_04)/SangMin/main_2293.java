import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());
	    
	    int[] dp = new int[k+1];
	    
	    dp[0] = 1;
	    for(int i=0;i<n;i++) {
	    	int num = Integer.parseInt(br.readLine());
	    	for(int j=num;j<=k;j++) {
	    		dp[j] += dp[j-num];
	    	}
	    }

	    System.out.println(dp[k]);
	}
}