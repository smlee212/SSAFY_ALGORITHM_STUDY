import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int s, p;
	static int[] limit = new int[4];
	static int[] cntDna = new int[4];
	static char[] dna;
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    s = Integer.parseInt(st.nextToken());
	    p = Integer.parseInt(st.nextToken());
	    
	    cntDna = new int[4];
	    dna = new char[s];
	    
	    String str = br.readLine();
	    for(int i=0;i<s;i++) {
	    	dna[i] = str.charAt(i);
	    	if(dna[i]=='A') cntDna[0]++;
	    	else if(dna[i]=='C') cntDna[1]++;
	    	else if(dna[i]=='G') cntDna[2]++;
	    	else if(dna[i]=='T') cntDna[3]++;
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<4;i++) {
	    	limit[i] = Integer.parseInt(st.nextToken());
	    	
	    	if(limit[i] > cntDna[i]) {
	    		System.out.println(0);
	    		System.exit(0);
	    	}
	    }

	    int cnt = 0;

	    cntDna = new int[4];
	    for(int i=0;i<p;i++) {
	    	if(dna[i]=='A') cntDna[0]++;
	    	else if(dna[i]=='C') cntDna[1]++;
	    	else if(dna[i]=='G') cntDna[2]++;
	    	else if(dna[i]=='T') cntDna[3]++;
	    }
	    if(isAble()) cnt++;
	    
	    
	    for(int i=0;i<s-p;i++) {
	    	if(dna[i]=='A') cntDna[0]--;
	    	else if(dna[i]=='C') cntDna[1]--;
	    	else if(dna[i]=='G') cntDna[2]--;
	    	else if(dna[i]=='T') cntDna[3]--;	    	

	    	if(dna[i+p]=='A') cntDna[0]++;
	    	else if(dna[i+p]=='C') cntDna[1]++;
	    	else if(dna[i+p]=='G') cntDna[2]++;
	    	else if(dna[i+p]=='T') cntDna[3]++;
	    	
		    if(isAble()) cnt++;
	    }
	    
	    System.out.println(cnt);
	}
	
	public static boolean isAble() {
		for(int i=0;i<4;i++) {
			if(cntDna[i] < limit[i])
				return false;
		}
		return true;
	}
}