import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987_alphabet {
	static int R, C, answer;
	static char[][] board;
	static boolean[] visited;
	static int dy[] = {-1, 0, 1 ,0};
	static int dx[] = {0, -1, 0, 1};
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		visited = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		dfs(0, 0, 1);
		
		System.out.println(answer);
	}

	public static void dfs(int y, int x, int cnt) {
		visited[board[y][x] - 'A'] = true; // 알파벳 방문 처리
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			// 이미 방문한 알파벳이거나 범위를 벗어나면
			if (ny < 0 || nx < 0 || ny >= R || nx >= C || visited[board[ny][nx] - 'A'])
				continue;
			
			// 다음 방문 검사
			dfs(ny, nx, cnt+1);
		}
		
		visited[board[y][x] - 'A'] = false; // 다음 방문을 위해 방문 처리 해제
		answer = (answer > cnt) ? answer : cnt;
	}
	
}
