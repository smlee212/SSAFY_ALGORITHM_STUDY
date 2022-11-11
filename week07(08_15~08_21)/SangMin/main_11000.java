import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static ArrayList<Pair> arr; 
	static boolean[] visited;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());		
		arr = new ArrayList<>();
		visited = new boolean[n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		// 시작 시간 순으로 정렬
		Collections.sort(arr);
		
		// 종료 시간을 넣어줌		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(arr.get(0).end);
		
		// 일찍 종료되는 강의실을 기준으로 다음 강의실과 비교한다
		for(int i=1;i<n;i++) {
			if(pq.peek() <= arr.get(i).start) {
				pq.poll();
			}
			
			pq.add(arr.get(i).end);
		}
		
		System.out.println(pq.size());
	}
	
}

class Pair implements Comparable<Pair>{
	int start;
	int end;
	Pair(int s,int e){
		start=s;
		end=e;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.start==o.start) return this.end-o.end;
		return this.start-o.start;
	}	
}