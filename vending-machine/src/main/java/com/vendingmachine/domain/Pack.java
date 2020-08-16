package com.vendingmachine.domain;

import java.util.List;
import java.util.Map;

public class Pack {
	
	private Product product;
	
	private Map<Coin,Integer> coins;
	
	public Pack(Product product,  Map<Coin,Integer> coins) {
		super();
		this.product = product;
		this.coins = coins;
	}
	
	public Pack() {
		
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public  Map<Coin,Integer> getCoins() {
		return coins;
	}

	public void setCoins( Map<Coin,Integer> coins) {
		this.coins = coins;
	}

}
