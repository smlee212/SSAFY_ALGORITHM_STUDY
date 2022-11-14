import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int t;
	static int a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t= Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		for(int tc=0;tc<t;tc++) {
			StringTokenizer str= new StringTokenizer(br.readLine());
			a=Integer.parseInt(str.nextToken());
			b=Integer.parseInt(str.nextToken());
			
			Queue<Integer> q= new LinkedList<>();
			boolean[] visited=new boolean[10000];
			String[] res=new String[10000];
			
			q.offer(a);
			visited[a]=true;
			Arrays.fill(res, "");
			
			while(!q.isEmpty() && !visited[b]) {
				int tmp=q.poll();
				
				int D=(2*tmp)%10000;
				int S=0;
				if(tmp==0) S=9999;
				else S=tmp-1;
				int L=(tmp%1000)*10+tmp/1000;
				int R=(tmp%10)*1000+tmp/10;
				
				//D부터 탐색
				if(!visited[D]) {
					q.offer(D);
					visited[D]=true;
					res[D]=res[tmp]+"D";
				}
				
				if(!visited[S]) {
					q.offer(S);
					visited[S]=true;
					res[S]=res[tmp]+"S";
				}
				
				if(!visited[L]) {
					q.offer(L);
					visited[L]=true;
					res[L]=res[tmp]+"L";
				}
				
				if(!visited[R]) {
					q.offer(R);
					visited[R]=true;
					res[R]=res[tmp]+"R";
				}

			}
			
			sb.append(res[b]).append("\n");
		}
		System.out.println(sb);
	}

}
