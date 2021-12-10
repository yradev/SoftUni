package Reflеction.barracksWars.core.factories;

import Reflеction.barracksWars.interfaces.Unit;
import Reflеction.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"Reflеction.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		Class unitClass = Class.forName(UNITS_PACKAGE_NAME+unitType);
		Constructor<Unit>constructor = unitClass.getConstructor();
		return constructor.newInstance();
	}


}
