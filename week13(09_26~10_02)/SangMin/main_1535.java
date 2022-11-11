import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

	    int n = Integer.parseInt(br.readLine());
	    
	    int[][] map = new int[n+1][2];
	    
	    st = new StringTokenizer(br.readLine());
	    
	    for(int i=1;i<=n;i++) { // 체력
	    	map[i][0] = Integer.parseInt(st.nextToken());
	    }

	    st = new StringTokenizer(br.readLine());
	    for(int i=1;i<=n;i++) { // 기쁨
	    	map[i][1] = Integer.parseInt(st.nextToken());
	    }
	    
	    int[][] dp = new int[n+1][100];
	    
	    for(int i=1;i<=n;i++) {
	    	
	    	for(int j=1;j<100;j++) {
	    		if(map[i][0] <= j) {
	    			dp[i][j] = Math.max(dp[i-1][j-map[i][0]] + map[i][1], dp[i-1][j]);
	    		}
	    		else {
	    			dp[i][j] = dp[i-1][j];
	    		}
	    	}
	    }
	    
	    System.out.println(dp[n][99]);
	}

}