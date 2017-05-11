package com.epam.task.dao.provider;

import com.epam.task.bean.Shop;

public class ShopProvider {
	private static final ShopProvider instance = new ShopProvider();
	
	private static Shop shop = new Shop();
	
	private ShopProvider(){
	}
	
	public static ShopProvider getInstance() {
		return instance;
	}
	
	public static Shop getShop() {
		return shop;
	}
	
	public static void setShop(Shop shop){
		ShopProvider.shop = shop;
	}
	
	
}
