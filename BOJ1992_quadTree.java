import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1992_quadTree {
	static int N;
	static char[][] map;
	static char C;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
		}
		divide(0, 0, N);
		bw.flush();
		bw.close();
	}
	
	private static boolean check(int r, int c, int n) {
		C = map[r][c];
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if (map[i][j] != map[r][c]) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static void divide(int r, int c, int n) throws Exception {
		if (check(r, c, n)) {
			bw.append(C);
		} else {
			bw.append("(");
			int len = n / 2;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					divide(r + len * i, c + len * j, len);
				}
			}
			bw.append(")");
		}
	}

}
