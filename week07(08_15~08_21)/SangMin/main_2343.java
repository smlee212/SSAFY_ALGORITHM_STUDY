import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer; 

class Main {
	static int n,m;
	static int[] map;
    
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int l=0, r=0, mid;
		map = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			map[i] = Integer.parseInt(st.nextToken());
			r += map[i];
			l = Math.max(l, map[i]);
		}
		
		int minRes = r;
		while(l<=r) {
			mid = (l+r)/2;
			
			int mCnt = divide(mid);
			
			if(mCnt>m) {
				l = mid+1;
			}
			else {
				minRes = mid;
				r = mid-1;
			}		
		}		
		
		System.out.println(minRes);
	}	
	
	public static int divide(int len) {
		int sum = 0;
		int cnt = 1;
		for(int i : map) {
			sum += i;
			if(sum > len) {
				sum = i;
				cnt++;
			}
		}
		return cnt;
	}
}