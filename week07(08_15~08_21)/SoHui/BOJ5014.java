import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int f,s,g,u,d;
	static Queue<Integer> q=new LinkedList<>();
	static int[] chk;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str=new StringTokenizer(br.readLine());
		f=Integer.parseInt(str.nextToken());
		s=Integer.parseInt(str.nextToken());
		g=Integer.parseInt(str.nextToken());
		u=Integer.parseInt(str.nextToken());
		d=Integer.parseInt(str.nextToken());
		
		chk=new int[f+1];
		bfs();
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		q.offer(s);
		chk[s]=1;
		while(!q.isEmpty()) {
			int tmp=q.poll();
			
			if(tmp==g) {
				System.out.println(chk[tmp]-1);
			}
			
			if(tmp+u<=f && chk[tmp+u]==0) {
				chk[tmp+u]=chk[tmp]+1;
				q.offer(tmp+u);
			}
				
			if(tmp-d>0 && chk[tmp-d]==0) {
				chk[tmp-d]=chk[tmp]+1;
				q.offer(tmp-d);
			}
		}
		if(chk[g]==0) {
			System.out.println("use the stairs");
		}
	}


}
