import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc=new Scanner(System.in);
		//자릿수
		n=Integer.parseInt(br.readLine());
		//int[] num= {1,2,3,4,5,6,7,8,9};
		int[] prime= {2,3,5,7}; //한 자리수 소수는 고정
		for (int i = 0; i <4; i++) {
			recursive(prime[i],1);
		}
		
		System.out.println(sb);
	}
	
	
	private static void recursive(int sum, int k) {
		// TODO Auto-generated method stub
		if(k==n) {
			for(int i=2;i<sum;i++) {
				if(sum%i==0) {
					//소수가 아닌경우
					return;
				}
			}
			//소수일 경우 출력
			sb.append(sum+"\n");
			return;
		}
		
//		if(k==1) {
//			for(int i=0;i<num.length;i++) {
//				recursive(num,sum*10+num[i],k+1);
//			}
//		}
		
		for(int i=1;i<=9;i++) {
			for(int j=2;j<sum;j++) {
				if(sum%j==0) {
					//소수가 아닌경우
					return;
				}
			}
			recursive(sum*10+i,k+1);
		}
		
	}

}