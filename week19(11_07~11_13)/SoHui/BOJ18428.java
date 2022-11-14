import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
	static int n;
	static char[][] map;
	static ArrayList<Pos> teachers;
	static boolean flag=false; //학생들이 숨을 수 있는지 여부
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		map=new char[n][n];
		teachers=new ArrayList<>();
		for(int i=0;i<n;i++) {
			String str=br.readLine().replaceAll(" ", "");
			for(int j=0;j<n;j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='T')
					teachers.add(new Pos(i, j)); //선생님의 위치 저장
			}
		}
		
		//print(map);
		
		//장애물 3개를 랜덤하게 세운 후 감시 피하기 확인
		makeWall(0);
		
		if(flag) System.out.println("YES");
		else System.out.println("NO");
		
	}
	

	private static void makeWall(int wallCnt) {
		
		if(wallCnt==3) {
			//장애물을 3개 세웠을 때
			if(!findStudent()) {
			//찾을 수 있으면 flag=true;
			//몾찾으면 false;
				flag=true;
			}
		
			return;
		}
		
		if(flag) return; //숨을 수 있는 경우가 있으면 더 탐색할 필요 없

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]=='X') {
					map[i][j]='O';
					makeWall(wallCnt+1);
					map[i][j]='X';
				}
			}
		}
		
	}

	private static boolean findStudent() {
		
		for(int i=0;i<teachers.size();i++) {
			Pos cur=teachers.get(i);
			int r=cur.r;
			int c=cur.c;
			int d=0;
			while(d<4) {
				//처음 방향으로 탐색하는데 학생을 만나거나 장애물을 만날 때 까지 탐색
				r+=dr[d];
				c+=dc[d];
				
				if(r<0||r>=n||c<0||c>=n||map[r][c]=='O') { 
					//처음위치로 바꾸고 d 정보 업데이트
					r=cur.r;
					c=cur.c;
					d++;
				}
				if(map[r][c]=='S') {

					return true;
				}
			}
		
		}

		return false;
	}


	private static void print(char[][] map2) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	static class Pos{
		int r,c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

}
