


public class Brute {
   public static void main(String[] args) {
	   In in = new In(args[0]); // args[0] = name of file
	   int N = in.readInt();    // read an integer in the file
	   Point[] points = new Point[N];
       for (int i = 0; i < N; i++) {
           int x = in.readInt();
           int y = in.readInt();
           points[i] = new Point(x, y);
       }
       
       Selection.sort(points);
       for (int i1 = 0; i1 < N - 3; i1++) {
    	   for (int i2 = i1 + 1; i2 < N - 2; i2++) {
    		   for (int i3 = i2 + 1; i3 < N - 1; i3++) {
    			   for (int i4 = i3 + 1; i4 < N; i4++) {
    				   double slope1 = points[i1].slopeTo(points[i2]);
    				   double slope2 = points[i1].slopeTo(points[i3]);
    				   double slope3 = points[i1].slopeTo(points[i4]);
    				   if (slope1 == slope2 && slope1 == slope3) {
    					   System.out.println(points[i1].toString() + " -> " 
    							   			+ points[i2].toString() + " -> " 
    							   			+ points[i3].toString() + " -> " 
    							   			+ points[i4].toString());
    				   }
    			   }
    		   }
    	   }
       }
   }
}