import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static final int N = 10;
	static int minCnt = Integer.MAX_VALUE;
	static int[][] map;
	static boolean b = false;
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    
	    map = new int[N][N];
	    
	    int remain = 0;
	    for(int i=0;i<N;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j=0;j<N;j++) {
	    		map[i][j] = Integer.parseInt(st.nextToken());
	    		if(map[i][j]==1) remain++;
	    	}
	    }
	   
	    int[] cntPaper = new int[5+1];
	    for(int i=1;i<=5;i++) {
	    	cntPaper[i] = 5;
	    }
	    
    	func(0,0,map,cntPaper,0,remain);
	    
	    System.out.println(minCnt==Integer.MAX_VALUE?-1:minCnt);
	    
	}
	
	public static void func(int y, int x, int[][] temp, int[] cntPaper, int cnt, int remain) {
		if(cnt>minCnt) return;
		
		// 남아 있는 종이가 없다면 결과를 출력한다
		if(remain==0) {
			minCnt = Math.min(cnt, minCnt);
			return;
		}
		
		if(x==N) {
			x=0;
			y++;
		}
		
		// 모든 범위를 돌아봤을 경우 되돌아간다
		if(y>=N) {
			return;
		}
		
		// 종이가 없는 곳은 지나간다
		if(temp[y][x]==0) {
			int j = x;
			for(int i=y;i<N;i++) {
				for(;j<N;j++) {
					if(temp[i][j]==1) {
						func(i,j,temp,cntPaper,cnt,remain);
						return;
					}
				}
				j = 0;
			}
			return;
		}
		
		for(int s=5;s>0;s--) {
			// y,x에 size가 s인 종이를 놓을 수 있다면 
			if(isAble(y,x,s,cntPaper)) {
				// 크기 s인 종이를 하나 붙인다
				cntPaper[s]--;
				putPaper(y, x, s, temp, 0);
				
				// 다음 종이를 붙이러 떠난다
				func(y,x+s,temp,cntPaper,cnt+1, remain-s*s);	
				
				// 붙였던 크기 s인 종이를 떼어낸다
				cntPaper[s]++;
				putPaper(y, x, s, temp, 1);
			}
		}			
	}
	
	public static void putPaper(int y, int x, int size, int[][] temp, int val) {
		for(int i=y;i<y+size;i++) {
			for(int j=x;j<x+size;j++) {
				temp[i][j] = val;
			}
		}
		
	}
	
	public static boolean isAble(int y, int x, int size,int[] cntPaper) {	
		if(cntPaper[size]==0) return false; 
				
		if(y+size>N || x+size>N) return false;
		
		for(int i=y;i<y+size;i++) {
			for(int j=x;j<x+size;j++) {
				if(map[i][j]==0) return false;
			}
		}
		return true;
	}
}



