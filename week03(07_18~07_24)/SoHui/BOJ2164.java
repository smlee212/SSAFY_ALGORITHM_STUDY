import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Queue<Integer> q=new LinkedList<>();
		
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			q.add(i);
		}
		
		while(q.size()!=1) {
			q.remove();
			int x=q.poll();
			q.add(x);
		}
		
		System.out.println(q.peek());	
	}

}