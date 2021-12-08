import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2636_cheese {
	static int N, M, cheese, cnt, time;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					cheese++;
				}
			}
		}
		
		while (cheese != 0) {
			time++;
			cnt = cheese;
			bfs();
		}	
		
		System.out.println(time);
		System.out.println(cnt);
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {0, 0});
		v = new boolean[N][M];
		v[0][0] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || v[nx][ny]) {
					continue;
				}
				
				if (map[nx][ny] == 1) {
					cheese--;
					map[nx][ny] = 0;
				} else if (map[nx][ny] == 0) {
					q.offer(new int[] {nx, ny});
				}
				
				v[nx][ny] = true;
			}
		}
	}
	
}
