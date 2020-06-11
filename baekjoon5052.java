import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		int t= Integer.parseInt(st.nextToken());
		for(int test=0;test<t;test++)
		{
			boolean check = true;
			st = new StringTokenizer( br.readLine() );
			int n = Integer.parseInt(st.nextToken());
			ArrayList<String> numbers= new ArrayList<String>();
			for(int i=0;i<n;i++)
			{
				numbers.add( (String)(new StringTokenizer( br.readLine()).nextToken()));
			}
			Collections.sort(numbers);
			for(int i=0;i<n-1;i++)
			{
				if(numbers.get(i).length()<=numbers.get(i+1).length())
					if(numbers.get(i).equals(numbers.get(i+1).substring(0,numbers.get(i).length())))
					{
						check=false;
						break;
					}
			}
			if(check)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
