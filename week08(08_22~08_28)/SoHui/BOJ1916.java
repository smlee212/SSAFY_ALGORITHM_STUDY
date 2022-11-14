import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int vertex,weight;
		Node next;
		
		Node(int vertex,int weight,Node next){
			this.vertex=vertex;
			this.weight=weight;
			this.next=next;
		}
		
		Node(int vertex,int weight){
			this.vertex=vertex;
			this.weight=weight;
		}
	}
	static int n,m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine())+1;
		m=Integer.parseInt(br.readLine());
		
		Node[] bus=new Node[n];
		
		for(int i=0;i<m;i++) {
			StringTokenizer str=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(str.nextToken());
			int to=Integer.parseInt(str.nextToken());
			int weight=Integer.parseInt(str.nextToken());
			
			bus[from]=new Node(to,weight,bus[from]);
		}
		
		StringTokenizer str=new StringTokenizer(br.readLine());
		int start=Integer.parseInt(str.nextToken());
		int end=Integer.parseInt(str.nextToken());
		
		int[] dis=new int[n];
		boolean[] v=new boolean[n];
		
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq=new PriorityQueue<>((v1,v2)->v1.weight-v2.weight);
		
		dis[start]=0;
		pq.offer(new Node(start,dis[start]));
		
		while(!pq.isEmpty()) {
			Node minNode=pq.poll();
			
			if(v[minNode.vertex]) continue;
			
			v[minNode.vertex]=true;
			
			for(Node tmp=bus[minNode.vertex]; tmp!=null; tmp=tmp.next) {
				if(!v[tmp.vertex] && dis[tmp.vertex]>tmp.weight+dis[minNode.vertex]) {
					dis[tmp.vertex]=tmp.weight+dis[minNode.vertex];
					pq.offer(new Node(tmp.vertex,dis[tmp.vertex]));
				}
			}
		}
		
		System.out.println(dis[end]);
	}

}
