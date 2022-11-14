import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] sdoku;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sdoku = new int[9][9];

		for (int i = 0; i < 9; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				sdoku[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		playSdoku(0,0);

		
	}

	private static void playSdoku(int r,int c) {
		// TODO Auto-generated method stub
		if(c==9) {
			playSdoku(r+1, 0);
			return;
		}
		
		if(r==9) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(sdoku[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			
			System.exit(0);
		}
		// 숫자넣기
		if(sdoku[r][c]==0) {
			for(int i=1;i<=9;i++) {
				if(chk(r,c,i)) {
					sdoku[r][c]=i;
					playSdoku(r, c+1);
				}
			}
			sdoku[r][c]=0;
			return;
		}
		
		playSdoku(r, c+1);
	}

	private static boolean chk(int r,int c,int value) {
		// 유효성 검사
		// 3*3
		int rr=(r/3)*3;
		int cc=(c/3)*3;
		
		for(int i=rr;i<rr+3;i++) {
			for(int j=cc;j<cc+3;j++) {
				if(sdoku[i][j]==value)
					return false;
			}
		}
	
		
		// 가로
		for(int i=0;i<9;i++) {
			if(sdoku[r][i]==value)
				return false;
		}

		// 세로
		for(int i=0;i<9;i++) {
			if(sdoku[i][c]==value)
				return false;
		}
		
		return true;
	}

	static class Pair {
		int r, c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
