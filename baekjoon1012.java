import java.util.*;

public class Main {
	static int dx[] = { 0, -1, 0, 1 };
	static int dy[] = { 1, 0, -1, 0 };

	static class pair {
		int first, second;

		public pair(int x, int y) {
			first = x;
			second = y;
		}
	}

	static boolean isinside(int x, int y) {
		if (x >= 0 && x < m && y >= 0 && y < n)
			return true;
		else
			return false;
	}

	static int m;
	static int n;
	static int map[][];
	static ArrayList<pair> land = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 0; t < test; t++) {
			int result = 0;
			m = sc.nextInt();
			n = sc.nextInt();
			map= new int[m][n];
			int k = sc.nextInt();
			for (int j = 0; j < k; j++) {
				map[sc.nextInt()][sc.nextInt()] = 1;
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1) {
						map[i][j] = 0;
						land.add(new pair(i, j));
						while (!land.isEmpty()) {
							pair now = land.get(0);
							land.remove(0);
							for (int r = 0; r < 4; r++) {
								
								int cx = now.first + dx[r];
								int cy = now.second + dy[r];
								
								if (isinside(cx, cy) && map[cx][cy] == 1) {
									map[cx][cy] = 0;
									land.add(new pair(cx, cy));
								}
							}
						}
						result++;
					}
				}
			}
			
			System.out.println(result);
		}
	}
}
