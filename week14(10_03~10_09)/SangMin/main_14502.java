import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	// 입력 변수
	static int n, m; 	
	static int[][] map;

	// 벽이 세워질 빈 공간의 인덱스 배열 (저장되는 값은 blank의 인덱스)
	static int[] selectWall = new int[3];
	// 바이러스가 퍼진 연구소 배열
	static int[][] temp;
	// 빈 공간, 바이러스의 위치 배열
	static ArrayList<Pair> blank, virus;
	
	// 안전 영역 크기의 최대값
	static int maxCnt = 0;
	// 4방 탐색 방향 벡터
	static int[] dy = {0,1,0,-1},
				 dx = {1,0,-1,0};
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    // 입력 및 초기화 처리
	    st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    map = new int[n][m];
	    temp = new int[n][m];
	    blank = new ArrayList<>();
	    virus = new ArrayList<>();
	    
	    for(int i=0;i<n;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j=0;j<m;j++) {
	    		map[i][j] = Integer.parseInt(st.nextToken());
	    		
	    		// 0이면 빈 공간 배열에 좌표 추가
	    		if(map[i][j]==0) {
	    			blank.add(new Pair(i,j));
	    		}
	    		// 2이면 바이러스 배열에 좌표 추가
	    		else if(map[i][j]==2) {
	    			virus.add(new Pair(i,j));
	    		}
	    	}
	    }
	    
	    // 알고리즘 동작
	    combi(0,0);
	    
	    // 출력 처리
	    System.out.println(maxCnt);
	}
	
	// 벽이 세워질 빈 공간을 선택하는 함수
	public static void combi(int now, int cnt) {
		// 벽을 모두 선택했다면
		if(cnt==3) {
			// (바이러스가 퍼질 연구소 배열을 생성)
			copyArray();	
			// 1. 벽을 세우고
			buildWall();
			// 2. 바이러스가 퍼지고
			spreadVirus();
			// 3. 안전 영역 크기를 구한다
			countSaveZone();
			return;
		}
		
		// 조합 알고리즘 사용
		for(int i=now;i<blank.size();i++) {
			selectWall[cnt] = i;
			combi(i+1,cnt+1);
		}
	}
	
	// 바이러스가 퍼질 연구소 배열을 생성하는 함수
	public static void copyArray() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				temp[i][j] = map[i][j];
			}
		}
	}
	
	// 연구소 배열에서 선택한 공간에 벽을 짓는 함수
	public static void buildWall() {
		for(int i=0;i<3;i++) {
			int index = selectWall[i];
			Pair p = blank.get(index);
			temp[p.y][p.x] = 1;
		}
	}
	
	// 바이러스가 퍼지는 함수
	public static void spreadVirus() {			
		for(int i=0;i<virus.size();i++)
			bfs(i);		
	}
	
	// 너비 탐색 알고리즘
	public static void bfs(int index) {
		Pair p = virus.get(index);
		int y = p.y;
		int x = p.x;
		Deque<Pair> dq = new ArrayDeque<>();
		dq.add(new Pair(y,x));		
				
		while(!dq.isEmpty()) {
			y = dq.peek().y;
			x = dq.peek().x;
			dq.poll();		
			
			for(int i=0;i<4;i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny<0||nx<0||ny>=n||nx>=m)continue;
				
				if(temp[ny][nx]==0) {
					temp[ny][nx] = 2;
					dq.add(new Pair(ny,nx));
				}
			}
		}		
	}
	
	// 안전 영역 크기를 구하는 함수
	public static void countSaveZone() {
		int cnt = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(temp[i][j]==0) cnt++;
			}
		}
		
		// 안전 영역 크기의 최대값 갱신
		maxCnt = cnt>maxCnt ? cnt : maxCnt;
	}
}

// 좌표 클래스
class Pair{
	int y;
	int x;
	Pair(int y, int x){
		this.y=y;
		this.x=x;
	}
}