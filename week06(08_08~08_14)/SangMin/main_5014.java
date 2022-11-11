import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();

	static int n,start,end,up,down,res;
	
	static boolean[] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		up = Integer.parseInt(st.nextToken());
		down = Integer.parseInt(st.nextToken());
		
		map = new boolean[n+1];
	
		if(bfs(start,0))
			System.out.println(res);
		else 
			System.out.println("use the stairs");
	}
	
	public static boolean bfs(int x, int cnt) {
		Deque<Pair> dq = new ArrayDeque<>();
		dq.add(new Pair(x,cnt));
		
		while(!dq.isEmpty()) {
			x = dq.peek().x;
			cnt = dq.peek().cnt;
			dq.poll();
			
			if(x==end) {
				res = cnt;
				return true;
			}
			
			if(x+up<=n && !map[x+up]) {
				map[x+up] = true;
				dq.add(new Pair(x+up,cnt+1));
			}
			
			if(x-down>=1 && !map[x-down]) {
				map[x-down] = true;
				dq.add(new Pair(x-down,cnt+1));
			}
		}	
		return false;
	}
}

class Pair{
	int x;
	int cnt;
	Pair(int x, int cnt){
		this.x=x;
		this.cnt=cnt;
	}	
}
