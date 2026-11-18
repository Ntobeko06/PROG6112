/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package productapp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ntobe
 */
public class ProductCalculationsTest {
    
    public ProductCalculationsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of GetVat method, of class ProductCalculations.
     */
    @Test
    public void testGetVat() {
        System.out.println("GetVat");
        ProductCalculations instance = null;
        double expResult = 0.0;
        double result = instance.GetVat();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetCommission method, of class ProductCalculations.
     */
    @Test
    public void testGetCommission() {
        System.out.println("GetCommission");
        ProductCalculations instance = null;
        double expResult = 0.0;
        double result = instance.GetCommission();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetTotal method, of class ProductCalculations.
     */
    @Test
    public void testGetTotal() {
        System.out.println("GetTotal");
        ProductCalculations instance = null;
        double expResult = 0.0;
        double result = instance.GetTotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
