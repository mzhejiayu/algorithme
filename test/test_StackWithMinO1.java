package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import micro100.*;

public class test_StackWithMinO1 {

	
	StackWithMinO1 _testedStack;
	@Before
	public void init(){
		_testedStack = new StackWithMinO1();
		
	}
	
	@Test
	public void normal() throws Exception {
		_testedStack.push(100);
		assertEquals("not right", 100, _testedStack.min());
		_testedStack.push(33);
		assertEquals("not right", 33, _testedStack.min());
		_testedStack.push(44);
		assertEquals("not right", 33, _testedStack.min());
		_testedStack.push(55);
		assertEquals("not right", 33, _testedStack.min());
		_testedStack.push(22);
		assertEquals("not right", 22, _testedStack.min());
		assertEquals("pop error",22, _testedStack.pop());
		assertEquals("not right", 33, _testedStack.min());
		assertEquals("pop error",55, _testedStack.pop());
		assertEquals("not right", 33, _testedStack.min());
		assertEquals("pop error",44, _testedStack.pop());
		assertEquals("not right", 33, _testedStack.min());
		assertEquals("pop error",33, _testedStack.pop());
		assertEquals("not right", 100, _testedStack.min());
	}
	
	@Test(expected = Exception.class)
	public void exception() throws Exception{
		_testedStack.push(100);
		_testedStack.pop();
		_testedStack.min();
	}

}
