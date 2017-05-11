package com.epam.task.service.impl;

import java.util.List;

import com.epam.task.bean.Category;
import com.epam.task.bean.SportEquipment;
import com.epam.task.dao.DAOFactory;
import com.epam.task.dao.SportEquipmentDAO;
import com.epam.task.dao.exception.DAOException;
import com.epam.task.service.SportEquipmentService;
import com.epam.task.service.exception.ServiceException;

public class SportEquipmentServiceImpl implements SportEquipmentService {

	@Override
	public void addNewEquipment(String title, Category category, int price, int count) throws ServiceException {
		DAOFactory daoFactoryObject = DAOFactory.getInstance();
		SportEquipmentDAO equipmentDAO = daoFactoryObject.getSportEquipmentDAO();
		
		if (title !="" && price >= 0 && count > 0){
			
			try {
				equipmentDAO.addNewEquipment(title, category, price, count);
			} catch (DAOException e) {
				throw new ServiceException(e);
			}
			
		}else{
			throw new ServiceException("Uncorrect parameters");
		}
		
	}

	@Override
	public List<SportEquipment> getStoreList() throws ServiceException {

		DAOFactory daoFactoryObject = DAOFactory.getInstance();
		SportEquipmentDAO equipmentDAO = daoFactoryObject.getSportEquipmentDAO();
		
		List<SportEquipment> list = null;
		
		try {
			list = equipmentDAO.getStoreList();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return list;
	}

	@Override
	public List<SportEquipment> getRentList() throws ServiceException {
		
		DAOFactory daoFactoryObject = DAOFactory.getInstance();
		SportEquipmentDAO equipmentDAO = daoFactoryObject.getSportEquipmentDAO();
		
		List<SportEquipment> list = null;
		
		try {
			list = equipmentDAO.getRentList();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return list;
	}

}
