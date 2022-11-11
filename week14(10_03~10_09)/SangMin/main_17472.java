import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/** 
 *  1. dfs로 섬들의 번호를 지정
 *  2. 섬들마다 4방탐색을 진행하여 섬들과 연결 여부와 가중치를 구함
 *  3. 구한 값으로 새로운 graph 배열을 만들어 MST를 진행
 *  
 */

public class Main {
	static final int INF = 999999;
	
	static int N, M;
	static int[][] map;
	
	static int countIsland = 0;
	static int[][] tempGraph;
	static ArrayList<Edge>[] graph;
	
	static int[] dy = {-1,0,1,0},
				 dx = {0,1,0,-1};

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		tempGraph = new int[6+1][6+1];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken())==1?-1:0;
			}
		}		
		
		// 각각의 섬마다 번호를 부여
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==-1) {
					countIsland++;
					bfs(i,j);
				}
			}
		}
		
		// 연결 그래프 초기화 1
		for(int i=1;i<=countIsland;i++) {
			for(int j=1;j<=countIsland;j++) {
				tempGraph[i][j] = INF;
			}
		}		

		// 연결 그래프 초기화 2
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]>0) {
					bridgeConnection(i,j);
				}
			}
		}
		
		// MST 알고리즘 시작
		graph = new ArrayList[countIsland+1];
		
		for(int i=0;i<=countIsland;i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 인접 행렬 초기화
		for(int i=1;i<=countIsland;i++) {
			for(int j=1;j<=countIsland;j++) {
				if(tempGraph[i][j]!=INF) {
					graph[i].add(new Edge(j,tempGraph[i][j]));
				}
			}
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[countIsland+1];
		
		int start = 1;
		pq.add(new Edge(start, 0));
		
		int sum = 0;
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(visited[now.to]) continue;
			
			visited[now.to] = true;
			sum += now.dist;
			cnt++;
			
			for(Edge next : graph[now.to]) {
				if(!visited[next.to]) {
					pq.add(next);
				}
			}
		}
		
		System.out.println(cnt!=countIsland?-1:sum);
	}
	
	// 섬에서 다른 섬까지 다리를 연결했을 때 거리 값을 구하는 함수
	static void bridgeConnection(int y, int x) {
		int now = map[y][x];
		
		for(int d=0;d<4;d++) {
			int cnt = 0,
				ny = y,
				nx = x;
			
			while(true) {
				ny += dy[d];
				nx += dx[d];
				
				if(ny<0||nx<0||ny>=N||nx>=M||map[ny][nx]==now) break;
				
				// 해당되는 섬이 있다면 가중치 갱신
				if(map[ny][nx]>0) {
					if(cnt>=2)
						tempGraph[now][map[ny][nx]] = Math.min(tempGraph[now][map[ny][nx]], cnt);					
					break;
				}
				
				cnt++;
			}
		}
	}
	
	
	static void bfs(int y, int x) {
		Deque<int[]> dq = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		
		dq.add(new int[]{y,x}); 
		visited[y][x] = true;
		
		while(!dq.isEmpty()) {
			y = dq.peek()[0];
			x = dq.poll()[1];
			
			map[y][x] = countIsland;
			
			for(int i=0;i<4;i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny<0||nx<0||ny>=N||nx>=M) continue;
				
				if(!visited[ny][nx] && map[ny][nx]==-1) {
					visited[ny][nx] = true;
					dq.add(new int[]{ny,nx});
				}
			}
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int to;
		int dist;
		public Edge(int to, int dist) {
			super();
			this.to = to;
			this.dist = dist;
		}
		@Override
		public int compareTo(Edge o) {
			return this.dist-o.dist;
		}
	}
}
