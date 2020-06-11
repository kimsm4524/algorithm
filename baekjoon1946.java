import java.util.*;
public class Main {
	static class pair
	{
		int right;
		int left;
		public pair(int a, int b)
		{
			this.right = a;
			this.left = b;
		}
		public String toString()
		{
			return this.right+"  "+this.left;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T,n;
		T=sc.nextInt();
		for(int t=0;t<T;t++)
		{
			n=sc.nextInt();
			int top;
			top=0;
			ArrayList<pair> apply = new ArrayList<>();
			for(int i=0;i<n;i++)
			{
				int a,b;
				a=sc.nextInt();
				b=sc.nextInt();
				if(a==1)
					top=b;
				apply.add(new pair(a,b));
			}
			Collections.sort(apply,new Comparator<pair>(){

				@Override
				public int compare(pair arg0, pair arg1) {
					if(arg0.right>arg1.right)
						return 1;
					else if (arg0.right==arg1.right)
						return 0;
					else
						return -1;
				}
				
			});
			int result = 1;
			for(int i=0;i<n;i++)
			{
				if(apply.get(i).left<top)
				{
					result++;
					top=apply.get(i).left;
				}
			}
			
			System.out.println(result);
		}
	}
}
