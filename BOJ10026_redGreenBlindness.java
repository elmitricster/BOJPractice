import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10026_redGreenBlindness {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0 , -1, 1};
	static int N;
	static char[][] map, map2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		map2 = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j); // 정상
				if(s.charAt(j) == 'G') // 적록색약 (G일경우 R로 저장)
					map2[i][j] = 'R';
				else map2[i][j] = s.charAt(j);
			}
		}
		
		int cnt = 0; // 정상
		int cnt2 = 0; // 적록색약
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 'X') { // 정상 : 방문하지 않은 곳이면
					dfs(i, j, map[i][j]);
					cnt++;
				}
				
				if (map2[i][j] != 'X') { // 적록색약 : 방문하지 않은 곳이면
					dfs2(i, j, map2[i][j]);
					cnt2++;
				}
			}
		}
		
		System.out.println(cnt + " " + cnt2);

	}
	
	// 정상
	public static void dfs(int x, int y, char color) {
		map[x][y] = 'X'; // 방문 처리
		
		for (int d = 0; d < 4; d++) {
			int xx = x + dx[d];
			int yy = y + dy[d];
			
			if (xx < 0 || yy < 0 || xx >= N || yy >= N) // 범위를 넘어가면 pass
				continue;
			if (map[xx][yy] == 'X') // 이미 방문한 곳이면 pass
				continue;
			if (color != map[xx][yy]) // 색이 있는데 다른 색이면
				continue;
			
			dfs(xx, yy, map[xx][yy]);
		}
	}
	
	// 적록색약
	public static void dfs2(int x, int y, char color) {
		map2[x][y] = 'X'; // 방문 처리
		
		for (int d = 0; d < 4; d++) {
			int xx = x + dx[d];
			int yy = y + dy[d];
			
			if (xx < 0 || yy < 0 || xx >= N || yy >= N) // 범위를 넘어가면 pass
				continue;
			if (map2[xx][yy] == 'X') // 이미 방문한 곳이면 pass
				continue;
			if (color != map2[xx][yy]) // 색이 있는데 다른 색이면
				continue;
			
			dfs2(xx, yy, map2[xx][yy]);
		}
	}
	
}
