import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map, res;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		res = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<=N;i++) {
			visited = new boolean[N+1];
			dfs(i,i);
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				sb.append(res[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
	
	static void dfs(int now, int start) {
//		if(start == now) {
//			if(visited[start]) {
//				res[start][start] = 1;
//				return;
//			}
//			else
//				visited[start] = true;
//		}
		
		for(int i=1;i<=N;i++) {
			if(map[now][i]==1 && !visited[i]) {
				visited[i] = true;
				res[start][i] = 1;
				dfs(i,start);
			}
		}
	}

}
