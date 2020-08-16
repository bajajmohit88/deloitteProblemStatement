package com.vendingmachine;

import com.vendingmachine.service.impl.VendingMachineServiceImpl;
import com.vendingmachine.domain.Coin;
import com.vendingmachine.domain.Pack;
import com.vendingmachine.domain.Product;
import com.vendingmachine.exceptions.VendingMachineExceptions;
import com.vendingmachine.service.VendingMachineService;
public class VendingMachineApi {
	
	private VendingMachineService vendingMachineService = new VendingMachineServiceImpl();
	
	
	
	public VendingMachineApi() {
		super();
	}

	public Double selectProductGetPrice(Product product) throws VendingMachineExceptions {
		return vendingMachineService.selectProductGetPrice(product);
	}

	public void insertCoin(Coin coin) throws VendingMachineExceptions{
		vendingMachineService.insertCoin(coin);
	}

	public Pack getProductAndChange() throws VendingMachineExceptions{
		Pack p = vendingMachineService.getProductAndChange();
		vendingMachineService.clear();
		return p;
	}
	
	public void addProduct(Product product) {
		vendingMachineService.addProduct(product);
	}	
	
}
