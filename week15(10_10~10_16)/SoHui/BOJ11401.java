import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n,r;
	static int mod=1000000007;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer str= new StringTokenizer(br.readLine());
		n=Integer.parseInt(str.nextToken());
		r=Integer.parseInt(str.nextToken());
			
		long[] facto = new long[n+1];
			
		facto[0]=1;
			
		for(int i=1;i<=n;i++) facto[i]=(facto[i-1]*i)%mod;
			
		long bot=(facto[r]*facto[n-r])%mod;
		long rebot=fermat(bot,mod-2);
			
		sb.append((facto[n]*rebot)%mod).append("\n");
		System.out.println(sb);

	}
	

	private static long fermat(long bot, int x) {
		if(x==0) return 1;
		long tmp=fermat(bot, x/2);
		long ttmp=(tmp*tmp)%mod;
		if(x%2==0) return ttmp;
		else return (ttmp*bot)%mod;
	}
}
