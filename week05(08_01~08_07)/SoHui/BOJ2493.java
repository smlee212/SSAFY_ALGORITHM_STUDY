import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		Stack<Pair> arr=new Stack<>(); //건물들의 높이 저장정보
		StringBuilder sb= new StringBuilder();
		StringTokenizer str=new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int height=Integer.parseInt(str.nextToken());
			
			if(arr.isEmpty()) {
				sb.append("0 ");
				arr.push(new Pair(height,i));
			}
			else {
				while(true) {
					if(arr.isEmpty()) {
						sb.append("0 ");
						arr.push(new Pair(height,i));
						break;
					}
					Pair top=arr.peek();
					
					if(top.height>height) {
						sb.append(top.idx+" "); //나보다 크면 얘의 인덱스 번호 넣기
						arr.push(new Pair(height,i));
						break;
					}
					else {
						arr.pop();
					}

				}
			}
		}
		System.out.println(sb);	
			
	}
	
	static public class Pair{
		int height;
		int idx;
		Pair() {}
		Pair(int height,int idx){
			this.height=height;
			this.idx=idx;
		}
	}
}
