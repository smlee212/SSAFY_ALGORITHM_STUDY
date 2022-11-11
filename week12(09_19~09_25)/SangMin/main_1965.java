import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] num = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		int res = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(num[i]<num[j]) {
					dp[j] = Math.max(dp[j], dp[i]+1);
				}
			}
			res = Math.max(dp[i], res);
		}
		System.out.println(res+1);
	}	
}
