import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][] RGB,RB; //적록색약이 아닌 사람, 적록색약인 사람
	static int n;
	static Queue<Pair> q1=new LinkedList<>();
	static Queue<Pair> q2=new LinkedList<>();
	static int cnt1,cnt2; //적록색약x , 적록색약 o
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	static int r;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		n= Integer.parseInt(br.readLine());
		RGB=new char[n][n];
		RB=new char[n][n];
		
		for(int i=0;i<n;i++) {
			RGB[i]=br.readLine().toCharArray();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(RGB[i][j]=='G') {
					RB[i][j]='R';
				}
				else{
					RB[i][j]=RGB[i][j];
				}
			}
		}
		
		//print(RB);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(RGB[i][j]=='R') {
					q1.offer(new Pair(i,j));									
					RGB[i][j]='0';					
					bfs1('R');					
				}
				if(RB[i][j]=='R') {
					q2.offer(new Pair(i,j));
					RB[i][j]='0';
					bfs2('R');
				}
				
				if(RGB[i][j]=='G') {
					q1.offer(new Pair(i,j));
					RGB[i][j]='0';
					bfs1('G');
				}
				
				if(RGB[i][j]=='B') {					
					q1.offer(new Pair(i,j));					
					RGB[i][j]='0';
					bfs1('B');					
				}
				
				if(RB[i][j]=='B') {
					q2.offer(new Pair(i,j));
					RB[i][j]='0';
					bfs2('B');
					
				}
			}
		}
		
//		print(map1);
//		System.out.println(r);
		System.out.println(cnt1 + " "+ cnt2);
		
	}

	private static void print(char[][] map12) {
		// TODO Auto-generated method stub
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(map12[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void bfs1(char c) { //적록색약이 아닌 사람
		// TODO Auto-generated method stub
		while(!q1.isEmpty()) {
			Pair tmp=q1.poll();
			//System.out.println(tmp.r+" "+tmp.c);
			for(int i=0;i<4;i++) {
				int rr=tmp.r+dr[i];
				int cc=tmp.c+dc[i];
				if(rr<0||rr>=n||cc<0||cc>=n||RGB[rr][cc]!=c) continue;
				if(RGB[rr][cc]==c) {
					RGB[rr][cc]='0';
					q1.offer(new Pair(rr,cc));
				}
			}
			
		}
		//if(c=='G') r++;
		cnt1++;
	}
	
	private static void bfs2(char c) { //적록색약인 사람
		// TODO Auto-generated method stub
		while(!q2.isEmpty()) {
			Pair tmp=q2.poll();
			for(int i=0;i<4;i++) {
				int rr=tmp.r+dr[i];
				int cc=tmp.c+dc[i];
				if(rr<0||rr>=n||cc<0||cc>=n||RB[rr][cc]!=c) continue;
				if(RB[rr][cc]==c) {
					RB[rr][cc]='0';
					q2.offer(new Pair(rr,cc));
				}
			}
		}
		cnt2++;
	}

	static public class Pair{
		int r,c;
		Pair(int r, int c){
			this.r=r;
			this.c=c;
		}
	}

}
