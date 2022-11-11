import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Set<Integer> distance = new HashSet<>();		
		int preTree = Integer.parseInt(br.readLine());
		int minDistance = Integer.MAX_VALUE;
		int sum = 0;
		for(int i=1;i<n;i++) {
			int postTree = Integer.parseInt(br.readLine());
			int difDist = postTree - preTree;
			distance.add(difDist); 
			sum += difDist;
			minDistance = Math.min(minDistance, difDist);
			preTree = postTree;					
		}

		for(int i=minDistance;i>0;i--) {
			Iterator<Integer> iter = distance.iterator();
			boolean check = true;
			while(iter.hasNext()) {
				int difDist = iter.next();
				if(difDist%i!=0) {
					check = false;
					break;
				}
			}
			if(check) {
				System.out.println(sum/i-n+1);
				break;
			}
		}
		br.close();
	}

}
