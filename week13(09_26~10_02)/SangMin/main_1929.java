import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    
	    st = new StringTokenizer(br.readLine());
	    int M = Integer.parseInt(st.nextToken());
	    int N = Integer.parseInt(st.nextToken());
	    
	    int[] num = new int[N+1];
	    for(int i=2;i<=N;i++) {
	    	num[i] = i;
	    }
	    
	    for(int i=2;i<=N;i++) {
	    	if(num[i]==0) continue;
	    	
	    	for(int j=i*2;j<=N;j+=i) {
	    		num[j] = 0;
	    	}
	    }
	    
	    for(int i=M;i<=N;i++) {
	    	if(num[i]!=0)
	    		sb.append(num[i]).append("\n");
	    }
	    
	    System.out.println(sb);
	}
}