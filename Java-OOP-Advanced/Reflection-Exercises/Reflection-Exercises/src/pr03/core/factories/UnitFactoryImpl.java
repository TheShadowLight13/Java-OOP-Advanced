package pr03.core.factories;

import pr03.contracts.Unit;
import pr03.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "pr03.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        Unit unit = null;

        try {
            Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor unitCtor = unitClass.getConstructor();
            unit = (Unit) unitCtor.newInstance();
        } catch (ClassNotFoundException |
                NoSuchMethodException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException e) {
            e.printStackTrace();
        }

        return unit;
    }
}
