import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	   
	    st = new StringTokenizer(br.readLine());
	    
	    long A = Integer.parseInt(st.nextToken());
	    int B = Integer.parseInt(st.nextToken());
	    int C = Integer.parseInt(st.nextToken());
		
		System.out.println(calc(A,B,C));
	}
	
	static long calc(long a, int b, int c) {	
		if(b==1) {
			return a % c;
		}
		
		long temp = calc(a,b/2,c);
		temp = temp * temp % c;
		if(b%2==1) {
			temp = temp * a % c;
		}
		return temp;
	}
}