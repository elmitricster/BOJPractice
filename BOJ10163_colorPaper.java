import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10163_colorPaper {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[1001][1001];
		
		for (int t = 1; t <= N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			for (int i = x; i < x+width; i++) {
				for (int j = y; j < y+height; j++) {
					map[i][j] = t;
				}
			}
		}
		
		for (int t = 1; t <= N; t++) {
			int cnt = 0;
			for (int i = 0; i < 1001; i++) {
				for (int j = 0; j < 1001; j++) {
					if(map[i][j] == t) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
