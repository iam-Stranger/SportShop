package com.epam.task.dao;

import com.epam.task.dao.exception.DAOException;

public interface ShopDAO {
	void init() throws DAOException;
	void destroy() throws DAOException;

}
