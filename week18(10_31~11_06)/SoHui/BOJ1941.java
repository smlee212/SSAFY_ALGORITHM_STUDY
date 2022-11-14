import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][] friends;
	static int[] sel;
	static boolean[] visited;
	static int res = 0;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		friends = new char[5][5];
		sel = new int[7];
		visited=new boolean[25];
		
		int somCnt = 0; // 이다솜파
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				friends[i][j] = str.charAt(j);
				if (friends[i][j] == 'S')
					somCnt++;
			}
		}

		// 이다솜파가 4명 미만이면 탐색할 필요 없음
		if (somCnt < 4)
			res = 0;
		else {
			union(0,0);
		}
		
		System.out.println(res);
	}

	private static void union(int idx,int start) {

		if (idx == 7) {
			if(check())
				res++;
			return;
		}
		//0~25 까지 조합
		for(int i=start;i<25;i++) {
			if(!visited[i]) {
				visited[i]=true;
				sel[idx]=i;
				union(idx+1, i+1);
				visited[i]=false;
			}
		}
	}

	private static boolean check() {
		//학생들끼리 인접해있는지 확인
		// 도연파가 몇 명인지 확인
		int yeonCnt=0;
		ArrayList<Integer> tmp=new ArrayList<>();
		for(int i=0;i<7;i++) {
			tmp.add(sel[i]); //학생들의 정보 우선 저장
			int r=sel[i]/5;
			int c=sel[i]%5;
			if(friends[r][c]=='Y')
				yeonCnt++;
		}
		
		if(yeonCnt>=4) return false;
		
		//조건에 맞으면 인접한지 확인
		Queue<Integer> q=new LinkedList<>();
		
		q.offer(sel[0]); //첫 번째 학생 넣기
		
		while(!q.isEmpty()) {
			int cur=q.poll();
			
			for(int i=0;i<4;i++) {
				int rr=cur/5+dr[i];
				int cc=cur%5+dc[i];
				
				if(rr<0||rr>=5||cc<0||cc>=5) continue;
				if(tmp.contains(rr*5+cc)) {
					q.offer(rr*5+cc);
					tmp.remove(Integer.valueOf(rr*5+cc));
				}
			}
		}
		
		if(!tmp.isEmpty()) return false;
		
		return true;
	}



}