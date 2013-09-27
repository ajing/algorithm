import java.util.Arrays;

public class PercolationStats 
{
   private double[] PercolationNum;
   private int Num;
   private int Time;
   public PercolationStats(int N, int T)    // perform T independent computational experiments on an N-by-N grid
   {
       PercolationNum = new double[T];
       Num  = N;
       Time = T;
       for (int i = 0; i< T; i++)
       {
           Percolation test = new Percolation(N);
           while( !test.percolates() ){
               int randompoint = StdRandom.uniform(N*N);
               int x = randompoint/N + 1;
               int y = randompoint%N + 1;
               //System.out.println(x);
               //System.out.println(y);
               if( !test.isOpen( x, y ))
               {
                   test.open(x, y);
                   ++PercolationNum[i];
               }
           }
       }
       for (int i = 0; i< T; i++)
       {
           PercolationNum[i] = PercolationNum[i]/(N*N);
       }
       //System.out.println(Arrays.toString(PercolationNum));
   }
   public double mean()                     // sample mean of percolation threshold
   {
       double mean     = 0;
       double totalNum = 0;
       for (int i = 0; i < Time; i++)
       {
           totalNum = totalNum + PercolationNum[i];
       }
       mean = totalNum/Time;
       return mean;
   }
   public double stddev()                   // sample standard deviation of percolation threshold
   {
       double m    = mean();
       double accu = 0;
       for (int i = 0; i < Time; i++)
       {
           accu = accu + (PercolationNum[i] - m)*(PercolationNum[i] - m);
       }
       double std = Math.sqrt(accu/(Time - 1));
       return std;
   }
   public double confidenceLo()             // returns lower bound of the 95% confidence interval
   {
       double m    = mean();
       double s    = stddev();
       double Lo   = m - 1.96*s/Math.sqrt(Time);
       return Lo;
   }
   public double confidenceHi()             // returns upper bound of the 95% confidence interval
   {
       double m    = mean();
       double s    = stddev();
       double Hi   = m + 1.96*s/Math.sqrt(Time);
       return Hi;
   }
   public static void main(String[] args)   // test client, described below
   {
       int Num = Integer.parseInt(args[0]);
       int Time = Integer.parseInt(args[1]);
       if (Num < 0 || Time < 0)
       {
           throw new IllegalArgumentException();
       }
       PercolationStats Percolate = new PercolationStats(Num, Time);
       System.out.println(Percolate.mean());
       System.out.println(Percolate.stddev());
       System.out.println(Percolate.confidenceLo());
       System.out.println(Percolate.confidenceHi());
   }
}