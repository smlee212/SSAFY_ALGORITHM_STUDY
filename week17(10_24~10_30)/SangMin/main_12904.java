import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static String str;
	static Deque<Character> res = new ArrayDeque<>();
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    str = br.readLine();
	    
	    char[] temp = br.readLine().toCharArray();
	    for(char c : temp) {
	    	res.add(c);
	    }
	    
	    boolean isBack = true;
	    
	    while(str.length() < res.size()) {
	    	if(isBack) {
	    		if(res.peekLast() == 'B') {
	    			isBack = false;
	    		}
	    		res.pollLast();
	    	}
	    	else {
	    		if(res.peekFirst() == 'B') {
	    			isBack = true;
	    		}
	    		res.pollFirst();
	    	}
	    }
	    
	    boolean check = true;
	    if(isBack) {
	    	for(int i=0;i<str.length();i++) {
	    		if(str.charAt(i) != res.poll()) {
	    			check = false;
	    			break;
	    		}
	    	}
	    }
	    else {
	    	for(int i=0;i<str.length();i++) {
	    		if(str.charAt(i) != res.pollLast()) {
	    			check = false;
	    			break;
	    		}
	    	}
	    }
	    
	    System.out.println(check?1:0);
	}
	
}