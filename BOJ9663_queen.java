import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9663_queen {
	static int N, answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int queen[] = new int[N]; // queen[열] = 행
		
		dfs(0, queen);
		System.out.println(answer);
		
	}
	
	// DFS 메소드
	public static void dfs(int v, int[] queen) {
		// 마지막 열의 배치를 마치고 증가하면 queen.length == v이 되므로 종료조건
		// 마지막 열까지 배치를 완료했으므로 하나의 경우의 수가 발생한 것이다.
		if(v == queen.length) {
			answer++;
			return;
		}
		
		// 전달받는 v는 열, 아래 반복문은 고정된 열에서 행을 탐색한다.
		for (int i = 0; i < N; i++) {
			// v가 0번째 열
			// 즉, 처음 퀸을 배치하는 경우는 다른 퀸이 없기 때문에 차례대로 배치하면 된다.
			if (v == 0) {
				queen[v] = i; // queen[0번 열] = 0번 행, 1번 행, 2번 행... 순서대로 들어간다.
				dfs(v+1, queen); // 0번 열이 정해지면 1번열을 DFS 탐색 수행
			} else { // 0번 열이 아닌 나머지 열의 경우에는 이전에 배치한 퀸의 범위를 고려해야 한다.
				// 이전 퀸의 범위를 탐색하는 메소드
				if (isPossible(queen, i, v)) {
					queen[v] = i; // 배치가 가능한 경우 값을 넣어준다.
					dfs(v+1, queen); // 다음 열을 대상으로 DFS 탐색 수행
				}
			}	
		}
	}
	
	// 배치된 퀸의 이동반경에 걸리는지 확인하는 메소드
	public static boolean isPossible(int[] queen, int x, int y) {
		// 0번 열부터 자신 이전의 열까지 데이터를 탐색해야 한다.
		for (int i = 1; i <= y ; i++) {
			// 이전 열의 퀸의 행과 현재 열의 전달받은 행이 겹치면 false
			if(queen[y-i] == x)
				return false;
			// |현재 열의 행 - 이전 열의 행| == |현재 열 - 이전 열| 인 경우
			// 이전 행, 열에 위치한 퀸의 대각선 범위에 포함되는 경우이므로 false
			if(Math.abs(x-queen[y-i]) == Math.abs(y-(y-i)))
				return false;
		}
	// 그 외는 고려할 필요가 없으므로 배치할 수 있다.
	return true;
	}
	
}
