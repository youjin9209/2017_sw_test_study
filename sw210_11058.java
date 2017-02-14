package sw_assignment;

import java.util.Scanner;

public class sw210_11058 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] d = new long[1002];
		d[0] = 1;
		
		for (int i = 1; i <= 6; i++)
			d[i] = i;
		
		for (int i = 7; i <= n; i++) {
			for (int j = 1; j <= i-3; j++) {
				long count = d[i - (j+2)]*(j+1);
					if (count > d[i])
						d[i] = count;
			}
		}
		System.out.println(d[n]);
	}
}