import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int H,W;
	static int[][] map;
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	 
	    st = new StringTokenizer(br.readLine());
	    H = Integer.parseInt(st.nextToken());
	    W = Integer.parseInt(st.nextToken());
	    
	    map = new int[H+1][W+1];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int j=1;j<=W;j++) {
	    	int h = Integer.parseInt(st.nextToken());
	    	for(int i=H;i>=H-h+1;i--) {
	    		map[i][j] = 1;
	    	}
	    }

	    int sum = 0;
	    for(int i=H;i>=1;i--) {
	    	int r = rain(i);
	    	sum += r;
	    }
	    
//	    for(int i=1;i<=H;i++) {
//	    	for(int j=1;j<=W;j++) {
//	    		System.out.print(map[i][j]+" ");
//	    	}
//	    	System.out.println();
//	    }
	    
	    System.out.println(sum);
	}
	
	public static int rain(int h) {		
		int leftWall = (map[h][1]==1)?1:-1;
		
		int sum = 0;
		
		for(int j=2;j<=W;j++) {
			if(map[h][j]==1) {
				if(leftWall>0 && leftWall+1<j)
					sum += j - (leftWall + 1);
				leftWall = j;
			}
		}
		return sum;
	}
}