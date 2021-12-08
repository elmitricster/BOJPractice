import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1463_make1 {
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1000001];
		dp[2] = 1;
		dp[3] = 1;
		
		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i-1] + 1;
			
			if (i % 3 == 0) {
				if (dp[i/3] < dp[i]) {
					dp[i] = dp[i/3] + 1;
				}
			}
			
			if (i % 2 == 0) {
				if (dp[i/2] < dp[i]) {
					dp[i] = dp[i/2] + 1;
				}
			}
		}
		
		System.out.println(dp[n]);
		
	}

}
