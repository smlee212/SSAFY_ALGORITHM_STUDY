import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 준현, 성민의 보유 현금
		int JH = n, SM = n;
		// 준현, 성민의 보유 주식 수
		int JHCnt = 0, SMCnt = 0;
		
		// 1일차
		int stock = Integer.parseInt(st.nextToken());
		int preStock = stock;
		JHCnt += JH / stock;
		JH %= stock;
		
		int cnt = 0;
		boolean isUp = true;
		
		// 2일차 ~ 14일차		
		for(int i=1;i<14;i++) {
			stock = Integer.parseInt(st.nextToken());
			JHCnt += JH / stock;
			JH %= stock;
			
			if(isUp && stock>preStock) {
				cnt++;
			}
			else if(!isUp && stock>preStock) {
				isUp = true;
				cnt = 1;
			}
			else if(isUp && stock<preStock) {
				isUp = false;		
				cnt = -1;
			}
			else if(!isUp && stock<preStock) {
				cnt--;
			}
			else {
				cnt = 0;
			}
			
			preStock = stock;
			
			if(cnt>=3 && isUp) {
				SM += SMCnt * stock;
				SMCnt = 0;
			}
			else if(cnt<=-3 && !isUp) {
				SMCnt += SM / stock;
				SM %= stock;
			}
		}
		
		JH += JHCnt * stock;
		SM += SMCnt * stock;

		if(JH>SM) {
			System.out.println("BNP");
		}
		else if(JH<SM) {
			System.out.println("TIMING");
		}
		else {
			System.out.println("SAMESAME");
		}
		
		
	}
}
