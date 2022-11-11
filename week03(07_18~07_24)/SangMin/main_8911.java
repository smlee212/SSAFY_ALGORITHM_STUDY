import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
				
		for(int t=0;t<n;t++) {
			char[] str = br.readLine().toCharArray();
			int lx = 0, rx = 0;
			int ly = 0, ry = 0;
			int[] dy = {1,0,-1,0};
			int[] dx = {0,-1,0,1};
			int d = 0;
			int x = 0, y = 0;
			
			for(char c : str) {
				switch(c) {
				case 'F':
					x += dx[d];
					y += dy[d];
					break;
				case 'B':
					x -= dx[d];
					y -= dy[d];
					break;
				case 'L':
					d = (d+5)%4;
					break;
				case 'R':
					d = (d+3)%4;
					break;
				}
				lx = Math.min(lx, x);
				rx = Math.max(rx, x);
				ly = Math.min(ly, y);
				ry = Math.max(ry, y);
			}
			System.out.println(Math.abs(lx-rx)*Math.abs(ly-ry));
		}
	}
}