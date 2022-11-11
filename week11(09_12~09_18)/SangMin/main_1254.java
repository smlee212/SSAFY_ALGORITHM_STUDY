import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    char[] str = br.readLine().toCharArray();
	    
	    for(int i=0;i<str.length;i++) {
	    	String temp = new String(str);
	    	
	    	for(int j=i-1;j>=0;j--) {
	    		temp += str[j];
	    	}
	    	
	    	boolean check = true;
	    	for(int j=0, l=temp.length()/2;j<l;j++) {
	    		if(temp.charAt(j) != temp.charAt(temp.length()-j-1)) {
	    			check = false;
	    			break;
	    		}
	    	}
	    	
	    	if(check) {
	    		System.out.println(temp.length());
	    		break;
	    	}
	    }
	    
	}
	
}