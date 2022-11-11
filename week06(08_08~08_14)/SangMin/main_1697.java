import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static final int MAX_LENGTH = 100000;
	static int n, k;
	static boolean[] map, visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new boolean[MAX_LENGTH+1];
		visited = new boolean[MAX_LENGTH+1];

		bfs(n,0);
	}
	
	public static void bfs(int now, int time) {
		Deque<Pair> dq = new ArrayDeque<Pair>();
		dq.add(new Pair(now,time));
		visited[now] = true;
		
		while(!dq.isEmpty()) {
			now = dq.peek().now;
			time = dq.peek().time;
			dq.poll();
			
			if(now==k) {
				System.out.println(time);
				return;
			}
			
			if(now>=1 && !visited[now-1]) {
				visited[now-1] = true;
				dq.add(new Pair(now-1,time+1));					
			}
			
			if(now+1<=MAX_LENGTH && !visited[now+1]) {
				visited[now+1] = true;
				dq.add(new Pair(now+1,time+1));				
			}

			if(now*2<=MAX_LENGTH && !visited[now*2]) {
				visited[now*2] = true;
				dq.add(new Pair(now*2,time+1));
			}
			
		}
	}
}

class Pair{
	int now;
	int time;
	Pair(int now,int time){
		this.now=now;
		this.time=time;
	}
}