import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576_tomato {
	static int N, M;
	static int[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static class Tomato {
		int x;
		int y;
		int day;
		
		public Tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
	}
	
	public static void bfs() {
		Queue<Tomato> q = new LinkedList<Tomato>();
		int day = 0;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1)
					q.offer(new Tomato(i, j, 0));
			}
		}
		
		while (!q.isEmpty()) {
			Tomato tomato = q.poll();
			day = tomato.day;
			
			for (int i = 0; i < 4; i++) {
				int nx = tomato.x + dx[i];
				int ny = tomato.y + dy[i];
				
				if (0 <= nx && nx < M && 0 <= ny && ny < N) {
					if (map[nx][ny] == 0) {
						map[nx][ny] = 1;
						q.add(new Tomato(nx, ny, day+1));
					}
				}
			}
		}
		
		if (check()) {
			System.out.println(day);
		} else {
			System.out.println(-1);
		}	
	}
	
	public static boolean check() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					return false;
			}
		}
		
		return true;
	}

}
