import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
	    Stack<Character> res = new Stack<>();
	    
	    char[] input = br.readLine().toCharArray();
	    char[] boom = br.readLine().toCharArray();
	    
	    int boomSize = boom.length;
	    
	    for(int i=0;i<input.length;i++) {
	    	res.push(input[i]);
	    	
	    	if(res.size() >= boomSize) {
	    		boolean check = true;
	    		
	    		for(int j=0;j<boomSize;j++) {
	    			if(res.get(res.size()-boomSize+j) != boom[j]) {
	    				check = false;
	    				break;
	    			}    				    			
	    		}
	    		
	    		if(check) {
	    			for(int j=0;j<boomSize;j++) {
	    				res.pop();
	    			}
	    		}	    		
	    	}
	    	
	    }
	  
	    for(char c : res) {
	    	sb.append(c);
	    }
	    
	    System.out.println(sb.length()==0?"FRULA":sb);
	}
	
}