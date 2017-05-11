package com.epam.task.controller.command;

import java.util.HashMap;
import java.util.Map;

import com.epam.task.controller.impl.GetRentList;
import com.epam.task.controller.impl.GetStoreList;

public class CommandProvider {
	private final Map<CommandName, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(CommandName.GET_RENT_LIST, new GetRentList());
		commands.put(CommandName.GET_STORE_LIST, new GetStoreList());
	}

	public Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;

		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = commands.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = commands.get(CommandName.WRONG_REQUEST);
		}

		return command;
	}

}
