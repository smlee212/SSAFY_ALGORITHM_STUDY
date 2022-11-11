import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int h, w;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static char[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			visited = new boolean[h][w];
			
			for(int i=0;i<h;i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			int cnt = 0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(!visited[i][j] && map[i][j]=='#') {
						bfs(i,j);
						cnt++;
					}
				}
			}
            
			System.out.println(cnt);
		}
	}
	
	public static void bfs(int y, int x) {
		visited[y][x] = true;
		
		for(int k=0;k<4;k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			
			if(ny<0||nx<0||ny>=h||nx>=w) continue;
			
			if(!visited[ny][nx] && map[ny][nx]=='#') {
				bfs(ny,nx);
			}
		}
	}
}