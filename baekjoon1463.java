import java.util.*;
public class Main {
	static int answer[]=new int[1000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n=sc.nextInt();
		answer[1]=0;
		for(int i=2;i<=n;i++)
		{
			int min=answer[i-1];
			if(i%2==0)
				if(answer[i-1]>answer[i/2])
					min=answer[i/2];
			if(i%3==0)
				if(answer[i-1]>answer[i/3])
					min=answer[i/3];
			answer[i]=min+1;
		}
		System.out.println(answer[n]);
	}
}
