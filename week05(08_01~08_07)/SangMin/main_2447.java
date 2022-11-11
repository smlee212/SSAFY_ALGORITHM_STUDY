import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static char[][] map;
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    N = Integer.parseInt(br.readLine());
	    
	    map = new char[N][N];
	    for(int i=0;i<N;i++) {
			Arrays.fill(map[i],' ');
	    }
	    
	    map[0][0] = '*';
	    
	    star(3);
	    
	    for(int i=0;i<N;i++) {
	    	for(int j=0;j<N;j++) {
	    		sb.append(map[i][j]);
	    	}
	    	sb.append('\n');
	    }
	    
	    System.out.println(sb.toString());
	    
	    br.close();
	}
	
	public static void star(int n) {
		
		int a = n/3;
		int a0 = 0, a1 = a, a2 = a*2;
		s(a,a0,a1);
		s(a,a0,a2);
		s(a,a1,a0);
		s(a,a1,a2);
		s(a,a2,a0);
		s(a,a2,a1);
		s(a,a2,a2);
		
		if(n==N) return;
		
		star(3*n);
	}
	
	public static void s(int a, int y, int x) {
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				map[i+y][j+x] = map[i][j];
			}
		}
	}
}