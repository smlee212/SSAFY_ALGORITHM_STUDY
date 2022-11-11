import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] a = br.readLine().toCharArray();
		char[] b = br.readLine().toCharArray();
		char[] c = br.readLine().toCharArray();
		
		int[][][] lcs = new int[a.length+1][b.length+1][c.length+1];
		
		for(int i=1;i<=a.length;i++) {
			for(int j=1;j<=b.length;j++) {
				for(int k=1;k<=c.length;k++) {
					if(a[i-1]==b[j-1] && a[i-1]==c[k-1]) {
						lcs[i][j][k] = lcs[i-1][j-1][k-1] + 1;
					}
					else {
						lcs[i][j][k] = Math.max(lcs[i-1][j][k], Math.max(lcs[i][j-1][k], lcs[i][j][k-1]));
					}
				}
			}
		}
		
		System.out.println(lcs[a.length][b.length][c.length]);
	}
}