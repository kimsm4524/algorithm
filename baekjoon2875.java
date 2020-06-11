import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,m,k;
		int result,remain;
        result=0;
        remain=0;
		n=sc.nextInt();
		m=sc.nextInt();
		k=sc.nextInt();
        
        if(n>2*m)
		{
	        result=m;
		    remain=n-2*m;
		}else
		{
		    result = n/2;
		    remain = n%2 +m-result;
		}
        if(remain<k)
        {
            if(((k-remain)%3)==0)
				result-=(k-remain)/3;
			else
				result-=(k-remain)/3+1;
        }    
		System.out.println(result);
	}
}
