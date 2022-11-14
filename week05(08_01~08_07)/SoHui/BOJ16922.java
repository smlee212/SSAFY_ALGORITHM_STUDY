import java.util.Scanner;

public class Main {//중복조합 문제
	static int cnt=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr= {1,5,10,50};
		int[] sel=new int[10000];
		
		recursive(arr,sel,0,0,0,n);
		
		System.out.println(cnt);
	}
	private static void recursive(int[] arr, int[] sel, int idx, int k, int sum,int n) {
		// TODO Auto-generated method stub
		if(k==n) {
			if(sel[sum]==0) {
				sel[sum]=1;
				cnt++;
			}
			return;
		}
		for(int i=idx;i<4;i++) {
			recursive(arr,sel,i,k+1,sum+arr[i],n);
		}
	}
	
	
}
