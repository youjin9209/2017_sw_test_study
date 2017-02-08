package sw_assignment;
import java.util.*;

class Pair {
	int x;
	int y;
	int z; //chance flag
	Pair (int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class sw26_2206 {
	public static final int[] dx = {0, 0, 1, -1};
	public static final int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		int[][] a = new int[N][M];

		// initialize	
		for (int i = 0; i < N; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < M; j++) {
				a[i][j] = s.charAt(j) - '0';
			}
		}
		
		int[][][] dist = new int[N][M][2];
		
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist[i].length; j++) {
				for (int k = 0; k < dist[i][j].length; k++) {
					dist[i][j][k] = -1;
				}
			}
		}
		
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(0, 0, 0));
		dist[0][0][0] = 1;
		dist[0][0][1] = 1;
		
		while (!queue.isEmpty()) {
			Pair p = queue.remove();
			int x = p.x;
			int y = p.y;
			int z = p.z;
			
			if (x == N-1 && y == M-1) {
				System.out.println(dist[N-1][M-1][z]);
				System.exit(0);
			}
			
			for (int k = 0; k < 4; ++k) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if (nx < 0 || nx > N-1 || ny < 0 || ny > M-1)
					continue;
				
				// 만약 방문한 노드가 방이라면, dist = 이전 노드 + 1
				if (a[nx][ny] == 0 && dist[nx][ny][z] == -1) {
					dist[nx][ny][z] = dist[x][y][z] + 1;
					queue.add(new Pair(nx, ny, z));
				}
					
				// 만약 방문한 노드가 벽이라면, 이전 노드 가 찬스를 사용하지 않았어야하고, dist = 이전 노드 + 1
				if (a[nx][ny] == 1 && z == 0 && dist[nx][ny][z] == -1) {
					dist[nx][ny][1] = dist[x][y][z] + 1;
					queue.add(new Pair(nx, ny, 1));
				}
			}
		}
		System.out.println("-1");
		System.exit(0);
	}
}