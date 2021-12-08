import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13300_roomAllocation {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] room = new int[7][2];
		int roomCnt = 0;
		
		for (int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			room[Y][S]++;
		}
			
		/*for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				if (room[i][j] == 0) {
					continue;
				} else {
					roomCnt += Math.ceil((double)room[i][j] / K);
				}
			}
		}*/
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				roomCnt += room[i][j] % K == 0 ? room[i][j] / K : room[i][j] / K + 1;
			}
		}
		System.out.println(roomCnt);
	}

}
