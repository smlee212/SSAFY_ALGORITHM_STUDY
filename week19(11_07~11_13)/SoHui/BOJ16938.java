import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n,l,r,x;
	static int[] problems;
	static int res=0;
	static boolean[] sel;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(str.nextToken());
		l=Integer.parseInt(str.nextToken());
		r=Integer.parseInt(str.nextToken());
		x=Integer.parseInt(str.nextToken());
		
		problems=new int[n];
		sel=new boolean[n];
		str=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			problems[i]=Integer.parseInt(str.nextToken());
		}
		
		selectPro(0);
		
		System.out.println(res);
	}
	
	private static void selectPro(int idx) {
		if(idx==n) {
			int cnt=0,sum=0,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
			for(int i=0;i<n;i++) {
				if(sel[i]) {
					cnt++;
					sum+=problems[i];
					max=Math.max(max, problems[i]);
					min=Math.min(min, problems[i]);
				}
			}
			
			int diff=max-min;
			//System.out.println(cnt+" "+sum+" "+max+" "+min);
			if(cnt<2) return;
			
			if(l<=sum && sum<=r && diff>=x) res++;
			
			return;
		}
		
		sel[idx]=true;
		selectPro(idx+1);
		
		sel[idx]=false;
		selectPro(idx+1);
	}

}
