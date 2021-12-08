import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244_switch {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] swit = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			swit[i] = Integer.parseInt(st.nextToken());
		}
		
		int stu = Integer.parseInt(br.readLine());
		for (int i = 0; i < stu; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if (gender == 1) {
				for (int j = 0; j < N; j++) {
					if((j+1) % num == 0) {
						swit[j] = swit[j] == 0 ? 1 : 0;
					}
				}
			} else {
				swit[num-1] = swit[num-1] == 0 ? 1 : 0;
				for (int j = 1; j < N/2; j++) {
					if (num - 1 + j >= N || num - 1 - j < 0) {
						break;
					}
					if(swit[num-1-j] == swit[num-1+j]) {
						swit[num-1-j] = swit[num-1-j] == 0 ? 1 : 0;
						swit[num-1+j] = swit[num-1+j] == 0 ? 1 : 0;
					} else {
						break;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(swit[i] + " ");
			if((i+1) % 20 == 0) {
				System.out.println();
			}
		}
	}
}
