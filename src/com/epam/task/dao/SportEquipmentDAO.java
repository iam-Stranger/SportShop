package com.epam.task.dao;

import java.util.List;

import com.epam.task.bean.Category;
import com.epam.task.bean.SportEquipment;
import com.epam.task.dao.exception.DAOException;

public interface SportEquipmentDAO {

	void addNewEquipment(String title, Category category, int price, int count) throws DAOException;

	void deleteEquipment(SportEquipment equipment) throws DAOException;
	
	List<SportEquipment> getStoreList() throws DAOException;
	List<SportEquipment> getRentList() throws DAOException;

}
