import java.util.Scanner;

public class Main {
	static int n;
	static int[][] map;
	static int[] dr= {0,0,1,1};
	static int[] dc= {0,1,1,0};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		map=new int[n+2][n+2];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		//->: 1 \:2 아래:3
		
		dfs(1,2,1);
		
		System.out.println(ans);

	}
	static int ans;
	private static void dfs(int r, int c, int dir) {
		if(r==n && c==n) {
			ans++;
			return;
		}
		
		if(dir==1) {
			for(int i=1;i<=2;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr>=1 && nr<=n && nc>=2 && nc<=n && chk(r,c,i)) {
					dfs(nr,nc,i);
				}
			}
		}
		else if(dir==2) {
			for (int i = 1; i <= 3; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr>=1&&nr<=n&&nc>=1&&nc<=n&&chk(r,c,i)) {
					dfs(nr,nc,i);
				}
			}
		}
		
		else if(dir==3) {
			for (int i = 2; i <= 3; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr>=1&&nr<=n&&nc>=1&&nc<=n&&chk(r,c,i)) {
					dfs(nr,nc,i);
				}
			}
		}
	}
	private static boolean chk(int r, int c, int i) {
		if(i==1) {
			if(map[r][c+1]==0)
				return true;
		}
		else if(i==2) {
			if(map[r][c+1]==0 && map[r+1][c+1]==0 && map[r+1][c]==0) return true;
		}
		else if(i==3) {
			if(map[r+1][c]==0)
				return true;
		}
		return false;
	}

}
