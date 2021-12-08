import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1475_roomNumber {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] num = new int[6];
		int[] numCnt = new int[8];
		int numCnt69 = 0;
		int maxNum = 0;
		int maxNum2 = 0;
		
		for (int i = 0; i < s.length(); i++) {
			num[i] = s.charAt(i) - '0';
		}
		
		for (int i = 0; i < s.length(); i++) {
			if (num[i] == 0) {
				numCnt[0]++;
			} else if (num[i] == 1) {
				numCnt[1]++;
			} else if (num[i] == 2) {
				numCnt[2]++;
			} else if (num[i] == 3) {
				numCnt[3]++;
			} else if (num[i] == 4) {
				numCnt[4]++;
			} else if (num[i] == 6) {
				numCnt69++;
			} else if (num[i] == 5) {
				numCnt[5]++;
			} else if (num[i] == 7) {
				numCnt[6]++;
			} else if (num[i] == 8) {
				numCnt[7]++;
			} else if (num[i] == 9) { 
				numCnt69++;
			}
		}
		
		if (numCnt69 % 2 == 0) {
			maxNum2 = numCnt69 / 2;
		} else {
			maxNum2 = numCnt69 / 2 +1;
		}
		
		for (int i = 0; i < numCnt.length; i++) {
			maxNum = Math.max(maxNum, numCnt[i]);
		}
		
		if (maxNum > maxNum2) {
			System.out.println(maxNum);
		} else {
			System.out.println(maxNum2);
		}

	}

}
