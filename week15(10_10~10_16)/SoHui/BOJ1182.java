import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n,s,res;
	static int[] num;
	static boolean[] sel;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str= new StringTokenizer(br.readLine());
		n=Integer.parseInt(str.nextToken());
		s=Integer.parseInt(str.nextToken());
		
		num=new int[n];
		sel=new boolean[n];
		str=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(str.nextToken());
		}
		
		recur(0);
		
		System.out.println(res);
	}
	
	
	private static void recur(int idx) {
		if(idx==n) {
			List<Integer> list=new ArrayList<>();
			for(int i=0;i<n;i++) {
				if(sel[i]) list.add(num[i]);
			}
			
			if(list.size()==0) return;
			int sum=0;
			for(int i=0;i<list.size();i++) {
				sum+=list.get(i);
			}
			
			if(sum==s) res++;
			
			return;
		}
		
		sel[idx]=true;
		recur(idx+1);
		
		sel[idx]=false;
		recur(idx+1);
		
	}

}
