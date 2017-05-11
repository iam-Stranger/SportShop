package com.epam.task.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.epam.task.bean.Category;
import com.epam.task.bean.Client;
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
		
	}

	@Override
	public List<SportEquipment> getStoreList() throws DAOException {
		
		ArrayList<SportEquipment> list = new ArrayList<>();
		Shop shop = ShopProvider.getShop();
		Map<SportEquipment, Integer> goods = shop.getGoods();

		for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
			SportEquipment equipment = entry.getKey();
			Integer count = entry.getValue();
				
			for (int i=0; i<count; i++){
				list.add(equipment);
			}
				
		}
		
		return list;
	}

	@Override
	public List<SportEquipment> getRentList() throws DAOException {
		
		ArrayList<SportEquipment> list = new ArrayList<>();
		Shop shop = ShopProvider.getShop();
		List<Client> clients = shop.getClients();

		for (Client client : clients) {
			for (SportEquipment rec : client.getRentUnit().getUnitsArr()) {
				if (rec != null) {
					list.add(rec);
				}
			}
		}

		return list;
	}

}
