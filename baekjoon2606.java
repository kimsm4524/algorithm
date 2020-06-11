import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num_com,num_link;
		num_com=sc.nextInt();
		num_link=sc.nextInt();
		int result = num_com-1;

		int table[][] = new int[num_com][num_com];
		for(int i=0;i<num_link;i++)
		{
			int a,b;
			a=sc.nextInt();
			b=sc.nextInt();
			table[a-1][b-1]=1;
			table[b-1][a-1]=1;
		}
        for(int k=0;k<num_link-1;k++)
		    for(int i=0;i<num_com;i++)
		    {
			    if(table[0][i]==1)
			    {
				    for(int j=0;j<num_com;j++)
				    {
					    if(table[i][j]==1)
						    table[0][j]=1;
				    }
			    }
		    }
		for(int i=0;i<num_com;i++)
		{
			if(table[0][i]==0)
			{
				result--;
			}
		}
		System.out.println(result);
	}

}
