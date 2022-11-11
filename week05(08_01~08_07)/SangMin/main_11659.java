import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] num = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			dp[i] = dp[i-1] + num[i];
		}
		
		for(int t=0;t<m;t++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			sb.append(dp[j]-dp[i-1]).append('\n');
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}