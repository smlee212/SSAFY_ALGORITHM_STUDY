import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,res,totalSum;
	static int[] section;
	static int[][] near;
	static boolean[] sel;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		section=new int[n+1];
		near=new int[n+1][n+1];
		
		StringTokenizer str=new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			section[i]=Integer.parseInt(str.nextToken());
			totalSum+=section[i];
		}
		
		for(int i=0;i<n;i++) {
			str=new StringTokenizer(br.readLine());
			int num=Integer.parseInt(str.nextToken());
			for(int j=0;j<num;j++) {
				int tmp=Integer.parseInt(str.nextToken());
				near[i+1][tmp]=near[tmp][i+1]=1;
			}
		}
		res=Integer.MAX_VALUE;
		//print(near);
		sel=new boolean[n+1];
		gerryMandering(1);
		
		if(res==Integer.MAX_VALUE)
			res=-1;
		
		System.out.println(res);
	}

	private static void gerryMandering(int idx) {
		if(idx==n) {
			ArrayList<Integer> part1=new ArrayList<>();
			ArrayList<Integer> part2=new ArrayList<>();
			
			for(int i=1;i<=n;i++) {
				if(sel[i]) part1.add(i);
				else part2.add(i);
			}
			
			if(part1.size()+part2.size()!=n) return;
			if(part1.size()==0 || part2.size()==0) return;
			if(check(part1,'1') && check(part2,'2')) { //구역이 연결되어있는지 체크
				int tmp=0;
				for(int i=0;i<part1.size();i++) {
					tmp+=section[part1.get(i)];
				}
				int tmp2=totalSum-tmp;
				
				res=Math.min(res, Math.abs(tmp-tmp2));
			}else return;
			
			return;
		}
		
		sel[idx]=true;
		gerryMandering(idx+1);
		
		sel[idx]=false;
		gerryMandering(idx+1);
		
	}

	private static boolean check(ArrayList<Integer> part, char team) {
		Queue<Integer> q=new LinkedList<>();
		boolean [] connected=new boolean[n+1];
		int now=part.get(0); //현재 구역 번호
		q.offer(now);
		connected[now]=true;
		
		while(!q.isEmpty()) {
			int tmp=q.poll();
			
			for(int i=0;i<near[tmp].length;i++) {
				int next=0;
				if(near[tmp][i]==1) next=i;
				if(connected[next]) continue;
				if((team=='1'&&sel[next])||(team=='2'&&!sel[next])) {
					//같은 구역이라면
					q.offer(next);
					connected[next]=true;
				}
			}
		}
		
		for(int i=0;i<part.size();i++) {
			if(!connected[part.get(i)]) return false;
		}
		return true;
	}

	private static void print(int[][] arr) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
