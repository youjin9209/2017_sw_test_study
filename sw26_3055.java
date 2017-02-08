package sw_assignment;
import java.util.*;

class Node {
	int x;
	int y;
	Node (int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class sw26_3055 {
	public static final int[] dx = {0, 0, 1, -1};
	public static final int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		sc.nextLine();
		String[][] map = new String[R][C];
		int[][] water = new int[R][C];
		int[][] visit = new int[R][C];
		
		int startx = 0, starty = 0;
		int destx = 0, desty = 0;
		Queue<Node> wqueue = new LinkedList<Node>();
		Queue<Node> gqueue = new LinkedList<Node>();
		//initialize - input
		for (int i = 0; i < R; i++) {
			String[] s = sc.nextLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = s[j];
				visit[i][j] = 0;
			}
		}
		
		//initialize - start(S) , destination(D), water(*), stone(X)
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j].equals("S")) {
					startx = i;
					starty = j;
				} else if (map[i][j].equals("D")) {
					destx = i;
					desty = j;
					water[i][j] = -1;
				} else if (map[i][j].equals("*")) {
					water[i][j] = 1;
					wqueue.add(new Node(i, j));
				} else if (map[i][j].equals("X")) {
					water[i][j] = 1;
				}
			}
		}

		// gosmdochi
		gqueue.add(new Node(startx, starty));
		visit[startx][starty] = 1;
		int waterFlag = 1;
		int gosmFlag = 1;
		
		while (!gqueue.isEmpty()) {
			// fill water
			while (!wqueue.isEmpty() && true) {
				int wx = wqueue.peek().x;
				int wy = wqueue.peek().y;
				
				if (water[wx][wy] != waterFlag) {
					waterFlag++;
					break;
				}
				
				wqueue.remove();
				
				for (int i = 0; i < 4; i++) {
					int nextx = wx + dx[i];
					int nexty = wy + dy[i];
					
					if ((nextx >= 0 && nextx < R) && (nexty >= 0 && nexty < C)) {
						if (water[nextx][nexty] == 0) {
							water[nextx][nexty] = water[wx][wy] + 1;
							wqueue.add(new Node(nextx, nexty));
						}
					}
				}
			}
			
			while (!gqueue.isEmpty()) {
				int gx = gqueue.peek().x;
				int gy = gqueue.peek().y;
				
				if (visit[gx][gy] != gosmFlag) {
					gosmFlag++;
					break;
				}
				
				gqueue.remove();
				
				for (int i = 0; i < 4; i++) {
					int nextx = gx + dx[i];
					int nexty = gy + dy[i];
					
					if ((nextx >= 0 && nextx < R) && (nexty >= 0 && nexty < C)) {
						if (water[nextx][nexty] <= 0 && visit[nextx][nexty] == 0) {
							visit[nextx][nexty] = visit[gx][gy] + 1;
							gqueue.add(new Node(nextx, nexty));
						}
					}
				}
			}
		}
		
		if (visit[destx][desty] == 0)
			System.out.println("KAKTUS");
		else
			System.out.println(visit[destx][desty] -1);
	}
}