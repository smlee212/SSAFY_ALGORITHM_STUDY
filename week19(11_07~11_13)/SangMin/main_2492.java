import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	static int N,M,T,K;
	static Point[] points;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		points = new Point[T];
		
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());	
			
			points[i] = new Point(y,x);
		}
		
		int resCnt=0, resY=0,resX=0;
		
		for(int a=0;a<T;a++) {
			for(int b=0;b<T;b++) {
				int ax, by;
				
				int X = points[a].x;
				int Y = points[b].y;
				
				if(X+K>N)
					ax = N-K;
				else
					ax = X;
				
				if(Y+K>M)
					by = M-K;
				else
					by = Y;
				
				int cnt = calcCnt(ax,by);
				
				if(resCnt < cnt) {
					resCnt = cnt;
					resX = ax;
					resY = by + K;
				}
			}
		}
		
		System.out.println(resX+" "+resY);
		System.out.println(resCnt);
    }
	
	static int calcCnt(int ax, int by) {
		int cnt = 0;
		
		for(int i=0;i<T;i++) {
			Point now = points[i];
			
			if(ax<=now.x && ax+K>=now.x && by<=now.y && by+K>=now.y) {
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
