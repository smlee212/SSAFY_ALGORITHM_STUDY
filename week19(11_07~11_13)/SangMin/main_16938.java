import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, L, R, X;
	static int[] A;
	
	static int res;
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    L = Integer.parseInt(st.nextToken());
	    R = Integer.parseInt(st.nextToken());
	    X = Integer.parseInt(st.nextToken());
	    
	    A = new int[N+1];
	    st = new StringTokenizer(br.readLine());
	    for(int i=1;i<=N;i++) {
	    	A[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    subset(1, 0, 0);
	    
	    System.out.println(res);
	}
	
	static void subset(int now, int cnt, int selected) {
		if(now > N) {
			if(cnt < 2) return;
			isAble(cnt,selected);
			return;
		}
		
		// 선택
		subset(now+1, cnt+1, selected|(1<<now));
		
		// 선택하지 않음
		subset(now+1, cnt, selected);
	}
	
	static void isAble(int k, int selected) {
		
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=1;i<=N;i++) {
			if((selected&(1<<i)) > 0) {
				sum += A[i];
				max = Math.max(max, A[i]);
				min = Math.min(min, A[i]);
			}
		}
		
		if(sum >= L && sum <= R && max - min >= X) {
			res++;
		}		
	}
}








