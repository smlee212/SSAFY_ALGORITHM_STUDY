import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<Integer>> num;
	static int n;
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	  
	    n = Integer.parseInt(br.readLine());
	    num = new ArrayList<>();

	    ArrayList<Integer> a = new ArrayList<>();
	    a.add(2); a.add(3); a.add(5); a.add(7);
	    num.add(a);
	    
	    if(n>1)
	    	func(2);
	    
	    printNum();
	    
	    System.out.println(sb.toString());
	}
	
	public static void func(int cnt) {
		if(cnt>n) {
			return;
		}
		ArrayList<Integer> a = new ArrayList<>();

		for(int x : num.get(cnt-2)) {
			int buf = x * 10;
			for(int i=buf;i<buf+10;i++) {
				if(!isPrime(i)) continue;				
				a.add(i);
			}
		}
		
		num.add(a);
		func(cnt+1);
	}
	
	public static boolean isPrime(int num) {
		for(int i=2;i*i<=num;i++) {
			if(num%i==0) 
				return false;			
		}
		return true;
	}
	
	public static void printNum() {
		for(int x : num.get(n-1))
    		sb.append(x).append('\n');
	}
}