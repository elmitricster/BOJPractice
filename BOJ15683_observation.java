import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15683_observation { 
	public static class Cctv { // cctv의 정보를 담을 객체
		int y, x, type;
		
		public Cctv(int y, int x, int type) {
			this.y = y;
			this.x = x;
			this.type = type;
		}
	}
	
	static int N, M, answer;
	static List<Cctv> cctvs;
	static int[] cctvDir;
	static int[][] map;
	static int[][] obs;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1}; // 우 상 좌 하

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		obs = new int[N][M];
		cctvs = new ArrayList<Cctv>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] > 0 && map[i][j] < 6) { // cctv인 경우에만
					cctvs.add(new Cctv(i, j, map[i][j]));
				}
			}
		}
		
		cctvDir = new int[cctvs.size()];
		answer = Integer.MAX_VALUE;
		
		dfs(0);
		
		System.out.println(answer);
	}
	
	// 맵 복사
	public static void copy(int[][] origin, int[][] target) { 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				target[i][j] = origin[i][j];
			}
		}
	}
	
	public static void dfs(int cnt) {
		if (cnt == cctvs.size()) { // cctv 배치 완료
			copy(map, obs); // 맵을 복사해서 씀
			
			// 모든 cctv의 정보 가져오기
			for (int i = 0; i < cctvs.size(); i++) { 
				Cctv cctv = cctvs.get(i);
				
				if (cctv.type == 1) { // 1번 카메라 = 한 방향
					observation(cctv.y, cctv.x, cctvDir[i]);
				} else if (cctv.type == 2) { // 2번 카메라 = 선택한 방향 + 180도 방향
					for (int k = 0; k < 2; k++) {
						int dir = (cctvDir[i] + (k*2)) % 4;
						observation(cctv.y, cctv.x, dir);
					}
				} else if (cctv.type == 3) { // 3번 카메라 = 선택한 방향 + 90도 방향
					for (int k = 0; k < 2; k++) {
						int dir = (cctvDir[i] + k) % 4;
						observation(cctv.y, cctv.x, dir);
					}
				} else if (cctv.type == 4) { // 4번 카메라 = 선택한 방향 + 90도 + 180도 방향
					for (int k = 0; k < 3; k++) {
						int dir = (cctvDir[i] + k) % 4;
						observation(cctv.y, cctv.x, dir);
					}
				} else if (cctv.type == 5) { // 5번 카메라 = 4방향
					for (int k = 0; k < 4; k++) {
						observation(cctv.y, cctv.x, k);
					}
				}
			}
			
			// 0의 갯수를 카운팅
			int blindArea = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (obs[i][j] == 0) {
						blindArea++;
					}
				}
			}
			
			answer = (answer > blindArea) ? blindArea : answer;
			
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			cctvDir[cnt] = i;
			dfs(cnt+1);
		}
	}
	
	public static void observation(int y, int x, int dir) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		
		while (ny >= 0 && nx >= 0 && ny < N && nx < M) {
			if (obs[ny][nx] == 6) { // 벽이면
				return;
			}
			
			if (obs[ny][nx] == 0) { // 빈 칸이면
				obs[ny][nx] = -1; // -1로 바꿔줌
			}
			
			ny += dy[dir];
			nx += dx[dir];
		}
	}

}
