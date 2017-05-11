package com.epam.task.controller;

import com.epam.task.controller.command.Command;
import com.epam.task.controller.command.CommandProvider;

public class Controller {
	private final CommandProvider provider = new CommandProvider();
	
	public String executeTask(String request){
		Command executionCommand;
		
		executionCommand = provider.getCommand(request);
		
		String response;
		response = executionCommand.execute(request);
		
		return response;
		
	}
	
}
