import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc= new Scanner(System.in);
		int n=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> cRoom=new PriorityQueue<>();
		classRoom[] arr= new classRoom[n];
		for(int i=0;i<n;i++) {
			StringTokenizer str= new StringTokenizer(br.readLine());
			arr[i]=new classRoom(Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken())); 
		}
		
		Arrays.sort(arr);
		
		cRoom.offer(arr[0].end);
		
		for(int i=1;i<n;i++) {
			if(arr[i].start>=cRoom.peek()) {
				cRoom.poll();
			}
			cRoom.offer(arr[i].end);
		}
		
		System.out.println(cRoom.size());
		
	}
	
	static public class classRoom implements Comparable<classRoom> {
		int start, end;
		
		classRoom(int start,int end){
			this.start=start;
			this.end=end;
		}

		@Override
		public int compareTo(classRoom o) {
			// TODO Auto-generated method stub
			if(this.start==o.start) return this.end-o.end;
			return this.start-o.start;
		}
	}

}
