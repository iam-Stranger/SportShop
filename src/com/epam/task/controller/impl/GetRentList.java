package com.epam.task.controller.impl;

import java.util.List;

import com.epam.task.bean.SportEquipment;
import com.epam.task.controller.command.Command;
import com.epam.task.service.ServiceFactory;
import com.epam.task.service.SportEquipmentService;
import com.epam.task.service.exception.ServiceException;

public class GetRentList implements Command {

	@Override
	public String execute(String request) {
		String response = "Goods out the Store:\n--------------------\n";
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		SportEquipmentService equipmentService = serviceFactory.getSportEquipmentService();
		
		List<SportEquipment> list = null;
		try {
			list = equipmentService.getRentList();
			
			for (SportEquipment equipment : list){
				response += equipment.getTitle()+"\t"+equipment.getCategory().name()+"\n"; 
			}
			
		} catch (ServiceException e) {
			response = e.getMessage();
		}
		
		
		
		return response;
	}

}
