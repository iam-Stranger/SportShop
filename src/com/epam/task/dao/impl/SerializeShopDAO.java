package com.epam.task.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.epam.task.bean.Shop;
import com.epam.task.dao.ShopDAO;
import com.epam.task.dao.exception.DAOException;
import com.epam.task.dao.provider.ShopProvider;

public class SerializeShopDAO implements ShopDAO {

	@Override
	public void init() throws DAOException {
		try {
			FileInputStream fis = new FileInputStream("res/shop.res");
			@SuppressWarnings("resource")
			ObjectInputStream ois = new ObjectInputStream(fis);

			Shop shop = (Shop) ois.readObject();
			ShopProvider.setShop(shop);
			
		} catch (FileNotFoundException e) {
			throw new DAOException("Read file>> File not found", e);
		} catch (IOException e) {
			throw new DAOException("Read file>> IO Error", e);
		} catch (ClassNotFoundException e) {
			throw new DAOException("Read file>> Class Not Found", e);
		}

	}

	@Override
	public void destroy() throws DAOException {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("res/shop.res");
			@SuppressWarnings("resource")
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			Shop shop = ShopProvider.getShop();
			oos.writeObject(shop);
			
		} catch (FileNotFoundException e) {
			throw new DAOException("Write file>> File not found", e);
		} catch (IOException e) {
			throw new DAOException("Write file>> IO Error", e);
		}
		
		
		

	}

}
