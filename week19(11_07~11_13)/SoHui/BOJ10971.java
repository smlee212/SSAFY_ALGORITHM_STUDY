import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[] visited;
	static int[] route;
	static int[][] cost;
	static int start;
	static int res=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		cost=new int [n][n];
		visited=new boolean[n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer str=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				cost[i][j]=Integer.parseInt(str.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			start=i;
			route=new int[n+1];
			route[0]=i;
			visited[i]=true;
			TSP(1);
			visited[i]=false;
		}
		
		System.out.println(res);
	}
	private static void TSP(int idx) {
		if(idx==n) {
			route[n]=start;
			//비용 구하기
			//System.out.println(Arrays.toString(route));
			int payment=0;
			for(int i=0;i<n;i++) {
                if(cost[route[i]][route[i+1]]==0) return;
				payment+=cost[route[i]][route[i+1]];
			}
			//System.out.println(payment);
			res=Math.min(res, payment);
			
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visited[i] && i!=start) {
				visited[i]=true;
				route[idx]=i;
				TSP(idx+1);
				visited[i]=false;
			}
		}
		
	}

}
