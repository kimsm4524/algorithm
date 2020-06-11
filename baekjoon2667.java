import java.util.*;
public class Main {
	static int dx[] = {0,-1,0,1};
	static int dy[] = {1,0,-1,0};
	static int room;
	static ArrayList<Integer>result = new ArrayList<>();
	static void dfs(int x,int y)
	{
		map[x][y]=0;
		room++;
		for(int i=0;i<4;i++)
		{
			int cx = x+dx[i];
			int cy = y+dy[i];
			if(isinside(cx,cy)&&map[cx][cy]==1)
			{
				dfs(cx,cy);
			}
		}
		
	}
	static boolean isinside(int x, int y)
	{
		if(x>=0&&x<n&&y>=0&&y<n)
			return true;
		else
			return false;
	}
	static int n;
	static int map[][];
   public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);       
		n = sc.nextInt();
		map=new int[n][n];
		String temp;
		for(int i=0;i<n;i++)
		{
			temp = sc.next();

			for(int j=0;j<n;j++)
			{
				map[i][j]=temp.charAt(j)-'0';
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(map[i][j]==1)
				{
					room=0;
					dfs(i,j);
					result.add(room);
				}
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
		for(int i=0;i<result.size();i++)
		{
			System.out.println(result.get(i));
		}
   }
}
