import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2477_koreanMelon {
	static int K;
	static int[] d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		d = new int[6];
	
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			//int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			d[i] = len;
		}
		
		int area = 0;
		int sArea = 0;
		int idx = -1;
		
		for (int i = 0; i < 6; i++) {
			int tmp = d[i] * d[(i+1)%6];
			if (area < tmp) {
				area = tmp;
				idx = i;
			}
		}
		
		sArea = d[(idx+3)%6] * d[(idx+4)%6];
		System.out.println((area-sArea)*K);
	}

}
