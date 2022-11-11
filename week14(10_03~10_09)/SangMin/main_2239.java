import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static ArrayList<Point> remain;
	
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	   
	    map = new int[9][9];
	    remain = new ArrayList<>();
	    
	    for(int i=0;i<9;i++) {
	    	char[] input = br.readLine().toCharArray();
	    	
	    	for(int j=0;j<9;j++) {
	    		map[i][j] = input[j] - '0';
	    		
	    		if(map[i][j]==0) {
	    			remain.add(new Point(i,j));
	    		}
	    	}
	    }

	    dfs(0);
	}
	
	static void dfs(int cnt) {
		if(cnt == remain.size()) {
			StringBuilder sb = new StringBuilder();
			
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			
			System.out.println(sb);
			
			System.exit(0);
		}
		
		int y = remain.get(cnt).y;
		int x = remain.get(cnt).x;
		
		for(int num=1;num<=9;num++) {
			if(checkRow(y, num) && checkCol(x, num) && checkSquare(y, x, num)) {
				map[y][x] = num;
				dfs(cnt+1);
				map[y][x] = 0;
			}
		}
	}
	
	static boolean checkRow(int y, int num) {
		for(int j=0;j<9;j++) {
			if(map[y][j] == num) return false;
		}
		
		return true;
	}

	static boolean checkCol(int x, int num) {
		for(int i=0;i<9;i++) {
			if(map[i][x] == num) return false;
		}
		
		return true;
	}

	static boolean checkSquare(int y, int x, int num) {
		y = (y/3) * 3;
		x = (x/3) * 3;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(map[i+y][j+x] == num) return false;
			}
		}
		
		return true;
	}
	
	static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}		
	}
}