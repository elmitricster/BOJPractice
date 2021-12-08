import java.util.Scanner;

public class BOJ1107_remocon {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		boolean[] broken = new boolean[10];
		for (int i = 0; i < M; i++) {
			int btn = sc.nextInt();
			broken[btn] = true;
		}
		
		int answer = Math.abs(N - 100);  //초기값 설정
		
		for (int i = 0; i < 1000000; i++) {
			String str = String.valueOf(i);
			int len = str.length();
			
			boolean isBreak = false;
			
			for (int j = 0; j < len; j++) {
				if (broken[str.charAt(j) - '0']) {  //고장난 버튼을 눌러야 하면
					isBreak = true;
					break;  //더 이상 탐색하지 않고 빠져나온다.
				}
			}
			
			if (!isBreak) {  //i를 누를 때 고장난 버튼을 누르지 않는다면
				int min = Math.abs(N - i) + len;  //i를 누른 후(len) N까지 이동하는 횟수(N - i)
				answer = Math.min(min, answer);
			}
		}
	
		System.out.println(answer);
		sc.close();
	}
}
