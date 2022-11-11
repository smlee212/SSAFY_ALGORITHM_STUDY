import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    while(true) {
	    	st = new StringTokenizer(br.readLine());
	    	int k = Integer.parseInt(st.nextToken());
	    	if(k==0) break;
	    	
	    	int[] num = new int[k];
	    	int[] temp = new int[6];
	    	
	    	for(int i=0;i<k;i++) {
	    		num[i] = Integer.parseInt(st.nextToken());
	    	}
	    	
	    	combination(0,0,k,num,temp);
	    	
	    	sb.append("\n");
	    }
	    System.out.println(sb);
	}
	
	public static void combination(int now, int time, int k, int[] num, int[] temp) {
		if(time==6) {
			for(int i : temp) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=now;i<k;i++) {
			temp[time] = num[i];
			combination(i+1, time+1, k, num, temp);
		}
	}
}