import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] chk=new int[n+1]; //아직 안지워졌으면 0, 지워졌으면 1
		for(int i=0;i<=n;i++) {
			chk[i]=0;
		}
		int cnt=0;
		int res=0; //k번째 지워지는 수
		
		for(int i=2;i<=n;i++) {
			for(int j=i;j<=n;j+=i) {
				if(chk[j]==0) { //안지워졌다면 1로 바꾸고 cnt++
					cnt++;
					chk[j]=1;
				}
				if(cnt==k) { //수를 출력하고 바로 종료
					System.out.println(j);
					System.exit(0);
				}
			}
		}		
	}
}