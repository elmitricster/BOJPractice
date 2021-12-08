import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2669_4Rectangle {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean map[][] = new boolean[101][101];
		int cnt = 0;
		for (int k = 0; k < 4; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sX = Integer.parseInt(st.nextToken());
			int sY = Integer.parseInt(st.nextToken());
			int eX = Integer.parseInt(st.nextToken());
			int eY = Integer.parseInt(st.nextToken());
			
			for (int i = sX; i < eX; i++) {
				for (int j = sY ; j < eY; j++) {
					map[i][j] = true;
				}
			}

		}
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
			if (map[i][j])
				cnt++;
			}
		}	
		
		System.out.println(cnt);
	}

}
