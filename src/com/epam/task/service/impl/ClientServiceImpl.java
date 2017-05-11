package com.epam.task.service.impl;

import com.epam.task.dao.ClientDAO;
import com.epam.task.dao.DAOFactory;
import com.epam.task.dao.exception.DAOException;
import com.epam.task.service.ClientService;
import com.epam.task.service.exception.ServiceException;

public class ClientServiceImpl implements ClientService {

	@Override
	public void addNewClient(String login) throws ServiceException {

		if (login != "") {
			DAOFactory daoFactoryObject = DAOFactory.getInstance();
			ClientDAO clientDAO = daoFactoryObject.getClientDAO();

			try {
				clientDAO.addNewClient(login);
			} catch (DAOException e) {
				throw new ServiceException(e);
			}
		}else{
			throw new ServiceException("Uncorrect parameter");
		}

	}

	@Override
	public void getEquipment(String clientLogin, String equipmentTitle) throws ServiceException {
		
		if (clientLogin != "" && equipmentTitle != "") {
			DAOFactory daoFactoryObject = DAOFactory.getInstance();
			ClientDAO clientDAO = daoFactoryObject.getClientDAO();

			try {
				clientDAO.addNewClient(clientLogin);
			} catch (DAOException e) {
				throw new ServiceException(e);
			}
		}else{
			throw new ServiceException("Uncorrect parameters");
		}

	}

}
