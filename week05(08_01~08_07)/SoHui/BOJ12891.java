import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner sc=new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str=new StringTokenizer(br.readLine());
		
		int s=Integer.parseInt(str.nextToken());
		int p=Integer.parseInt(str.nextToken());
		
		String dna=br.readLine();
		int[] num=new int[4]; //각 알파벳의 기준 갯수
		int pass_cnt=0;
		int[] cnt=new int[4]; //A=0번인덱스  C=1, G=2,T=3;
		str=new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			num[i]=Integer.parseInt(str.nextToken());
		}
		
		for(int i=0;i<p;i++) {
			switch(dna.charAt(i)){
			case 'A':
				cnt[0]++;
				break;
			case 'C':
				cnt[1]++;
				break;
			case 'G':
				cnt[2]++;
				break;
			case 'T':
				cnt[3]++;
				break;
			}
		}
		if(cnt[0]>=num[0] && cnt[1]>=num[1] && cnt[2]>=num[2] && cnt[3]>=num[3]) pass_cnt++;
		for (int i = 0; i < s-p; i++) {
			if(dna.charAt(i)=='A') cnt[0]--;
			if(dna.charAt(i)=='C') cnt[1]--;
			if(dna.charAt(i)=='G') cnt[2]--;
			if(dna.charAt(i)=='T') cnt[3]--;
			
			if(dna.charAt(i+p)=='A') cnt[0]++;
			if(dna.charAt(i+p)=='C') cnt[1]++;
			if(dna.charAt(i+p)=='G') cnt[2]++;
			if(dna.charAt(i+p)=='T') cnt[3]++;
			
			if(cnt[0]>=num[0] && cnt[1]>=num[1] && cnt[2]>=num[2] && cnt[3]>=num[3]) pass_cnt++;
		}
		
		System.out.println(pass_cnt);

	}
	

}