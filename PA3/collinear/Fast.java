public class Fast {
   public static void main(String[] args) {
	   In in = new In(args[0]); // args[0] = name of file
	   int N = in.readInt();    // read an integer in the file
	   Point[] points = new Point[N];
       for (int i = 0; i < N; i++) {
           int x = in.readInt();
           int y = in.readInt();
           points[i] = new Point(x, y);
       }
       
       for (int i = 0; i < N; i++) {
    	   Point curPoint = points[i]; 
    	   Selection.sort(points, points[i].SLOPE_ORDER);
    	   Queue<Point> colinear = new Queue<Point>();
    	   for (int j = 1; j < N; j++) {
        	   double slope1 = curPoint.slopeTo(points[j]);
    		   double slope2 = curPoint.slopeTo(points[j - 1]);
    		   if (slope1 == slope2) {
    			   colinear.enqueue(points[j]);
    		   } else if (colinear.size() > 3){
    			   // output the list
    			   if IsMin(curPoint, colinear) {
    				   // output the list
    				   colinear = new Queue<Point>();
    			   }   
    		   } else {
    			   colinear = new Queue<Point>();
    		   }
    	   }
       }
   }
   
   private boolean IsMin(Point apoint, Queue<Point> queuePoints) {
	   for(Point point : queuePoints){
		   if (apoint.compareTo(point)) {
			   return false;
		   }
	   }
	   return true;
   }
}