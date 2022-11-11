import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int n,m;
	static int r,c,d;
	static int cnt = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(r,c);
		
		System.out.println(cnt);
		
		br.close();
	}
	
	public static void func(int y, int x) {
		if(!visited[y][x]) {
			cnt++;
			visited[y][x] = true;
		}
		
		boolean check = false;
		for(int t=1;t<=4;t++) {
			int ny = y + dy[(d+3*t)%4];
			int nx = x + dx[(d+3*t)%4];
			
			if(ny<0||nx<0||ny>=n||nx>=m) continue;
			
			if(map[ny][nx]==0 && !visited[ny][nx]) {
				d = (d+3*t)%4;
				func(ny,nx);
				check = true;
				break;
			}
		}
		
		if(!check) {
			int ny = y + dy[(d+2)%4];
			int nx = x + dx[(d+2)%4];			

			if(ny<0||nx<0||ny>=n||nx>=m) return;
			
			if(map[ny][nx]==0) {
				func(ny,nx);
			}			
		}
	}
}
