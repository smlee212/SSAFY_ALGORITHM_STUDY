import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n,m,k;
	static int[][] map;
	static int a_cnt;
	static Queue<Pair> q= new LinkedList<>();
	static Queue<Integer> num=new LinkedList<>();
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		k=sc.nextInt();
		
		map=new int[n][m];
		
		for (int i = 0; i < k; i++) {
			int c1=sc.nextInt();
			int r1=sc.nextInt();
			int c2=sc.nextInt();
			int r2=sc.nextInt();
			
			for(int r=r1;r<r2;r++) {
				for(int c=c1;c<c2;c++) {
					//사각형 표시
					map[r][c]++;
				}
			}
		}
				
		for (int i = 0; i <n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]==0) {
					q.offer(new Pair(i,j));
					map[i][j]=1;
					bfs();
				}
			}
		}
		
		int[] res=new int[num.size()];
		for (int i = 0; i < res.length; i++) {
			res[i]=num.poll();
		}
		Arrays.sort(res);
		
		System.out.println(a_cnt);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+" ");
		}
	}
	
	
	private static void bfs() {
		// TODO Auto-generated method stub
		int cnt=1;
		while(!q.isEmpty()) {
			Pair tmp=q.poll();
			for(int i=0;i<4;i++) {
				int rr= tmp.r+dr[i];
				int cc=tmp.c+dc[i];
				
				if(rr<0||rr>=n||cc<0||cc>=m||map[rr][cc]!=0) continue;
				else {
					if(map[rr][cc]==0) {
						q.offer(new Pair(rr,cc));
						cnt++;
						map[rr][cc]=1;
					}
				}
			}
		}
		num.offer(cnt);
		a_cnt++;
	}


	static public class Pair{
		int r,c;
		Pair(int r,int c){
			this.r=r;
			this.c=c;
		}
	}

}
