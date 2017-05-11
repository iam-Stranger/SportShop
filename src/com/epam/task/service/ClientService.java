package com.epam.task.service;

import com.epam.task.service.exception.ServiceException;

public interface ClientService {

	void addNewClient(String login) throws ServiceException;

	void getEquipment(String clientLogin, String equipmentTitle) throws ServiceException;

}
