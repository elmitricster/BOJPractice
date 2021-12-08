import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17135_castleDefense {
	static int N, M, D, answer;
	static int[][] map;
	static ArrayList<Point> enemy = new ArrayList<>();
	
	public static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					enemy.add(new Point(j, i)); // 적의 좌표를 ArrayList에 저장
			}
		}
		
		combination(0, new int[3], 0);
		System.out.println(answer);
		
	}
	
	public static void combination(int cnt, int[] selected, int idx) {
		if(cnt == 3) {
			int score = atk(selected);
			answer = Math.max(answer, score);
			return;
		}
		
		for (int i = idx; i < M; i++) {
			selected[cnt] = i;
			combination(cnt+1, selected, i+1);
		}
	}
	
	public static int distance(Point a, Point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
	
	public static int atk(int[] arr) {
		int row = N, cnt = 0;
		boolean[] check = new boolean[enemy.size()]; // 적 사살 여부 체크해주는 배열
		Arrays.fill(check, true);
		
		while(row > 0) { // 적이 내려오는게 아니고 궁수가 위로 올라감
			Point[] kill = new Point[3]; // 각각의 궁수가 처리할 적의 좌표 저장
			
			for (int i = 0; i < arr.length; i++) {
				int dis = D; // 최소거리를 D로 초기화
				Point cur = new Point(arr[i], row); // 궁수의 현재 좌표
				kill[i] = new Point(M, -1); // 몰라레후
				
				for (int j = 0; j < check.length; j++) {
					if(!check[j]) 
						continue; // 이미 죽은 적이면 pass
					Point e = enemy.get(j);
					int ad = distance(cur, e); // 궁수와 적 사이 거리를 구함
					if((ad == dis && e.x < kill[i].x) || (ad < dis)) { // 거리가 같으면서 왼쪽에 있거나, 거리가 더 작으면
						dis = distance(cur, e); // 최소 거리 및 좌표 갱신
						kill[i] = e;
					}
				}
			}
		
			row--; // 궁수가 위로 이동
			
			for (int i = 0; i < check.length; i++) {
				for (int j = 0; j < kill.length; j++) {
					// kill 배열에 미리 저장해두었던 좌표를 이미 처리했는지 고려하면서 카운트
					if((kill[j].x == enemy.get(i).x) && (kill[j].y == enemy.get(i).y) && check[i]) {
						cnt++;
						check[i] = false;
					}
				}
				if(enemy.get(i).y == row) { // 성에 다다른 적 삭제
					check[i] = false;
				}
			}
		}
		return cnt;
	}
}
