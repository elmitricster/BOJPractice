import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2961_sourBitter {
	static int list[][];
	static long ans = Long.MAX_VALUE;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 1, 0);
		System.out.println(ans);
		
	}
	
	static void dfs(int idx, int sour, int bitter) {
		if (idx > 0)
			ans = Math.min(ans, Math.abs(sour - bitter));
		
		if (idx == N)
			return;
		
		for (int i = idx; i < N; i++) {
			dfs(i+1, sour * list[i][0], bitter + list[i][1]);
		}
	}
}
