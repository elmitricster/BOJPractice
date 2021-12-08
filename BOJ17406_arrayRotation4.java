import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17406_arrayRotation4 {
	//반시계 방향 (하우상좌)
	private static int[] dr = {1, 0, -1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	private static int[][] map, mapClone; // 원본 map과 한번의 순열마다 변화시킬 mapClone 변수
	private static int N, M, K; // 주어진 제한을 저장할 변수
	private static Pair[] set; // 회전 연산을 순열로 뽑아 저장할 변수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 행(row) 제한
		M = Integer.parseInt(st.nextToken()); // 열(column) 제한
		K = Integer.parseInt(st.nextToken()); // 연산 횟수
		map = new int[N+1][M+1]; // 원본 맵 변수
		mapClone = new int[N+1][M+1]; // 한 번의 순열마다 회전시키며 변화하는 복사본 맵 변수
		
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 1; c <= M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				mapClone[r][c] = map[r][c];
			}
		}
		
		set = new Pair[K]; // 연산의 순서를 순열로 뽑아 저장할 변수
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			set[i] = new Pair(
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));		
		}
		
		answer = Integer.MAX_VALUE; // 정답 변수
		visited = new boolean[K]; // 순열을 뽑을 때, 뽑은 수인지 확인할 변수
		rotateOrder = new int[K]; // 연산의 순서를 순열로 저장할 변수
		
		solve(0); // 연산의 순서를 순열로 뽑고, 회전시키기
		
		System.out.println(answer);
	}

	private static int answer;
	private static boolean[] visited;
	private static int[] rotateOrder;
	
	private static void solve(int len) {
		if (len == K) { // 주어진 연산 횟수만큼 뽑았다면,
			for (int i = 0; i < K; i++) { // 하나씩 회전시켜본다
				rotate(set[rotateOrder[i]]); // 회전시키기
			}
			int tmp = getMinsum(); // 회전 후, 가장 작은 행의 값 저장
			answer = answer > tmp ? tmp : answer; // 정답 갱신
			
			// 최적 해를 찾기 위해 맵을 원상복귀 시킨다
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= M; c++) {
					mapClone[r][c] = map[r][c];
				}
			}
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if (!visited[i]) {
				visited[i] = true;
				rotateOrder[len] = i;
				solve(len + 1);
				visited[i] = false;
			}
		}
	}
	
	private static void rotate(Pair pair) {
		for (int s = 1; s <= pair.s; s++) { // 주어진 사이즈만큼 회전시키기
			int r = pair.r - s; // 시작 행
			int c = pair.c - s; // 시작 열
			
			int tmp = mapClone[r][c]; // 시계 방향으로 회전 시 오른쪽 위치에 해당 값을 저장하기 위해 임시 저장
			int dir = 0; // 반시계 방향으로 탐색
			
			while (dir < 4) { // 4방향을 모두 돌았다면
				int nR = r + dr[dir];
				int nC = c + dc[dir];
				
				if (nR <= pair.r + s && nC <= pair.c + s && nR >= pair.r - s && nC >= pair.c - s) {
					// 한 방향으로 탐색할 수 있는 경우
					mapClone[r][c] = mapClone[nR][nC];
					r = nR;
					c = nC;
				} else { // 한 방향으로 탐색이 끝난경우
					dir++; // 방향 바꾸기
				}
			}
			mapClone[pair.r-s][pair.c-s+1] = tmp; // 회전을 모두 끝냈으므로, 시작값을 바로 오른쪽에 저장한다
		}
	}
	
	private static int getMinsum() {
		int min = Integer.MAX_VALUE;
		for (int r = 1; r <= N; r++) {
			int tmp = 0;
			for (int c = 1; c <= M; c++) {
				tmp += mapClone[r][c];
			}
			min = tmp < min ? tmp : min;
		}
		return min;
	}
	
	private static class Pair {
		int r, c, s;
		
		public Pair(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
}
