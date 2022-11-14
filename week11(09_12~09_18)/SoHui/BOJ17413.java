import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		
		StringBuilder sb= new StringBuilder();
		
		//꺽새 판단
		boolean flag=false;
		
		Stack<Character> s=new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='<') {
				//열린꺽새일 경우
				while(!s.isEmpty()) {
					sb.append(s.pop());
				}
				flag=true;
			}
			else if(str.charAt(i)=='>') {
				//닫힌 꺽새일 경우
				flag=false;
				sb.append(str.charAt(i));
				continue;
			}
			
			if(flag==true) {
				//> 전까지 입력
				sb.append(str.charAt(i));
			}
			else if(flag==false) {
				if(str.charAt(i)==' ') {
					//공백일 경우
					while(!s.isEmpty()) {
						sb.append(s.pop());
					}
					sb.append(' ');
					continue;
				}else {
					//스택에 추가
					s.push(str.charAt(i));
				}
			}
			
			if(i==str.length()-1) {
				//마지막 원소일 때
				while(!s.isEmpty()) {
					sb.append(s.pop());
				}
			}
		}
		
		System.out.println(sb);
	}

}
