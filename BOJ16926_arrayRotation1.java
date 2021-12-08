import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16926_arrayRotation1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer buf = new StringBuffer();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int t = 0; t < R; t++) {
			int start_i = 0;
			int start_j = 0;
			int s_N = N;
			int s_M = M;
			
			while (true) {
				if (start_i >= s_N || start_j >= s_M) {
					break;
				}
				
				int tmp1 = arr[start_i][start_j];
				int tmp2 = 0;
				
				for (int i = start_i + 1; i < s_N; i++) {
					tmp2 = arr[i][start_j];
					arr[i][start_j] = tmp1;
					tmp1 = tmp2;
				}
				for (int j = start_j + 1; j < s_M; j++) {
					tmp2 = arr[s_N - 1][j];
					arr[s_N - 1][j] = tmp1;
					tmp1 = tmp2;
				}
				for (int i = s_N - 2; i >= start_i; i--) {
					tmp2 = arr[i][s_M - 1];
					arr[i][s_M - 1] = tmp1;
					tmp1 = tmp2;
				}
				for (int j = s_M - 2; j >= start_j; j--) {
					tmp2 = arr[start_i][j];
					arr[start_i][j] = tmp1;
					tmp1 = tmp2;
				}
				
				start_i++;
				start_j++;
				s_N--;
				s_M--;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				buf.append(arr[i][j] + " ");
			}
			buf.append("\n");
		}
		
		System.out.println(buf);
	}
}
