import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i>=j) {
					dp[i] = Math.max(dp[i-j] + arr[j], dp[i]);
				}
			}
		}
		
		System.out.println(dp[n]);
	}

}
