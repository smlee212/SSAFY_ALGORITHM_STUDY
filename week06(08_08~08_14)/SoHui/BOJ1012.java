import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[][] map;
	static Queue<Pair> q=new LinkedList<>();
	static int cnt;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer str=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(str.nextToken());
			int m=Integer.parseInt(str.nextToken());
			int k=Integer.parseInt(str.nextToken());
			
			map=new int[n][m];
			
			for(int i=0;i<k;i++) {
				str=new StringTokenizer(br.readLine());
				
				int r= Integer.parseInt(str.nextToken());
				int c=Integer.parseInt(str.nextToken());
				
				map[r][c]=1;
			}
			
			for(int i=0;i<n;i++) {
				for (int j = 0; j < m;j++) {
					if(map[i][j]==1) {
						map[i][j]=0;
						q.offer(new Pair(i,j));
						bfs(n,m);
					}
				}
			}
			sb.append(cnt+"\n");
			cnt=0;
		}
		
		System.out.println(sb);
	}
	
	private static void bfs(int n,int m) {
		// TODO Auto-generated method stub
		while(!q.isEmpty()) {
			Pair tmp=q.poll();
			for(int i=0;i<4;i++) {
				int rr=tmp.r+dr[i];
				int cc=tmp.c+dc[i];
				
				if(rr<0||rr>=n||cc<0||cc>=m||map[rr][cc]==0) continue;
				if(map[rr][cc]==1) {
					map[rr][cc]=0;
					q.offer(new Pair(rr,cc));
				}
			}
		}
		cnt++;
	}

	static public class Pair{
		int r,c;
		Pair(int r,int c){
			this.r=r;
			this.c=c;
		}
	}
}
