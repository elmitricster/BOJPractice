import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502_lab {
	static int N, M, wallCnt, answer;
	static int[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static class Virus {
		int y, x;
		
		public Virus(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

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
			}
		}
		
		wallCnt = 0;
		answer = 0;
		dfs(wallCnt);
		
		System.out.println(answer);
	}
	
	public static void dfs(int wallCnt) {
		if (wallCnt == 3) {  // 벽이 3개 세워지면
			bfs();  		 // 바이러스 뿌리기
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {	// 만약 빈 공간이면
					map[i][j] = 1;		// 벽을 세우고
					dfs(wallCnt + 1);	// 벽 카운트를 증가시키고
					map[i][j] = 0;	 	// 다시 원래대로 되돌리고
				}
			}
		}
	}
	
	public static void bfs() {
		Queue<Virus> q = new LinkedList<>();
		int[][] copyMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];     // 벽이 3개 세워질 때마다 원본 map을 복사해서 복사된 맵 사용
				if (map[i][j] == 2)
					q.offer(new Virus(i, j));  // 바이러스 좌표를 큐에 추가
			}
		}
		
		while (!q.isEmpty()) {
			Virus cur = q.poll();
			for (int d = 0; d < 4; d++) {  // 바이러스를 4방향으로 뿌리기 시작
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				
				if (ny >= 0 && ny < N && nx >= 0 && nx < M && copyMap[ny][nx] == 0) {
					copyMap[ny][nx] = 2;
					q.offer(new Virus(ny, nx));
				}
			}
		}
		
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0)
					cnt++;
			}
		}
		
		answer = Math.max(answer, cnt);
	}
	
}
