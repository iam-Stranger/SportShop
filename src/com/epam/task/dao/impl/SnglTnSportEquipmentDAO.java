package com.epam.task.dao.impl;

import java.util.List;
import java.util.Map;

import com.epam.task.bean.Category;
import com.epam.task.bean.Shop;
import com.epam.task.bean.SportEquipment;
import com.epam.task.dao.SportEquipmentDAO;
import com.epam.task.dao.exception.DAOException;
import com.epam.task.dao.provider.ShopProvider;

public class SnglTnSportEquipmentDAO implements SportEquipmentDAO {

	@Override
	public void addNewEquipment(String title, Category category, int price, int count) throws DAOException {
		SportEquipment equipment = new SportEquipment(category, title, price);
		
		Shop shop = ShopProvider.getShop();
		Map<SportEquipment, Integer> goods = shop.getGoods();
		goods.put(equipment, count);
		
		
	}

	@Override
	public void deleteEquipment(SportEquipment equipment) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SportEquipment> getEquipmentsList() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
