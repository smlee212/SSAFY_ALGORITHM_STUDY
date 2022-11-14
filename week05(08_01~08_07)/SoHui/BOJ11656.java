import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		String[] str_=new String[str.length()];
		str_[0]=str;
		for(int i=1;i<str_.length;i++) {
			str_[i]=str.substring(i);
		}
		//
		
		Arrays.sort(str_);
		
		for(int i=0;i<str_.length;i++) {
			System.out.println(str_[i]);
		}
	}

}