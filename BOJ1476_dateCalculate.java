import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1476_dateCalculate {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 1;
		int e = 1, s = 1, m = 1;
		
		while(true) {
			if (e > 15) {
				e = 1;
			}
			
			if (s > 28) {
				s = 1;
			}
			
			if (m > 19) {
				m = 1;
			}
			
			if (e == E && s == S && m == M) {
				break;
			}
			
			e++;
			s++;
			m++;
			answer++;
		}
		
		System.out.println(answer);
	}

}
