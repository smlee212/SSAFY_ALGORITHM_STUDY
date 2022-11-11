import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    
	    int[] map = new int[N+1];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=1;i<=N;i++) {
	    	map[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int i=1;
	    int sum = 0;
	    
	    while(i<=K)
	    	sum += map[i++];
	    
	    int maxRes = sum;
	    
	    while(i<=N){
	    	sum += map[i] - map[i-K];
	    	if(maxRes < sum)
	    		maxRes = sum;
	    	i++;
	    }
	    
	    System.out.println(maxRes);
	}
}