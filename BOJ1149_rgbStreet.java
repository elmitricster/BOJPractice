import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149_rgbStreet {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][3];
		int[][] dp = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = map[i][j];
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][0] = Math.min(dp[i - 1][1] + map[i][0], dp[i - 1][2] + map[i][0]);
				dp[i][1] = Math.min(dp[i - 1][0] + map[i][1], dp[i - 1][2] + map[i][1]);
				dp[i][2] = Math.min(dp[i - 1][0] + map[i][2], dp[i - 1][1] + map[i][2]);
			}
		}
		
		int answer = Integer.MAX_VALUE;
		
		for (int i = 0; i < 3; i++) {
			if (dp[N-1][i] < answer) {
				answer = dp[N-1][i];
			}
		}
		
		System.out.println(answer);
		
	}

}
