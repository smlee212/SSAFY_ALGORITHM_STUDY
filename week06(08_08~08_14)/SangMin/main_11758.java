import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		
		double a = (double)(y2-y1) / (double)(x2-x1);
		double b = (double)(y1*x2-x1*y2) / (double)(x2-x1);
		double c = (double)(y3-y2) / (double)(x3-x2);
		
		double s = a * x3 + b;
		
		int res = 0;
		
		if(a==c) {
			res = 0;
		}
		else if((double)y3 > s) {
			res = 1;
		}
		else if((double)y3 < s ) {
			res = -1;
		}
		
		res = (x1<x2) ? res : -res;
		
		System.out.println(res);
	}

}