import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		List<Integer> arrList = new ArrayList<>();
		arrList.add(a);
		
		while(true) {
			int temp = arrList.get(arrList.size()-1); // 마지막 원소를 가져온다.
			int res = 0;
			
			// 각 자리 숫자들을 p제곱하여 더한다.
			while(temp!=0) { 
				res += (int)Math.pow(temp%10,(double)p);
				temp /= 10;
			}
			
			// 첫 번째로 중복된 숫자가 나온다면
			// 그 이후로도 중복된 숫자들의 반복이 이어지기 때문에
			// 인덱스를 반환하여 이전까지 나온 원소들의 개수를 출력한다.
			if(arrList.contains(res)) {
				int index = arrList.indexOf(res);
				System.out.println(index);
				break;
			}
			
			// 중복된 원소가 아니라면 리스트에 저장한다.
			arrList.add(res);
		}
		
		br.close();
	}
}

