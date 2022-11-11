import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static final int N = 6;
	static boolean isAble;
	static int matchSize;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		matchSize = 0;
		for(int i=1;i<N;i++) {
			matchSize += i;
		}

		for(int t=0;t<4;t++) {
			Country[] arr = new Country[N];
			
			st = new StringTokenizer(br.readLine());
							
			isAble = true;
			for(int i=0;i<N;i++) {
				int w = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				arr[i] = new Country(w, d, l);
				
				if(w+d+l != N-1) {
					isAble = false;	
					break;
				}
			}
			
			if(!isAble) {
				sb.append("0 ");
				continue;
			}
			
			int[][] match = new int[matchSize][2];
			
			for(int i=0,index=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					match[index][0] = i;
					match[index++][1] = j;					
				}
			}
			
			isAble = false;
			
			func(arr,match,0);
			
			sb.append(isAble?1:0).append(" ");
		}
		System.out.println(sb);
	}
	
	public static void func(Country[] C, int[][] match, int time) {
		if(isAble) {
			return;
		}
		
		if(time==matchSize) {
			isAble = true;
			return;
		}
		
		int team1 = match[time][0];
		int team2 = match[time][1];
		
		// team 1이 이겼을 경우
		if(C[team1].win>0 && C[team2].lose>0) {
			C[team1].win--;
			C[team2].lose--;
			func(C,match,time+1);
			C[team1].win++;
			C[team2].lose++;
		}
		
		// team 1이 졌을 경우
		if(C[team1].lose>0 && C[team2].win>0) {
			C[team1].lose--;
			C[team2].win--;
			func(C,match,time+1);
			C[team1].lose++;
			C[team2].win++;
		}
				
		// team 1이 비겼을 경우
		if(C[team1].draw>0 && C[team2].draw>0) {
			C[team1].draw--;
			C[team2].draw--;
			func(C,match,time+1);
			C[team1].draw++;
			C[team2].draw++;
		}
	}
}

class Country{
	int win;
	int draw;
	int lose;
	public Country(int win, int draw, int lose) {
		super();
		this.win = win;
		this.draw = draw;
		this.lose = lose;
	}
}
