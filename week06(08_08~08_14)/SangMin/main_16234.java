import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static int N, L, R, count;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dy = {0,1,0,-1};
	public static int[] dx = {1,0,-1,0};
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    L = Integer.parseInt(st.nextToken());
	    R = Integer.parseInt(st.nextToken());
	    
	    map = new int[N][N];
	    
	    for(int i=0;i<N;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j=0;j<N;j++) {
	    		map[i][j] = Integer.parseInt(st.nextToken());	    		
	    	}
	    }
	    
	    int days = 0;
	    while(true) {
	    	count = 0;
		    visited = new boolean[N][N];
		    
	    	for(int i=0;i<N;i++) {
	    		for(int j=0;j<N;j++) {
	    			if(!visited[i][j]) {
	    				bfs(i,j);
	    			}
	    		}
	    	}
	    	
	    	if(count==0) break;
	    	else days++;
	    }
	    
	    System.out.println(days);
	}
	
	public static void bfs(int y, int x) {
		Deque<Pair> dq = new ArrayDeque<>();
		dq.add(new Pair(y,x));
		
		visited[y][x] = true;
		
		int sum = map[y][x];
		int cnt = 1;
		
		while(!dq.isEmpty()) {
			y = dq.peek().y;
			x = dq.peek().x;
			dq.poll();
			int mapVal = map[y][x];
			map[y][x] = -1;

			for(int i=0;i<4;i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny<0||nx<0||ny>=N||nx>=N) continue;
				
				int diff = Math.abs(mapVal - map[ny][nx]);
				
				if(!visited[ny][nx] && diff >= L && diff <= R) {
					visited[ny][nx] = true;
					sum += map[ny][nx];
					cnt++;
					dq.add(new Pair(ny,nx));
				}
			}
		}
		
		if(cnt>1) {
			count++;
		}
		else {
			map[y][x] = sum;
			return;
		}
		
		int val = sum / cnt;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]<0) {
					map[i][j] = val;
				}
			}
		}
	}
}

class Pair{
	int y;
	int x;
	Pair(int y, int x){
		this.y=y;
		this.x=x;		
	}
}