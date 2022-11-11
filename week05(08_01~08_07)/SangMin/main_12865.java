import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
	    StringTokenizer st; 
	    
	    st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    
	    int[][] obj = new int[2][N+1];
	    int[][] dp = new int[K+1][N+1];
	    
	    for(int i=1;i<=N;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	obj[0][i] = Integer.parseInt(st.nextToken()); // 무게
	    	obj[1][i] = Integer.parseInt(st.nextToken()); // 가치
	    }
	    br.close();
	    
	    for(int i=1;i<=K;i++) { // 현재 가방의 무게
	    	for(int j=1;j<=N;j++) { // 현재 고려할 물건의 번호
	    		if(i >= obj[0][j]) // j번째 물건을 넣었수 있을 때
	    			dp[i][j] = Math.max(dp[i][j-1],dp[i-obj[0][j]][j-1]+obj[1][j]);
	    		else // j번째 물건을 넣지 않았을 때 이전까지의 값들을 가져온다
	    			dp[i][j] = dp[i][j-1];
	    	}
	    }
	    System.out.println(dp[K][N]);	    
	}
}