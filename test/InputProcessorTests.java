import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputProcessorTests {
	
	InputProcessor processor;
	
	@BeforeEach
	public void createInputProcessor() {
		processor = new InputProcessor();
	}
	
	@Test
	public void testInvalidInputFormats() {
		assertFalse(processor.validateInputFormat("invalid"));
		assertFalse(processor.validateInputFormat(""));
		assertFalse(processor.validateInputFormat("C 2"));
		assertFalse(processor.validateInputFormat("C 2 3 4"));
		assertFalse(processor.validateInputFormat("L 1"));
		assertFalse(processor.validateInputFormat("L 1 2 3 4 5"));
		assertFalse(processor.validateInputFormat("R 1 2"));
		assertFalse(processor.validateInputFormat("R 1 2 3 G m"));
		assertFalse(processor.validateInputFormat("R A B C D"));
		assertFalse(processor.validateInputFormat("B 5"));
		assertFalse(processor.validateInputFormat("B r 0"));
		assertFalse(processor.validateInputFormat("D 4"));
		assertFalse(processor.validateInputFormat("Q Q"));
	}
	
	@Test
	public void testValidInputFormats() {
		assertTrue(processor.validateInputFormat("C 2 3"));
		assertTrue(processor.validateInputFormat("L 1 2 3 4"));
		assertTrue(processor.validateInputFormat("R 1 2 3 4"));
		assertTrue(processor.validateInputFormat("B 5 1 c"));
		assertTrue(processor.validateInputFormat("D "));
		assertTrue(processor.validateInputFormat("Q"));
	}
	
	@Test
	public void testInvalidInputValues() {
		assertEquals("Error : Maximum canvas size supported is 100x32\n", processor.validateInputValues("C 105 18"));
		assertEquals("Error : Please create a canvas first.\n", processor.validateInputValues("L 10 2 20 2"));
		
		processor.processInput("C 50 18");
		assertEquals("Error : Input values exceed canvas size!\n", processor.validateInputValues("L 40 5 60 5"));
		assertEquals("Error : Line end coordinates should have a higher values than line start coordinates!\n", processor.validateInputValues("L 30 5 10 3")); 
		assertEquals("Error : Input values exceed canvas size!\n", processor.validateInputValues("R 5 100 12 110"));
		assertEquals("Error : Right bottom corner cordinates should be higher than left top corner coordinates!\n", processor.validateInputValues("R 15 10 6 3")); 
		assertEquals("Error : Input values exceed canvas size!\n", processor.validateInputValues("B 40 26 c"));
	}
	
	@Test
	public void testValidInputValues() {
		assertEquals("", processor.validateInputValues("C 100 32"));
		
		processor.processInput("C 100 32");
		assertEquals("", processor.validateInputValues("L 40 5 60 5"));
		assertEquals("", processor.validateInputValues("R 5 10 15 20")); 
		assertEquals("", processor.validateInputValues("B 40 26 c"));
	}
}
