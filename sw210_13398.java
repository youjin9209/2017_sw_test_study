package sw_assignment;

import java.util.Scanner;

public class sw210_13398 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] dl = new int[n];
		int[] dr = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		// 왼쪽 배열 채우기 
		for (int i = 0; i < n; i++) {
			dl[i] = a[i];
			if (i == 0) {
				continue;
			}
			if (dl[i] < dl[i-1] + a[i]) {
				dl[i] = dl[i-1] + a[i];
			}
		}
		
		// 오른쪽 배열 채우기 
		for (int i = n-1; i >= 0; i--) {
			dr[i] = a[i];
			if (i == n-1) {
				continue;
			}
			if (dr[i] < dr[i+1] + a[i]) {
				dr[i] = dr[i+1] + a[i];
			}
		}
		
		// 왼쪽 + 오른쪽 
		int sum = dl[0];
		for (int i = 1; i < n; i++) {
			if (sum < dl[i]) {
				sum = dl[i];
			}
		}
		
		for (int i = 1; i < n-1; i++) {
			if (sum < dl[i-1] + dr[i+1]) {
				sum = dl[i-1] + dr[i+1];
			}
		}
		System.out.println(sum);
	}
}