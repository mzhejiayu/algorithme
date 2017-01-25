package test;

import static org.junit.Assert.*;

import org.junit.Before;

import micro100.MaxSubArray;
import org.junit.Test;

public class test_MaxSubArray {

	@Before
	public void init(){
		
	}
	
	@Test
	public void test() {
		int [] a = {1, -2, 3, 10, -4, 7, 2, -5};
		int [] b = {1,-2,3,-4,5,6,11,-39};
		MaxSubArray ma = new MaxSubArray(a);
		MaxSubArray mb = new MaxSubArray(b);
		assertEquals("not equal to 18", 18, ma._max);
		assertEquals("not equal to 22", 22, mb._max);
	}

}
