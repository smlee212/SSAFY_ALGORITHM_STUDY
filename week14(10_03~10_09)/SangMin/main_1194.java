import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	// 입력 변수
	static int N, M;
	static char[][] map;

	// 문의 위치 좌표
	static ArrayList<Point>[] doors;
	// 방향 벡터
	static int[] dy = {-1,0,1,0},
				 dx = {0,1,0,-1};
	// 탈출 확인 변수
	static int minCnt = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;		
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];		
		doors = new ArrayList[6];
		
		for(int i=0;i<6;i++) {
			doors[i] = new ArrayList<>();
		}
		
		int y=0,x=0;
		
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				if(map[i][j]>='A' && map[i][j]<='F') {
					doors[map[i][j]-'A'].add(new Point(i,j));
				}
				else if(map[i][j]=='0') {
					y = i; x = j;
					map[i][j] = '.';
				}
			}
		}
		
		bfs(new Point(y,x,0));
		if(minCnt==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(minCnt);
		}
	}
	
	static void bfs(Point p) {		
		Deque<Point> dq = new ArrayDeque<>();
		boolean[][][] visited = new boolean[N][M][64+1];
		
		int y = p.y;
		int x = p.x;
		int key = p.key;
		int cnt = 1;
		
		visited[y][x][0] = true;
		dq.add(p);
		
		while(!dq.isEmpty()) {	
			
			int size = dq.size();
			
			for(int s=0;s<size;s++) {				
				Point now = dq.poll();
				y = now.y;
				x = now.x;
				key = now.key;
//				System.out.println(now);
				
				for(int i=0;i<4;i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					
					if(ny<0||nx<0||ny>=N||nx>=M||visited[ny][nx][key]||map[ny][nx]=='#') continue;
					
					char val = map[ny][nx];
					if(val=='1') { // 탈출구
						minCnt = Math.min(cnt,minCnt);
						return;
					}
					else if(val>='a' && val<='f') { // 열쇠
                        int next_key = findKey(key,val);
                        visited[ny][nx][next_key] = true;
                        dq.add(new Point(ny,nx,next_key));
					}
					else { // 빈 공간 또는 벽
						if(val=='.' || openDoor(val, key)) { // 지나갈 수 있거나, 열쇠로 문을 열 수 있다면 그대로 진행 
							visited[ny][nx][key] = true;
							dq.add(new Point(ny,nx,key));
						}
					}
					
				}	
				
			}			
			
			cnt++;
		}
	}
	
	// 가지고 있는 열쇠가 문을 열 수 있는지 확인하는 함수
	static boolean openDoor(char val, int key) {
		return (key & (1 << (int)(val-'A'))) != 0;
	}
	
	// 이미 열쇠를 가지고 있는지 확인하는 함수 (가지고 있다면 true)
	static boolean haveKey(int key, char val) {
		return (key & (1 << (int)(val-'a'))) != 0;
	}
	
	// 열쇠를 저장하는 함수
	static int findKey(int key, char val) {
		key |= 1 << (int)(val-'a');
		return key;
	}
	
	static class Point{
		int y;
		int x;
		int key;
		public Point(int y, int x) {
			this(y,x,0);
		}		
		public Point(int y, int x, int key) {
			this.y = y;
			this.x = x;
			this.key = key;
		}
		@Override
		public String toString() {
			return "Point [(" + y + "," + x + "), key=" +  Integer.toBinaryString(key) + "]";
		}		
	}
}


