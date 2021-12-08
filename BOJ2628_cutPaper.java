import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2628_cutPaper {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		List<Integer> garo = new ArrayList<>();
		List<Integer> sero = new ArrayList<>();
		int max = 0;
		
		garo.add(Integer.parseInt(st.nextToken()));
		sero.add(Integer.parseInt(st.nextToken()));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if (dir == 0) {
				int index;
				for (index = 0; num - sero.get(index) > 0 ; index++) {
					num -= sero.get(index);
				}
				int temp = sero.remove(index);
				sero.add(index, temp - num);
				sero.add(index, num);
			} else {
				int index;
				for (index = 0; num - garo.get(index) > 0 ; index++) {
					num -= garo.get(index);
				}
				int temp = garo.remove(index);
				garo.add(index, temp - num);
				garo.add(index, num);
			}
		}

		for (int i : garo) {
			for (int j : sero)
				max = Math.max(i*j, max);
		}
		
		System.out.println(max);
	}

}
