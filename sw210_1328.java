package sw_assignment;
import java.util.*;
import java.math.*;

/*
가장 왼쪽에 빌딩1이 있는 경우 -> L이 하나 증가해야하기에 
d[N-1][L-1][R] 

가장 오른쪽에 빌딩1이 있는 경우 -> R이 하나 증가해야함 
d[N-1][L][R-1] 

사이에 빌딩1이 있는 경우 -> 추가할수 있는 경우가 N-2개 존재 
d[N-1][L][R]*(N-2) 
*/

public class sw210_1328 {
	static long mod = 1000000007L;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int R = sc.nextInt();
		long[][][] d = new long[N+1][L+1][R+1];
		d[1][1][1] = 1L;
		
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= L; j++) {
				for (int k = 1; k <= R; k++) {
					d[i][j][k] = d[i-1][j-1][k] + d[i-1][j][k-1] + (i-2)*d[i-1][j][k];
					d[i][j][k] %= mod;
				}
			}
		}
		System.out.println(d[N][L][R]);
	}
}