public class Percolation 
{
   private boolean[][] OpenSite;
   private WeightedQuickUnionUF QuickUnion;
   private int Size;
   public Percolation(int N)              // create N-by-N grid, with all sites blocked
   {
       Size = N;
       OpenSite = new boolean[N+2][N+2];
       QuickUnion = new WeightedQuickUnionUF(N*N+2);
//       for (int i=1; i < N+1; i++)
//       {
//           QuickUnion.union(i,N*N);
//           QuickUnion.union(N*N-i,N*N+1);
//       }
   }
   private int coordinate2index(int i, int j)     // i and j is from 0 to N-1
   {
       return Size*(i-1) + j-1;
   }
   private int[] index2coordinate(int cord)     // cord is from 0 to N*N-1
   {
       int x = cord/Size;
       int y = cord%Size;
       return new int[] {x, y};
   }
   private void indexchecking(int i, int j)
   {
       if ( i<1 || i>Size)
       {
           throw new IndexOutOfBoundsException("Row index i is out of bounds");
       }else{
           if ( j<1 || j>Size){
               throw new IndexOutOfBoundsException("Column index j is out of bounds");
           }
       }
   }
   public void open(int i, int j)         // open site (row i, column j) if it is not already
   {
       indexchecking(i, j);
       // fit the convention
       OpenSite[i][j] = true;
       // check the sites around
       if (i==1) QuickUnion.union(coordinate2index(i,j),Size*Size);
       if (i==Size) QuickUnion.union(coordinate2index(i,j),Size*Size+1);
       if (OpenSite[i-1][j]) QuickUnion.union(coordinate2index(i,j), coordinate2index(i-1,j));              // upper site
       if (OpenSite[i+1][j]) QuickUnion.union(coordinate2index(i,j), coordinate2index(i+1,j));              // down site
       if (OpenSite[i][j-1]) QuickUnion.union(coordinate2index(i,j), coordinate2index(i,j-1));              // left site
       if (OpenSite[i][j+1]) QuickUnion.union(coordinate2index(i,j), coordinate2index(i,j+1));              //right site
   }
   public boolean isOpen(int i, int j)    // is site (row i, column j) open?
   {
       indexchecking(i, j);
       // fit the convention
       if (OpenSite[i][j])
       {
           return true;
       }
       else{
           return false;
       }  
   }
   public boolean isFull(int i, int j)    // is site (row i, column j) full?
   {
       if ( i >= Size || j > Size || i < 0 || j < 0 )
       {
           throw new IndexOutOfBoundsException();
       }
       int cord = coordinate2index(i, j);
       return QuickUnion.connected(cord,Size*Size);
   }
   public boolean percolates()            // does the system percolate?
   {
       return QuickUnion.connected(Size*Size+1,Size*Size);
   }
   
}
