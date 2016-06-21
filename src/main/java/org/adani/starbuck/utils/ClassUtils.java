package org.adani.starbuck.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

public final class ClassUtils {


    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtils.class);

    public static <T> T make(Type objectType, Map<Object, Class<?>> valueTypeMap) {

        try {

            Class<T> clazz = (Class<T>) Class.forName(objectType.getTypeName());

            Collection<Class<?>> parameterTypesMapValues = valueTypeMap.values();

            Class<?>[] parameterTypes = parameterTypesMapValues.toArray(new Class<?>[parameterTypesMapValues.size()]);

            Constructor<T> cons = clazz.getConstructor(parameterTypes);

            Object[] initArgs = valueTypeMap.keySet().toArray(new Object[valueTypeMap.keySet().size()]);

            T instance = cons.newInstance(initArgs);

            return instance;
        } catch (ClassNotFoundException | NoSuchMethodException
                | IllegalAccessException | InstantiationException
                | InvocationTargetException e) {
            LOGGER.error("UNABLE TO CREATE NEW INSTANCE OF_ : " + objectType.toString(), e);
        }

        return null;
    }

}
