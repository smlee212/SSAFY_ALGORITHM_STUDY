import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		HashSet<String> memo = new HashSet<>();
		for(int i=0;i<n;i++) {
			memo.add(br.readLine());
		}
		
		for(int i=0;i<m;i++) {
			String[] blog = br.readLine().split(",");
			
			for(String str : blog) {
				if(memo.contains(str)) {
					memo.remove(str);
				}
			}
			
			sb.append(memo.size()).append("\n");
		}	
		System.out.println(sb);
	}
}
