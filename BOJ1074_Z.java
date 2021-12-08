import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074_Z {
	static int N, r, c, answer;
	static int[] dx = {0,1,0,1};
	static int[] dy = {0,0,1,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, N);
		
		div_area(0, 0, N);
	}
	
	public static void div_area(int y, int x, int len) {
		if(len == 2) {
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny == r && nx == c) {
					System.out.println(answer);
					System.exit(0);
					return;
				}
				answer++;
			}
			return;
		}
		
		for (int i = y; i < y + len; i+= len / 2) {
			for (int j = x; j < x + len; j+= len / 2) {
				if (i + len / 2 -1 < r || j + len / 2 - 1 < c) {
					answer += Math.pow(len / 2, 2);
					continue;
				}
				div_area(i, j, len / 2);
			}
		}
		
	}

}
