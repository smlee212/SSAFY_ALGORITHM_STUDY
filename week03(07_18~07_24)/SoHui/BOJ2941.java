import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] find_str= {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		String str=sc.next();
		
		for(int i=0;i<find_str.length;i++) {
			if(str.contains(find_str[i]))
				str=str.replace(find_str[i], "0");
		}
		
		System.out.print(str.length());
	}

}