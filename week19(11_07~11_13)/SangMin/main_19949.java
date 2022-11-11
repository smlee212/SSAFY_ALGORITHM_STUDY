import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	static final int N = 10;
	static int[] answer;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		answer = new int[N];
		
		for(int i=0;i<N;i++) {
			answer[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0,0,0);
		
		System.out.println(cnt);
	}
	
	static void dfs(int depth, int before2, int before1, int score) {		
		if(depth == N) {
			if(score>=5)
				cnt++;
			return;
		}
		
		for(int i=1;i<=5;i++) {
			if(before2 == before1 && before1 == i) {
				continue;
			}
			
			if(answer[depth] == i) {
				dfs(depth+1,before1,i,score+1);
			}
			else {
				dfs(depth+1,before1,i,score);
			}
		}
		
	}
}
