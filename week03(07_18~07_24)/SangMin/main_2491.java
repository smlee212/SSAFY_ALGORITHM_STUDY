import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int maxL = 0;
		int cnt = 1;
		
		for(int i=1;i<n;i++) {
			if(arr[i-1]<=arr[i]) {
				cnt++;
			}
			else {
				maxL = Math.max(maxL, cnt);
				cnt = 1;
			}
		}
		maxL = Math.max(maxL, cnt);
		cnt = 1;
		
		for(int i=1;i<n;i++) {
			if(arr[i-1]>=arr[i]) {
				cnt++;
			}
			else {
				maxL = Math.max(maxL, cnt);
				cnt = 1;
			}
		}
		maxL = Math.max(maxL, cnt);	

		
		System.out.println(maxL);
	}

}
