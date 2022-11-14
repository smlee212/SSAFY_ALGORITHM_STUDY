import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] map;
	static int[][] virus; //바이러스가 퍼진 후의 맵
	static int res= Integer.MIN_VALUE;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str= new StringTokenizer(br.readLine());
		n=Integer.parseInt(str.nextToken());
		m=Integer.parseInt(str.nextToken());
		map=new int[n][m];
		
		for(int i=0;i<n;i++) {
			str=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(str.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					setWall(1); //벽 세우기
					map[i][j]=0;
				}
			}
		}
		
		System.out.println(res);
	}
	private static void setWall(int cnt) {
		if(cnt==3) {
			//벽을 추가로 3개 다 세움
			//바이러스 퍼트리기
			virus=new int[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					virus[i][j]=map[i][j];	
				}
			}
			spreadV();
			return;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					setWall(cnt+1);
					map[i][j]=0;
				}
			}
		}
	}
	private static void safeArea() {
		// 안전 영역 크기 세기
		int cnt=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(virus[i][j]==0)
					cnt++;
			}
		}
		res=Math.max(res, cnt);
	}
	private static void spreadV() {
		// 바이러스 퍼트리기
		Queue<Pair> q=new LinkedList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(virus[i][j]==2)
					q.offer(new Pair(i,j));
			}
		}
		
		while(!q.isEmpty()) {
			Pair tmp=q.poll();
			for(int i=0;i<4;i++) {
				int rr=tmp.r+dr[i];
				int cc=tmp.c+dc[i];
				
				if(rr<0||rr>=n||cc<0||cc>=m||virus[rr][cc]!=0) continue;
				
				q.offer(new Pair(rr,cc));
				virus[rr][cc]=2;
			}
		}
		//안전 영역 크기 세기
		safeArea();
	} 
	
	static class Pair{
		int r,c;
		
		Pair(int r, int c){
			this.r=r;
			this.c=c;
		}
	}
	
	
	private static void print(int[][] map2) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map2[i][j]);
			}
			System.out.println();
		}
		
	}
}
