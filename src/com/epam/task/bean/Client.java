package com.epam.task.bean;

import java.io.Serializable;

public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String login;
	private RentUnit rentUnit;
	
	
	public Client() {
		super();
	}

	public Client(String login, RentUnit rentUnit) {
		this.login = login;
		this.rentUnit = rentUnit;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public RentUnit getRentUnit() {
		return rentUnit;
	}

	public void setRentUnit(RentUnit rentUnit) {
		this.rentUnit = rentUnit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((rentUnit == null) ? 0 : rentUnit.hashCode());
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
		Client other = (Client) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (rentUnit == null) {
			if (other.rentUnit != null)
				return false;
		} else if (!rentUnit.equals(other.rentUnit))
			return false;
		return true;
	}
	
	
	

}
