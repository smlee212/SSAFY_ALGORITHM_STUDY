import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		
		int x=0,y=0; //로봇의 위치
		int r_dir=2; //1:북 2:동 3:남 4:서
		for(int i=0;i<n;i++) {
			String command=sc.next();
			int dir=sc.nextInt();
			if(command.equals("TURN")) {
				if(dir==0) {
					r_dir=r_dir%4+3;
					if(r_dir>4) {
						r_dir-=4;
					}
				}
				else if(dir==1) {
					r_dir=r_dir%4+1;
				}
			}
			else if(command.equals("MOVE")) {
				if(r_dir==1) {
					if(x+dir>m) {
						System.out.println("-1");
						System.exit(0);
					}
					x+=dir;
				}
				else if(r_dir==2) {
					if(y+dir>m) {
						System.out.println("-1");
						System.exit(0);
					}
					y+=dir;
				}
				else if(r_dir==3) {
					if(x-dir<0) {
						System.out.println("-1");
						System.exit(0);
					}
					x-=dir;
				}
				else if(r_dir==4) {
					if(y-dir<0) {
						System.out.println("-1");
						System.exit(0);
					}
					y-=dir;
				}
			}
		}
		
		System.out.println(y+" "+x);
				
	}

}