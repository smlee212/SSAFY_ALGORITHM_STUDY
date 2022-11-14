import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(str.nextToken());
		int m=Integer.parseInt(str.nextToken());
		int [][] chk=new int[n][m]; //방문했는지 체크할 배열 + 최단거리 표시
		int [][] map=new int[n][m];
		for(int i=0;i<n;i++) {
			String line=br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j]=line.charAt(j)-'0';
				chk[i][j]=-1; //초기화
			}
		}
		
		Queue<Pair> q= new LinkedList<>();
		q.offer(new Pair(0,0)); //초기값 집어넣기
		int []dr= {-1,0,1,0};
		int []dc= {0,1,0,-1}; //델타 탐색
		
		chk[0][0]=1;
		while(!q.isEmpty()) {
			int d_r=q.peek().r;
			int d_c=q.peek().c;
			q.remove();
			for (int i = 0; i < 4; i++) {
				int n_r=d_r+dr[i];
				int n_c=d_c+dc[i]; //탐색
				
				//범위를 벗어나거나 이동할 수 없는 칸인 경우 pass
				if(n_r<0 || n_r>=n||n_c<0||n_c>=m||map[n_r][n_c]==0||chk[n_r][n_c]!=-1) continue;
				
                q.offer(new Pair(n_r,n_c));
				chk[n_r][n_c]=chk[d_r][d_c]+1;
			}
		}
		System.out.println(chk[n-1][m-1]);

	}
	
	public static class Pair{
		int r,c;
		Pair(int r, int c){
			this.r=r;
			this.c=c;
		}
	}

}