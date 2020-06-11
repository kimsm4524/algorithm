import java.util.Scanner;

public class Main {
	static int result=1;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int[] backx = {1,0,-1,0};
	static int[] backy = {0,1,0,-1};
	static int[][] room;
	static void dfs(int x, int y ,int d)
	{
		for(int i=0;i<4;i++)
		{
			int cx,cy,cd;
			cd = (d+i+1)%4;
			cx = x+dx[cd];
			cy = y+dy[cd];
			if(room[cx][cy]==0)
			{
				result++;
				room[cx][cy]=2;
				dfs(cx,cy,cd);
				return;
			}else
				continue;
		}
		int cx2,cy2;
		cx2 = x+backx[d];
		cy2 = y+backy[d];
		if(room[cx2][cy2]==1)
			return;
		else
		{
			dfs(cx2,cy2,d);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,m;
		int c,r,d;
		n=sc.nextInt();
		m=sc.nextInt();
		r=sc.nextInt();
		c=sc.nextInt();
		d=sc.nextInt();
		room = new int[50][50];
		if(d==1)
			d=3;
		else if(d==3)
			d=1;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				room[i][j]=sc.nextInt();
			}
		}
		room[r][c]=2;
		dfs(r,c,d);
		System.out.println(result);		
	}

}
