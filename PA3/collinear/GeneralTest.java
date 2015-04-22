import static org.junit.Assert.*;

import org.junit.Test;


public class GeneralTest {

	@Test
	public void test1() {
		Point p1 = new Point(1, 2);
		Point p2 = new Point(2, 1);
		assertEquals("slope should be -1", -1, p1.slopeTo(p2), 0.1);;
	}

}
