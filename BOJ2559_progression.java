import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2559_progression {
	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += arr[i];
		}
		
		int ans = sum;
		for (int i = K; i < N; i++) {
			sum = sum - arr[i - K] + arr[i];
			ans = Math.max(ans, sum);
		}
		
		System.out.println(ans);
	}

}
