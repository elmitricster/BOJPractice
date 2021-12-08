import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109_bakery {
	static int R, C, answer;
	static char map[][];
	static boolean visited[][];
	static int[] direction = {-1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) { // 0행 ~ R-1행
			visited[i][0] = true;
			dfs(i, 0);
		}
		
		System.out.println(answer);
	}
	
	public static boolean dfs(int r, int c) {
		if(c == C-1) { // 오른쪽 끝까지 연결되었다면
			answer++;
			return true;
		}
		
		for (int d = 0; d < 3; d++) {
			int dr = r + direction[d];
			int dc = c + 1;
			
			if (dr < 0 || dr >= R)
				continue;
			if (map[dr][dc] == 'x' || visited[dr][dc]) // 건물이 있거나, 파이프가 이미 설치되었다면
				continue;
			
			visited[dr][dc] = true; // 해당 공간에 파이프 설치
			
			if (dfs(dr, dc)) // 해당 방향으로 파이프가 설치되었으면 다른 방향은 확인할 필요 없음
				return true; 
		}
		return false; // 파이프를 끝까지 설치 못했을 경우 전부 다시 false로 리턴
	}

}
