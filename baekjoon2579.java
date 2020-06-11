import java.util.*;
public class Main {
	static int dp(int a) {
		if(a==1)
			return answer[1];
		else if(a==2)
			return answer[1]+answer[2];
		else if(a==3)
		{
			if((answer[1]+answer[3])>(answer[2]+answer[3]))
				return answer[1]+answer[3];
			else
				return answer[2]+answer[3];
		}
		else
		{
			if((dp(a-2)+answer[a])>(dp(a-3)+answer[a-1]+answer[a]))
			{
				return dp(a-2)+answer[a];
			}
			else
				return dp(a-3)+answer[a-1]+answer[a];
		}
	}
	static int answer[];
	static int result[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n=sc.nextInt();
		answer=new int[n+1];
		answer[0]=-2000;
		result=new int[n+1];
		for(int i=1;i<n+1;i++)
		{
			answer[i]=sc.nextInt();
		}
		for(int i=1;i<n+1;i++)
		{
			if(i==1)
				result[i]= answer[1];
			else if(i==2)
				result[i]=answer[1]+answer[2];
			else if(i==3)
			{
				if((answer[1]+answer[3])>(answer[2]+answer[3]))
					result[i] =  answer[1]+answer[3];
				else
					result[i] = answer[2]+answer[3];
			}
			else
			{
				if((result[i-2]+answer[i])>(result[i-3]+answer[i-1]+answer[i]))
				{
					result[i]= result[i-2]+answer[i];
				}
				else
					result[i]= result[i-3]+answer[i-1]+answer[i];
			}
		}
		System.out.println(result[n]);
		
	}
}
