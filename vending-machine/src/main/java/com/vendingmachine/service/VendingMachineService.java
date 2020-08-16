package com.vendingmachine.service;

import java.util.Optional;

import com.vendingmachine.domain.Coin;
import com.vendingmachine.domain.Pack;
import com.vendingmachine.domain.Product;
import com.vendingmachine.exceptions.VendingMachineExceptions;

public interface VendingMachineService {

	public Double selectProductGetPrice(Product product) throws VendingMachineExceptions;

	public void insertCoin(Coin coin) throws VendingMachineExceptions;

	public Pack getProductAndChange() throws VendingMachineExceptions;
	
	public void addProduct(Product Product);
	
	public void clear();
}
