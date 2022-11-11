import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int K, N, M;
	static int[][] map;
	
	static int[] dy1 = {-1,0,1,0};
	static int[] dx1 = {0,1,0,-1};
	static int[] dy2 = {-2,-2,-1,-1,1,1,2,2};
	static int[] dx2 = {-1,1,-2,2,-2,2,-1,1};
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    K = Integer.parseInt(br.readLine());
	    
	    st = new StringTokenizer(br.readLine());
	    M = Integer.parseInt(st.nextToken());
	    N = Integer.parseInt(st.nextToken());
	    
	    map = new int[N][M];
	    for(int i=0;i<N;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j=0;j<M;j++) {
	    		map[i][j] = Integer.parseInt(st.nextToken());
	    	}
	    }
	    
	    
	    bfs(0,0,0);
	}	
	
	static void bfs(int y, int x, int cnt) {
		Deque<Node> dq = new ArrayDeque<>();
		boolean[][][] visited = new boolean[N][M][K+1];
		
		dq.add(new Node(y,x,cnt));
		visited[y][x][cnt] = true;
		
		int time = 0;
		
		while(!dq.isEmpty()) {
			int size = dq.size();		
			
//			for(int k=0;k<=K;k++) {
//				System.out.println("K = "+k);
//				for(int i=0;i<N;i++) {					
//					for(int j=0;j<M;j++) {
//						System.out.print(visited[i][j][k]?"X ":"O ");
//					}
//					System.out.println();
//				}
//				System.out.println();
//			}
			
			for(int s=0;s<size;s++) {
				y = dq.peek().y;
				x = dq.peek().x;
				cnt = dq.peek().cnt;
				dq.poll();
				
				if(y==N-1&&x==M-1) {
					System.out.println(time);
					return;
				}
				
				for(int i=0;i<4;i++) {
					int ny = y + dy1[i];
					int nx = x + dx1[i];
					
					if(ny<0||nx<0||ny>=N||nx>=M||visited[ny][nx][cnt]) continue;
					
					if(map[ny][nx]==0) {
						visited[ny][nx][cnt] = true;
						dq.add(new Node(ny,nx,cnt));
					}
				}
				
				if(cnt==K) continue;
				
				for(int i=0;i<8;i++) {
					int ny = y + dy2[i];
					int nx = x + dx2[i];
					
					if(ny<0||nx<0||ny>=N||nx>=M||visited[ny][nx][cnt+1]) continue;
					
					if(map[ny][nx]==0) {
						visited[ny][nx][cnt+1] = true;
						dq.add(new Node(ny,nx,cnt+1));
					}
				}
			}
			
			time++;
		}
		System.out.println("-1");
	}
}

class Node{
	int y;
	int x;
	int cnt;
	public Node(int y, int x, int cnt) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}