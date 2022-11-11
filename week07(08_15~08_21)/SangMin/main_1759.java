import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int l,c;
	static char[] input, temp;
	static boolean[] isVowel;
	static char[] vowel = {'a','e','i','o','u'};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		input = new char[c];
		temp = new char[l]; // 선택할 알파벳 배열
		isVowel = new boolean[c]; // 
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<c;i++) {
			input[i] = st.nextToken().charAt(0); 
		}

		Arrays.sort(input);
		
		for(int i=0;i<c;i++) {
			// 입력받은 알파벳이 모음인지 확인
			for(int j=0;j<5;j++) {
				if(input[i]==vowel[j]) {
					isVowel[i] = true;					
					break;
				}
			}	
		}
		
		dfs(0,0,0,0);
		
		System.out.println(sb);
		
	}
	
	public static void dfs(int now, int cnt, int vCount, int cCount) {
		if(cnt==l) {
			if(vCount>=1 && cCount>=2) {
				for(char c : temp) {
					sb.append(c);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i=now;i<c;i++) {
			temp[cnt] = input[i];
			
			if(isVowel[i]) 
				dfs(i+1,cnt+1,vCount+1,cCount);				
			else 
				dfs(i+1,cnt+1,vCount,cCount+1);		
		}
	}
}
