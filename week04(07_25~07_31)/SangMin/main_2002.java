import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int n = Integer.parseInt(br.readLine());
		HashMap<String,Integer> car = new HashMap<>();
		for(int i=1;i<=n;i++) {
			car.put(br.readLine(), i);
		}
		int[] res = new int[n];
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			res[i] = car.get(str);
		}
		int cnt = 0;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(res[i]>res[j]) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}