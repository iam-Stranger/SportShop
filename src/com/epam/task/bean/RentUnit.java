package com.epam.task.bean;

import java.io.Serializable;
import java.util.Arrays;

public class RentUnit implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private SportEquipment[] units;

	
	public RentUnit() {
	}

	public RentUnit(SportEquipment[] units) {
		this.units = units;
	}

	public SportEquipment[] getUnitsArr() {
		return units;
	}

	public void setUnitsArr(SportEquipment[] units) {
		this.units = units;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(units);
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
		RentUnit other = (RentUnit) obj;
		if (!Arrays.equals(units, other.units))
			return false;
		return true;
	}

}
