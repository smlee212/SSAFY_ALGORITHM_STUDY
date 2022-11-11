import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

class Main {
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		int[] num = new int[N];
		
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);
		
		long sum = 0;
		
		for(int i=0;i<N;i++) {
			sum += Math.abs(num[i] - (i+1));
		}
		
		System.out.println(sum);
    }
}
