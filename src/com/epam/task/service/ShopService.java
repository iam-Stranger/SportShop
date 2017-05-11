package com.epam.task.service;

import com.epam.task.service.exception.ServiceException;

public interface ShopService {

	void init() throws ServiceException;

	void destroy() throws ServiceException;

}
