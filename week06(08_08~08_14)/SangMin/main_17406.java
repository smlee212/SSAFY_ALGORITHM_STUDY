import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N,M,K,minSum;
	static int[][] map, data;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
	    StringTokenizer st; 	    
	    
	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    minSum = Integer.MAX_VALUE;
	    
	    map = new int[N+1][M+1];
	    
	    for(int i=1;i<=N;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j=1;j<=M;j++) {
	    		map[i][j] = Integer.parseInt(st.nextToken());
	    	}
	    }
	    
	    data = new int[K][3];
	    for(int i=0;i<K;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	data[i][0] = Integer.parseInt(st.nextToken()); // y
	    	data[i][1] = Integer.parseInt(st.nextToken()); // x
	    	data[i][2] = Integer.parseInt(st.nextToken()); // s
	    }
	    
	    arr = new int[K];
	    visited = new boolean[K];
	    permutation(0);
	    
	    System.out.println(minSum);
	}
	
	
	public static void permutation(int now) {
		if(now==K) {
			calc();
			return;
		}
		
		for(int i=0;i<K;i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[now] = i;
				permutation(now+1);
				visited[i] = false;
			}
		}
	}
	
	public static void calc() {
		int[][] temp = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		for(int i=0;i<K;i++) {
			int index = arr[i];
			int y = data[index][0];
			int x = data[index][1];
			int s = data[index][2];
			
			rotate(y,x,s);
		}
		
		int sum;
		for(int i=1;i<=N;i++) {
			sum = 0;
			for(int j=1;j<=M;j++) {
				sum += map[i][j];
				map[i][j] = temp[i][j];
			}
			minSum = minSum>sum ? sum : minSum;
		}
	}
	
	public static void rotate(int y, int x, int s) {	
		for(int t=s;t>0;t--) {
			int temp = map[y-t][x-t];

			for(int i=y-t;i<y+t;i++)	// 좌 세로
				map[i][x-t] = map[i+1][x-t];

			for(int j=x-t;j<x+t;j++)	// 하 가로
				map[y+t][j] = map[y+t][j+1];
			
			for(int i=y+t;i>y-t;i--)	// 우 세로
				map[i][x+t] = map[i-1][x+t];
			
			for(int j=x+t;j>x-t;j--)	// 상 가로
				map[y-t][j] = map[y-t][j-1];				
			
			map[y-t][x-t+1] = temp;
		}
	}
	
}