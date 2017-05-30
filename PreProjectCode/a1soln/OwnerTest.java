package a1soln;
import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A test class for owner.
 * @author Shahrukh
 *
 */

public class OwnerTest {
	
	protected Restaurant restaurantOne, restaurantTwo, restaurantThree;
	protected Owner owner;
	protected Reviewer reviewer;
	protected Review reviewOne;
	
	@Before
	/**
	 * Setup for test methods
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		owner = new Owner("Tyrone", "Tyrone@gmail.com");
		List<String> listOfCuisine = new ArrayList<String>();
		listOfCuisine.add("Fish");
		listOfCuisine.add("Ham");
		listOfCuisine.add("Bacon");
		restaurantOne = new Restaurant("Phil's Place", "Harlem","10$-15$", listOfCuisine);
		restaurantTwo = new Restaurant("Mohammed", "Mexico","20$-25$", listOfCuisine);
		restaurantThree = new Restaurant("T-Bonez", "Toronto","20$-35$", listOfCuisine);
    	reviewer = new Reviewer("Michael", "michael@yahoo.com"); 
    	reviewOne = new Review(reviewer, true, "Really Good Food and Service");
	}

	@After
	/**
	 * tear down for test methods
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		owner = null;
		restaurantOne = null;
		restaurantTwo = null;
		restaurantThree = null;
	}

	@Test
	/**
	 * Test Constructor tests the constructor 
	 */
	public void testOwner() {
        assertEquals("Tyrone", owner.getUsername());
        assertEquals("Tyrone@gmail.com", owner.getEmail());
	}

    /**
     * Test addRestaurant(String, Object).
     */
    @Test
    public void testAddRestaurant() {   
        owner.addRestaurant(restaurantOne);
        assertEquals("Phil's Place", owner.getRestaurant(restaurantOne.getName()));
        owner.addRestaurant(restaurantTwo);
        assertEquals("Mohammed", owner.getRestaurant(restaurantTwo.getName()));
        owner.addRestaurant(restaurantThree);
        assertEquals("T-Bonez", owner.getRestaurant(restaurantThree.getName()));
    }
    /**
     * Test respondToReview(int,String,String).
     */
    public void testRespondToReview() {
    	owner.respondToReview(1, "Phil's Place","Thank you very much!");
    	assertEquals("Thank you very much!",reviewOne.getResponse());
    }
	
    /**
     * Test testGetRestaurant(String)
     */
    public void testGetRestaurant(){
            assertEquals(restaurantOne, owner.getRestaurant("Phil's Place"));
            assertEquals(restaurantTwo, owner.getRestaurant("Mohammed"));
            assertEquals(restaurantThree, owner.getRestaurant("T-Bonez"));
    }

}
