import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long sum = 0;	// 불만도 합 최솟값
		int[] arr = new int[N];
		
		for(int i=0; i<arr.length; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length; i++) {
			sum += Math.abs(arr[i] - (i+1));			
		}
		
		System.out.println(sum);

	}

}