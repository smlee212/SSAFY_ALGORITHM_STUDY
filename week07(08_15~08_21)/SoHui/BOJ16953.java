import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int res;
	static long a,b;
	static Queue<Long> q=new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str=new StringTokenizer(br.readLine());
		
		a= Long.parseLong(str.nextToken());
		b= Long.parseLong(str.nextToken());
		q.offer(a);
		bfs();
		
		System.out.println(res);
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		while (!q.isEmpty()) {
			int size=q.size();
			
			for(int i=0;i<size;i++) {
				long tmp=q.poll();
				if(tmp==b) {
					res+=1;
					return;
				}
				
				if(tmp*2<=b) q.offer(tmp*2);
				if(tmp*10+1<=b) q.offer(tmp*10+1);
				
			}
			res++;
		}
		
		res=-1;
	}

}
