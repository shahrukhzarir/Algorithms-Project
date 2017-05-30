package a1soln;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

/**
 * Test class of Review
 * @author shahrukhzarir
 *
 */

public class ReviewTest {
	protected Owner owner;
	protected Review reviewOne, reviewTwo, reviewThree;
	protected Reviewer michael;
	
	/**
	 * Sets up for test methods 
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		michael = new Reviewer("Michael","mike@yahoo.com");
		owner = new Owner("Tyrone", "Tyrone@gmail.com");
		reviewOne = new Review(michael, true, "really good!");
		reviewTwo = new Review(michael, false, "bad");
		reviewThree = new Review(michael, true, "");
	
	}

	/**
	 * Resets all the variables
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		michael = null;
		reviewOne = null;
		reviewTwo = null;
		reviewThree = null;
	}
	/**
	 * Test method for getThumbsUp()
	 */
	public void testGetThumbsUp() {
        assertEquals(true, reviewOne.getThumbsUp());
        assertEquals(false, reviewTwo.getThumbsUp());
        assertEquals(true, reviewThree.getThumbsUp());
	}
	/**
	 * Test method for getReviewer()
	 */
	public void testGetReviewer() {
        assertEquals(michael, reviewOne.getThumbsUp());
        assertEquals(michael, reviewTwo.getThumbsUp());
        assertEquals(michael, reviewThree.getThumbsUp());
		
	}
	/**
	 * Test method for getComments()
	 */
	public void testGetComments() {
        assertEquals("really good!", reviewOne.getComments());
        assertEquals("bad", reviewTwo.getComments());
        assertEquals("", reviewThree.getComments());
		
	}
	/**
	 * Test method for getResponse()
	 */
	public void testGetResponse() {
    	owner.respondToReview(1, "Phil's Place","Thank you very much!");
    	assertEquals("Thank you very much!",reviewOne.getResponse());
	}
	/**
	 * Test method for setResponse(String)
	 */
	public void testSetResponse() {
    	owner.respondToReview(1, "Phil's Place","Thank you very much!");
    	reviewOne.setResponse("I like your review!");
    	assertTrue(reviewOne.equals("I like your review!"));
	}

}
