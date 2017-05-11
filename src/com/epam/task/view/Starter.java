package com.epam.task.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.task.bean.Category;
import com.epam.task.bean.Client;
import com.epam.task.bean.Shop;
import com.epam.task.bean.SportEquipment;
import com.epam.task.controller.Controller;
import com.epam.task.dao.ClientDAO;
import com.epam.task.dao.DAOFactory;
import com.epam.task.dao.ShopDAO;
import com.epam.task.dao.SportEquipmentDAO;
import com.epam.task.dao.exception.DAOException;
import com.epam.task.dao.provider.ShopProvider;
import com.epam.task.service.ClientService;
import com.epam.task.service.ServiceFactory;
import com.epam.task.service.ShopService;
import com.epam.task.service.exception.ServiceException;

public class Starter {

	public static void main(String[] args) {
		ServiceFactory serviceFactoryObject = ServiceFactory.getInstance();
		ShopService shopService = serviceFactoryObject.getShopService();
//		ClientService clientService = serviceFactoryObject.getClientService();
//	
		try {
			shopService.init();
//			clientService.getEquipment("Bill Gates", "Tennis rocket");
//			clientService.getEquipment("Bill Gates", "Inflatable boat");
//			clientService.getEquipment("Bill Gates", "Boxing gloves");
//			clientService.getEquipment("Vasily Chapaev", "Boxing gloves");
//			shopService.destroy();
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		Controller controller = new Controller();
		String response1 = controller.executeTask("GET_STORE_LIST");
		System.out.println(response1);
		
		String response2 = controller.executeTask("GET_RENT_LIST");
		System.out.println(response2);

	}

}

// Shop shop = ShopProvider.getShop();
// shop.setClients(new ArrayList<Client>());
// shop.setGoods(new HashMap<SportEquipment, Integer>());
//
// clientDAO.addNewClient("Bill Gates");
// clientDAO.addNewClient("Vasily Chapaev");
//
// equipmentDAO.addNewEquipment("Boxing gloves", Category.COMBATS, 10, 3);
// equipmentDAO.addNewEquipment("Tennis rocket", Category.TENNIS, 7, 5);
// equipmentDAO.addNewEquipment("Inflatable boat", Category.TOURISM, 75, 1);
