package ir.javacup.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ElevatorTest {
	Elevator elevator;

	@Before
	public void beforeTest() {
		elevator = new Elevator();
	}

	@Test
	public void testInitialization() {
		assertTrue(elevator.isOpen());
		assertFalse(elevator.isUnderMaintenance());
		assertEquals(0, elevator.getFloorNumber());
		assertEquals(State.SECURE, elevator.getState());
	}

	@Test
	public void testMoveToInvalidFloor1() {
		try {
			elevator.move(-3);
			fail("An error expected");
		} catch (IllegalArgumentException e) {
			assertEquals("Floor number should be between -2 and 10", e.getMessage());
		}
	}

	@Test
	public void testMoveToInvalidFloor2() {
		try {
			elevator.move(11);
			fail("An error expected");
		} catch (IllegalArgumentException e) {
			assertEquals("Floor number should be between -2 and 10", e.getMessage());
		}
	}

	@Test
	public void testMoveToSameFloor() {
		elevator.move(4);
		elevator.open();
		
		elevator.move(4);
		assertEquals(4, elevator.getFloorNumber());
		assertTrue(elevator.isOpen());
	}
	
	@Test
	public void testMoveToFloor() {
		elevator.move(5);
		assertEquals(5, elevator.getFloorNumber());
		assertFalse(elevator.isOpen());
	}
	
	@Test
	public void testStartMaintenance(){
		elevator.startMaintenance();
		assertEquals(State.INSECURE, elevator.getState());
		assertTrue(elevator.isUnderMaintenance());
	}
	
	@Test
	public void testFinishMaintenance(){
		elevator.finishMaintenance();
		assertEquals(State.SECURE, elevator.getState());
		assertFalse(elevator.isUnderMaintenance());
	}

	@Test
	public void testMoveUnsecureElevator(){
		elevator.startMaintenance();
		try{
			elevator.move(1);
			fail("An error expected");
		}
		catch(RuntimeException e){
			assertEquals("Elevator is insecure", e.getMessage());
		}
	}
	
	@Test
	public void testOpen(){
		elevator.open();
		assertTrue(elevator.isOpen());
	}
	
	@Test
	public void testClose(){
		elevator.close();
		assertFalse(elevator.isOpen());
	}

}
