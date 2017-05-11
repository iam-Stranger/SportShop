package com.epam.task.dao.impl;

import java.util.List;
import java.util.Map;

import com.epam.task.bean.Client;
import com.epam.task.bean.RentUnit;
import com.epam.task.bean.Shop;
import com.epam.task.bean.SportEquipment;
import com.epam.task.dao.ClientDAO;
import com.epam.task.dao.exception.DAOException;
import com.epam.task.dao.provider.ShopProvider;

public class SnglTnClientDAO implements ClientDAO {

	private static final int COUNT_OF_RENT = 3;
	private static final String MINUS_FROM_STORE = "minus";
	private static final String PLUS_FROM_STORE = "plus";

	@Override
	public void addNewClient(String login) throws DAOException {
		RentUnit rentUnit = new RentUnit(new SportEquipment[COUNT_OF_RENT]);
		Client client = new Client(login, rentUnit);

		Shop shop = ShopProvider.getShop();
		List<Client> clients = shop.getClients();
		clients.add(client);

	}

	@Override
	public void getEquipment(String clientLogin, String equipmentTitle) throws DAOException {

		Client client = findClientByLogin(clientLogin);
		if (client == null) {
			throw new DAOException("Client not found");
		}

		SportEquipment equipment = findSportEquipmentByTitle(equipmentTitle);
		if (equipment == null) {
			throw new DAOException("Equipment not found");
		}

		Integer countFromStore = findSportEquipmentCount(equipmentTitle);
		if (countFromStore <= 0) {
			throw new DAOException("Equipment count = 0");
		}

		int countRentUnins = countFreeRentUnit(client);
		if (countRentUnins <= 0) {
			throw new DAOException("Client has maximum equipment");
		}

		sportEquipmentChangeCount(equipmentTitle, MINUS_FROM_STORE);
		rentUnitAdd(client, equipment);

	}

	@Override
	public void returnEquipment(Client client, SportEquipment equipment) throws DAOException {

	}

	private Client findClientByLogin(String clientLogin) {

		Shop shop = ShopProvider.getShop();
		List<Client> clients = shop.getClients();

		for (Client client : clients) {
			if (client.getLogin().equals(clientLogin)) {
				return client;
			}
		}

		return null;
	}

	private SportEquipment findSportEquipmentByTitle(String equipmentTitle) {

		Shop shop = ShopProvider.getShop();
		Map<SportEquipment, Integer> goods = shop.getGoods();

		for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
			SportEquipment equipment = entry.getKey();

			if (equipment.getTitle().equals(equipmentTitle)) {
				return equipment;
			}
		}

		return null;
	}

	private Integer findSportEquipmentCount(String equipmentTitle) {

		Shop shop = ShopProvider.getShop();
		Map<SportEquipment, Integer> goods = shop.getGoods();

		for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
			SportEquipment equipment = entry.getKey();
			Integer count = entry.getValue();

			if (equipment.getTitle().equals(equipmentTitle)) {
				return count;
			}
		}

		return null;
	}

	private void sportEquipmentChangeCount(String equipmentTitle, String action) {

		Shop shop = ShopProvider.getShop();
		Map<SportEquipment, Integer> goods = shop.getGoods();

		for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
			SportEquipment equipment = entry.getKey();

			if (equipment.getTitle().equals(equipmentTitle)) {
				if (action.equals(MINUS_FROM_STORE)) {
					entry.setValue(entry.getValue() - 1);
				} else if (action.equals(PLUS_FROM_STORE)) {
					entry.setValue(entry.getValue() + 1);
				}
			}
		}

	}

	private void rentUnitAdd(Client client, SportEquipment equipment) {

		SportEquipment[] array = client.getRentUnit().getUnitsArr();

		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				array[i] = equipment;

				RentUnit unit = new RentUnit();
				unit.setUnitsArr(array);
				client.setRentUnit(unit);

				return;
			}
		}

	}

	private int countFreeRentUnit(Client client) {
		int count = 0;

		SportEquipment[] array = client.getRentUnit().getUnitsArr();

		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				count++;
			}
		}

		return count;
	}

}
