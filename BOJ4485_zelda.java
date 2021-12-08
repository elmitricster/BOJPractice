import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4485_zelda {
	static class Point implements Comparable<Point> {
		int r, c, rupee;
		
		public Point(int r, int c, int rupee) {
			super();
			this.r = r;
			this.c = c;
			this.rupee = rupee;
		}
		
		@Override
		public int compareTo(Point o) {
			int diff = this.rupee - o.rupee;
			return diff;
		}
	}
	
	static int N;
	static int[][] map, distance;
	static int min;
	static int[] dr = {-1, 1, 0 ,0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			
			map = new int[N][N];
			distance = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}
			
			sb.append("Problem " + cnt++ + ": " + dijkstra());
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int dijkstra() {
		distance[0][0] = map[0][0];
		
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.add(new Point(0, 0, map[0][0]));
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (distance[nr][nc] > distance[cur.r][cur.c] + map[nr][nc]) {
						distance[nr][nc] = distance[cur.r][cur.c] + map[nr][nc]; 
						pq.add(new Point(nr, nc, distance[nr][nc]));
					}
				}
			}
		}
		return distance[N-1][N-1];
	}
	
}


/*
 * bfs
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map, rupeeMap;
	static int N;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static private class Pos {
		int x;
		int y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		int t = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			map = new int[N][N];
			rupeeMap = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					rupeeMap[i][j] = Integer.MAX_VALUE;
				}
			}
			rupeeMap[0][0] = map[0][0];
			bfs();
			bw.append("Problem " + t + ": " + rupeeMap[N - 1][N - 1] + "\n");
			t++;
		}
		bw.flush();
		bw.close();
	}

	private static void bfs() {
		Deque<Pos> queue = new ArrayDeque<>();
		queue.add(new Pos(0, 0));
		while (!queue.isEmpty()) {
			int nx, ny;
			Pos pos = queue.poll();
			int x = pos.x;
			int y = pos.y;
			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (!isRange(nx, ny))
					continue;
				if (rupeeMap[nx][ny] <= rupeeMap[x][y] + map[nx][ny])
					continue;
				rupeeMap[nx][ny] = rupeeMap[x][y] + map[nx][ny];
				queue.add(new Pos(nx, ny));
			}
		}
	}

	private static boolean isRange(int x, int y) {
		return x < 0 || y < 0 || x >= N || y >= N ? false : true;
	}

}
*/