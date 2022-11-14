import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Queue<Integer> q=new LinkedList<>();
		Queue<Integer> delete=new LinkedList<>();
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			q.add(i);
		}
		
		while(q.size()!=1) {
			int x=q.poll();
			delete.add(x);
            int y=q.poll();
            q.add(y);
		}
		
        for(int i=0;i<n-1;i++)
        {
            int x=delete.poll();
            System.out.print(x+" ");
        }
        
		System.out.println(q.peek());	
	}

}
