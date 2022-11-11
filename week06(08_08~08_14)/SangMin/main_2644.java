import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m, a, b, res;
	static boolean[][] map;
	static boolean[] visited;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		res = -1;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());		
			
			map[x][y] = true;
			map[y][x] = true;
		}
		
		visited[a] = true;
		dfs(a,0);
		
		System.out.println(res);
	}
	
	public static void dfs(int start, int cnt) {
		if(start==b) {
			res = cnt;
			return;
		}
		
		for(int i=1;i<=n;i++) {
			if(!visited[i] && map[start][i]) {
				visited[i] = true;
				dfs(i,cnt+1);
				visited[i] = false;
			}
		}
	}
}