import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, cnt;
	static char[] str;
	static char[] buf;	
	static char[] res;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb;
		StringTokenizer st;
		
		String input;
		while((input = br.readLine())!=null) {
			st = new StringTokenizer(input);
			sb = new StringBuffer();
			
			str = st.nextToken().toCharArray();
			n = Integer.parseInt(st.nextToken());
			
			res = new char[str.length];
			buf = new char[str.length];
			visited = new boolean[str.length];
			
			cnt = 0;
			func(0);

			sb.append(str).append(" ");
			if(cnt<n) {
				sb.append(n).append(" = ").append("No permutation");
			}
			else {	
				sb.append(cnt).append(" = ").append(res);
			}
			System.out.println(sb);
		}
	}
	
	public static void func(int time) {		
		if(cnt==n) return;
		if(time == str.length) {
			cnt++;
			if(cnt==n) {
				res = buf.clone();
			}			
			return;	
		}
		
		for(int i=0;i<str.length;i++) {
			if(!visited[i]) {
				buf[time] = str[i];
				visited[i] = true;
				func(time+1);
				visited[i] = false;
			}
		}
		
		
	}
} 

