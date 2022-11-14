import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();		
		for(int tc=1;tc<=T;tc++) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			Queue<Pair> q=new LinkedList<>(); //c++ 에서 썼던 pair 가 생각나서 그렇게 풀어봄
			
			for(int j=0;j<n;j++) { //큐에 현재 순서와 우선 순위 정보 담기
				q.add(new Pair (j,sc.nextInt()));
			}
			
			int cnt=0; //출력되는 순서
			while(!q.isEmpty()) {
				Pair tmp=q.poll();
				boolean flag = true; //우선 순위가 제일 큰지 확인
				
				for (Pair temp : q) {
					if(temp.y>tmp.y) { //맨 앞 보다 우선 순위 높은 애가 있을 경우
						flag=false;
						break;
					}
				}
				
				if(flag) {
					cnt++;
					if(tmp.x==m) break;
				}
				else {
					q.add(tmp); //맨뒤로 보내기
				}	
			}
			System.out.println(cnt);
		}
	}
	
	public static class Pair{
		int x,y;
		Pair(int x,int y){
			this.x=x;
			this.y=y;
		}
		
	}
}