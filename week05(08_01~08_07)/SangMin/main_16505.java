import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static char[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		
		int size = (int)Math.pow(2, n);
		map = new char[size][size];
		for(int i=0;i<size;i++) {
			Arrays.fill(map[i], ' ');
		}
		map[0][0] = '*';
		
		star(1);
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size-i;j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	public static void star(int cnt) {
		if(cnt>n) {
			return;
		}
		
		int size = (int)Math.pow(2, cnt-1);
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				map[i+size][j] = map[i][j];
				map[i][j+size] = map[i][j];
			}
		}
		star(cnt+1);
	}
} 