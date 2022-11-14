import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] sel;
	static int[] ans;
	static int res=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ans=new int[10];
		sel=new int[10];
		
		StringTokenizer str=new StringTokenizer(br.readLine());
		for(int i=0;i<10;i++) {
			//문제들의 정답
			ans[i]=Integer.parseInt(str.nextToken());
		}
		
		solveProblem(0);
		
		System.out.println(res);
	}
	private static void solveProblem(int idx) {
		if(idx==10) {
			//다 찍었을 때
			int score=0;
			for(int i=0;i<10;i++) {
				if(ans[i]==sel[i]) score++;
			}
			
			if(score>=5) res++;
			
			return;
		}
		for(int i=1;i<=5;i++) {
			if(idx>=2) {
				//연속해서 3개는 똑같이 안찍음
				if(sel[idx-2]==i && sel[idx-1]==i) continue;
			}
			sel[idx]=i;
			solveProblem(idx+1);			
		}
	}

}
