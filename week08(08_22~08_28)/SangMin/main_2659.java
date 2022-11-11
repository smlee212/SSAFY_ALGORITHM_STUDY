import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	 
	    st = new StringTokenizer(br.readLine());
	    int a = Integer.parseInt(st.nextToken());
	    int b = Integer.parseInt(st.nextToken());
	    int c = Integer.parseInt(st.nextToken());
	    int d = Integer.parseInt(st.nextToken());
	    		
	    System.out.println(func(a,b,c,d));
	}
	
	public static int func(int a, int b, int c, int d) {
		boolean[] visited = new boolean[10000];
		int cnt = 0;
		int target = calcMin(a,b,c,d);
		for(int i=1;i<10;i++) {
			for(int j=1;j<10;j++) {
				for(int k=1;k<10;k++) {
					for(int l=1;l<10;l++) {
						int num = calcMin(i,j,k,l);
						if(num==target) {							
							return cnt+1;
						}
						if(!visited[num]) {
							visited[num] = true;
							cnt++;
						}
					}
				}
			}
		}
		return cnt;
	}
	
	public static int calcMin(int a, int b, int c, int d) {
		int minNum = Math.min(calcNum(a,b,c,d),calcNum(b,c,d,a));
		minNum = Math.min(minNum, calcNum(c,d,a,b));
		minNum = Math.min(minNum, calcNum(d,a,b,c));
		return minNum;
	}
	
	public static int calcNum(int a, int b, int c, int d) {
		int sum = d;
		sum = (sum<<3)+(sum<<1)+c;
		sum = (sum<<3)+(sum<<1)+b;
		sum = (sum<<3)+(sum<<1)+a;
		return sum;
	}
}