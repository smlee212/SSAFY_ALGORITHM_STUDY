import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n, count;
	static int[] num = {1,5,10,50};
	static boolean[] visited;
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    n = Integer.parseInt(br.readLine());
	    
	    visited = new boolean[1001];
	    count = 0;
	    
	    func(0, 0, 0);
	    
	    System.out.println(count);
	}

	static void func(int cnt, int idx, int sum) {
		if(cnt == n) {
			if(!visited[sum]) {
				visited[sum] = true;
				count++;
			}
			return;
		}
	
		for (int i = idx; i < 4; i++) {
			func(cnt + 1, i, sum + num[i]);
		}
	}
	

}