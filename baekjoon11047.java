import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	static int how(int n, int k, ArrayList<Integer> coins)
	{
		int result=0;
		int newk=k;
		for(int i=n-1;i>=0;i--)
		{
			result+=newk/coins.get(i);
			newk=newk%coins.get(i);

		}
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,k;
		n=sc.nextInt();
		k=sc.nextInt();
		ArrayList<Integer> coins = new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			coins.add(sc.nextInt());
		}
		System.out.println(how(n,k,coins));
	}
}
