import java.util.Arrays;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] P=new int[n];
		for(int i=0;i<n;i++) {
			P[i]=sc.nextInt();
		}
		//첫번째 사람의 걸리는 시간은 총 5번 더해지고, 2번째는 4번, 3번째는 3번 이런식으로 더해지기 때문에
        //오름차순 정렬을 한 후 작은 값이 많이 더해지고 큰 값을 적게 더해지게 해야함
        //P를 오름차순 정렬
		Arrays.sort(P);
		int total_time=0; //최솟값
        
		for(int i=0;i<P.length;i++) {
			total_time+=P[i]*(P.length-i);
		}
		
		System.out.println(total_time);

	}

}