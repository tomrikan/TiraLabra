/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorsai;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomi
 */
public class DynamicArrayTest {
    
    DynamicArray da;
    
    public DynamicArrayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        da = new DynamicArray();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void isEmptyReturnsTrueIfEmpty() {
        assertEquals(true, da.isEmpty());
    }
    
    @Test
    public void isEmptyReturnsFalseIfnotEmpty() {
        da.add(1);
        assertEquals(false, da.isEmpty());
    }
    
    @Test
    public void addReturnTrueWhenAddingElement() {
        assertEquals(true, da.add(1));
    }
    
    @Test
    public void addAddsElementAndEnsureCapacityWorksWhenAddinOverSize() {
        for (int i = 0; i < 9; i++) {
            da.add(i);
        }
        assertEquals(true, da.add(10));
        assertEquals(true, da.add(11));
    }
    
    @Test
    public void setReturnsOldElementonSpotAndSetsNew() {
        for (int i = 0; i < 9; i++) {
            da.add(i);
        }
        assertEquals(0, da.set(0, 10));
    }
}
