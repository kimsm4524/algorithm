import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int visited[] = new int[n];
		ArrayList<Integer> got[] = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			got[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			got[a].add(b);
			got[b].add(a);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		visited[0] = 1;
		q.add(0);
		while (!q.isEmpty()) {
			for (int i = 0; i < q.size(); i++) {
				int temp = q.poll();
				for (int j = 0; j < got[temp].size(); j++) {
					if (visited[got[temp].get(j)] == 0) {
						visited[got[temp].get(j)] = visited[temp] + 1;
						q.add(got[temp].get(j));
					}
				}
			}
		}
		int big = -1;
		int first = 0;
		int cnt = 0;
		for (int i = 1; i < n; i++) {
			if (visited[i] > big) {
				big = visited[i];
				first = i + 1;
			}
		}
		for (int i = 1; i < n; i++) {
			if (big == visited[i])
				cnt++;
		}
		System.out.println(first + " " + (big-1) + " " + cnt);

	}
}
