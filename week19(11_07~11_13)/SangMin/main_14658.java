import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	static int N, M, L, K;
	static Point[] points;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		points = new Point[K];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			points[i] = new Point(y,x);
		}
		
		
		int cnt = 0, res = 0;
		
		for(int i=0;i<K;i++) {
			for(int j=0;j<K;j++) {
				Point A = points[i];
				Point B = points[j];
				
				int x, y;
				
				if(A.x + L > N) x = N-L;
				else x = A.x;
				
				if(B.y + L > M) y = M-L;
				else y = B.y;
				
				cnt = calcStar(y,x);
				res = Math.max(cnt, res);
			}
		}
		
		System.out.println(K - res);
	}
	
	static int calcStar(int y, int x) {
		int cnt = 0;
		
		for(Point now : points) {
			if(now.y >= y && now.y <= y+L && now.x >= x && now.x <= x+L) {
				cnt++;
			}
		}
		
		return cnt;
	}

	static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
