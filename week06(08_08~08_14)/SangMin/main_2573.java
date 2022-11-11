import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();

	static int n,m;
	
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	static int[][] map, buf;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		while(!isVaild()) {
			time++;

			buf = new int[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]>0) {
						iceMelt(i,j);
					}
				}
			}
			map = buf.clone();
			
			int cnt = 0;
			visited = new boolean[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]>0 && !visited[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}

			if(cnt>=2) {
				time = -time;
				break;
			}
		}
		
		System.out.println(time<0 ? -time : 0);
	}
	
	public static void iceMelt(int y, int x) {
		
		buf[y][x] = map[y][x];
		
		for(int i=0;i<4;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny<0||nx<0||ny>=n||nx>=m) continue;
			
			if(map[ny][nx]<=0) {
				buf[y][x]--;
			}
		}
		if(buf[y][x]<0) buf[y][x] = 0;
	}
	
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		
		for(int i=0;i<4;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny<0||nx<0||ny>=n||nx>=m) continue;
			
			if(map[ny][nx]>0 && !visited[ny][nx]) {
				dfs(ny,nx);
			}
		}
	}
	
	public static boolean isVaild() {		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]>0) {
					return false;
				}
			}
		}
		return true;
	}
}
