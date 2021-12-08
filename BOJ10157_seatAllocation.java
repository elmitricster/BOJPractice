/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10157_seatAllocation {
	static int r, c, K;
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1}; // 하, 우, 상, 좌

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken()) + 1;
		K = Integer.parseInt(br.readLine());
		
		int d = -1, num = 0, x = 0, y = 1;
		
		int check = 1;
		
		while (check > 0) {
			d = (d + 1) % 4;
			
			if (d % 2 == 0)
				r--;
			else
				c--;
			
			check = d % 2 == 0 ? r : c;
			
			for (int j = 0; j < check; j++) {
				num++;
				x += dx[d];
				y += dy[d];
				
				if (num == K) {
					System.out.println(y + " " + x);
					return;
				}
			}
		}
		System.out.println("0");
	}

}*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ10157_seatAllocation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;

	static int map[][];
	static boolean visit[][];
	static int r, c, k;

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int cnt = 1;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[r][c];

		k = Integer.parseInt(br.readLine());
		if (r * c < k) {
			bw.write(String.valueOf(0));
			bw.flush();
			System.exit(0);
		}

		int cnt = 1;

		int x = r - 1;
		int y = 0;
		int dir = 0;
		while (cnt != k) {

			// if(cnt==k)break;
			map[x][y] = cnt;
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] != 0) {
				dir++;
				if (dir == 4)
					dir = 0;
				nx = x + dx[dir];
				ny = y + dy[dir];
			}

			x = nx;
			y = ny;

			cnt++;
		}

		bw.write(String.valueOf((y + 1) + " " + (r - x)));
		bw.flush();
	}

}
