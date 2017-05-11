package com.epam.task.dao;

import com.epam.task.dao.impl.SerializeShopDAO;
import com.epam.task.dao.impl.SnglTnClientDAO;
import com.epam.task.dao.impl.SnglTnSportEquipmentDAO;

public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final ShopDAO shopDAO = new SerializeShopDAO();

	private final SportEquipmentDAO equipmentDAO = new SnglTnSportEquipmentDAO();
	
	private final ClientDAO clientDAO = new SnglTnClientDAO();

	
	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return instance;
	}
	
	public ShopDAO getShopDAO(){
		return shopDAO;
	}

	public SportEquipmentDAO getSportEquipmentDAO(){
		return equipmentDAO;
	}
	
	public ClientDAO getClientDAO(){
		return clientDAO;
	}
	
}
