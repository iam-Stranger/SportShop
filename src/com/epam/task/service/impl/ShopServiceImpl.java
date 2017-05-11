package com.epam.task.service.impl;

import com.epam.task.dao.DAOFactory;
import com.epam.task.dao.ShopDAO;
import com.epam.task.dao.exception.DAOException;
import com.epam.task.service.ShopService;
import com.epam.task.service.exception.ServiceException;

public class ShopServiceImpl implements ShopService {

	@Override
	public void init() throws ServiceException {
		DAOFactory daoFactoryObject = DAOFactory.getInstance();
		ShopDAO shopDAO = daoFactoryObject.getShopDAO();
		
		try {
			shopDAO.init();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public void destroy() throws ServiceException {
		DAOFactory daoFactoryObject = DAOFactory.getInstance();
		ShopDAO shopDAO = daoFactoryObject.getShopDAO();
		
		try {
			shopDAO.destroy();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
