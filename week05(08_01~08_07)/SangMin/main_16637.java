import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, maxRes;
	static char[] expression;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.parseInt(br.readLine());
		maxRes = Integer.MIN_VALUE;
	
		expression = br.readLine().toCharArray();
		
		parenthesis(2,expression[0]-'0');
		
		System.out.println(maxRes);
		
		br.close();		
	}

	public static void parenthesis(int index, int total) {
		if(index >= n ) {
			maxRes = (maxRes < total) ? total : maxRes;
			return;
		}
		
		// 괄호를 추가하지 않았을 때
		// 이전까지의 total값과 현재 [index]값을 연산해준다
		parenthesis(index+2, calc(total, expression[index-1], expression[index]-'0'));
		
		// 다음 숫자가 있을 경우
		if(index+2<n) {
			// 현재 index의 숫자와 다음 index의 숫자를 괄호처리하여 연산한다
			int nextExp = calc(expression[index]-'0', expression[index+1], expression[index+2]-'0');
			
			// 이전까지의 total값과 괄호처리로 연산한 값을 연산한다
			parenthesis(index+4, calc(total, expression[index-1], nextExp));
		}		
	}
	
	public static int calc(int A, char OP, int B) {
		if(OP=='+') 
			return A+B;		
		else if(OP=='-') 
			return A-B;		
		else 
			return A*B;		
	}
}