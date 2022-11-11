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
		int[][] map = new int[n][2];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			map[i][0] = from;
			map[i][1] = to;
		}
		
		Arrays.sort(map, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});

		int max = 0;
		int[] dp = new int[n];
		
		for(int i=0;i<n;i++) {
			
			dp[i] = 1;
			
			for(int j=0;j<i;j++) {
				if(map[i][1]>map[j][1]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}			
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(n-max);
	}	
}
