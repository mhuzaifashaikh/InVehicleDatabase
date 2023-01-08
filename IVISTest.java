import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IVISTest {

	@Test
	/**
	 * This test inserts "Music" as a key and tests for the value associated with it
	 */
	void test1() {
		IVIS myIVIS = new IVIS();
		myIVIS.insert("Music");
		
		Integer expected = myIVIS.mainHash.get("Music");
		Integer actual = myIVIS.search("Music");
		assertEquals(expected, actual);
		
		
		

	}
	
	
	@Test
	/**
	 * This test inserts "Lights" as a key and tests for the value associated with it
	 * Then it deletes "Lights" as a key and tests if the value is null
	 */
	void test2() {
		
		System.out.println("\n\nTest 2 Results-");
		IVIS myIVIS = new IVIS();
		
		myIVIS.insert("Lights");
				
		Integer expected = myIVIS.mainHash.get("Lights");
		Integer actual = myIVIS.search("Lights");
		assertEquals(expected, actual);
		
		myIVIS.delete("Lights");
		
		Integer expected2 = null;
		Integer actual2 = myIVIS.search("Lights");
		assertEquals(expected2, actual2);
		

	}
	
	
	@Test
	void test3() {
	    System.out.println("\n\nTest 3 Results-");
	    IVIS myIVIS = new IVIS();

	    myIVIS.insert("Lights");
	    Integer expected1 = myIVIS.mainHash.get("Lights");
	    Integer actual1 = myIVIS.search("Lights");
	    System.out.println("\nLights expected value = " + expected1);
	    System.out.println("Lights actual value = " + actual1);
	    assertEquals(expected1, actual1);
	    

	    myIVIS.insert("Windows");
	    Integer expected2 = myIVIS.mainHash.get("Windows");
	    Integer actual2 = myIVIS.search("Windows");
	    System.out.println("\nWindows expected value = " + expected2);
	    System.out.println("Windows actual value = " + actual2);
	    assertEquals(expected2, actual2);


	    myIVIS.insert("Volume");
	    Integer expected3 = myIVIS.mainHash.get("Volume");
	    Integer actual3 = myIVIS.search("Volume");
	    System.out.println("\nVolume expected value = " + expected3);
	    System.out.println("Volume actual value = " + actual3);
	    assertEquals(expected3, actual3);


	    myIVIS.insert("Song");
	    Integer expected4 = myIVIS.mainHash.get("Song");
	    Integer actual4 = myIVIS.search("Song");
	    System.out.println("\nSong expected value = " + expected4);
	    System.out.println("Song actual value = " + actual4);
	    assertEquals(expected4, actual4);


	    myIVIS.delete("Windows");
	    Integer expected5 = null;
	    Integer actual5 = myIVIS.search("Windows");
	    System.out.println("\nWindows expected value = " + expected5);
	    System.out.println("Windows actual value = " + actual5);
	    assertEquals(expected5, actual5);
	    

	}
	
	
	
	
	
	
	
	

	




}
