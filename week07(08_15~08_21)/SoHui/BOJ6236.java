
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		//StringTokenizer str= new StringTokenizer(br.readLine());
		n=sc.nextInt();
		int m=sc.nextInt();
		int lt=0,rt=0;
		int res=0,max=Integer.MIN_VALUE;
		arr=new int[n];
		//str=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
			rt+=arr[i];
			max=Math.max(arr[i], max);
		}
		
		while(lt<=rt) {
			int mid=(lt+rt)/2;
			if(mid>=max && count(mid)<=m) {
				res=mid;
				rt=mid-1;
			}else {
				lt=mid+1;
			}
		}
		
		System.out.println(res);
	}

	private static int count(int s) {
		// TODO Auto-generated method stub
		int cnt=1,sum=0;
		for(int i=0;i<n;i++) {
			if(sum+arr[i]>s) {
				cnt++;
				sum=arr[i];
			}
			else sum+=arr[i];
		}
		return cnt;
	}

}
