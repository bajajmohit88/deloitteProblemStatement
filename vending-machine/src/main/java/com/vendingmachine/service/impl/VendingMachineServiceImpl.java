package com.vendingmachine.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vendingmachine.domain.Coin;
import com.vendingmachine.domain.Pack;
import com.vendingmachine.domain.Product;
import com.vendingmachine.exceptions.VendingMachineExceptions;
import com.vendingmachine.service.VendingMachineService;

public class VendingMachineServiceImpl implements VendingMachineService {

	private List<Coin> coinsCollected = new ArrayList<>();
	private Integer coinCollectedValue = 0;;
	private Map<Product, Integer> productQuantityMap = new HashMap<>();
	private Product selectedProduct;

	public VendingMachineServiceImpl(){ 
		initialize(); 
	}

	private void initialize(){ 
		Product p = new Product("Coke",0.85);
		Product p2 = new Product("Cadbury",1.85);
		this.productQuantityMap.put(p, 5);
		this.productQuantityMap.put(p2, 5);
	}


	@Override
	public Double selectProductGetPrice(Product product) throws VendingMachineExceptions {
		if (productQuantityMap.containsKey(product)) {
			this.selectedProduct = product;
			return product.getPrice();
		}
		throw new VendingMachineExceptions("Sold Out, Please buy another item");
	}

	@Override
	public void insertCoin(Coin coin) throws VendingMachineExceptions {
		this.coinsCollected.add(coin);
		this.coinCollectedValue = this.coinCollectedValue + computePennies(coin);
	}

	@Override
	public Pack getProductAndChange() throws VendingMachineExceptions {
		if (this.coinCollectedValue < this.selectedProduct.getPrice() * 100)
			throw new VendingMachineExceptions("Insufficient Amount added");
		Map<Coin, Integer> coins = computeChange();
		this.productQuantityMap.put(this.selectedProduct, this.productQuantityMap.get(this.selectedProduct)-1);
		return new Pack(this.selectedProduct, coins);
	}

	@Override
	public void addProduct(Product product) {
		this.selectedProduct = product;
	}
	
	@Override
	public void clear() {
		this.coinsCollected.clear();
		this.selectedProduct = null;
		
	}

	private Map<Coin, Integer> computeChange() {
		Integer difference = (int) (this.coinCollectedValue - selectedProduct.getPrice()*100);
		return computeCoins(difference);
	}
	
	

	private Map<Coin, Integer> computeCoins(Integer difference) {
		// algorithm for adding all coins could cahnge it to map as well
		Map<Coin, Integer> map = new HashMap<>();
		map.put(Coin.QUARTER, difference / 25);
		difference = difference % 25;
		map.put(Coin.DIME, difference / 10);
		difference = difference % 10;
		map.put(Coin.NICKLE, difference / 10);
		difference = difference % 5;
		map.put(Coin.PENNY, difference);
		return map;
	}

	private Integer computePennies(Coin coin) {
		return coin.getDenomination();
	}

	

}
