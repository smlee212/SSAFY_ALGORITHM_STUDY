import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	    StringTokenizer st;
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    Stack<Pair> s = new Stack<>();
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=1;i<=n;i++) {
	    	int h = Integer.parseInt(st.nextToken());
	    	
	    	while(!s.isEmpty()) {
	    		// 이 전의 타워들 중 현재 타워보다 높은 타워가 있다면 
	    		if(s.peek().h >= h) {
	    			// 신호가 전파된 것이므로 높은 타워의 인덱스 출력
	    			sb.append(s.peek().index).append(' ');
	    			break;
	    		}
	    		
	    		// 이 전의 타워의 높이가 낮으므로 제거해준다 
	    		s.pop();
	    	}
	    	
	    	// 이 전의 타워들이 모두 낮아서 신호가 전파되지 못했다
	    	if(s.isEmpty())
	    		sb.append("0 ");
	    	
	    	// 현재 타워의 높이를 저장한다
	    	s.push(new Pair(i,h));
	    }	
	    
	    System.out.println(sb.toString());
	}
}

class Pair {
	int index;
	int h;
	public Pair(int index, int h) {
		this.index = index;
		this.h = h;
	}
}