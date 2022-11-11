import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] num;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.parseInt(br.readLine());
		
		num = new int[n];
		visited = new boolean[n+1];
		
		permutation(0);
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
	public static void permutation(int time) {
		if(time == n) {
			for(int j=0;j<n;j++) {
				sb.append(num[j]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=1;i<=n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				num[time] = i;
				permutation(time+1);
				visited[i] = false;
			}
		}				
	}
}