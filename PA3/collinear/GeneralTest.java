import static org.junit.Assert.*;

import org.junit.Test;


public class GeneralTest {

	@Test
	public void test1() {
		Point p1 = new Point(1, 2);
		Point p2 = new Point(2, 1);
		assertEquals("slope should be -1", -1, p1.slopeTo(p2), 0.1);
		
		p1 = new Point(10454, 26716);
		p2 = new Point(25243, 26716);
		assertEquals("p2 is on the right of p1", -1, p1.compareTo(p2));
		assertEquals("p2 is on the right of p1", 1, p2.compareTo(p1));
		
		p1 = new Point(14, 1);
		p2 = new Point(86, 1);
		assertEquals("p2 is on the right of p1", -1, p1.compareTo(p2));
		
		p1 = new Point(3, 8);
		p2 = new Point(7, 8);
		assertEquals("p2 is on the right of p1", -1, p1.compareTo(p2));
		
		p1 = new Point(190, 1);
		p2 = new Point(140, 1);
		Point p3 = new Point(180, 1);
		System.out.println(p3.slopeTo(p1) - p3.slopeTo(p2));
	}

}
