import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n=sc.nextInt();
		ArrayList<Integer> rope = new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			rope.add(sc.nextInt());
		}
		Collections.sort(rope);
		int result=0;
		for(int i=0;i<n;i++)
		{
			if(result<(n-i)*rope.get(i))
				result = (n-i)*rope.get(i);
		}
		System.out.println(result);
	}
}
