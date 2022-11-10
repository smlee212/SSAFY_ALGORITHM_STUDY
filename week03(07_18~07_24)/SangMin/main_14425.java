import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String,Integer> map = new HashMap<>();
		
		for(int i=0;i<n;i++) {
			map.put(br.readLine(),i);			
		}
		
		String str = "";
		int cnt = 0;
		for(int i=0;i<m;i++) {
			str = br.readLine();
			if(map.get(str) != null) {
				cnt++;
			}			
		}
		System.out.println(cnt);		
	}
}
