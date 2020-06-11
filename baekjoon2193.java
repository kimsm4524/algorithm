import java.util.*;
public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n=sc.nextInt();
      long result0[] = new long[n];
      long result1[] = new long[n];
      for(int i=0;i<n;i++)
      {
    	  if(i==0)
    	  {
    		  result0[0]=0;
    		  result1[0]=1;
    	  }
    	  else {
    	  result0[i]=result0[i-1]+result1[i-1];
    	  result1[i]=result0[i-1];}
      }
      System.out.println(result0[n-1]+result1[n-1]);
   }
}	
