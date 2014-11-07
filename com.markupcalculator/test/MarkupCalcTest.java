import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for testing MarkupCalculator class
 * @author Marina
 *
 */
public class MarkupCalcTest {
	
	protected MarkupCalculator c;
	
	@Before
	public void setUp (){
		c = new MarkupCalculator ();	
	}
	
	/**
	 *  Tests method calculate when no base price is provided.
	 */
	@Test
	public void testCalculateNoBasePrice() {
		assertEquals (0, c.calculate(0, 0, "books"), 0.0);
		assertEquals (0, c.calculate(0, 0, "food"), 0.0);
		assertEquals (0, c.calculate(0, 3, "cosmetics"), 0.0);
		assertEquals (0, c.calculate(0, 3, "pharmaceuticals"), 0.0);
	}
	
	/**
	 *  Tests method calculate when no staff members are needed to work
	 *  on the project.
	 */
	@Test
	public void testCalculateNoStaff() {
		assertEquals (1342.71, c.calculate(1278.77, 0, "cars"), 0.0);
		assertEquals (1441.54, c.calculate(1345.98, 0, "electronics"), 0.0);
		assertEquals (1597.01, c.calculate(1345.98, 0, "food"), 0.0);
		assertEquals (1519.27, c.calculate(1345.98, 0, "pharmaceuticals"), 0.0);
	}
	
	/**
	 *  Tests method calculate when project involves materials of any type
	 *  but pharmaceuticals, food or electronics. 
	 */
	@Test
	public void testCalculateNoMarkupType() {
		assertEquals (37166.31, c.calculate(34566.88, 2, "books"), 0.0);
	}
	
	/**
	 *  Tests method calculate when project includes a base price, requires one 
	 *  or more staff members and has one of the specified material types.
	 */
	@Test
	public void testCalculateAllFields() {
		assertEquals (1456.20, c.calculate(1234.96, 4, "pharmaceuticals"), 0.0);
		assertEquals (1574.20, c.calculate(1234.96, 7, "food"), 0.0);
		assertEquals (1338.20, c.calculate(1234.96, 1, "electronics"), 0.0);
	}
	
	/**
	 *  Tests the method flatMarkup
	 */
	@Test
	public void testflatMarkup (){
		assertEquals (67.299, c.flatMarkup(1345.98), 0.0);
	}
	
	/**
	 * Tests the method workForceMarkup
	 */
	@Test
	public void testWorkForceMarkup (){
		assertEquals (0.0, c.workForceMarkup(1345.98, 0), 0.00000001);
		assertEquals (16.15176, c.workForceMarkup(1345.98, 1), 0.00000001);
		assertEquals (161.5176, c.workForceMarkup(1345.98, 10), 0.00000001);
	}
	
	/**
	 * Tests the method materialMarkup
	 */
	@Test
	public void testMaterialMarkup (){
		assertEquals (0.0, c.materialMarkup(1345, "books"), 0.00000001);
		assertEquals (100.875, c.materialMarkup(1345,
				                                 "pharmaceuticals"), 0.00000001);
		assertEquals (26.9, c.materialMarkup(1345, "electronics"), 0.00000001);
		assertEquals (174.85, c.materialMarkup(1345, "food"), 0.00000001);

	}
}
