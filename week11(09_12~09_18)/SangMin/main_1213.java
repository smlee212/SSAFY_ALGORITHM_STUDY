import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
	    String str = br.readLine();
	    
	    int[] alpha = new int[26];
	    
	    for(int i=0;i<str.length();i++) {
	    	alpha[str.charAt(i)-'A']++;
	    }
	    
	    int isOdd = 0;
	    for(int i=0;i<alpha.length;i++) {
	    	if(alpha[i]%2!=0) isOdd++;
	    }
	    
	    if(isOdd>1) {
	    	sb.append("I'm Sorry Hansoo");
	    }
	    else {
	    	for(int i=0;i<alpha.length;i++) {
	    		for(int j=0;j<alpha[i]/2;j++) {
	    			sb.append((char)(i+'A'));
	    		}
	    	}

	    	System.out.print(sb);
	    	
	    	String end = sb.reverse().toString();
	    	sb.setLength(0);
	    	
	    	for(int i=0;i<alpha.length;i++) {
	    		if(alpha[i]%2==1) {
	    			sb.append((char)(i+'A'));
	    		}
	    	}
	    	sb.append(end);
	    }
		
		System.out.println(sb);
	}
}