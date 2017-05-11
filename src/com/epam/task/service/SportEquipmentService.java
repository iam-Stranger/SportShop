package com.epam.task.service;

import java.util.List;

import com.epam.task.bean.Category;
import com.epam.task.bean.SportEquipment;
import com.epam.task.service.exception.ServiceException;

public interface SportEquipmentService {

	void addNewEquipment(String title, Category category, int price, int count) throws ServiceException;

	List<SportEquipment> getStoreList() throws ServiceException;

	List<SportEquipment> getRentList() throws ServiceException;

}
