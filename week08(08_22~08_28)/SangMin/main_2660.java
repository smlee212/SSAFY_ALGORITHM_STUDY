import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static ArrayList<Integer>[] persons;
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    n = Integer.parseInt(br.readLine());
	    
	    persons = new ArrayList[n+1];
	    for(int i=1;i<=n;i++) {
	    	persons[i] = new ArrayList<>();
	    }	    
	    
	    while(true) {
	    	st = new StringTokenizer(br.readLine());	    	
	    	int a = Integer.parseInt(st.nextToken());
	    	int b = Integer.parseInt(st.nextToken());
	    	
	    	if(a==-1 && b==-1) break;
	    	
	    	persons[a].add(b);
	    	persons[b].add(a);
	    }
	    
	    int minCnt = Integer.MAX_VALUE;
	    ArrayList<Integer> res = new ArrayList<>();
	    
	    for(int i=1;i<=n;i++) {
	    	int cnt = bfs(i);
	    	if(minCnt>cnt) {
	    		minCnt = cnt;
	    		res.clear();
	    		res.add(i);
	    	}
	    	else if(minCnt==cnt) {
	    		res.add(i);
	    	}
	    }
	    
	    sb.append(minCnt).append(" ").append(res.size()).append("\n");
	    for(int person : res) {
	    	sb.append(person).append(" ");
	    }
	    System.out.println(sb);
	}
	
	public static int bfs(int person) {
		Deque<Pair> dq = new ArrayDeque<>();
		int cnt = 0;
		dq.add(new Pair(person,cnt));
		
		boolean[] visited = new boolean[n+1];
		visited[person] = true;
		
		while(!dq.isEmpty()) {
			person = dq.peek().person;
			cnt = dq.peek().cnt;
			dq.poll();
			
			for(int next : persons[person]) {
				if(!visited[next]) {
					visited[next] = true;
					dq.add(new Pair(next,cnt+1));
				}
			}
		}
		
		return cnt;
	}
}

class Pair{
	int person;
	int cnt;
	Pair(int p, int c){
		person=p;
		cnt=c;
	}
}