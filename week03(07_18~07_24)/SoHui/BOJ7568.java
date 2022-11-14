
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] height=new int[N];
        int[] weight=new int[N];
        int[] rank=new int[N];
        for(int i=0;i<N;i++){
            //순위배열 1로 초기화
            rank[i]=1;
        }
        
        for(int i=0;i<N;i++){
            //키, 몸무게 입력받기
            height[i]=sc.nextInt();
            weight[i]=sc.nextInt();
        }
        //순위 정하기
        //나보다 키&몸무게 값이 크면 rank[나]++;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(height[i]<height[j] && weight[i]<weight[j]){
                    rank[i]++;
                }
            }
        }
        
        for(int i=0;i<rank.length;i++){
            System.out.print(rank[i]+" ");
        }
		
	}
}  