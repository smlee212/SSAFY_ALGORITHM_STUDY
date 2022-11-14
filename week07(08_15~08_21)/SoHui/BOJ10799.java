import java.util.Scanner;
import java.io.FileInputStream;

class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc=new Scanner(System.in);

		String str=sc.next();
		String lazer=str.replace("()", "-"); //레이저 부분을 -로 변환
		int stick =0; //막대기
		int tot=0; // 총 막대기 갯수
		for(int i=0;i<lazer.length();i++) {
			if(lazer.charAt(i)=='-') tot+=stick;
			else if(lazer.charAt(i)=='(') {
				stick++;
				tot++;
			}
			else if(lazer.charAt(i)==')') {
				stick--;
			}
		}
		System.out.println(tot);

	}
}