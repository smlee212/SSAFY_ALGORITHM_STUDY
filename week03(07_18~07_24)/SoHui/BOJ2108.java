import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] num= new int[N];
		double sum=0.0;
		//공백 - N-1->0 별 1->N
		for(int i=0;i<N;i++)
		{
			num[i]=sc.nextInt();
			sum+=num[i];
		}
		//산술평균
		double avg = sum/(double)N;
		System.out.println(Math.round(avg));
		
		//중앙값
		Arrays.sort(num);
		System.out.println(num[(N-1)/2]);
		
		//최빈값
		int cnt=0;
		int max=-1;
		int n_num=num[0];
		boolean chk=false;
		
		for(int i=0;i<N-1;i++) {
			if(num[i]==num[i+1]) {
				cnt++;
			}
			else {
				cnt=0;
			}
			if(max<cnt) {
				max=cnt;
				n_num=num[i];
				chk=true;
			}
			else if(max==cnt && chk==true) {
				n_num=num[i];
				chk=false;
			}
		}
		
		System.out.println(n_num);
		
		//범위
		System.out.println(num[N-1]-num[0]);
		
	}

}
