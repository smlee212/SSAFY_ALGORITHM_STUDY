import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		
		Queue<Integer> q= new LinkedList<>();
		//요세푸스순열 저장 큐
		int[] res=new int[n];
		int idx=0;
		for(int i=1;i<=n;i++) {
			q.add(i);
		}
		
		while(!q.isEmpty()) {
			//K-1 번째 원소는 뒤로 보내버리기
			for(int i=0;i<k-1;i++) {
				int x=q.poll();
				q.add(x);
			}
			
			//저장하면서 버리기
			res[idx++]=q.poll();
		}
		
		System.out.print("<");
		for(int i=0;i<n-1;i++) {
			System.out.print(res[i]+", ");
			
		}
		
		System.out.print(res[n-1]+">");

	}

}