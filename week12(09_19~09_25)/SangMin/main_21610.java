import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static ArrayList<Cloud> clouds = new ArrayList<>();
	static int[] dy = {0,0,-1,-1,-1,0,1,1,1}, // 8방향
				 dx = {0,-1,-1,0,1,1,1,0,-1};
	static int[] dy2 = {-1,-1,1,1}, // 대각선 방향
				 dx2 = {-1,1,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clouds.add(new Cloud(N-1,1));
		clouds.add(new Cloud(N-1,2));
		clouds.add(new Cloud(N,1));
		clouds.add(new Cloud(N,2));
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			move(d,s);
			rain();
			copyWater();
			createCloud();
		}
		
		System.out.println(countWater());
	}

	static void move(int d, int s) {
		
		for(Cloud c : clouds) {
			int y = c.y;
			int x = c.x;
			
			int ny = (y + dy[d] * s) % N;
			
			int nx = (x + dx[d] * s) % N;
			
			while(ny<=0) {
				ny += N;
			}
			while(nx<=0) {
				nx += N;
			}
			
			c.y = ny;
			c.x = nx;
		}
	}
	
	static void rain() {
		
		for(Cloud c : clouds) {
			map[c.y][c.x]++;
		}
	}
	
	static void copyWater() {
		
		for(Cloud c : clouds) {
			int y = c.y;
			int x = c.x;			
			int cnt = 0;
			
			for(int i=0;i<4;i++) {
				int ny = y + dy2[i];
				int nx = x + dx2[i];
				
				if(ny<1||nx<1||ny>N||nx>N) continue;
				
				if(map[ny][nx]>0) {
					cnt++;
				}
			}
			
			map[y][x] += cnt;
		}
	}
	
	static void createCloud() {
		boolean[][] visited = new boolean[N+1][N+1];
		for(Cloud c: clouds) {
			visited[c.y][c.x] = true; 
		}
		
		clouds = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(map[i][j]>=2 && !visited[i][j]) {
					clouds.add(new Cloud(i, j));
					map[i][j] -= 2;
				}
			}
		}
	}
	
	static int countWater() {
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				cnt += map[i][j];
			}
		}
		return cnt;
	}
	
}

class Cloud{
	int y;
	int x;
	Cloud(int y,int x){
		this.y=y;
		this.x=x;
	}
}
