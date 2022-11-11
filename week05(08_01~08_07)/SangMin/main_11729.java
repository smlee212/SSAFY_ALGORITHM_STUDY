import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N, k;
	static StringBuilder sb;

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		k = 0;
		
		hanoi(N,1,2,3);
		
		System.out.println(k);
		System.out.println(sb.toString());
		
		br.close();
	}

	public static void hanoi(int n, int start, int sub, int end) {
		if(n==1) {
			sb.append(start).append(" ").append(end).append('\n'); k++;
			return;
		}
		hanoi(n-1,start,end,sub);
		sb.append(start).append(" ").append(end).append('\n'); k++;
		hanoi(n-1,sub,start,end);
	}
}