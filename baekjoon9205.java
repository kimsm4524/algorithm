import java.util.*;
public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      int n;
      
      for(int test=0;test<t;test++)
      {
    	  n= sc.nextInt();
    	  int xy[][]=new int[n+2][2];
          int map[][]= new int[n+2][n+2];
      for(int i=0;i<n+2;i++)
      {
    	  xy[i][0]=sc.nextInt();
    	  xy[i][1]=sc.nextInt();
      }
      for(int i=0;i<n+2;i++)
      {
    	  for (int j=0;j<n+2;j++)
    	  {
    		  if(i==j)
    		  {
    			  map[i][j]=0;
    		  }
    		  else
    		  {
    			  map[i][j]=Math.abs(xy[i][0]-xy[j][0])+Math.abs(xy[i][1]-xy[j][1]);
    		  }
    	  }
      }
      for(int a=0;a<n+1;a++)
      for(int i=1;i<n+2;i++)
      {
    	  for(int j=1;j<n+2;j++)
    	  {
    		  if(map[i][j]!=0)
    		  if(Math.max(map[0][j], map[j][i])<=map[0][i])
    			  map[0][i]=Math.max(map[0][j], map[j][i]);
    	  }
      }
      if(map[0][n+1]<=1000)
    	  System.out.println("happy");
      else
    	  System.out.println("sad");
      }
   }
}	
