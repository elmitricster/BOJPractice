import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600_horseMonkey {
	static int K, R, C;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[] dhx = {-1, -2, -1, -2, 1, 2, 1, 2};
	static int[] dhy = {-2, -1, 2, 1, -2, -1, 2, 1};
	static int result = -1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C][K+1];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {0, 0, 0, 0});
		while (!q.isEmpty()) {
			int[] data = q.poll();
			int x = data[0];
			int y = data[1];
			int k = data[2];
			int tr = data[3];
			
			if (x == R-1 && y == C-1) {
				result = tr;
				break;
			}
			
			if (k < K) {
				for (int i = 0; i < 8; i++) {
					int nx = x + dhx[i];
					int ny = y + dhy[i];
					if (nx < 0 || ny < 0 || nx >= R || ny >= C)
						continue;
					if (map[nx][ny] == 1)
						continue;
					if (visited[nx][ny][k+1])
						continue;
					visited[nx][ny][k+1] = true;
					q.add(new int[] {nx, ny, k+1, tr+1});
				}
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue;
				if (map[nx][ny] == 1)
					continue;
				if (visited[nx][ny][k])
					continue;
				visited[nx][ny][k] = true;
				q.add(new int[] {nx, ny, k, tr+1});
			}
		}
		
		System.out.println(result);
	}

}
