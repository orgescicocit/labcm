/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sun.misc.VM;
import junit.framework.*;

/**
 *
 * @author orges
 */
public class T1 {
    private VendingMachine vm = new VendingMachine();

    public T1() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        vm.addBeverage("Coke", 0.50);
	vm.addBeverage("Water", 0.30);
        vm.refillColumn(1, "Coke", 1);
    }
    
    @After
    public void tearDown() {
    }
    
   
    @Test
    public void hello() {
    
    
        assertEquals(vm.availableCans("Coke"), 1);
        
    }
}
