import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] map = new int[n];
		int[] dp = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1;
		
		int max = 1;
		for(int i=1;i<n;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				if(map[j] > map[i] && dp[j]+1 > dp[i]) {
					dp[i] = dp[j]+1;
				}
			}
			max = Math.max(max, dp[i]);
		}		
		
		System.out.println(max);
	}

}
