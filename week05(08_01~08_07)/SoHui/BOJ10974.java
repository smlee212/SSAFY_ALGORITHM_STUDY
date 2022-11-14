import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr= new int [n];
		for (int i = 0; i < n ; i++) {
			arr[i]=i+1;
		}
		
		int[] sel=new int[arr.length];
		
		boolean[] visited=new boolean[arr.length];
		
		recursive(arr,sel,visited,0);
	}
	
	static int cnt=0;
	
	private static void recursive(int[] arr, int[] sel, boolean[] visited, int idx) {
		// TODO Auto-generated method stub
		if(idx==sel.length) {
			for(int i=0;i<sel.length;i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			
			return;
		}
		
		
		for(int i=0;i<arr.length;i++) {
			if(visited[i]==false) {
				visited[i]=true;
				sel[idx]=arr[i];
				recursive(arr,sel,visited,idx+1);
				visited[i]=false;
			}
		}
	}
}