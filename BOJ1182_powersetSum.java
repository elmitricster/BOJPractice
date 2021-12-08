import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182_powersetSum {
	static int N, S;
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		powerSet(arr, N, 0, 0);
		
		if (S == 0) {
			cnt--;
		}
		
		System.out.println(cnt);
	}
	
	static void powerSet(int[] arr, int n, int idx, int sum) {
		if (idx == n) {
			if (sum == S) {
				cnt++;
			}
			return;
		}
		
		powerSet(arr, n, idx+1, sum);
		powerSet(arr, n, idx+1, sum+arr[idx]);	
	}

}
