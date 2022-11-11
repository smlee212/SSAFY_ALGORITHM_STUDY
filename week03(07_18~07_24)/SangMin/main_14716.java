import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static int[] dy = {0,1,0,-1,-1,1,1,-1};
	public static int[] dx = {1,0,-1,0,1,1,-1,-1};
	public static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==1) {
					bfs(i,j);
					cnt++;
				}
			}
		}		
		System.out.println(cnt);
	}
	
	public static void bfs(int y, int x) {
		map[y][x] = 0;
		
		for(int t=0;t<8;t++) {
			int ny = y + dy[t];
			int nx = x + dx[t];
			
			if(ny<0||nx<0||ny>=n||nx>=m) continue;
			
			if(map[ny][nx]==1) {
				bfs(ny,nx);
			}
		}
	}
}
