import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Stack<Integer> stack= new Stack<>();
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<n;i++) {
			String str=sc.next();
			
			if(str.equals("push")) {
				int x=sc.nextInt();
				stack.push(x);
			}
			else if(str.equals("pop")) {
				if(stack.isEmpty()) {
					sb.append("-1\n");
				}
				else
				{
					sb.append(stack.peek()+"\n");
					stack.pop();
				}
			}
			else if(str.equals("size")) {
				sb.append(stack.size()+"\n");
			}
			else if(str.equals("empty")) {
//				System.out.println(stack.isEmpty());
				if(stack.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
			}
			else if(str.equals("top")) {
				if(stack.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					sb.append(stack.peek()+"\n");
				}
			}
		}
		System.out.println(sb);

	}

}