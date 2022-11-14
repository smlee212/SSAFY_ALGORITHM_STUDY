import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,k;
	static List<Fireball>[][] fireballs;
	
	static int[] dr= {-1,-1,0,1,1,1,0,-1};
	static int[] dc= {0,1,1,1,0,-1,-1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(str.nextToken());
		m=Integer.parseInt(str.nextToken());
		k=Integer.parseInt(str.nextToken());
		
		fireballs= new List[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				fireballs[i][j]=new ArrayList<Fireball>();
			}
		}
		
		
		for(int i=0;i<m;i++) {
			str=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(str.nextToken());
			int c=Integer.parseInt(str.nextToken());
			int m=Integer.parseInt(str.nextToken());
			int s=Integer.parseInt(str.nextToken());
			int d=Integer.parseInt(str.nextToken());
			
			fireballs[r-1][c-1].add(new Fireball(r-1, c-1, m, s, d));
		}
		
		for(int command=0;command<k;command++) {
			//명령 횟수 만큼 반복
			
			//이동
			ballsMove();
			
			//정산
			calcBalls();
		}
		
		int res=calcTot();
		
		System.out.println(res);
	}
	
	private static int calcTot() {
		int sum=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int size=fireballs[i][j].size();
				if(size==0) continue;
				for(int k=0;k<size;k++)
					sum+=fireballs[i][j].get(k).m;
			}
		}
		return sum;
	}

	private static void calcBalls() {
		//2개 이상인 곳 정리
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(fireballs[i][j].size()>1) {
					//1개 이상인 경우 합쳐야함
					//현재 칸의 파이어볼의 갯수
					boolean even =true; //짝수면 true, 홀수면 false
					boolean flag=true; //다르면 false
					
					if(fireballs[i][j].get(0).d%2==0) even=true;
					else even =false;
					
					int size=fireballs[i][j].size();
					int sumM=0,sumS=0; //질량의 합, 속력의 합
					for(int k=0;k<size;k++) {
						sumM+=fireballs[i][j].get(k).m;
						sumS+=fireballs[i][j].get(k).s;						
					}
					
					int totM=sumM/5, totS=sumS/size; //질량, 속력
					if(totM==0) {
						fireballs[i][j].clear(); //질량이 0일 경우 소멸되어 없어짐
						continue;
					}
					
					//0이 아닐 경우
					//모두 홀수 || 짝수 => 0,2,4,6
					//아니면 1,3,5,7
					for(int k=1;k<size;k++) {
						if((even && fireballs[i][j].get(k).d%2!=0) ||(!even && fireballs[i][j].get(k).d%2==0)) {
							flag=false;
							break;
						}
					}
					//비우고 새로 담아줌
					fireballs[i][j].clear();
					
					if(flag) {
						fireballs[i][j].add(new Fireball(i, j, totM, totS, 0));
						fireballs[i][j].add(new Fireball(i, j, totM, totS, 2));
						fireballs[i][j].add(new Fireball(i, j, totM, totS, 4));
						fireballs[i][j].add(new Fireball(i, j, totM, totS, 6));
					}else {
						fireballs[i][j].add(new Fireball(i, j, totM, totS, 1));
						fireballs[i][j].add(new Fireball(i, j, totM, totS, 3));
						fireballs[i][j].add(new Fireball(i, j, totM, totS, 5));
						fireballs[i][j].add(new Fireball(i, j, totM, totS, 7));
					}
				}
			}
		}
		
	}

	private static void ballsMove() {
		// 파이어볼 이동
		Queue<Fireball> q=new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(fireballs[i][j].size()>0) {
					int size=fireballs[i][j].size();
					
					for(int k=0;k<size;k++) {
						q.offer(fireballs[i][j].get(k));
					}
					
					fireballs[i][j].clear();
					//큐에 넣고 이동을 위해 지워버리기
				}
			}
		}
		
		while(!q.isEmpty()) {
			Fireball tmp=q.poll();
			
			int r=tmp.r;
			int c=tmp.c;
			int d=tmp.d;
			int s=tmp.s;
			
			//자신의 방향으로 속력만큼 이동
			r+=dr[d]*s;
			c+=dc[d]*s;
			
			while(r<0 ||r>=n) {
				r = r<0? r+n:r-n;
			}
			
			while(c<0 ||c>=n) {
				c = c<0? c+n:c-n;
			}
			
			fireballs[r][c].add(new Fireball(r, c, tmp.m, s, d));
		}
		
	}

	static class Fireball{
		int r,c,m,s,d; //위치, 질량 ,속력, 방향

		public Fireball(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

}
