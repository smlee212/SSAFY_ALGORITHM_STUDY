import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
	    StringTokenizer st; 	    
	    
	    int n = Integer.parseInt(br.readLine());
	    int[] arr = new int[n+1];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=1;i<=n;i++) {
	    	arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int l = 1, r = n;
	    int mid = (l+r)/2;	    
	    long sum;
	    long minSum = Integer.MAX_VALUE;
	    int minL=l, minR=r;
	    
	    while(l<r) {
	    	sum = arr[l]+arr[r];
	    	if(Math.abs(sum)<Math.abs(minSum)) {
		    	minSum = sum;
		    	minL = l;
		    	minR = r;
	    	}
	    	
	    	if(sum<0) {
	    		l++;
	    	}
	    	else if(sum>0) {
	    		r--;
	    	}
	    	else {
	    		break;
	    	}
	    }
	    
	    System.out.println(arr[minL]+" "+arr[minR]);
	}
	
}