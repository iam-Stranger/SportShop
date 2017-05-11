package com.epam.task.view;

import java.util.List;
import java.util.Map;

import com.epam.task.bean.Client;
import com.epam.task.bean.Shop;
import com.epam.task.bean.SportEquipment;
import com.epam.task.dao.ClientDAO;
import com.epam.task.dao.DAOFactory;
import com.epam.task.dao.ShopDAO;
import com.epam.task.dao.SportEquipmentDAO;
import com.epam.task.dao.exception.DAOException;
import com.epam.task.dao.provider.ShopProvider;

public class Starter {

	public static void main(String[] args) {

		DAOFactory daoFactoryObject = DAOFactory.getInstance();
		ShopDAO shopDAO = daoFactoryObject.getShopDAO();
		ClientDAO clientDAO = daoFactoryObject.getClientDAO();
		SportEquipmentDAO equipmentDAO = daoFactoryObject.getSportEquipmentDAO();

		try {

			shopDAO.init();

			//clientDAO.addNewClient("Vasily_Chapaev"); 
			//equipmentDAO.addNewEquipment("Tent", Category.TOURISM, 50, 2);
			
			
			System.out.println("");
			
			Shop shop = ShopProvider.getShop();
					
			List<Client> clients = shop.getClients();
			
			for (Client client : clients){
				//client.getRentUnit().setUnitsArr(units);
				System.out.println(client.getLogin());
			}
			
			System.out.println("");

			Map<SportEquipment, Integer> goods = shop.getGoods();

			for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
				SportEquipment equipment = entry.getKey();
				Integer count = entry.getValue();

				System.out.println(equipment.getTitle() + " " + count);
				
			}
			
		//shopDAO.destroy();	

		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

}
