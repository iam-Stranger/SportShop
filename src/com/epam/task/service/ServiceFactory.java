package com.epam.task.service;

import com.epam.task.service.impl.ClientServiceImpl;
import com.epam.task.service.impl.ShopServiceImpl;
import com.epam.task.service.impl.SportEquipmentServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final ShopService shopService = new ShopServiceImpl();

	private final SportEquipmentService equipmentService = new SportEquipmentServiceImpl();

	private final ClientService clientService = new ClientServiceImpl();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public ShopService getShopService(){
		return shopService;
	}
	
	public SportEquipmentService getSportEquipmentService(){
		return equipmentService;
	}
	
	public ClientService getClientService(){
		return clientService;
	}
}
