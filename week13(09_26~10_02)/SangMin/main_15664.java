import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] map, temp;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

	    st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    map = new int[n];
	    temp = new int[m];
	    visited = new boolean[n];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<n;i++) {
	    	map[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    Arrays.sort(map);
	    
	    func(0,0);
	    
	    System.out.println(sb);
	}
	
	static void func(int now, int time) {
		if(time == m) {
			for(int x : temp) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for(int i=now, buf=-1;i<n;i++) {
			
			if(!visited[i] && buf!=map[i]) {
				visited[i] = true;
				temp[time] = map[i];
				func(i+1,time+1);
				visited[i] = false;
				
				buf = map[i];
			}
		}
	}
}