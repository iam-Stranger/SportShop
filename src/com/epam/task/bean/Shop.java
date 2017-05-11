package com.epam.task.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Shop implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Map<SportEquipment, Integer> goods;
	private List<Client> clients;
	
	
	public Shop() {
	}

	public Shop(Map<SportEquipment, Integer> goods, List<Client> clients) {
		super();
		this.goods = goods;
		this.clients = clients;
	}

	public Map<SportEquipment, Integer> getGoods() {
		return goods;
	}

	public void setGoods(Map<SportEquipment, Integer> goods) {
		this.goods = goods;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clients == null) ? 0 : clients.hashCode());
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shop other = (Shop) obj;
		if (clients == null) {
			if (other.clients != null)
				return false;
		} else if (!clients.equals(other.clients))
			return false;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		return true;
	}
	
	
}
