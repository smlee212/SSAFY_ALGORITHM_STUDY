import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] a = br.readLine().toCharArray();
		char[] b = br.readLine().toCharArray();
		
		int[][] lcs = new int[a.length+1][b.length+1];
		
		for(int i=1;i<=a.length;i++) {
			for(int j=1;j<=b.length;j++) {
				if(a[i-1]==b[j-1]) {
					lcs[i][j] = lcs[i-1][j-1] + 1;
				}
				else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);					
				}
			}
		}
		
		int maxL = lcs[a.length][b.length];
		System.out.println(maxL);

		StringBuilder sb = new StringBuilder();
		
		int i = a.length;
		int j = b.length;
		while(i>0 && j>0) {
			if(i==0||j==0) break;
			
			if(lcs[i][j] == lcs[i-1][j]) {
				i--;
			}
			else if(lcs[i][j] == lcs[i][j-1]) {
				j--;
			}
			else {
				sb.append(a[i-1]);
				i--;j--;
			}
		}
		
		System.out.println(sb.reverse().toString());
		
	}

}
