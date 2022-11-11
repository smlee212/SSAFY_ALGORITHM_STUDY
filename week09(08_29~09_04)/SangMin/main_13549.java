import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    
	    Deque<Node> dq = new ArrayDeque<>();
	    int[] map = new int[100001];
	    
	    int x = N;
	    int time = 1;
		map[x] = 1;
	    dq.add(new Node(x,time));
		
		while(!dq.isEmpty()) {
			x = dq.peek().x;
			time = dq.peek().time;
			dq.poll();
			
			int nx = x * 2;
			if(nx<=100000 && (map[nx]>time||map[nx]==0)) {
				map[nx] = time;
				dq.add(new Node(nx,time));				
			}
			
			nx = x + 1;
			if(nx<=100000 && (map[nx]>time+1||map[nx]==0)) {
				map[nx] = time+1;
				dq.add(new Node(nx,time+1));
			}
			
			nx = x - 1;
			if(nx>=0 && (map[nx]>time+1||map[nx]==0)) {
				map[nx] = time+1;
				dq.add(new Node(nx,time+1));				
			}
		}
		
		System.out.println(map[K]-1);
	}	
}

class Node{
	int x;
	int time;
	public Node(int x, int time) {
		super();
		this.x = x;
		this.time = time;
	}
}