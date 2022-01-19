package Reflеction.barracksWars.core;

import Reflеction.barracksWars.interfaces.Repository;
import Reflеction.barracksWars.interfaces.Runnable;
import Reflеction.barracksWars.interfaces.UnitFactory;
import Reflеction.barracksWars.core.commands.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	private String interpretCommand(String[] data, String commandName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		String result = "";
			String className = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);
			if (getClass(className) == null) {
				return "Invalid command!";
			}
			Class clazz = (Class) getClass(className);
			Constructor constructor = clazz.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
			Command commandInstance = (Command) constructor.newInstance(data, repository, unitFactory);
			Method executeMethod = clazz.getDeclaredMethod("execute");
		try {
			result = (String) executeMethod.invoke(commandInstance);
		} catch (InvocationTargetException e) {
			System.out.print(e.getCause().getMessage());
		}
		return result;
	}

	private Object getClass(String className) {
		switch (className){
			case"Add": return Add.class;
			case"Report": return Report.class;
			case"Fight": return Fight.class;
			case"Retire": return Retire.class;
		}

		return null;
	}
}
