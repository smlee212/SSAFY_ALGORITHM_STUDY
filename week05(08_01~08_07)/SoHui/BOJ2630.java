import java.util.Scanner;

public class Main {
	public static int w_cnt=0; // 흰 색종이
	public static int b_cnt=0; // 파랑 색종이
	public static int[][] arr; //전체 맵
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		arr=new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		/*for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}*/
		
		Color(0,0,n);
		
		System.out.println(w_cnt);
		System.out.println(b_cnt);
	}
	
	private static void Color(int r, int c, int size) {
		// TODO Auto-generated method stub
		boolean flag=true;
		int color=arr[r][c]; //각 영역의 첫 번째 요소 기준
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				if(arr[i][j]!=color)
					flag=false; // 분할 해야함
			}
		}
		
		if(flag) {
			if(arr[r][c]==0) {
				w_cnt++;
			}
			else {
				b_cnt++;
			}
			
			return;
		}
		
		//재귀 돌리기
		
		int resize=size/2;
		
		Color(r,c,resize); //1구역
		Color(r,c+resize,resize); //2구역
		Color(r+resize,c,resize); // 3구역
		Color(r+resize,c+resize,resize);//4구역
	}
}