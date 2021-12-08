import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15686_chickenDelivery {
	static int N, M, answer;
	static ArrayList<Point> chicken, home;
	static Point[] selected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		selected = new Point[M];
		answer = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int val = Integer.parseInt(st.nextToken());
				if (val == 2) // 치킨집 목록
					chicken.add(new Point(i, j));
				if (val == 1) // 집 목록
					home.add(new Point(i, j));
			}
		}
		
		dfs(0, 0);
		System.out.println(answer);

	}
	
	public static void dfs(int idx, int cnt) {
		if (cnt == M) { // M개의 치킨집을 골랐을 때
			int all = 0; // 도시의 모든 집에 대한 치킨집 거리 정보
			for (int h = 0; h < home.size(); h++) { // 도시의 모든 집들로부터
				int dis = Integer.MAX_VALUE; // 현재 집에 대한 정보
				for (int c = 0; c < M; c++) { // 선택된 치킨집들까지의 치킨거리의 최솟값 연산
					int tmp = Math.abs(home.get(h).x - selected[c].x);
					tmp += Math.abs(home.get(h).y - selected[c].y);
					dis = Math.min(dis, tmp); // 가장 가까운 거리
				}
				all += dis;
			}
			
			//도시에 있는 모든 집들로부터 선택된 치킨집들까지의 치킨거리의 최솟값
			answer = Math.min(answer, all); 
			return;
		}
		
		if (idx == chicken.size()) // 더이상 고를 치킨집이 없을 경우
			return;
		
		// 조합 구하기
		selected[cnt] = chicken.get(idx);
		dfs(idx + 1, cnt + 1); // idx에 있는 치킨집을 선택할 경우
		dfs(idx + 1, cnt); // idx에 있는 치킨집을 선택하지 않을 경우
	}

}
