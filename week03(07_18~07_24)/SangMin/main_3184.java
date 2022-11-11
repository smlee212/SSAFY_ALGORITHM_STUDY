import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static int r, c, vCnt, oCnt;
	public static int[] dy = {1,0,-1,0};
	public static int[] dx = {0,1,0,-1};
	public static char[][] map;
	public static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		vCnt = 0; oCnt = 0;
		
		map = new char[r][c];
		visited = new boolean[r][c];
				
		
		for(int i=0;i<r;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int v = 0;
		int o = 0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]!='#' && !visited[i][j]) {
					vCnt = 0; oCnt = 0;
					visited[i][j] = true;
					bfs(i,j);
					if(vCnt >= oCnt) 
						v += vCnt;
					else 
						o += oCnt;					
				}
			}				
		}
		
		System.out.println(o + " " + v);
	}

	public static void bfs(int y, int x) {	
		if(map[y][x]=='v') {
			vCnt++;
		}
		else if(map[y][x]=='o') {
			oCnt++;		
		}
		
		for(int t=0;t<4;t++) {
			int ny = y + dy[t];
			int nx = x + dx[t];
			
			if(ny<0||ny>=r||nx<0||nx>=c) continue;
			
			if(map[ny][nx]=='#') continue;
			
			if(visited[ny][nx]!=true) {
				visited[ny][nx] = true;
				bfs(ny,nx);
			}			
		}		
	}	
}