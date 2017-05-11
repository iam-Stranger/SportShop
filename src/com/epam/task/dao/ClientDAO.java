package com.epam.task.dao;

import com.epam.task.bean.Client;
import com.epam.task.bean.SportEquipment;
import com.epam.task.dao.exception.DAOException;

public interface ClientDAO {
	void addNewClient(String login) throws DAOException;

	void getEquipment(String clientLogin, String equipmentTitle) throws DAOException;

	void returnEquipment(Client client, SportEquipment equipment) throws DAOException;

}
