package com.vendingmachine;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vendingmachine.domain.Coin;
import com.vendingmachine.domain.Pack;
import com.vendingmachine.domain.Product;
import com.vendingmachine.exceptions.VendingMachineExceptions;

public class VendingMachineTest {
	
	private Product coke;
	private Product pepsi;
	private static VendingMachineApi api ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		api = new VendingMachineApi();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.coke = new Product("Coke",0.85);
		this.pepsi = new Product("Pepsi", 3.9);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testProductisCokeandChangeIsThere() {
		api.addProduct(coke);
		api.insertCoin(Coin.QUARTER);
		api.insertCoin(Coin.QUARTER);
		api.insertCoin(Coin.QUARTER);
		api.insertCoin(Coin.QUARTER);
		
		Pack p = api.getProductAndChange();
		Product p1 = p.getProduct();
		Map<Coin,Integer> change = p.getCoins();
		assertEquals(p1.getName(),"Coke");
		assertNotEquals(change.get(Coin.DIME),  new Integer(3)); 		
		
	}
	
	@Test
	public void testProductisCokeandChangeIsNotThere() {
		api.addProduct(coke);
		api.insertCoin(Coin.QUARTER);
		api.insertCoin(Coin.QUARTER);
		api.insertCoin(Coin.QUARTER);
		api.insertCoin(Coin.DIME);
		
		Pack p = api.getProductAndChange();
		Product p1 = p.getProduct();
		Map<Coin,Integer> change = p.getCoins();
		assertEquals(p1.getName(),"Coke");
		assertNotEquals(change.get(Coin.DIME),  new Integer(3)); 		
		
	}
	
	@Test(expected = VendingMachineExceptions.class)
	public void testProductisnotdispensed() {
		api.addProduct(coke);
		api.insertCoin(Coin.QUARTER);
		api.insertCoin(Coin.QUARTER);
		api.insertCoin(Coin.QUARTER);	
		
		Pack p = api.getProductAndChange();	
		
	}
	
	@Test(expected = VendingMachineExceptions.class)
	public void testProductisnotpresent() {
		api.addProduct(pepsi);

		api.selectProductGetPrice(pepsi);	
		
	}

}
