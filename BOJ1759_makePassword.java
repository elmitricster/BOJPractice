import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759_makePassword {
	static int L, C;
	static char alpha[], word[];
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken()); // 암호 자리수
		C = Integer.parseInt(st.nextToken()); // 주어진 알파벳 종류
		alpha = new char[C];
		word = new char[L];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alpha); // 정렬된 문자열을 선호
		
		dfs(0,0,0,0);
		System.out.println(sb);
	}
	
	static void dfs(int idx, int cnt, int c, int v) {
		if(cnt == L) { // 주어진 길이만큼 암호가 만들어지면
			if(v >= 1 && c >= 2) { // 최소 한 개의 모음(vowel)과 두 개의 자음(consonant)으로 구성
				for (int i = 0; i < L; i++) {
					sb.append(word[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for (int i = idx; i < C; i++) {
			word[cnt] = alpha[i];
			
			if(alpha[i] == 'a' || alpha[i] == 'e' || alpha[i] == 'i' || alpha[i] == 'o' || alpha[i] == 'u')
				dfs(i+1, cnt+1, c, v+1);
			else
				dfs(i+1, cnt+1, c+1, v);
		}
	}
	
}
