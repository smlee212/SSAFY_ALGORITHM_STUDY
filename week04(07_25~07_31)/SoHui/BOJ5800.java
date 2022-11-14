import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int K=sc.nextInt();
		int[][] res=new int[K+1][3]; // 결과값들을 저장할 배열
		for(int tc=1;tc<=K;tc++) {
			int student=sc.nextInt();
			Integer[] score=new Integer[student];
			int max=Integer.MIN_VALUE;
			int min=Integer.MAX_VALUE;
			
			for (int i = 0; i < score.length; i++) {
				score[i]=sc.nextInt();
				if(max<score[i]) max=score[i];
				if(min>score[i]) min=score[i];
			}
			int gap=Integer.MIN_VALUE;
			Arrays.sort(score,new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2-o1;
				}});
			for(int i=0;i<student-1;i++) {
				gap=Math.max(gap, score[i]-score[i+1]);
 			}
			res[tc][0]=max;
			res[tc][1]=min;
			res[tc][2]=gap;
            
			/*한 번에 출력 될 수 있게 해야함
			 * System.out.println("Class "+tc);
			System.out.println("Max "+max+", Min "+min+", Largest gap "+gap);*/
		}
		for(int i=1;i<=K;i++) {
			System.out.println("Class "+ i);
			System.out.println("Max "+res[i][0]+", Min "+res[i][1]+", Largest gap "+res[i][2]);
		}
	}
}
